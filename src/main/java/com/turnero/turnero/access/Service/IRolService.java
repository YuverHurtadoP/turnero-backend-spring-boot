package com.turnero.turnero.access.Service;

import java.util.List;
import java.util.Optional;

import com.turnero.turnero.access.dto.Response.RolResponseDto;

public interface IRolService {
	public List<RolResponseDto> rolList();
	public  RolResponseDto  findByrolId(int rolId);
}
