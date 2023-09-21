package com.com.mini_project_1.Utils;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender mailSender;

	public Boolean sendMail(String sub, String body, String to, File f) throws MessagingException {
		
		try {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper helper= new MimeMessageHelper(mimeMessage, true);
		
		helper.setSubject(sub);
		helper.setText(body, true);
		helper.setTo(to);
		helper.addAttachment(to, f);;
		
		mailSender.send(mimeMessage);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
}

