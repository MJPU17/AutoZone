package co.edu.unbosque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "motorcycle_az")
@PrimaryKeyJoinColumn(name = "motorcycle_id")
public class Motorcycle extends Vehicle{
	
	private final Integer engineDisplacement;  
	private final Boolean isAutomatic, isCompactDesign, isSportsCar, hasFuelEfficiency;
	
	public Motorcycle() {
		this.engineDisplacement = 0;
		this.isAutomatic =  false;
		this.isCompactDesign = false;
		this.isSportsCar = false;
		this.hasFuelEfficiency = false;
	}
	
	public Motorcycle(Long id, String type, String brand, String model, String color, String engine,
			Integer year, Double price, Boolean hasAirConditioning, Boolean hasPremiumSoundSystem,
			Boolean hasTouchScreen, Boolean hasCollisionAlert, Boolean hasCruiseControl, Integer engineDisplacement,
			Boolean isAutomatic, Boolean isCompactDesign, Boolean isSportsCar, Boolean hasFuelEfficiency) {
		super(id, type, brand, model, color, engine, year, price, hasAirConditioning, hasPremiumSoundSystem,
				hasTouchScreen, hasCollisionAlert, hasCruiseControl);
		this.engineDisplacement = engineDisplacement;
		this.isAutomatic = isAutomatic;
		this.isCompactDesign = isCompactDesign;
		this.isSportsCar = isSportsCar;
		this.hasFuelEfficiency = hasFuelEfficiency;
	}

	public Integer getEngineDisplacement() {
		return engineDisplacement;
	}

	public Boolean getIsAutomatic() {
		return isAutomatic;
	}

	public Boolean getIsCompactDesign() {
		return isCompactDesign;
	}

	public Boolean getIsSportsCar() {
		return isSportsCar;
	}

	public Boolean getHasFuelEfficiency() {
		return hasFuelEfficiency;
	} 
	

}
