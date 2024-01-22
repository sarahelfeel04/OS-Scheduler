package OS;

// Import the HashMap class
import java.util.HashMap;
class Memory {
    static int size;
    static int baseRegister;
    static HashMap<Integer, Integer> memory;
    static HashMap<Integer, HashMap<String, String>> variables;
    public Memory(int size) {
        this.size = size;
        memory = new HashMap<>();
        variables = new HashMap<>();
        baseRegister=0;
    }
    public Memory() {
        this.size = 50;
        memory = new HashMap<>();
        variables = new HashMap<>();
        baseRegister=0;
    }
    public static void allocate(Process p ) {
        int start = baseRegister;
        int end = p.noOfInstructions ;
        p.pcb.base=baseRegister;
        p.pcb.limit=end;
        if (start >= 0 && start < size && end >= 0 && end + baseRegister < size && start <= end + baseRegister) {
            for (int i = start; i < end + baseRegister; i++) {
                memory.put(i , p.pcb.ID);
        
                
            }
            HashMap<String, String> vars = new HashMap<>();
            variables.put(p.pcb.ID, vars);
        } else {
            System.out.println("Invalid memory allocation");
            System.out.println("Start:" + start + " End: " + end);
        }
        baseRegister+=p.noOfInstructions;
    }
    // A method to store a variable and its value for a process
    public static void storeVariable(Process p, String var, String value) {
        // Check if the process ID exists in the variables map
        if (variables.containsKey(p.pcb.ID)) {
            // Get the variables HashMap for the process
            HashMap<String, String> vars = variables.get(p.pcb.ID);
            // Store the variable and its value in the HashMap
            vars.put(var, value);
        } else {
            // Print an error message
            System.out.println("Invalid process ID");
        }
    }
    public static void printMemory() {
        for (int i = 0; i < size; i++) {
            System.out.println("Index: " + i + " " + memory.get(i));
            
        }
        System.out.println();
    }
    public static void printVariables() {
        for (Integer pid : variables.keySet()) {
            HashMap<String, String> vars = variables.get(pid);
            System.out.print("Process " + pid + ": ");
            for (String var : vars.keySet()) {
                String value = vars.get(var);
                System.out.print(var + " = " + value + ", ");
            }
            System.out.println();
        }
    }

}

