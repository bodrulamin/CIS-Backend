package com.cis.mail;

import org.springframework.stereotype.Component;

import java.util.List;

public interface EmailService {
	
	public void sendSimpleMessage(String to, String subject, String text);

	void sendSimpleMessage(String[] to, String subject, String text);

 
	

}
