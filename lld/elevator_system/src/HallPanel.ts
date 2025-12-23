import { HallButton } from "./Button";
import { Direction } from "./enums";

export class HallPanel {
    private up: HallButton;
    private down: HallButton;

    constructor(floor: number, topFloor: number) {
        let direction: Direction
        direction = (floor < topFloor) ? Direction.UP : Direction.DOWN
        this.up = new HallButton(direction)
        this.down = new HallButton(direction)
    }

    getUpButton() {
        return this.up
    }

    getDownButton() {
        return this.down
    }
}