Assignment for Truck Fleet Charging
-----------------------------------

Main class -> TruckChargingMain.java
------------------------------------
  - user inputs defined (can be modified to test various truck, charging point and time parameters)
Entity
------
  - Truck.java - truck properties
  - ChargePoint.java - charging station properties
Config
------
  - config to chose a specific algorithm implementation
DTO
-----
  - standard dto for results
Service
---------
  - route service call logic from main class
schedule_algorithm
-------------------
  - core truck assignment logic (greedy approach)
  - can be improvised using various algorithmic patterns

Run TruckChargingMain.java to see the truck assignments for the available chargepoint stations.
