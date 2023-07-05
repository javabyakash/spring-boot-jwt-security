package com.ngsb.service;

import com.ngsb.dto.AppUserDto;
import com.ngsb.entity.AppUser;

public interface IAppUserService {
	String createUser(AppUserDto appUserDto);
	public AppUser findByUsername(String username);
}
