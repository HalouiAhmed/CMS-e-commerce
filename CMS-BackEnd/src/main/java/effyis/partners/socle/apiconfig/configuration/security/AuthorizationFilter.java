package effyis.partners.socle.apiconfig.configuration.security;

import effyis.partners.socle.apiconfig.configuration.datasource.TenantStorageContext;
import effyis.partners.socle.apiconfig.exception.CustomAuthenticationException;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author EL KOTB ZAKARIA
 *
 */
@Component
public class AuthorizationFilter extends OncePerRequestFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationFilter.class);

	@Value("${security.jwt.secret}")
	private String secret;

	@Autowired
	private JWTProvider jwtProvider;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		if (!JWTProvider.ifOption(request, response)) {
			try {
				String jwt = JWTProvider.resolveJWT(request);
				if (!jwt.equals("")) {
					if (this.jwtProvider.validateJwt(jwt, this.secret)) {
						this.authUser(jwt);
					}
				}
			} catch (SignatureException e) {
				AuthorizationFilter.LOGGER.error("", e);
			} catch (MalformedJwtException e) {
				AuthorizationFilter.LOGGER.error("", e);
			} catch (ExpiredJwtException e) {
				AuthorizationFilter.LOGGER.error("", e);
			} catch (CustomAuthenticationException e) {
				AuthorizationFilter.LOGGER.error("", e);
			}

		} else {
			response = JWTProvider.addAuthorizedHeaders(response);
		}
		filterChain.doFilter(request, response);
	}

	private void authUser(String jwt) {
		Jws<Claims> parsedJwt = JWTProvider.parseJwt(jwt, this.secret);
		String username = parsedJwt.getBody().getSubject();
		String role = (String) parsedJwt.getBody().get("role");
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority((role.isEmpty() || (role == null)) ? "DEFAULT" : role));
		TenantStorageContext.setTenantId(parsedJwt.getBody().get("tenant", String.class));
		SecurityContextHolder.getContext()
				.setAuthentication(new UsernamePasswordAuthenticationToken(username, null, authorities));
	}

}
