import java.util.Arrays;
import java.util.Scanner;

// Scheduler for Shortest Job First (SJF)
class SJFScheduler {
    Process[] processes;

    // Constructor to set up the scheduler with a list of processes
    public SJFScheduler(Process[] processes) {
        this.processes = processes;
    }

    // Schedule processes using the Shortest Job First (SJF) algorithm
    public void scheduleProcesses() {
        // Sort processes based on burst time
        Arrays.sort(processes, (p1, p2) -> p1.burstTime - p2.burstTime);

        int currentTime = 0;
        // Execute processes in order of sorted burst time
        for (Process process : processes) {
            System.out.println("Executing " + process.name + " from time " + currentTime +
                    " to " + (currentTime + process.burstTime));

            currentTime += process.burstTime;
        }
    }
}