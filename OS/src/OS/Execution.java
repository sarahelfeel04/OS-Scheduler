package OS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Execution {

	static String ganttx = " ";
	static String gantts = "";
	static String ganttn = " 0";
	static int cycle = 0;
	
	public static void main(String[] args) {
		
	}
	
	public static int ok(Process p)
	{
		if(Main.flag)
			return p.noOfInstructions;
		else
			return p.pcb.pc + RoundRobin.q ;
		
	}
	public static void execute(Process p)
	{		
		//Show Process about to run
		System.out.println();
		System.out.println("Current process on CPU: " + p.pcb.getID());
		System.out.println();
		int theEnd = ok(p);
		//Gantt Chart String add and show
		
		
		
		for(int i = p.pcb.pc; i < Math.min(theEnd, p.noOfInstructions); i++)
		{
			
			
			
				String inst = p.instructions[i][0];
				switch(inst)
				{
				case "assign": assignMethod(p.instructions[i], p); System.out.println("Assign Complete!");break;
				case "writeFile": writeToFile(p.instructions[i][1], p.instructions[i][2], p); System.out.println("WriteToFile Complete!");break;
				case "print": 	
				{
					HashMap<String, String> processVariables = Memory.variables.get(p.pcb.getID());
					String val = processVariables.get( p.instructions[i][1] );
					System.out.println("Print");
					System.out.println( val );
					break;
				}
				default: System.out.println("Invalid program!");
				}
			
			p.pcb.pc ++;
			cycle++;
		}
		
		gantts += " | " + " Process " + p.pcb.getID();
		if( cycle > 10)
			ganttn += "           " +  cycle;
		else
			ganttn += "            " +  cycle;
		ganttx += "-------------";
		System.out.println();
		System.out.println("Gantt Chart: ");
		System.out.println(ganttx);
		System.out.println(gantts + " |");
		System.out.println(ganttx);
		System.out.println(ganttn);

		System.out.println();
		//Mem state
		System.out.println();
		System.out.println("Memory state: ");
	    Memory.printVariables();
	    System.out.println();
	}
	/* storeVariable(Process p, String var, String value)*/
	public static void assignMethod(String s[], Process p)
	{
		switch(s[2])
		{
		case "input": 
		{
			System.out.println("Please input the value");
			Scanner sc = new Scanner(System.in);
			String in = sc.nextLine();  
			Memory.storeVariable( p, s[1], in);
			
			break;
		}	
		case "readFile":
			{
		        HashMap<String, String> processVariables = Memory.variables.get(p.pcb.getID());
				String path = processVariables.get(s[3]);
				try {
					 BufferedReader reader = new BufferedReader(new FileReader(path));
					 String line = "";
					 String text = "";
				        while ((line = reader.readLine()) != null) 
				            text += line;
				        Memory.storeVariable( p, s[1], text);  
				       reader.close(); 
	
				}
				catch(Exception e)
				{
					System.out.println(e.getMessage());
				}
				
				break;
			}
			

			
		default: arithmetic( s[1], s[2], s[3], s[4], p); break;
		
		}
	}
	
	public static void arithmetic(String res, String op, String x , String y, Process p)
	{

		try {
			
			HashMap<String, String> processVariables = Memory.variables.get(p.pcb.getID());
			double operand1 = Double.parseDouble( processVariables.get(x) );
			double operand2 = Double.parseDouble( processVariables.get(y) );

			
			double ans = 0;
			switch(op)
			{
				case "add": ans = operand1 + operand2; break;
				case "subtract": ans = operand1 - operand2; break;
				case "multiply": ans = operand1 * operand2; break;
				case "divide": 
				{	
					try 
					{
						
						ans = operand1 / operand2; break;

					}
				catch(Exception e)
					{
						System.out.println(e.getMessage());
					}
					
				}
				default: System.out.println("This is not an operator!");
			}

			Memory.storeVariable( p, res, ans + "");
		}
		catch(Exception e)
		{
			System.out.println("Number format Exception");
		}
				
		
	}
	public static void writeToFile( String dest, String in, Process p)
	{
		HashMap<String, String> processVariables = Memory.variables.get(p.pcb.getID());
		String input = processVariables.get(in);
		String fileName = processVariables.get(dest);
		
        File file = new File(fileName);
        
        try 
        (
        	BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(input);
        }

     catch (IOException e) {
        System.out.println("An error occurred while creating the file.");
    }
        

        
	}

}
