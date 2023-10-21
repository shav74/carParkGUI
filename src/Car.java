import java.util.Date;

/**
 *Project1-Parking Spot System
 *
 * @author Warnakulasuriya Sarani Erandi Umeshika Tissera(104210269)
 * @version 1.1
 * @date 2023.09.10
 */
public class Car {
    private String registrationNumber;
    private String make;
    private String model;
    private int year;
    private Date parkingTimeStart;

    public Car(String registrationNumber, String make, String model, int year) {
        this.registrationNumber = registrationNumber;
        this.make = make;
        this.model = model;
        this.year = year;
        this.parkingTimeStart = null;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }
    public Date getParkingStartTime() {
        return parkingTimeStart;
    }

    public void setParkingTimeStart(Date parkingTimeStart) {
        this.parkingTimeStart = parkingTimeStart;
    }
}
