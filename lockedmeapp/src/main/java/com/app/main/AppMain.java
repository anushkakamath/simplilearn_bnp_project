package com.app.main;

import java.util.Scanner;

import com.app.bo.AppBO;
import com.app.bo.impl.AppBoImpl;
import com.app.model.User;

public class AppMain {

	public static void main(String[] args) {
		System.out.println("Welcome to the App");
		Scanner scanner = new Scanner(System.in);
		AppBO appBO = new AppBoImpl();
		int ch=0;
		
		do {
			System.out.println("-----------------------------------");
			System.out.println("LockedMe.com App Main Menu");
			System.out.println("-----------------------------------BY : Anushka Kamath");
			System.out.println("1) Retrieve all files in the directory / folder");
			System.out.println("2) Business Level Operations Menu");
			System.out.println("3) Exit");
			System.out.println("Enter your choice");
			ch = Integer.parseInt(scanner.nextLine());
			
			switch (ch) {
			case 1: appBO.getAllFiles();
				break;
			case 2: boolean b = false;
				while(b == false) {
				System.out.println("----------------------------------");
				System.out.println("Business Level Operations Menu");
				System.out.println("----------------------------------BY: Anushka Kamath");
				System.out.println("1) Add a new file");
				System.out.println("2) Delete an existing file");
				System.out.println("3) Search a file");
				System.out.println("4) Exit Business Level Operations Menu");
				System.out.println("Enter your choice");
				int a = 0;
				a = Integer.parseInt(scanner.nextLine());
				switch (a) {
				case 1: System.out.println("Enter username:");
						String username1 = scanner.nextLine();
						System.out.println("Enter file details:");
						System.out.println("Enter file name");
						String name = scanner.nextLine();
						System.out.println("Enter file contents");
						String contents = scanner.nextLine();
						User user = new User(name, contents);
						user = appBO.createFiles(user, username1);
//						if(user!= null) {
//							if(user.getName()!= null) {
//								//System.out.println("File created with below details");
//								System.out.println(user);
//							}
//						}
					break;
				case 2: System.out.println("Enter username:");
						String username2 = scanner.nextLine();
						System.out.println("Enter file details:");
						System.out.println("Enter file name");
						String s = scanner.nextLine();
						appBO.removeFileByName(s, username2);
					break;
				case 3: System.out.println("Enter username:");
						String username = scanner.nextLine();
						System.out.println("Enter file details:");
						System.out.println("Enter file name");
						String filename = scanner.nextLine();
						//String user1 = new User(filename);
						appBO.getFilesByName(filename, username);
						
					break;
				case 4: System.out.println("Thankyou for using the business level operations.");
						b = true;
					break;
				default: System.out.println("Invalid choice. Try again");
					break;
				}
			}
				break;
			case 3: System.out.println("Thankyou for using the app");
				break;
			default: System.out.println("Invalid choice. Try again");
				break;
			}
		}while(ch!=3);
		
		

	}

}
