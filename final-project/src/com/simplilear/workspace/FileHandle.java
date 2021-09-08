
package com.simplilear.workspace;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FileHandle
{
	//code for search the file in the folder
	public static void searchFile(String path, String fileName, List<String> fileListNames) 
	{
		File dir = new File("/Users/aperuru/Documents/Java=Phase-1 codes/");
		File[] files = dir.listFiles();
		List<File> filesList = Arrays.asList(files);

		if (files != null && files.length > 0)
		{
			for (File file : filesList) 
			{

				if (file.getName().startsWith(fileName)) 
				{
					fileListNames.add(file.getAbsolutePath());
					
				}

				// Need to search in directories separately to ensure all files of required
				// fileName are searched
				if (file.isDirectory()) 
				{
					searchFile(file.getAbsolutePath(), fileName, fileListNames);
					
				}
				
			}
			
		}
	}

	
	
		

//code for Add file in the folder
	public static void addFile(String fileToAdd,Scanner sc) throws InvalidFileException
	{
		Path pathToFile = Paths.get("/Users/aperuru/Documents/Java=Phase-1 codes/" +fileToAdd);
		
		try
		{
			
			Files.createDirectories(pathToFile.getParent());
			Files.createFile(pathToFile); 
			
				System.out.println(fileToAdd + " created successfully");
			
			
		} 
		catch (IOException  e) 
		{
			
			System.err.println("File Already present \n"+e.getMessage());
		}
		
	}



	//code for sort the file in Ascending order
	public static void openFile(String sname)
	{
		try
		{
			// path of the folder
			File fdir = new File("/Users/aperuru/Documents/Java=Phase-1 codes/"); //path 
			if(fdir.isDirectory())
			{
				List listFile = Arrays.asList(fdir.list());
				
				
				Collections.sort(listFile);   //sort
				System.out.println("File Name Sorted In Ascending Order");
				for(Object name : listFile)
				{
					System.out.println(name);
				}
			}
			else
			{
				System.out.println(fdir.getName() +" No Such File Found!----");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			System.out.println("\n Inside the Virtual Key Folder");
		}
		
	}
	
	//code for display the file 
	public static List<String> display(String fileName, String path)
	{
		List<String> fileListNames = new ArrayList<>();
		FileHandle.searchFile(path, fileName, fileListNames);

		if (fileListNames.isEmpty())
		{
			
			System.out.println("\n Unsuccessful Operation \n------File Not find with the given file name \"" + fileName + "\" ------\n\n");  //file not found 
		} 
		else 
		{
			System.out.println("\n Successful Operation \nFound file at below location(s):");

			List<String> files = IntStream.range(0, fileListNames.size())
					.mapToObj(index -> (index + 1) + ": " + fileListNames.get(index)).collect(Collectors.toList());

			files.forEach(System.out::println);
		}

		return fileListNames;
	}


	// Code for delete the file 
	public static void deleteFile(String fileToDelete,Scanner sc) throws InvalidFileException
	{
		
		       
		File f= new File("/Users/aperuru/Documents/Java=Phase-1 codes/"+fileToDelete);           //file to be delete  
		if(f.delete())                      //returns Boolean value  
		{  
			System.out.println(f.getName() + " Sucessfully Deleted");   //getting and printing the file name  
		}  
		else  
		{  
				throw new InvalidFileException("File Not Found");
		}  
		
	}





	public void Endisplay()
	{
		// TODO Auto-generated method stub
		
	}
}
	
	
	



