# Airport Simulation

Airport Simulation is a simulation model of the real-word process involved with several airports. It mainly focuses on arrival event, landing event, and departure event of various airplanes in different airports with one runway. Random process is employed there for simulation

**The project is evolving. Features, such as Multiple runways, departure runway time, weather condition and GUI, will be impelemented.**

### How to run

```java
javac AirportSim.java
java AirportSim
```

### Output Example

You may modify the configuration in AirportSim.java

```java
4.00: Airplane3 arrives at airport JFK
4.00: Airplane6 arrives at airport LAX
5.00: Airplane1 arrives at airport LAX
5.00: Airplane2 arrives at airport ATL
5.00: Airplane8 arrives at airport JFK
7.00: Airplane5 arrives at airport DCA
8.00: Airplane4 arrives at airport SFO
10.00: Airplane7 arrives at airport ATL
10.00: Airplane2 lands at airport ATL
14.00: Airplane6 lands at airport LAX
14.00: Airplane4 lands at airport SFO
15.00: Airplane5 lands at airport DCA
15.00: Airplane7 lands at airport ATL
16.00: Airplane3 lands at airport JFK
18.00: Airplane2 departs from airport ATL
21.00: Airplane4 departs from airport SFO
23.00: Airplane7 departs from airport ATL
24.00: Airplane1 lands at airport LAX
24.00: Airplane5 departs from airport DCA
26.00: Airplane3 departs from airport JFK
28.00: Airplane8 lands at airport JFK
34.00: Airplane6 departs from airport LAX
37.11: Airplane2 arrives at airport SFO
38.00: Airplane8 departs from airport JFK
39.57: Airplane4 arrives at airport LAX
42.40: Airplane7 arrives at airport SFO
43.11: Airplane2 lands at airport SFO
44.00: Airplane1 departs from airport LAX
45.57: Airplane5 arrives at airport SFO
48.39: Airplane3 arrives at airport DCA
49.11: Airplane7 lands at airport SFO
49.57: Airplane4 lands at airport LAX
50.11: Airplane2 departs from airport SFO
54.59: Airplane6 arrives at airport SFO
55.11: Airplane5 lands at airport SFO
56.11: Airplane7 departs from airport SFO
56.39: Airplane3 lands at airport DCA
61.11: Airplane6 lands at airport SFO
61.48: Airplane8 arrives at airport ATL
62.11: Airplane5 departs from airport SFO
64.59: Airplane1 arrives at airport SFO
65.39: Airplane3 departs from airport DCA
66.48: Airplane8 lands at airport ATL
68.11: Airplane6 departs from airport SFO
68.68: Airplane2 arrives at airport LAX
69.57: Airplane4 departs from airport LAX
70.59: Airplane1 lands at airport SFO
74.48: Airplane8 departs from airport ATL
74.72: Airplane7 arrives at airport LAX
77.59: Airplane1 departs from airport SFO
78.68: Airplane2 lands at airport LAX
Simulator stopping at time: 80.0
LAX Landing Flow: 2410; Departure Flow: 1348; Circle Time: 9.00
ATL Landing Flow: 1362; Departure Flow: 1461; Circle Time: .00
JFK Landing Flow: 884; Departure Flow: 894; Circle Time: 11.00
SFO Landing Flow: 2818; Departure Flow: 2858; Circle Time: 4.78
DCA Landing Flow: 883; Departure Flow: 966; Circle Time: .00
```





