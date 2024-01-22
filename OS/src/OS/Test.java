package OS;

import java.io.IOException;

public class Test {
    public static void main (String args []) throws IOException {

        // Create an object of the Memory class with size 20
        Memory m = new Memory();
        // Allocate some space for the processes
        //m.allocate(new Process();
       // m.allocate(new Process();
       // m.allocate(new Process();
        // Store some variables for the processes
        /*m.storeVariable(new Process(1, 10), "x", 5);
        m.storeVariable(new Process(1, 10), "y", 10);
        m.storeVariable(new Process(2, 5), "z", 15);
        m.storeVariable(new Process(3, 15), "a", 20);
        m.storeVariable(new Process(3, 15), "b", 25);
        // Print the memory contents*/
        m.printMemory();
        // Print the variables contents
        m.printVariables();

    }
}
