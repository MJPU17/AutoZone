package co.edu.unbosque.pattern.abstractfactory;

import co.edu.unbosque.model.Car;
import co.edu.unbosque.model.Motorcycle;
import co.edu.unbosque.model.Truck;
import co.edu.unbosque.model.Vehicle;

public abstract class VehicleAbstractFactory {
	
    public Vehicle createVehicle(Long id,String type, String brand, String model, String color, String engine, int year, double price) {
        switch (type) {
            case "CAR":
                return createCar(id, type, brand, model, color, engine,year, price);
            case "MOTORCYCLE":
                return createMotorcycle(id, type, brand, model, color, engine,year, price);
            case "TRUCK":
                return createTruck(id, type, brand, model, color, engine,year, price);
            default:
                throw new IllegalArgumentException("Unsupported vehicle type: " + type);
        }
    }

    
    public abstract Car createCar(Long id, String type, String brand, String model, String color, String engine, int year, double price);
    public abstract Motorcycle createMotorcycle(Long id,String type, String brand, String model, String color, String engine, int year, double price);
    public abstract Truck createTruck(Long id,String type, String brand, String model, String color, String engine, int year, double price);
}
