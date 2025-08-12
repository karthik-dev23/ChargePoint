import config.TruckAssignmentConfig;
import entity.ChargePoint;
import entity.Truck;
import dto.ChargingEvent;
import service.FleetChargingService;

import java.util.*;

public class TruckChargingMain {
    public static void main(String[] args) {

        //sample data - can be modified
        //10 Trucks to be charged
        List<Truck> trucks = new ArrayList<>();
        trucks.add(new Truck("T1",100,0));
        trucks.add(new Truck("T2",70,0));
        trucks.add(new Truck("T3",20,0));
        trucks.add(new Truck("T4",90,0));
        trucks.add(new Truck("T5",200,0));
        trucks.add(new Truck("T6",60,0));
        trucks.add(new Truck("T7",30,0));
        trucks.add(new Truck("T8",5,0));
        trucks.add(new Truck("T9",150,0));
        trucks.add(new Truck("T10",70,0));

        //Available Chargepoints with charging rate in kwh
        List<ChargePoint> cp = new ArrayList<>();
        cp.add(new ChargePoint("C1", 10));
        cp.add(new ChargePoint("C2", 25));
        cp.add(new ChargePoint("C3", 15));
        cp.add(new ChargePoint("C4", 40));

        //Time available for trucks to be charged
        int amt_time = 4; // in hours

        // truck assignment through service
        FleetChargingService service = new FleetChargingService(TruckAssignmentConfig.loadAssignmentStrategy());
        List<ChargingEvent> events = service.schedule(trucks, cp, amt_time);

        //print Final Assigned schedule for the assignments
        for (ChargingEvent e : events) {
            System.out.println("ChargePoint: " + e.getChargePointId() +
                    ", Trucks: " + e.getTruckIds());
        }
    }
}
