package schedule_algorithm;

import entity.ChargePoint;
import entity.Truck;
import dto.ChargingEvent;

import java.util.*;
import java.util.stream.Collectors;

//main class demonstrating schedule logic

public class TruckAssignmentImpl implements TruckAssignment{

    @Override
    public List<ChargingEvent> assignTrucks(List<Truck> trucks, List<ChargePoint> cps, Integer amt_time) {

        double hours = amt_time.doubleValue();

        // Step 1 : Total energy (kWh) from all charging stations
        double totalEnergy = cps.stream()
                .mapToDouble(c -> c.getChargingRate() * hours)
                .sum();
        System.out.println("Step 1: Total station energy available = " + totalEnergy + " kWh");

        // Step 2 : Sort Trucks based on required energy (ascending)
        List<Truck> ascOrderedTrucks = trucks.stream()
                .sorted(Comparator.comparingDouble(Truck::getEnergyRequired))
                .toList();


        // Step 3 : Choose eligibleTrucks by adding from smallest upwards until capacity runs out
        List<Truck> eligibleTrucks = new ArrayList<>();
        double usedEnergy = 0.0;
        for (Truck t : ascOrderedTrucks) {
            double need = t.getEnergyRequired();
            if (usedEnergy + need <= totalEnergy) {
                eligibleTrucks.add(t);
                usedEnergy += need;
            } else {
                break;
            }
        }
        System.out.println("Step 3: Eligible trucks (fit in total energy): " +
                eligibleTrucks.stream().map(Truck::getId).collect(Collectors.joining(", ")) +
                " | Sum need = " + usedEnergy + " kWh");

        // Step 4 : Assign trucks (desc) to ChargePoints with most remaining that can fit, else max remaining

        Map<String, Double> cpRemaining = new HashMap<>();
        for (ChargePoint cp : cps) {
            cpRemaining.put(cp.getId(), cp.getChargingRate() * hours);
        }

        // sort CPs (by capacity desc)
        List<String> cpOrdered = cpRemaining.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .toList();

        Map<String, List<String>> assignment = new LinkedHashMap<>();
        for (String cpId : cpOrdered) assignment.put(cpId, new ArrayList<>());

        //sort eligible trucks for desc order
        List<Truck> eligibleTrucksOrderedDesc = new ArrayList<>(eligibleTrucks);
        eligibleTrucksOrderedDesc.sort(Comparator.comparingDouble(Truck::getEnergyRequired).reversed());

        //assignment of trucks to charging points
        for (Truck t : eligibleTrucksOrderedDesc) {
            double energyRequiredForTruck = t.getEnergyRequired();

            for (var cpRem : cpRemaining.entrySet()) {
                double remainingCpEnergy = cpRem.getValue();
                if (remainingCpEnergy >= energyRequiredForTruck) {
                    assignment.get(cpRem.getKey()).add(t.getId());
                    cpRemaining.put(cpRem.getKey(), remainingCpEnergy -  energyRequiredForTruck);
                    break;
                }
            }
        }

        // Build DTOs
        List<ChargingEvent> events = new ArrayList<>();
        for (String cpId : cpOrdered) {
            events.add(new ChargingEvent(cpId, List.copyOf(assignment.get(cpId))));
        }
        return List.copyOf(events);

    }
}
