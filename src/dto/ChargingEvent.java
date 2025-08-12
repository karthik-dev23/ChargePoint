package dto;

import java.util.List;

public class ChargingEvent {
    private String chargePointId;
    private List<String> truckIds;

    public ChargingEvent(String chargePointId, List<String> truckIds) {
        this.chargePointId = chargePointId;
        this.truckIds = List.copyOf(truckIds);
    }

    public String getChargePointId() {
        return chargePointId;
    }
    public void setChargePointId(String chargePointId) {
        this.chargePointId = chargePointId;
    }

    public List<String> getTruckIds() {
        return truckIds;
    }
    public void setTruckIds(List<String> truckIds) {
        this.truckIds = truckIds;
    }
}
