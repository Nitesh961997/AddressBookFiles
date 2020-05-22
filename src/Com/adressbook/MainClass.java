package Com.adressbook;

import java.util.*;
import java.lang.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;


public class MainClass {
	private static Formatter x;	
	public static void main(String[] args) 
	{
		
		displayMenu();	
	}
	//public static void openFile(Formatter x,)
//	public static void openFile(String name)
//	{
//		newFile(name);
//		try {
//		name.format("%s   %s  %s","20", "bucky","roberts");
//		}
//		catch(Exception e)
//		{
//			System.out.println("Unable to open file");
//		}
//	}	
	public static void displayMenu()
	{
		String name;
		Scanner in=new Scanner(System.in);
		
		System.out.println("What would you like to do" );
		System.out.println("1.new");
		System.out.println("2.open");
		System.out.println("3.add");
		System.out.println("4.find");
		System.out.println("5.remove address");
		System.out.println("6.delete address Book");
		System.out.println("7.rename file");
		int choice=in.nextInt();
		in.nextLine();
		AddressBookManager abm=new AddressBookManager();
		switch(choice)
		{
		//new file
			case 1:
				System.out.println("\nName the new Address Book");
				name=in.nextLine();
				
				abm.newFile(name);
			break;
		//open file
			case 2:
			try {
				Files.list(Paths.get(".")).forEach(System.out::println);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				System.out.println("\nfilename to open");	
				name=in.nextLine();
				abm.openFile(name);
				abm.readFile(name);
				//abm.closeFile(name);
			break;
		//add address	
			case 3:
				abm.addNew();
			break;
			case 4:
				String searchWord; 
				System.out.println("find");
				System.out.println("name the file u want to search in");
				String searchFile=in.next();
				System.out.println("enter the word to search");
				searchWord=in.next();
				abm.find(searchWord,searchFile);
			break;
		//deleteaddress
			case 5:
				System.out.println("delete content in file?");
				String fileName=in.next();
				System.out.println("enter the mobile No of person You want to delete");
				String number=in.next();
			abm.delete(fileName,number);
				
			break;
		//delete file	
			case 6:
				
				System.out.println("Select the file you want to remove");
				String fileDelete=in.next();
				abm.fileDeleter(fileDelete);
			break;
			default:
				System.out.println("invalid");
			case 7:
				System.out.println("Enter the file To rename");
				String renameFile=in.next();
				System.out.println("New name of the file");
				String renameName=in.next();
				abm.rename(renameFile,renameName);
			break;
				
		}
	}

}
