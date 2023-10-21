/**
 *Project1-Parking Spot System
 *
 * @author Warnakulasuriya Sarani Erandi Umeshika Tissera(104210269)
 * @version 1.1
 * @date 2023.09.10
 */
public class ParkingSlot {
    private String slotID;
    private boolean occupied;
    private Car parkedCar;

    public ParkingSlot(String slotID) {
        this.slotID = slotID;
        this.occupied = false;
        this.parkedCar = null;
    }

    public String getSlotID() {
        return slotID;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public Car getParkedCar() {
        return parkedCar;
    }

    public void parkCar(Car car) {
        this.parkedCar = car;
        this.occupied = true;
    }

    public void removeCar() {
        this.parkedCar = null;
        this.occupied = false;
    }
}