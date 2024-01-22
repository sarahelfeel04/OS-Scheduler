package OS;

import java.security.cert.PolicyQualifierInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RoundRobin implements Scheduler {
    static int q;
    Queue<Process> RRQ = new LinkedList<Process>();
    
    public RoundRobin(int quantum){
        q = quantum;
        while (!ReadyQueue.ReadyQueue.isEmpty()){
        	
            Process tmp = ReadyQueue.ReadyQueue.remove();
            if ( tmp.burst <= q)
            	RRQ.add(tmp);
            else
            {
                tmp.burst-=q;
                ReadyQueue.ReadyQueue.add(tmp);
                RRQ.add(tmp);
            }
        }
    }
    
    @Override
    public Process scheduleNextProcess() {
        return RRQ.remove();
    }

	public void showQueue() {
		System.out.println();
    	System.out.println("Ready Queue: ");
		int size = RRQ.size();
		for( int i = 0 ; i < size ; i ++)
		{
			Process temp = RRQ.remove();
			System.out.print("Process: " + temp.pcb.getID());
			if (i < size - 1) {
		        System.out.print(" -> ");
		    }
			RRQ.add(temp);
		}
		System.out.println();
		
	}
    
}
