## Project Structure

```text
.
├── TruckChargingMain.java        # Entry point; tweak inputs here
├── entity/
│   ├── Truck.java                # Truck properties
│   └── ChargePoint.java          # Charging station properties
├── config/
│   └── ...                       # Choose a specific algorithm implementation
├── dto/
│   └── ...                       # Standard DTOs for results
├── service/
│   └── ...                       # Routes service calls from main class
└── schedule_algorithm/
    └── ...                       # Core truck assignment logic (greedy approach)
