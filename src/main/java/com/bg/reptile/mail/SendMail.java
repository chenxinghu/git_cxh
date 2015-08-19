package com.bg.reptile.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class SendMail {

	 public static void main(String args[]){
	        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
	        //设定mail server
	        senderImpl.setHost("smtp.qq.com");
	        senderImpl.setUsername("370493972@qq.com");
	        senderImpl.setPassword("4774021cxh");


	        //建立邮件消息
	        SimpleMailMessage mailMessage = new SimpleMailMessage();
	        //设置收件人，寄件人
	        //String[] array = new String[]    {"sun111@163.com","sun222@sohu.com"};
	        //mailMessage.setTo(array);
	        mailMessage.setTo("7726173531@qq.com");
	        mailMessage.setFrom("370493972@qq.com");
	        mailMessage.setSubject("hi ！逼逼哥");
	        mailMessage.setText("嗨，逼逼哥！！");

	        //发送邮件
	        senderImpl.send(mailMessage);

	        System.out.println("邮件发送成功.....");
	    }


}
