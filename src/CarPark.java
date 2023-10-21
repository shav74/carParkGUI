/**
 *Project1-Parking Spot System
 *
 * @author Warnakulasuriya Sarani Erandi Umeshika Tissera(104210269)
 * @version 1.1
 * @date 2023.09.10
 */
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;


public class CarPark {
    public static ArrayList<ParkingSlot> parkingSlots;
    Scanner scanner = new Scanner(System.in);
    private static CarPark instance;

    public CarPark() {
        this.parkingSlots = new ArrayList<>();
    }

    public static CarPark getInstance(){
        if(instance == null){
            instance = new CarPark();
        }
        return instance;
    }

    public void addParkingSlot(String slotID) {
        // Check if the slot already exists
        if (findParkingSlot(slotID) != null) {
            WindowSetup.setMessage("Slot " + slotID + " already exists.");
            return; // Exit the method if the slot already exists
        }

        // Check if the slotID matches the pattern of a capital letter followed by three digits
        if (slotID.matches("[A-Z][0-9]{3}")) {
            ParkingSlot parkingSlot = new ParkingSlot(slotID);
            parkingSlots.add(parkingSlot);
            WindowSetup.setMessage("Slot " + slotID + " added.");
            SlotsPanel.setupSlots();
        } else {
            WindowSetup.setMessage("Invalid slot ID format. Slot ID must start with a capital letter, followed by three digits (e.g., D001).");
        }
    }
    public void deleteParkingSlot(String slotID) {
        ParkingSlot slotToRemove = findParkingSlot(slotID);
        if (slotToRemove != null && !slotToRemove.isOccupied()) {
            parkingSlots.remove(slotToRemove);
            WindowSetup.setMessage("Slot deleted Successfully.");
            for (Component component : SlotsPanel.panelSlots.getComponents()) {
                if (component instanceof JPanel slotPanel) {
                    JLabel slotLabel = (JLabel) slotPanel.getComponent(0);
                    if (slotLabel.getText().equals(" Slot ID: " + slotID)) {
                        SlotsPanel.panelSlots.remove(slotPanel);
                        break;
                    }
                }
            }
            SlotsPanel.setupSlots();
        } else {
            WindowSetup.setMessage("Slot is either occupied or does not exist.");
        }
    }


    public void parkCar(String slotID, String regNum, String make, String model, int year) {
        ParkingSlot slot = findParkingSlot(slotID);

        if (slot != null && slot.getSlotID() != null && !slot.isOccupied()) {
            if (regNum.matches("[A-Z]{1}[0-9]{4}")) {
                Car carToPark = new Car(regNum, make, model, year);
                carToPark.setParkingTimeStart(new Date());
                slot.parkCar(carToPark);
                WindowSetup.setMessage("Car parked successfully in slot " + slotID);
                SlotsPanel.setupSlots();
            } else {
                WindowSetup.setMessage("Invalid Registration number");

            }
        } else {
            WindowSetup.setMessage("Slot is occupied or Not available");
        }
    }

    public void findCarByRegistrationNumber(String registrationNumber) {
        for (ParkingSlot slot : parkingSlots) {
            if (slot.isOccupied()) {
                Car car = slot.getParkedCar();
                if (car.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                    WindowSetup.setMessage("Car found in slot " + slot.getSlotID() + ", Registration Number: " + car.getRegistrationNumber());
                    return;
                }
            }
        }
        WindowSetup.setMessage("Car with registration number " + registrationNumber + " not found.");
    }

    public void removeCarByRegistrationNumber(String registrationNumber) {
        for (ParkingSlot slot : parkingSlots) {
            if (slot.isOccupied()) {
                Car car = slot.getParkedCar();
                if (car.getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                    slot.removeCar();
                    WindowSetup.setMessage("Car removed from slot " + slot.getSlotID());
                    SlotsPanel.setupSlots();
                    return;
                }
            }
        }
        WindowSetup.setMessage("Car with registration number " + registrationNumber + " not found.");
    }
public void findCarsByMake(String make) {
    ArrayList<String> result = new ArrayList<>();

    for (ParkingSlot slot : parkingSlots) {
        if (slot.isOccupied()) {
            Car car = slot.getParkedCar();
            if (car.getMake().equalsIgnoreCase(make)) {
                String message = "Car found in slot " + slot.getSlotID() + " Registration Number: " +
                        car.getRegistrationNumber() + " Make: " + car.getMake() + " Model: " + car.getModel() + " Year: " + car.getYear();
                result.add(message);
            }
        }
    }

    if (!result.isEmpty()) {
        WindowSetup.setMessage(result.toArray(new String[0]));
    } else {
        WindowSetup.setMessage("Car with make: " + make + " not found");
    }
}


    private static ParkingSlot findParkingSlot(String slotID) {
        for (ParkingSlot slot : parkingSlots) {
            if (slot.getSlotID().equals(slotID)) {
                return slot;
            }
        }
        return null;
    }
}
