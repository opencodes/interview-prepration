# Elevator System
## In this LLD interview case study, we will focus on:
- Multiple elevators coordination: Distributing requests among cars and managing their interaction.
- Request scheduling: Prioritizing and queuing floor requests.
- Capacity management: Preventing overloading.
- Real-time updates: Showing current floor, direction, and occupancy.
- Safety and fault tolerance: Managing emergencies and critical faults.
- User experience: Minimizing wait times, supporting up/down requests, and providing clear information.

## Design pattern 

- Singleton: Used for managing centralized control logic that coordinates multiple elevator cars to prevent conflicts and ensure efficient operation.
- Observer: Notifies floor panels and displays when an elevator arrives, changes state, or updates its current floor, ensuring real-time status updates.
- State: Represents different states of the elevator car (moving up, moving down, stopped), allowing the system to handle transitions smoothly.
- Strategy (Optional): Could be applied for implementing various request scheduling algorithms (e.g., nearest-car, collective control) that can be swapped as needed.
