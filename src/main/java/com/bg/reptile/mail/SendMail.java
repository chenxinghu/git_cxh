package com.bg.reptile.mail;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class SendMail {

	 public static void main(String args[]){
	        JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
	        //�趨mail server
	        senderImpl.setHost("smtp.qq.com");
	        senderImpl.setUsername("370493972@qq.com");
	        senderImpl.setPassword("4774021cxh");


	        //�����ʼ���Ϣ
	        SimpleMailMessage mailMessage = new SimpleMailMessage();
	        //�����ռ��ˣ��ļ���
	        //String[] array = new String[]    {"sun111@163.com","sun222@sohu.com"};
	        //mailMessage.setTo(array);
	        mailMessage.setTo("7726173531@qq.com");
	        mailMessage.setFrom("370493972@qq.com");
	        mailMessage.setSubject("hi ���ƱƸ�");
	        mailMessage.setText("�ˣ��ƱƸ磡��");

	        //�����ʼ�
	        senderImpl.send(mailMessage);

	        System.out.println("�ʼ����ͳɹ�.....");
	    }


}
