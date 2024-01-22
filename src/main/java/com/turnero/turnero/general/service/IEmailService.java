package com.turnero.turnero.general.service;

import com.turnero.turnero.general.dto.request.EmailRequestDto;

public interface IEmailService {
	public void sendEmail(EmailRequestDto emailRequestDto);

}
