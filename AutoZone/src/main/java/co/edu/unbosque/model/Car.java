package co.edu.unbosque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "car_az")
@PrimaryKeyJoinColumn(name = "car_id")
public class Car extends Vehicle {

	private final  Boolean isHybrid, hasNavigationSystem, hasParkingSensors, hasHillStartAssist, hasTurbo, hasSYNCSystem,
			hasRearCamera, hasAndroidAuto, hasAppleCarPlay;
	
	public Car() {
		this.isHybrid = false;
		this.hasNavigationSystem = false;
		this.hasParkingSensors = false;
		this.hasHillStartAssist = false;
		this.hasTurbo = false;
		this.hasSYNCSystem = false;
		this.hasRearCamera = false;
		this.hasAndroidAuto =  false;
		this.hasAppleCarPlay = false;
	}

	public Car(Long id, String type, String brand, String model, String color, String engine,
			Integer year, Double price, Boolean hasAirConditioning, Boolean hasPremiumSoundSystem,
			Boolean hasTouchScreen, Boolean hasCollisionAlert, Boolean hasCruiseControl, Boolean isHybrid,
			Boolean hasNavigationSystem, Boolean hasParkingSensors, Boolean hasHillStartAssist, Boolean hasTurbo,
			Boolean hasSYNCSystem, Boolean hasRearCamera, Boolean hasAndroidAuto, Boolean hasAppleCarPlay) {
		
		super(id, type, brand, model, color, engine, year, price, hasAirConditioning,
				hasPremiumSoundSystem, hasTouchScreen, hasCollisionAlert, hasCruiseControl);
		this.isHybrid = isHybrid;
		this.hasNavigationSystem = hasNavigationSystem;
		this.hasParkingSensors = hasParkingSensors;
		this.hasHillStartAssist = hasHillStartAssist;
		this.hasTurbo = hasTurbo;
		this.hasSYNCSystem = hasSYNCSystem;
		this.hasRearCamera = hasRearCamera;
		this.hasAndroidAuto = hasAndroidAuto;
		this.hasAppleCarPlay = hasAppleCarPlay;
	}

	public Boolean getIsHybrid() {
		return isHybrid;
	}

	public Boolean getHasNavigationSystem() {
		return hasNavigationSystem;
	}

	public Boolean getHasParkingSensors() {
		return hasParkingSensors;
	}

	public Boolean getHasHillStartAssist() {
		return hasHillStartAssist;
	}

	public Boolean getHasTurbo() {
		return hasTurbo;
	}

	public Boolean getHasSYNCSystem() {
		return hasSYNCSystem;
	}

	public Boolean getHasRearCamera() {
		return hasRearCamera;
	}

	public Boolean getHasAndroidAuto() {
		return hasAndroidAuto;
	}

	public Boolean getHasAppleCarPlay() {
		return hasAppleCarPlay;
	}
	
	
}
