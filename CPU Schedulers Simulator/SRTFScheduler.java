import java.util.Arrays;
import java.util.Scanner;

// Scheduler for Shortest Remaining Time First (SRTF)
class SRTFScheduler {
    Process[] processes;

    // Constructor to set up the scheduler with a list of processes
    public SRTFScheduler(Process[] processes) {
        this.processes = processes;
    }

    // Schedule processes using the Shortest Remaining Time First (SRTF) algorithm
    public void scheduleProcesses() {
        int currentTime = 0;

        while (true) {
            Process nextProcess = null;
            int minRemainingTime = Integer.MAX_VALUE;

            // Find the process with the shortest remaining time
            for (Process process : processes) {
                if (process.burstTime > 0 && process.arrivalTime <= currentTime &&
                        process.burstTime < minRemainingTime) {
                    minRemainingTime = process.burstTime;
                    nextProcess = process;
                }
            }

            if (nextProcess == null) {
                break; // No more processes to execute
            }

            // Execute process
            System.out.println("Executing " + nextProcess.name + " from time " + currentTime +
                    " to " + (currentTime + 1));

            // Update burst time and current time
            nextProcess.burstTime--;
            currentTime++;
        }
    }
}