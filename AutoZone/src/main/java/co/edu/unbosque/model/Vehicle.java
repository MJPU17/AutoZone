package co.edu.unbosque.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "vehicle_az")
@JsonTypeInfo(
		  use = JsonTypeInfo.Id.NAME,
		  include = JsonTypeInfo.As.PROPERTY,
		  property = "type"
		)
		@JsonSubTypes({
		  @JsonSubTypes.Type(value = Truck.class, name = "TRUCK"),
		  @JsonSubTypes.Type(value = Car.class, name = "CAR"),
		  @JsonSubTypes.Type(value = Motorcycle.class, name = "MOTORCYCLE")
		})
public abstract class Vehicle {

	@Id
	protected final Long id;

	protected final String brand, model, color, engine,type;

	protected final Integer year;

	protected final Double price;

	protected final Boolean hasAirConditioning, hasPremiumSoundSystem, hasTouchScreen, hasCollisionAlert, hasCruiseControl;

	public Vehicle() {
		this.id = (long)0;
		this.brand = "";
		this.model = "";
		this.color = "";
		this.engine = "";
		this.type = "";
		this.year = 0;
		this.price = 0.0;
		this.hasAirConditioning = false;
		this.hasPremiumSoundSystem = false;
		this.hasTouchScreen = false;
		this.hasCollisionAlert = false;
		this.hasCruiseControl = false;
	}
	 

	public Vehicle(Long id, String type, String brand, String model, String color, String engine,
			Integer year, Double price, Boolean hasAirConditioning,
			Boolean hasPremiumSoundSystem, Boolean hasTouchScreen, Boolean hasCollisionAlert,
			Boolean hasCruiseControl) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.engine = engine;
		this.year = year;
		this.price = price;
		this.type = type;
		this.hasAirConditioning = hasAirConditioning;
		this.hasPremiumSoundSystem = hasPremiumSoundSystem;
		this.hasTouchScreen = hasTouchScreen;
		this.hasCollisionAlert = hasCollisionAlert;
		this.hasCruiseControl = hasCruiseControl;
	}

	public Long getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public String getEngine() {
		return engine;
	}

	public Integer getYear() {
		return year;
	}

	public Double getPrice() {
		return price;
	}

	public Boolean getHasAirConditioning() {
		return hasAirConditioning;
	}

	public Boolean getHasPremiumSoundSystem() {
		return hasPremiumSoundSystem;
	}

	public Boolean getHasTouchScreen() {
		return hasTouchScreen;
	}

	public Boolean getHasCollisionAlert() {
		return hasCollisionAlert;
	}

	public Boolean getHasCruiseControl() {
		return hasCruiseControl;
	}


	public String getType() {
		return type;
	}

}
