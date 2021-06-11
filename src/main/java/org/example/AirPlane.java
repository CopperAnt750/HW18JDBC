package org.example;

public class AirPlane extends Enteties {
    private String model;
    private int serialNumber;
    private int seats;

    public AirPlane(String model, int serialNumber, int seats) {
        this.model = model;
        this.serialNumber = serialNumber;
        this.seats = seats;
    }

    public AirPlane(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public int getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "AirPlane{" +
                "model='" + model + '\'' +
                ", serialNumber=" + serialNumber +
                ", seats=" + seats +
                '}';
    }
}
