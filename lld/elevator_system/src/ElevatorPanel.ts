import { DoorButton, ElevatorButton, EmergencyButton } from "./Button"

export class ElevatorPanel {
    floorButtons: ElevatorButton[] = []
    openButton: DoorButton
    closeButton: DoorButton
    emergencyButton: EmergencyButton

    constructor(floor: number) {
        for (let i = 0; i < floor; i++) {
            this.floorButtons.push(new ElevatorButton(i));
        }
        this.openButton = new DoorButton()
        this.closeButton = new DoorButton()
        this.emergencyButton = new EmergencyButton()
    }

    enterEmergency(): void {
        this.emergencyButton.setPressed(true)
    }

    exitEmergency() {
        this.emergencyButton.setPressed(false)
    }
}