package com.bg.reptile.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
	
	public static void write(byte[] data, String filepath){
		File file = new File(filepath);
		try {
			FileOutputStream fop = new FileOutputStream(file);
			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			// get the content in bytes
			byte[] contentInBytes = data;

			fop.write(contentInBytes);
			fop.flush();
			fop.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void write(String content, String path, String name,
			String suffix) {
		String fileFull = name + "." + suffix;
		String filePath;
		;
		if (path.endsWith("/")) {
			filePath = path + fileFull;
		} else {
			filePath = path + "/" + fileFull;
		}
		File file = new File(filePath);
		try {
			FileOutputStream fop = new FileOutputStream(file);
			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			// get the content in bytes
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();
			System.out.println(name+" is Done");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
