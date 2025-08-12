package entity;

public class ChargePoint {
    public String getId() {
        return id;
    }

    private final String id;
    private double chargingRate;

    public ChargePoint(String id, double chargingRate) {
        this.id = id;
        this.chargingRate = chargingRate;
    }

    public double getChargingRate() {
        return chargingRate;
    }

    public void setChargingRate(double chargingRate) {
        this.chargingRate = chargingRate;
    }
}
