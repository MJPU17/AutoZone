package co.edu.unbosque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "truck_az")
@PrimaryKeyJoinColumn(name = "truck_id")
public class Truck extends Vehicle{
	
	private final Boolean isSUV, has4x4Traction, isDiesel, hasAutomaticTransmission, isLightweight;  
	private final Integer loadCapacity;
	
	public Truck() {
		this.isSUV = false;
		this.has4x4Traction = false;
		this.isDiesel = false;
		this.hasAutomaticTransmission = false;
		this.isLightweight = false;
		this.loadCapacity = 0;
	}
	
	public Truck(Long id, String type, String brand, String model, String color, String engine, Integer year,
			Double price, Boolean hasAirConditioning, Boolean hasPremiumSoundSystem, Boolean hasTouchScreen,
			Boolean hasCollisionAlert, Boolean hasCruiseControl, Boolean isSUV, Boolean has4x4Traction,
			Boolean isDiesel, Boolean hasAutomaticTransmission, Boolean isLightweight, Integer loadCapacity){
		super(id,type, brand, model, color, engine, year, price, hasAirConditioning, hasPremiumSoundSystem,
				hasTouchScreen, hasCollisionAlert, hasCruiseControl);
		this.isSUV = isSUV;
		this.has4x4Traction = has4x4Traction;
		this.isDiesel = isDiesel;
		this.hasAutomaticTransmission = hasAutomaticTransmission;
		this.isLightweight = isLightweight;
		this.loadCapacity = loadCapacity;
	}

	public Boolean getIsSUV() {
		return isSUV;
	}

	public Boolean getHas4x4Traction() {
		return has4x4Traction;
	}

	public Boolean getIsDiesel() {
		return isDiesel;
	}

	public Boolean getHasAutomaticTransmission() {
		return hasAutomaticTransmission;
	}

	public Boolean getIsLightweight() {
		return isLightweight;
	}

	public Integer getLoadCapacity() {
		return loadCapacity;
	}

}
