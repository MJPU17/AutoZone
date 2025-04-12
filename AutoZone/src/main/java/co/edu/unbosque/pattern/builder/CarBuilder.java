package co.edu.unbosque.pattern.builder;

import co.edu.unbosque.model.Car;

public class CarBuilder extends VehicleBuilder<Car,CarBuilder> {

	private Boolean isHybrid, hasNavigationSystem, hasParkingSensors, hasHillStartAssist, hasTurbo, hasSYNCSystem,
			hasRearCamera, hasAndroidAuto, hasAppleCarPlay;
	
	public CarBuilder() {
		// TODO Auto-generated constructor stub
	}

	public CarBuilder isHybrid(Boolean isHybrid) {
		this.isHybrid = isHybrid;
		return this;
	}

	public CarBuilder hasNavigationSystem(Boolean hasNavigationSystem) {
		this.hasNavigationSystem = hasNavigationSystem;
		return this;
	}

	public CarBuilder hasParkingSensors(Boolean hasParkingSensors) {
		this.hasParkingSensors = hasParkingSensors;
		return this;
	}

	public CarBuilder hasHillStartAssist(Boolean hasHillStartAssist) {
		this.hasHillStartAssist = hasHillStartAssist;
		return this;
	}

	public CarBuilder hasTurbo(Boolean hasTurbo) {
		this.hasTurbo = hasTurbo;
		return this;
	}

	public CarBuilder hasSYNCSystem(Boolean hasSYNCSystem) {
		this.hasSYNCSystem = hasSYNCSystem;
		return this;
	}

	public CarBuilder hasRearCamera(Boolean hasRearCamera) {
		this.hasRearCamera = hasRearCamera;
		return this;
	}

	public CarBuilder hasAndroidAuto(Boolean hasAndroidAuto) {
		this.hasAndroidAuto = hasAndroidAuto;
		return this;
	}

	public CarBuilder hasAppleCarPlay(Boolean hasAppleCarPlay) {
		this.hasAppleCarPlay = hasAppleCarPlay;
		return this;
	}

	@Override
	public Car build() {
		return new Car(id, type, brand, model, color, engine, year, price, hasAndroidAuto, hasAndroidAuto,
				hasAndroidAuto, hasAndroidAuto, hasAndroidAuto, isHybrid, hasNavigationSystem, hasParkingSensors,
				hasHillStartAssist, hasTurbo, hasSYNCSystem, hasRearCamera, hasAndroidAuto, hasAppleCarPlay);
	}

}
