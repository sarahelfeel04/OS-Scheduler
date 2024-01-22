package OS;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {
	
	public static boolean flag;
	
    public static void main(String[] args) {
    	
    	Scanner sc = new Scanner(System.in);

        System.out.println("Hello and welcome!");
        System.out.println();
        int num = 0;
        
    	while ( num <=0)
    		
    	{
	        System.out.println("Please enter the number of files");
	        String nums = sc.nextLine();
	        try
	        {
	        	  num = Integer.parseInt(nums);
	        
	        } 
	        catch
	        (NumberFormatException e) 
	        {
	        	  System.out.println("The string is not an integer.");
	        	  
	        }
    	}
       String Paths[] = new String[num];
       Memory memory = new Memory(50);
      
      
        for (int i = 0; i < num; i++) {

        	String s;
        	while(true)
        	{
	        	System.out.println("\nEnter the file path");
	        	s = sc.nextLine();
	        	 try {
	        		 BufferedReader reader = new BufferedReader(new FileReader(s));
	        		 break;
	             }
	             catch (Exception e)
	             {
	             	System.out.println("Parsing not successful");
	             	System.out.println();
	             	System.out.println(e.getMessage());
	             }
        	}
        	Paths[i] = s;
        	Process p = new Process( Paths[i]);
            
        }
        
        int size = ReadyQueue.ReadyQueue.size();
        System.out.println();
        System.out.println("Queue: ");
        for(int i = 0; i < size; i++)
        {
     	   Process temp = ReadyQueue.ReadyQueue.remove();
     	   System.out.println("Process: " + temp.pcb.getID());
     	   ReadyQueue.ReadyQueue.add(temp);
        }
       
        String alg;
        do {
        	
        System.out.println();
        System.out.println("Which Scheduling algorithm would you like to use: (SJF or RR)");
        alg = sc.nextLine();
        alg=alg.toLowerCase();
        }
        while( !alg.equals("rr") && !alg.equals("sjf") );
        
        if( alg.equals("sjf"))
        {
        	 SJF sjf = new SJF();
             flag = true;
             while(!sjf.pq.isEmpty())
             {
             	System.out.println("--------------------------------------------------------------------------------------");
             	sjf.showQueue();
          	    Execution.execute(sjf.scheduleNextProcess());
          	}
        }
        else 
        	if( alg.equals("rr") ) 
        	{
        	RoundRobin rr = new RoundRobin(2);
            flag = false;
            while(!rr.RRQ.isEmpty())
            {
            	System.out.println("--------------------------------------------------------------------------------------");
            	rr.showQueue();
         	    Execution.execute(rr.scheduleNextProcess());
            }
        	
        	}
        	else
        	{
        		System.out.println("ERR 404");	
        	}
        

        
    	System.out.println("--------------------------------------------------------------------------------------");
    	System.out.println();
    	System.out.println("Final Memory State: \n");
       Memory.printVariables();
       
		System.out.println();
		System.out.println("Gantt Chart: ");
		System.out.println(Execution.ganttx);
		System.out.println(Execution.gantts + " |");
		System.out.println(Execution.ganttx);
		System.out.println(Execution.ganttn);
		System.out.println();
		
       
    }
    
    
    
    
}