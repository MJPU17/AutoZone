package co.edu.unbosque.pattern.abstractfactory;

import co.edu.unbosque.model.Car;
import co.edu.unbosque.model.Motorcycle;
import co.edu.unbosque.model.Truck;
import co.edu.unbosque.pattern.builder.CarBuilder;
import co.edu.unbosque.pattern.builder.MotorcycleBuilder;
import co.edu.unbosque.pattern.builder.TruckBuilder;

public class ToyotaFactory extends VehicleAbstractFactory {

	@Override
	public Car createCar(Long id,String type, String brand, String model, String color, String engine, int year, double price) {
		return new CarBuilder()
			.id(id)
			.type(type)
			.brand(brand)
			.model(model)
			.color(color)
			.engine(engine)
			.year(year)
			.price(price)
			.hasTurbo(false)
			.hasSYNCSystem(false)
			.hasCruiseControl(true)
			.isHybrid(true)
			.hasNavigationSystem(true)
			.hasParkingSensors(true)
			.hasHillStartAssist(true)
			.hasRearCamera(true)
			.hasAndroidAuto(true)
			.hasAppleCarPlay(true)
			.build();
	}

	@Override
	public Motorcycle createMotorcycle(Long id,String type, String brand, String model, String color, String engine, int year,
			double price) {
		return new MotorcycleBuilder()
			.id(id)
			.type(type)
			.brand(brand)
			.model(model)
			.color(color)
			.engine(engine)
			.year(year)
			.price(price)
			.engineDisplacement(150)
			.isAutomatic(true)
			.isCompactDesign(true)
			.isSportsCar(false)
			.hasFuelEfficiency(true)
			.build();
	}

	@Override
	public Truck createTruck(Long id,String type, String brand, String model, String color, String engine, int year,
			double price) {
		return new TruckBuilder()
			.id(id)
			.type(type)
			.brand(brand)
			.model(model)
			.color(color)
			.engine(engine)
			.year(year)
			.price(price)
			.isSUV(true)
			.has4x4Traction(false)
			.isDiesel(false)
			.hasAutomaticTransmission(true)
			.isLightweight(true)
			.loadCapacity(3000)
			.build();
	}
}
