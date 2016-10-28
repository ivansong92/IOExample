package com.github.ivansong92.IOExample;

import java.io.File;
import java.io.IOException;

/**
 * Create file 'HelloWorld.txt',then move to 'D://IOTest'.And list the content of 'D://IOTest'.
 * 
 * @author ivan
 * 
 */
public class Test1 {
	public static void main(String[] args) {
		File file = new File("D://HelloWorld6.txt");
		boolean isCreated = false;
		try {
			isCreated = file.createNewFile();
		} catch (IOException e) {
			System.out.println(e);
		}
		if (isCreated) {
			System.out.println("File is created.");
		} else {
			System.out.println("File is not created.");
		}
        System.out.println("This is a file?" + !file.isDirectory());
        
        File directory = new File("D://IOTest");
        if (directory.exists() || directory.mkdirs()) {
        	System.out.println("The directory is created.");
        	if (file.renameTo(new File(directory.getPath()+ "/" +file.getName()))) {
        		System.out.println("Move the File sucessfully.");
        	} else {
        		System.out.println("Move the File fail.");
        	}
        	
        } else {
        	System.out.println("Create the directory fail.");
        }
        
        String[] files = directory.list();
        for (String string : files) {
			System.out.println(string);
		}
        
	}
	
	
}
