CPU Schedulers Simulator

Overview:
This Java program simulates key CPU scheduling algorithms including SJF, SRTF, Non-preemptive Priority Scheduling, and AG Scheduling. It addresses starvation issues and incorporates context switching.

Solution Design:
1. Each scheduler is implemented as a distinct module, ensuring modularity and easy management.
2. Custom AG scheduling algorithm integrates fairness and dynamic priority adjustments.
3. AG scheduler dynamically updates quantum time based on random function outcomes.

Input:
- Number of processes
- Round Robin Time Quantum
- Context switching
- Process details: Name, Color (Graphical Representation), Arrival Time, Burst Time, Priority Number

Output:
- Execution order of processes
- Waiting Time and Turnaround Time for each process
- Average Waiting Time and Average Turnaround Time
- History updates of quantum time for each process (AG Scheduling)

This simulator offers insight into CPU scheduling algorithms, addressing performance and fairness concerns.