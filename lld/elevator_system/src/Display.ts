import { Direction, ElevatorState } from "./enums";

export class Display {
    floor: number = 0;
    load: number = 0;
    direction: Direction;
    state: ElevatorState;
    maintenance: boolean;
    overloaded: boolean;

    constructor() {
        this.direction = Direction.IDLE
        this.state = ElevatorState.IDLE
        this.maintenance = false
        this.overloaded = false
    }

    update(f: number, d: Direction, load: number, s: ElevatorState, overloaded: boolean, maintenance: boolean) { }
    showElevatorDisplay(carId: number) { }
}