package entity;

public class Truck {
    private final String id;
    private final double totalCapacity;
    private double currentCapacity;

    public void setCurrentCapacity(double currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public Truck(String id, double capacity, double currentKWH) {
        this.id = id;
        this.totalCapacity = capacity;
        this.currentCapacity = currentKWH;
    }

    public double getTotalCapacity() {
        return totalCapacity;
    }

    public String getId() {
        return id;
    }

    public double getCurrentCapacity() {
        return currentCapacity;
    }

    public double getEnergyRequired() {
        return totalCapacity - currentCapacity;
    }
}
