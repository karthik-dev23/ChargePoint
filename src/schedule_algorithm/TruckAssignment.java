package schedule_algorithm;

import entity.ChargePoint;
import entity.Truck;
import dto.ChargingEvent;

import java.util.List;

public interface TruckAssignment {
    List<ChargingEvent> assignTrucks(List<Truck> trucks, List<ChargePoint> cps, Integer amt_time);
}
