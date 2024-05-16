import java.util.Arrays;
import java.util.Scanner;

// Scheduler for Priority Scheduling
class PriorityScheduler {
    Process[] processes;

    // Constructor to set up the scheduler with a list of processes
    public PriorityScheduler(Process[] processes) {
        this.processes = processes;
    }

    // Schedule processes using the Priority Scheduling algorithm
    public void scheduleProcesses() {
        int n = processes.length;

        // Sort processes based on priority using Bubble Sort
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (processes[j].priority > processes[j + 1].priority) {
                    // Swap processes if they are out of order
                    Process temp = processes[j];
                    processes[j] = processes[j + 1];
                    processes[j + 1] = temp;
                }
            }
        }

        int currentTime = 0;
        // Execute processes in order of sorted priority
        for (Process process : processes) {
            System.out.println("Executing " + process.name + " from time " + currentTime +
                    " to " + (currentTime + process.burstTime));

            currentTime += process.burstTime;
        }
    }
}