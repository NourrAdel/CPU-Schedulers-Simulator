import java.util.Arrays;
import java.util.Scanner;

// Main class for simulation
public class SchedulerSimulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User Input: Number of processes, Round Robin Time Quantum, Context Switching
        System.out.print("Enter the number of processes: ");
        int numberOfProcesses = scanner.nextInt();

        System.out.print("Enter Round Robin Time Quantum: ");
        int roundRobinTimeQuantum = scanner.nextInt();

        System.out.print("Enter Context Switching Time: ");
        int contextSwitchingTime = scanner.nextInt();

        // User Input: For each process - Process Name, Arrival Time, Burst Time, Priority
        Process[] processes = new Process[numberOfProcesses];
        for (int i = 0; i < numberOfProcesses; i++) {
            System.out.println("Enter details for Process " + (i + 1) + ":");
            System.out.print("Process Name: ");
            String processName = scanner.next();

            System.out.print("Arrival Time: ");
            int arrivalTime = scanner.nextInt();

            System.out.print("Burst Time: ");
            int burstTime = scanner.nextInt();

            System.out.print("Priority: ");
            int priority = scanner.nextInt();

            processes[i] = new Process(processName, arrivalTime, burstTime, priority);
        }

        // Simulates The SJF Scheduler
        SJFScheduler sjfScheduler = new SJFScheduler(processes.clone());
        sjfScheduler.scheduleProcesses();
        printResults("SJF", sjfScheduler.processes);

        // Simulates The SRTF Scheduler
        SRTFScheduler srtfScheduler = new SRTFScheduler(processes.clone());
        srtfScheduler.scheduleProcesses();
        printResults("SRTF", srtfScheduler.processes);

        // Simulates The Priority Scheduler
        PriorityScheduler priorityScheduler = new PriorityScheduler(processes.clone());
        priorityScheduler.scheduleProcesses();
        printResults("Priority", priorityScheduler.processes);
    }

    // Helper method to print scheduler results and calculate metrics
    private static void printResults(String schedulerName, Process[] processes) {
        System.out.println("\n" + schedulerName + " Scheduler Results:");
        System.out.println("Processes Execution Order: ");
        for (Process process : processes) {
            System.out.print(process.name + " ");
        }
        System.out.println();

        int n = processes.length;

        // Calculates and prints waiting time, turnaround time, response time
        int[] waitingTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] responseTime = new int[n];

        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int totalResponseTime = 0;
        int totalCpuTime = 0;

        int contextSwitchingTime = 2;

        for (int i = 0; i < n; i++) {
            turnaroundTime[i] = processes[i].burstTime + waitingTime[i];
            responseTime[i] = waitingTime[i] + processes[i].arrivalTime;
            totalWaitingTime += waitingTime[i];
            totalTurnaroundTime += turnaroundTime[i];
            totalResponseTime += responseTime[i];

            if (i > 0) {
                waitingTime[i] = Math.max(0, turnaroundTime[i - 1] - processes[i].arrivalTime);
                totalCpuTime += processes[i].burstTime + contextSwitchingTime; // context switching
            } else {
                waitingTime[i] = processes[i].arrivalTime;
                totalCpuTime += processes[i].burstTime;
            }
        }

        System.out.println("\n" + "Average Waiting Time: " + (double) totalWaitingTime / n);
        System.out.println("Average Turnaround Time: " + (double) totalTurnaroundTime / n);
        System.out.println("Average Response Time: " + (double) totalResponseTime / n);
    }
}