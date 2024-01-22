# OS Scheduler with Round Robin and Shortest Job First

This project is an implementation of an Operating System scheduler with Round Robin and Shortest Job First (SJF) algorithms. The scheduler manages the execution of programs that arrive at time zero. Each program is defined in a text file containing instructions for variable assignments, arithmetic operations, file I/O, and print commands.

## Project Overview

### Input
The system takes three text files as input, each containing programs with instructions. The instructions include variable assignments, arithmetic operations, file I/O, and print commands.

### Components Implemented

- Queue: A data structure for managing the ready queue.
- Memory: Allocation and management of memory for storing variables and program data.
- PCB: Keeps track of Process ID, Program Counter, and Memory Boundaries for each program.
- Scheduling Algorithms: Round Robin (quantum=2), Shortest Job First
- Functions/Operations Implemented, Assigning values to variables, Arithmetic operations, File I/O, Print commands. 

### Implementation Steps

The OS Scheduler project implements a process scheduler capable of managing programs with variable assignments, arithmetic operations, file I/O, and print commands. The system uses Round Robin and Shortest Job First (SJF) scheduling algorithms to efficiently execute tasks arriving at time zero. The implementation involves initializing queues and memory, parsing program instructions, and executing operations such as variable assignments, arithmetic operations, and file I/O. The scheduler prints real-time updates on the ready queues, processor status, memory state, and generates Gantt charts for each scheduling algorithm. Testing and debugging ensure correct execution.

### Expected Outputs at Each Clock Cycle

1. **Ready Queues**
   - Display the contents of the Ready queue.

2. **Processor Status**
   - Indicate which process is currently on the processor (CPU).

3. **Memory State**
   - Showcase the state of memory after each operation.
     - Variables and their assigned values.
     - Any changes in memory due to file I/O or program execution.

4. **Gantt Chart**
   - Display the Gantt chart for each scheduling algorithm.

Absolutely, you can simplify the "How to Use" section accordingly. Here's the updated version:

## How to Use

1. **Download and Run:**
   - Download the project by cloning the repository:
     ```bash
     git clone https://github.com/your-username/os-scheduler.git
     ```
   - Navigate to the project directory and run the main file:
     ```bash
     cd os-scheduler
     make
     ./scheduler
     ```

2. **Configure Input:**
   - Replace the default input text files with your specific programs for testing.

3. **Customize Scheduling:**
   - Tailor scheduling algorithms and parameters based on your requirements by modifying the relevant sections in the code.

4. **Explore Outputs:**
   - Observe real-time updates on ready queues, processor status, memory state, and Gantt charts during execution.

Feel free to adapt the instructions based on any specific setup or considerations for running your OS scheduler project.



