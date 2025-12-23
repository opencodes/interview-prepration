import { Direction } from "./enums";

abstract class Button {
    pressed: boolean = false;

    constructor() { }

    pressDown(): void {
        this.pressed = true
    }

    abstract isPressed(): boolean;

    reset(): void {
        this.pressed = false
    }
}

export class DoorButton extends Button {

    isPressed(): boolean {
        return this.pressed;
    }
}

export class HallButton extends Button {
    direction: Direction;

    constructor(direction: Direction) {
        super()
        this.direction = direction
    }
    isPressed(): boolean {
        return this.pressed;
    }

    getDirection() {
        return this.direction;
    }
}

export class ElevatorButton extends Button {
    destinationFloor: number;

    constructor(destination: number) {
        super()
        this.destinationFloor = destination
    }

    getDestinationFloor() {
        return this.destinationFloor
    }
    isPressed(): boolean {
        throw new Error("Method not implemented.");
    }
}

export class EmergencyButton extends Button {
    getPressed() {

    }
    setPressed(val: boolean) {
        this.pressed = val
        //call alarm
        // stop car
    }
    isPressed(): boolean {
        return this.pressed
    }
}

