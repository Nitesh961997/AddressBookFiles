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
		System.out.println("5.saveAs");
		System.out.println("6.remove");
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
		//edit file	
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
			case 5:
				System.out.println("select the file to save");
			break;
			case 6:
				System.out.println("Select the file you want to remove");
			break;
			default:
				System.out.println("invalid");
			break;
				
		}
	}

}
