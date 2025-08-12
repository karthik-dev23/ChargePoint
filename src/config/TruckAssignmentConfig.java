package config;

import schedule_algorithm.TruckAssignment;
import schedule_algorithm.TruckAssignmentImpl;

public class TruckAssignmentConfig {
    public static TruckAssignment loadAssignmentStrategy(){

        //kept simple for single implementation
        return new TruckAssignmentImpl();
    }
}
