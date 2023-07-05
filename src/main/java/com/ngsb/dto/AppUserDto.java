package com.ngsb.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppUserDto {
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private List<String> roles;	
}
