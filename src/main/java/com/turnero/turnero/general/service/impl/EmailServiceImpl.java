package com.turnero.turnero.general.service.impl;

import java.util.HashMap;
import java.util.Map;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.turnero.turnero.exception.ErrorInternalServer;
import com.turnero.turnero.exception.NotFoundException;
import com.turnero.turnero.general.dto.request.EmailRequestDto;
import com.turnero.turnero.general.service.IEmailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements IEmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private TemplateEngine templateEngine;

	@Override
	public void sendEmail(EmailRequestDto emailRequestDto) {
		MimeMessage message=javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper helper=new MimeMessageHelper(message,true);
			Context context = new Context();
			   Map<String, Object> model = new HashMap<>();
	           model.put("body","Usted ha sido registrado con exito, ahora cuenta con un usuario y contraseña para gestionar sus citas medicas.");
	           context.setVariables(model);
			String htmlText = templateEngine.process("email-template", context);
			helper.setFrom("yuversahupe@gmail.com");//desde
			helper.setTo(emailRequestDto.getMailTo());//para
			helper.setSubject(emailRequestDto.getSubject());//asunto
			helper.setText(htmlText,true);//cuerpod del correeo
			javaMailSender.send(message);//envia el correo
		}catch(MessagingException e) {
			e.printStackTrace();
			throw new  ErrorInternalServer("No se pudo enviar el correo");
			
			
		}
	}

}
