package effyis.partners.socle.apiconfig.configuration.datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

/**
 * 
 * @author EL KOTB ZAKARIA
 *
 */
public class MyRoutingDataSource extends AbstractRoutingDataSource {

	@Autowired
	private HttpServletRequest request;

	@Override
	protected Object determineCurrentLookupKey() {
		String keyDB;
		if ((SecurityContextHolder.getContext().getAuthentication() != null)
				&& SecurityContextHolder.getContext().getAuthentication().getName().equals("anonymousUser")) {
			keyDB = this.request.getHeader("keyDB");
			if (keyDB == null) {
				keyDB = "client1";
			}
		} else {
			keyDB = TenantStorageContext.getTenantId();
		}
		if (keyDB == null) {
			keyDB = "client1";
		}
		return keyDB;
	}

	@Override
	protected DataSource determineTargetDataSource() {
		try {
			DataSource ds = super.determineTargetDataSource();
			return ds;
		} catch (IllegalStateException e) {
			throw new DataSourceNotFoundException(this.request.getHeader("keyDB"));
		}
	}

}
