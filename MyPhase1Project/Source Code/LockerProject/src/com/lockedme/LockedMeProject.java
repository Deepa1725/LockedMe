
package com.lockedme;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class LockedMeProject 
{
    static final String folderpath="D:\\Simplilearn\\MyPhase1Project\\LockedMeFiles\\";
	public static void main(String[] args)
	{
		
		int proceed=1;
		
		do
		{
	        // Variable Declaration
		     Scanner obj= new Scanner(System.in);
		     int ch;
		
		
	       // Menus
		     displayMenu();
		     System.out.println("Enter your choice:");
		     ch=Integer.parseInt(obj.nextLine());
		
		  switch(ch)
		     {
		       case 1 :getAllFiles();
		               break;
		       case 2 :createFiles();
		               break;
		       case 3 :deleteFile();
		               break;
		       case 4 :searchFile();
		               break;
		       case 5 :System.exit(0);
		               break;
		       default:System.out.println("Invalid Option");
		               break;
		           
		     }
	 }while(proceed>0);
		
		
}
	public static void displayMenu()
	{
		System.out.println("*************************************************");
		System.out.println("\t\tLockedMe.com");
		System.out.println("*************************************************");
		System.out.println("1. Display All Files");
		System.out.println("2. Add new file");
		System.out.println("3. Delete a file");
		System.out.println("4. Search a file");
		System.out.println("5. Exit");
		System.out.println("*************************************************");
	}

	public static void getAllFiles()
	{
		// Get file names
		List<String> fileNames=FileManager.getAllFiles(folderpath);
		
		for(String f:fileNames)
			System.out.println(f);
	}
	
	/**
	 * This method creates or appends contents into the specified file
	 */
	
	public static void createFiles()
	{
		Scanner obj = new Scanner(System.in);
		String fileName;
		int linesCount;
		List<String> content = new ArrayList<String>();
		
		// Read file name from the User
		System.out.println("Enter file Name:\n");
		fileName=obj.nextLine();
		
		// Read the number of lines from the User
		System.out.println("Enter how many lines in the file:\n");
		linesCount=Integer.parseInt(obj.nextLine());
		
		//Read line from user
		for(int i=1;i<=linesCount;i++)
		  {
			System.out.println("Enter line "+i+":");
			content.add(obj.nextLine());
			
		  }
		
		// Save the content into the file
		boolean isSaved = FileManager.createFiles(folderpath, fileName, content);
		
		if(isSaved)
			System.out.println("File and Data saved Successfully.");
		else
			System.out.println("Some error occured.Please contactadmin@info.com");
		
		// Close scanner object
		//obj.close();

	}
	
	/**
	 * This method deletes the specified file from the folder.
	 */
	
	public static void deleteFile()	
	{
	 // Code for deleting a file
		String fileName;
		Scanner obj=new Scanner(System.in);
		System.out.println("Enter the file name to be deleted:");
		fileName=obj.nextLine();
		
		boolean isDeleted=FileManager.deleteFile(folderpath, fileName);
		
		if(isDeleted)
			System.out.println("File deleted successfully");
		else
			System.out.println("Either file is not there or some access issues");
		
	}
	
	/**
	 * This method will search a specified file from a folder.
	 */
	public static void searchFile()
	{
		// code for searching a file
		String fileName;
		Scanner obj= new Scanner(System.in);
		
	       System.out.println("Enter the file Name to be searched:");
           fileName=obj.nextLine();
		
		boolean isFound=FileManager.searchFile(folderpath, fileName);
		
		if(isFound)
			System.out.println("File is present in the folder.");
		else
			System.out.println("File is not present in the folder.");
		

	}
	
}




