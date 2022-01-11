package com.cis.mail;

import java.util.List;

public interface EmailService {
	public void sendSimpleMessage(String to, String subject, String text);

	void sendSimpleMessage(String[] to, String subject, String text);

 
	

}
