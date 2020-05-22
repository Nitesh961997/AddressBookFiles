package Com.adressbook;

import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

public class AddressBookManager
{
	
	Scanner in=new Scanner(System.in);
	private static Formatter x;
	private static Scanner y;
	private static String choice, name;
	 
	
	
	//newFile
	public void newFile(String name)
	 {
		File f1=new File(name);
		try
		{f1.createNewFile();
		}
		catch(Exception e)
		{
			System.out.println("Error");
		}
		System.out.printf("is Exist:"+ f1.exists());
//		 try {
//				x=new Formatter(name);
//			}
//			catch(Exception e)
//			{
//				System.out.println("file not created");
//			}
			System.out.println("\nfile created"+name);
			MainClass.displayMenu();
	 }
	
	 
	 
	 //read file
	 public void openFile(String name)
	 {
		 try 
		 {
			 y=new Scanner(new File(name));
		 }
		 catch(Exception e)
		 {
			 System.out.println("file not found");
		 }
	 }
//	 public void readFile(String name)
//	 {
//		 File file=new File("name");
//		 Scanner scan = null;
//		
//		 while(y.hasNext())
//		
//		 {
////			 System.out.println("\n");
//			 String firstName=y.next();
//			 String	lastName=y.next();
//			 String phoneNumber=y.next();
//			 System.out.printf("\n%s  %s  %s",firstName,lastName,phoneNumber);
//		 }
//		 System.out.println("ok");
//		 y.close();
//		 mainMenu();
//	 }
	 
//	 public void closeFile(String name)
//	 {
//		 y.close();
//		 MainClass.displayMenu();
//	 }
	 public void readFile(String name)
	 {
		 String fileName=name;
			File file=new File(fileName);
			
			try {
				Scanner inputStream = new Scanner(new File(fileName));
				while(inputStream.hasNext()) {
					String data=(inputStream.next());
					System.out.println(data);
				}
				System.out.println("=============================");
				inputStream.close();
			} catch (Exception e) 
			{}
			mainMenu();
				// TODO: handle exception
	 }
	 
	 
	 
	 
	 //add New Data
	 public void addNew()
	 {
		 Person person=new Person();
		 Address add=new Address();
		 System.out.println("enter first name");
		 String fName=in.nextLine();
		 person.setFirstName(fName);
		 System.out.println("enter last name");
		 String lName=in.nextLine();
		 person.setLastName(lName);
		 System.out.println("enter mobile No");
		 long mNumber=in.nextLong();
		 person.setPhoneNumber(mNumber);
		 System.out.println("enter city name");
		 String ncity=in.next();
		 person.setCity(ncity);
		 System.out.println(person.getCity());
		 System.out.println("enter state name");
		 String state=in.next();
		 person.setState(state);
		 System.out.println("enter Zip");
		 int zip=in.nextInt();
		 person.setZip(zip);
		 System.out.println(person.getCity());
		 System.out.println("what is name of file to add ");
		 String fileDir=in.next();
		 try {
			FileWriter fw= new FileWriter(fileDir,true);
			BufferedWriter bw=new BufferedWriter(fw);
			PrintWriter pw=new PrintWriter(bw);
			 pw.println(person.getFirstName()+","+person.getLastName()+","+person.getPhoneNumber()+","+person.getCity()+","+person.getState()+","+person.getZip());
			 pw.flush();
			 pw.close();
//			 JOptionPane.showMessageDialog(null,"data saved");
			 System.out.println("data saved");
			 MainClass.displayMenu();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
		}
	 }
	 public void find(String searchWord,String searchFile)
	 {
		 boolean found =false;
		 
		 String firstName=""; String lastName=""; String mobNo=""; String city=""; String state=""; String zip="";
		
		 try 
		 {
			 y=new Scanner(new File(searchFile));
			 y.useDelimiter("[,\n]");
			 while(y.hasNext() && found==false)
			 {
				firstName=y.next();
				lastName=y.next();
				mobNo=y.next();
				city=y.next(); 
				state=y.next();
				zip=y.next();
				if(mobNo.equals(searchWord))
					{
						found=true;
						System.out.println(firstName+","+lastName+","+mobNo+","+city+","+state+","+zip);
					}
				else
					{
						System.out.println("error");
					}
			 }
		 }
		 catch(Exception E)
		 {
			 System.out.println("Error");
		 }
	 }
	 
	 
	 //delete data
	 public void delete(String fileName,String number)
	 {
		 String tempFile="temp.csv";
//		 File oldFile=new File(fileName);
//		 File newFile=new File(tempFile);
		 String firstName=""; String lastName=""; String mobNo=""; String city=""; String state=""; String zip="";
		 try
		 {
			 FileWriter fw=new FileWriter(tempFile,true);
			 BufferedWriter bw=new BufferedWriter(fw);
			 //PrintWriter pw=new PrintWriter(bw);
			 y=new Scanner(new File (fileName));
			 y.useDelimiter("[,\n]");
			 
			 while(y.hasNext())
			 {
				firstName=y.next();
				lastName=y.next();
				mobNo=y.next();
				System.out.println(mobNo);
				city=y.next(); 
				state=y.next();
				zip=y.next();
				if(mobNo.equals(number))
				{
					System.out.println("deleted row with mobile no"+number);
				}
				else
				{
					bw.write(firstName+","+lastName+","+mobNo+","+city+","+state+","+zip);
				}
			 }
			 	y.close();
			 	//fw.flush();
			 	bw.flush();
				bw.close();
				fw.close();
				AddressBookManager abm=new AddressBookManager();
				//abm.fileDeleter(fileName);
				abm.rename(fileName,tempFile);
				
//				File oldName = new File(fileName);
//				File newName = new File(tempFile);
//				oldName.renameTo(newName);
//				if (oldName.renameTo(newName))  
//		            System.out.println("Renamed successfully");         
//		        else 
//		            System.out.println("Error");
//				oldFile.delete();
//				File dump=new File(fileName);
//				newFile.renameTo(dump);
//				System.out.println("9");
		 }
		 catch(Exception e)
		 {
			 System.out.println("Error");
			 e.printStackTrace();
		 }
		 AddressBookManager abm=new AddressBookManager();
		 
//			  File myObj = new File(fileName); 
//			  System.out.println(myObj);
//			  if (myObj.delete()) { 
//		      System.out.println("Deleted the file: " + myObj.getName());
//		    } else {
//		      System.out.println("Failed to delete the file.");
//		    }
//		      	File oldName = new File(fileName);
//				File newName = new File(tempFile);
//				//newName.renameTo(oldName);
//				if (newName.renameTo(oldName))  
//		            System.out.println("Renamed successfully");         
//		        else 
//		            System.out.println("Error");
	 }
		 
	 public void fileDeleter(String fileDelete)
	 {
		 File myObj = new File(fileDelete); 
		  System.out.println(myObj);
		  if (myObj.delete()) { 
	      System.out.println("Deleted the file: " + myObj.getName());
	    } else {
	      System.out.println("Failed to delete the file.");
	    } 
		  MainClass.displayMenu();
	 }
	 public void rename(String renameFile,String renameName)
	 {
		 File oldName = new File(renameFile);
			File newName = new File(renameName);
			if (oldName.renameTo(newName))  
	            System.out.println("Renamed successfully");         
	        else 
	            System.out.println("Error");
	 }
	 public void singleAdressBookOpenAtATime()
	 {
		 
	 }
	 public void Trackrecord()
	 {
		 
	 }
	 public static void mainMenu()
	 {
		 MainClass.displayMenu();
	 }
}