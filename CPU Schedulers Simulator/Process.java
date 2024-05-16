import java.util.Arrays;
import java.util.Scanner;

// Process class
class Process {
    String name;
    int arrivalTime;
    int burstTime;
    int priority;

    // Constructor; creates a process
    public Process(String name, int arrivalTime, int burstTime, int priority) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }
}