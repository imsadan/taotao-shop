package com.taotao.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.taotao.commons.ftp.FtpUtil;


public class ftpTest {
	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream fStream=new FileInputStream(new 
				File("C:\\Users\\Administrator\\Pictures\\1.jpg"));
		
		 FtpUtil.uploadFile("192.168.109.128", 21, "ftpuser", "ftpuser", "/home/ftpuser/www/images","2017/03/29","1.jpg", fStream );
	}
}
