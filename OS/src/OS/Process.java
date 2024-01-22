package OS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Process {
    String filepath;
    String[][] instructions;
    PCB pcb;
    int noOfInstructions;
    static int noOfProgram;
    int burst;
    public Process(String filepath) {
        this.filepath = filepath;
        pcb = new PCB();
        
        try {
        	parseTxtFile(filepath);
        }
        catch (Exception e)
        {
        	System.out.println("Parsing not successful");
        	System.out.println();
        	System.out.println(e.getMessage());
        }
        
        ReadyQueue.ReadyQueue.add(this);
       
    }

    public void parseTxtFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        
        // Count the number of lines in the file
        int lineCount = (int) reader.lines().count();
        // Reset the reader to the beginning of the file
       try
       {
        reader = new BufferedReader(new FileReader(filePath));
       }
       catch(Exception e)
       {
    	   System.out.println("No such file!");
       }
        // Create a 2D array to store the lines and words
        instructions = new String[(int) lineCount ][];//remove the + 1 later
        // Read each line and split into words
        int i = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+"); // Split by whitespace
            instructions[i] = words;
            i++;
            
           
            /*System.out.println("Instruction " + i + ": " + instructions[i]);*/
        }
        
        pcb.ID=noOfProgram++;
        noOfInstructions=lineCount;
        burst=noOfInstructions;
        Memory.allocate(this); //doesnt work yet
        reader.close();
    }
}
