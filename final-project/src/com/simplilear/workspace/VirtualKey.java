package com.simplilear.workspace;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class VirtualKey 
{
	public static void main(String[] args) throws IOException
	{	
		boolean running = true;
		
		Scanner sc = new Scanner(System.in);
	
		//object of the class FileHandle
		FileHandle fh = new FileHandle();
		
		char ch=0;
		
		do
		{
			System.out.println("Application name: ProtoType");
		    System.out.println("Developer name: Anil Kumar");
			System.out.println("Developer email: aperuru@cisco.com");
			System.out.println("\n==== Select Option ====");
			System.out.println("1. openFile");
			System.out.println("2. addFile");
			System.out.println("3. deleteFile");
			System.out.println("4. searchFile");
			System.out.println("5. Exit");
			System.out.println();
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				//open file
				System.out.println("=============");
				fh.openFile(null);
				
				break;
				
				
			case 2:
				//Add the file
				System.out.println("Enter the File Name: ");
				try
				{
					String fileToAdd = sc.next();
					
					fh.addFile(fileToAdd, sc);   
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				//Delete the file
				System.out.println("Enter the file name to Delete from the \"Virtual Key\"folder: ");
				try
				{
					String fileToDelete = sc.next();
					
					fh.deleteFile(fileToDelete, sc);
				}
				catch (InvalidFileException e) 
				{
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				//Search the file
				System.out.println("Enter the file name to search from the \"virtual key\" folder: ");
				try
				{
					String fileName = sc.next();
				
					FileHandle.openFile("/Users/aperuru/Documents/Java=Phase-1 codes/");
					FileHandle.display(fileName, "/Users/aperuru/Documents/Java=Phase-1 codes/");
				}
				catch (Exception e) 
				{
					// TODO: handle exception
				}
					break;
				
			case 5:
				//Exit the program
				System.out.println("-------Thank You! -------: ");
				running = false;
				
				sc.close();
				
				System.exit(0); //using exit method to exit the program
			default :
				System.out.println("---Please Enter the Valid Number!!---- \n");
				break;
			} 
			fh.Endisplay();            
           System.out.println("\nDo you want to continue (Type y or n) \n");
           ch = sc.next().charAt(0);
			 
			
		} while (ch == 'Y'|| ch == 'y');
		{
			if(running == true);
		}
				
	}
}


	
		

class InvalidFileException extends Exception
{
	public InvalidFileException(String s)
	{
		super(s);
	}
}



