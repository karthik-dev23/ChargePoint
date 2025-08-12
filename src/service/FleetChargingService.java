package service;

import entity.ChargePoint;
import entity.Truck;
import dto.ChargingEvent;
import schedule_algorithm.TruckAssignment;

import java.util.List;

public class FleetChargingService {
        private final TruckAssignment truckAssignment;

        public FleetChargingService(TruckAssignment truckAssignment) {
            this.truckAssignment = truckAssignment;
        }

        public List<ChargingEvent> schedule(List<Truck> trucks, List<ChargePoint> cps, Integer amt_time) {
            return truckAssignment.assignTrucks(trucks, cps, amt_time);
        }
}
