package com.fm.portal.util.mail;

public class MailSendUtil {
	public static boolean sendMail(String toEamil, String theme, String content) {
		MailSenderInfo mailInfo = new MailSenderInfo();

		mailInfo.setUserName("");
		mailInfo.setPassword("");
		mailInfo.setFromAddress("");

		mailInfo.setMailServerHost("smtp.163.com");
		mailInfo.setMailServerPort("25");
		mailInfo.setValidate(true);
		mailInfo.setToAddress(toEamil);
		mailInfo.setSubject(theme);
		mailInfo.setContent(content);

		SimpleMailSender sms = new SimpleMailSender();
		return sms.sendHtmlMail(mailInfo);
	}
}
