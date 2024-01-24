package com.turnero.turnero.access.Service;

import com.turnero.turnero.access.dto.Response.TokenResponseDto;
import com.turnero.turnero.access.dto.Response.UserResponseDto;
import com.turnero.turnero.access.dto.request.LoginRequestDto;
import com.turnero.turnero.access.dto.request.UserRequestDto;

public interface IUserService {
	public UserResponseDto saveUser(UserRequestDto dto);
	
	public TokenResponseDto login(LoginRequestDto loginDto);
}
