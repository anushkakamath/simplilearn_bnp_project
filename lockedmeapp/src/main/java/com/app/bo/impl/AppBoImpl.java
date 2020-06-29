package com.app.bo.impl;

import java.io.File;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.app.bo.AppBO;
import com.app.exception.BusinessException;
import com.app.model.User;

public class AppBoImpl implements AppBO {
	
	
	private boolean isValidName(String username) {
		boolean b = false;
		if (username.matches("admin[0-9]{0,3}")) {
			b = true;
		}
		return b;
	}
	
	
	@Override
	public User createFiles(User user, String username) {
		
		if(isValidName(username)) { 
			try {
				File myObj = new File(user.getName());
				if (myObj.createNewFile()) {
					System.out.println("File created with name: " + myObj.getName());
				} else {
					System.out.println("File already exists.");
				}
		    	} catch (IOException e) {
		    		//System.out.println("An error occurred.");
		    		new BusinessException("Enter a valid file name.");
		    	}
		}
		else {
			new BusinessException("User access denied. User "+username+" does not have rights for this operation");
		}
		return user;
		
	}

	@Override
	public void getFilesByName(String name, String username) {
		File myObj = new File(name);
		if(isValidName(username)) {
			if (myObj.exists()) {
				System.out.println("File name: " + myObj.getName());
				System.out.println("Absolute path: " + myObj.getAbsolutePath());
				System.out.println("Writeable: " + myObj.canWrite());
				System.out.println("Readable " + myObj.canRead());
				System.out.println("File size in bytes " + myObj.length());
				} else {
					System.out.println("The file does not exist.");
				}
		}
		else {
			new BusinessException("User access denied. User "+username+" does not have rights for this operation");
		}	
	}

	@Override
	public void removeFileByName(String name, String username) {
		
		File myObj = new File(name); 
		if(isValidName(username)) {
			if (myObj.delete()) { 
				System.out.println("Deleted the file "+name);
			} else {
				System.out.println("Failed to delete the file. No such file exists");
			} 
		}
	else {
		new BusinessException("User access denied. User "+username+" does not have rights for this operation");
	}
	}

	@Override
	public void getAllFiles() {
		File fileDir = new File("E:\\simpli_bnp\\java_demos_AK\\lockedmeapp");
		if(fileDir.isDirectory()){
			List<String> listFile = Arrays.asList(fileDir.list());
			Collections.sort(listFile);
			if(listFile.isEmpty()) {
				System.out.println("This Directory is empty");
			}
			else {
			System.out.println("---------------------------------------");
			System.out.println("Sorting by filename in ascending order");
			for(String s:listFile){
				System.out.println(s);
			}
			}
		}
		else{
			System.out.println(fileDir.getAbsolutePath() + " is not a directory");
		}

	}
	
}
