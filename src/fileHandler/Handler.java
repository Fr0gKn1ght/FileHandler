package fileHandler;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Handler {

	private File f;
	public Handler(String fname)
	{
		f = new File(fname);
	}
	
	public void setFile(String fname)
	{
		f = new File(fname);
	}
	
	public void create()
	{
		try
		{
			if(!f.exists())
				f.createNewFile();
			else
				System.out.println("File already exists!");
		}
		
		catch (IOException ex)
		{
			System.err.println(ex.getMessage());
		}
	}
	
	public void delete()
	{
		try
		{
			if(f.exists())
				f.delete();
			else
				System.out.println("File not found!");
		}
		
		catch(Exception ex)
		{
			System.err.println(ex.getMessage());
		}
	}
	
	public void read()
	{
		try
		{
			FileReader reader = new FileReader(f.getPath());
			int r;
			while((r=reader.read())!=-1)
				System.out.print((char)r);
			System.out.println("");
			reader.close();
			
		}
		
		catch(FileNotFoundException ex)
		{
			System.err.println(ex.getMessage());
		}
		
		catch(IOException ex)
		{
			System.err.println(ex.getMessage());
		}
	}
	
	public void write(String text, boolean append)
	{
		try
		{
			FileWriter writer = new FileWriter(f.getPath(),append);
			writer.write(text);
			writer.flush();
			writer.close();
		}
		
		
		catch(FileNotFoundException ex)
		{
			System.err.println(ex.getMessage());
		}
		
		catch(IOException ex)
		{
			System.err.println(ex.getMessage());
		}
	}
}
