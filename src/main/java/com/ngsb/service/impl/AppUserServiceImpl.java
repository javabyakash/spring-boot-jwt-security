package com.ngsb.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ngsb.dto.AppUserDto;
import com.ngsb.entity.AppUser;
import com.ngsb.repo.AppUserRepo;
import com.ngsb.service.IAppUserService;
import com.ngsb.utility.AppUtil;

@Service
public class AppUserServiceImpl implements IAppUserService, UserDetailsService {

	@Autowired
	private AppUserRepo userRepo;

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Override
	public String createUser(AppUserDto appUserDto) {
		AppUser appUser = AppUtil.getAppUser(appUserDto);
		// encode password before save into database.
		appUser.setPassword(encoder.encode(appUser.getPassword()));
		AppUser savedAppUser = userRepo.save(appUser);
		return new StringBuilder().append("User created with id : ").append(savedAppUser.getUserId()).toString();
	}
	
	@Override
	public AppUser findByUsername(String username) {
		Optional<AppUser> user = userRepo.findByUsername(username);
		if(user.isPresent())
			return user.get();
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AppUser user = findByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException(new StringBuilder().append("Username ").append(username).append(" not exist!").toString());
		List<SimpleGrantedAuthority> list = user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
		return new User(username, user.getPassword(), list);
	}
	
}
