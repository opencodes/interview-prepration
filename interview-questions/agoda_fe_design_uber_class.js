// Chainable Methods with a Fixed Order
// FrontendJavascriptPromise ChainingAsynchronous
// Medium
// Design a JavaScript class UberDriver that supports method chaining and enforces that coffeeBreak() always runs first, even when it's called later in the chain. All methods should return this to allow chaining.

// You must support the following methods:

// pick(passengerName, passengerId) — logs picking up a passenger.
// drive(distance) — logs driving a certain distance.
// coffeeBreak(duration) — logs a coffee break for given duration (must always run before any other action).
// status() — logs a summary of actions so far.
// drop() — logs dropping off the current passenger.
// rest(minutes) — logs rest time between rides.
// Key requirement: Even if .coffeeBreak() appears in the middle or after other calls, it should be executed first when the chain runs.

// Example Usage
// new UberDriver()
//   .pick("Alice", 1)
//   .drive(5)
//   .coffeeBreak(3)  // declared here, but must run first
//   .pick("Bob", 2)
//   .status()
//   .drop()
//   .rest(2);
// Expected Execution Order and Log Output (in console):

// Coffee break for 3 minutes
// Picked up Alice (ID: 1)
// Drove 5 miles
// Picked up Bob (ID: 2)
// Current actions: coffeeBreak -> pick(Alice) -> drive(5) -> pick(Bob)
// Dropped off Bob
// Resting for 2 minutes
// Follow-up Variation
// Now adapt your class so that:

// A driver can take a break at any time in the chain.
// But all breaks must still execute at the very start, before any other actions.
// Multiple .coffeeBreak() calls are allowed. They must all run first, in the order they were called, before any other method.
class UberDriver {
    constructor() {
        this.tasks = [];
        this.passengers = [];
        this.executeTask();
    }

    addTask(name, action, priority = 0) {
        this.tasks.push({ name, action, priority });
        return this;
    }
    //— logs picking up a passenger.
    pick(passengerName, passengerId) {
        this.passengers.push({
            passengerId,
            passengerName
        })
        return this.addTask(
            `pick(${passengerName})`,
            () => {
                console.log(`Picked up ${passengerName} (ID: ${passengerId})`);
            }
        )
    }
    //— logs driving a certain distance.
    drive(distance) {
        return this.addTask(
            `drive(${distance})`,
            () => {
                console.log(`Drove ${distance} miles`);
            }
        )
    }
    // — logs a coffee break for given duration (must always run before any other action).
    coffeeBreak(duration) {
        return this.addTask(
            `coffeeBreak(${duration})`,
            () => {
                console.log(`Coffee break for ${duration} minutes`);
            },
            1
        )
    }
    // — logs a summary of actions so far.
    status() {
        return this.addTask(
            `status`,
            () => {
                let stop = false;
                const currenttaskQueue = [];
                [...this.tasks].sort((a, b) => b.priority - a.priority).forEach(t => {
                    if (t.name == "status") {
                        stop = true;
                    }
                    if (!stop) {
                        currenttaskQueue.push(t.name);
                    }
                })
                console.log("Current actions:", currenttaskQueue.join(" -> "));
            }
        )
    }
    // — logs dropping off the current passenger.
    drop() {
        return this.addTask(
            `drop()`,
            () => {
                const passanger = this.passengers.pop();
                console.log(`Dropped off ${passanger.passengerName}`);
            }
        )
    }
    // — logs rest time between rides.
    rest(minutes) {
        return this.addTask(
            `rest(${minutes})`,
            () => {
                console.log(`Resting for ${minutes} minutes`);
            }
        )
    }

    executeTask() {
        Promise.resolve().then(() => {
            this.tasks.filter(f => f.name != "status").sort((a, b) => b.priority - a.priority).forEach(t => {
                t.action();
            })
        })
    }
}

const uberDriver = new UberDriver()
    .pick("Alice", 1)
    .drive(5)
    .coffeeBreak(3)  // declared here, but must run first
    .pick("Bob", 2)
    .status()
    .drop()
    .rest(2);