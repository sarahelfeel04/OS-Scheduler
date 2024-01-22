package OS;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;
import java.util.LinkedList;

public class SJF implements Scheduler{
    Comparator<Process> cmp = new Comparator<Process>() {
        @Override
        public int compare(Process p1, Process p2) {
            return (p1.noOfInstructions)-(p2.noOfInstructions);
        }
    };
    PriorityQueue<Process> pq = new PriorityQueue<Process>(cmp);

    public SJF() {
        while(!ReadyQueue.ReadyQueue.isEmpty()){
            pq.add(ReadyQueue.ReadyQueue.remove());
        }
    }
    public Process scheduleNextProcess() {
        return pq.remove();
    }
    
    public void showQueue() {
    	System.out.println();
    	System.out.println("Ready Queue: ");
		int size = pq.size();
		Queue<Process> nq = new LinkedList<Process>();
		
		for( int i = 0 ; i < size ; i ++)
		{
			Process temp = pq.remove();
			System.out.print("Process: " + temp.pcb.getID() );
			if (i < size - 1) {
		        System.out.print(" -> ");
		    }
			nq.add(temp);
		}
		while( !nq.isEmpty())
			pq.add(nq.remove());
		
		System.out.println();
		
	}
    
}
