package co.edu.unbosque.pattern.abstractfactory;

import co.edu.unbosque.model.Car;
import co.edu.unbosque.model.Motorcycle;
import co.edu.unbosque.model.Truck;
import co.edu.unbosque.pattern.builder.CarBuilder;
import co.edu.unbosque.pattern.builder.MotorcycleBuilder;
import co.edu.unbosque.pattern.builder.TruckBuilder;

public class ChevroletFactory extends VehicleAbstractFactory {

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
			.hasTurbo(true)
			.hasSYNCSystem(false)
			.hasCruiseControl(true)
			.isHybrid(false)
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
			.engineDisplacement(200)
			.isAutomatic(false)
			.isCompactDesign(false)
			.isSportsCar(true)
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
			.isSUV(false)
			.has4x4Traction(true)
			.isDiesel(true)
			.hasAutomaticTransmission(true)
			.isLightweight(false)
			.loadCapacity(6000)
			.build();
	}
	
}
