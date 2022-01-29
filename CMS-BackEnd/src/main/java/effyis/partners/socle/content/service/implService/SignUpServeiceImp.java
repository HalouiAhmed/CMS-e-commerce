package effyis.partners.socle.content.service.implService;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import effyis.partners.socle.apiconfig.exception.CustomAuthenticationException;
import effyis.partners.socle.content.dto.SignUpDto;
import effyis.partners.socle.content.entity.Account;
import effyis.partners.socle.content.entity.EffyisUser;
import effyis.partners.socle.content.repository.AccountRepository;
import effyis.partners.socle.content.repository.RoleRepository;
import effyis.partners.socle.content.repository.SignUpRespository;
import effyis.partners.socle.content.service.AccountService;
import effyis.partners.socle.content.service.SignUpService;

@Service
public class SignUpServeiceImp implements SignUpService {
	@Autowired
	private AccountService accountService;
	@Autowired
	effyis.partners.socle.content.outils.Outils outils;
	@Autowired
	SignUpRespository signUpRespository;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	AccountRepository repo;

	@Override
	public SignUpDto crreateUser(SignUpDto signUpDto) {

		if (signUpDto.isAgreement() != true) {
			throw new CustomAuthenticationException("Please agree to the terms and conditions");
		}
		// pour stocker dans la DB we need entity
		EffyisUser effyisUser = new EffyisUser();

		// On copy les donnée de UserDTO vers userEntity
		BeanUtils.copyProperties(signUpDto, effyisUser);
		// On creer un compte
		Account account = new Account(signUpDto.getEmail(), signUpDto.getPassword());
		// On cryptr le password
		account.setPassword(this.bCryptPasswordEncoder.encode(signUpDto.getPassword()));
		effyisUser.setUserId(this.outils.generateUserId(20));
		account.setRole(this.roleRepository.findById(1L).orElse(null));
		effyisUser.setAccount(account);
		EffyisUser newUser = this.signUpRespository.save(effyisUser);
		BeanUtils.copyProperties(newUser, signUpDto);
		return signUpDto;
	}

	@Override
	@Transactional
	public SignUpDto putUser(SignUpDto signUpdto) {
		String email = this.accountService.getConnectedUser();
		Account accountFromDb = this.repo.findByLogin(email).get();
		if (!this.bCryptPasswordEncoder.matches(signUpdto.getOldPassword(), accountFromDb.getPassword())) {
			throw new CustomAuthenticationException("Old password does not match");
		} else {
			EffyisUser userFromDb = this.signUpRespository.findByAccount(accountFromDb);
			accountFromDb.setPassword(this.bCryptPasswordEncoder.encode(signUpdto.getPassword()));
			userFromDb.setFirstName(signUpdto.getFirstName());
			userFromDb.setLastName(signUpdto.getLastName());
			userFromDb.setAdresse(signUpdto.getAdresse());
			userFromDb.setTel(signUpdto.getTel());
			userFromDb.setAccount(accountFromDb);
			EffyisUser userUpdated = this.signUpRespository.save(userFromDb);

			BeanUtils.copyProperties(userUpdated, signUpdto);
			return signUpdto;
		}
	}

}
