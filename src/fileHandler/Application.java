package fileHandler;
import java.util.Scanner;

public class Application 
{
	public static void main(String[] args)
	{
		Handler handle = new Handler("temp.txt");
		Scanner in = new Scanner(System.in);
		boolean terminate = false;
		while(true)
		{	System.out.println(">>");
			String input = in.nextLine();
			String[] op = input.split(" ");
			
			if(op.length > 1)
				handle.setFile(op[1]);
			
			
			switch(op[0])
			{
			case "create","Create":
				handle.create();
				break;
			case "delete","Delete":
				handle.delete();
				break;
			case "read","Read":
				handle.read();
				break;
			case "write","Write":
				System.out.println("Enter the text to write: ");
				String toWrite = in.nextLine();
				handle.write(toWrite, false);
				break;
			case "append","Append":
				System.out.println("Enter the text to add: ");
				String toAppend = in.nextLine();
				handle.write(toAppend, true);
				break;
			case "quit","Quit":
				terminate = true;
				break;
			default:
				System.out.println("Invalid Operation: must be \"create\", \"delete\", \"read\", \"write\", \"append\" or \"quit\".");
			}	
			if(terminate)
				break;
		}
		in.close();
		System.out.println("Goodbye");
	}
}
