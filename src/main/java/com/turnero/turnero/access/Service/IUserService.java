package com.turnero.turnero.access.Service;

import com.turnero.turnero.access.dto.Response.TokenResponseDto;
import com.turnero.turnero.access.dto.Response.UserResponseDto;
import com.turnero.turnero.access.dto.request.LoginRequestDto;
import com.turnero.turnero.access.dto.request.RecoveryPasswordRequestDto;
import com.turnero.turnero.access.dto.request.UserRequestDto;
import com.turnero.turnero.exception.dto.Message;

public interface IUserService {
	public UserResponseDto saveUser(UserRequestDto dto);
	
	public TokenResponseDto login(LoginRequestDto loginDto);
	
	public Message recoveryPassword(RecoveryPasswordRequestDto dto);
}
