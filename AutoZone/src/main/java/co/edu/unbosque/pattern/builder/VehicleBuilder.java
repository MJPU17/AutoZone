package co.edu.unbosque.pattern.builder;

import co.edu.unbosque.model.Vehicle;

public abstract class VehicleBuilder<T extends Vehicle,B extends VehicleBuilder<T,B>> {
	
	protected Long id;

	protected String brand, model, color, engine, type;

	protected Integer year;

	protected Double price;

	protected Boolean hasAirConditioning, hasPremiumSoundSystem, hasTouchScreen, hasCollisionAlert, hasCruiseControl;
	
	public VehicleBuilder() {
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unchecked")
	public B id(Long id) {
	    this.id = id;
	    return (B) this;
	}
	
	@SuppressWarnings("unchecked")
	public B brand(String brand) {
	    this.brand = brand;
	    return(B) this;
	}
	
	@SuppressWarnings("unchecked")
	public B type(String type) {
	    this.type = type;
	    return(B) this;
	}

	@SuppressWarnings("unchecked")
	public B model(String model) {
	    this.model = model;
	    return (B) this;
	}

	@SuppressWarnings("unchecked")
	public B color(String color) {
	    this.color = color;
	    return (B) this;
	}
	
	@SuppressWarnings("unchecked")
	public B engine(String engine) {
	    this.engine = engine;
	    return (B) this;
	}

	@SuppressWarnings("unchecked")
	public B year(Integer year) {
	    this.year = year;
	    return (B) this;
	}

	@SuppressWarnings("unchecked")
	public B price(Double price) {
	    this.price = price;
	    return (B) this;
	}

	@SuppressWarnings("unchecked")
	public B hasAirConditioning(Boolean hasAirConditioning) {
	    this.hasAirConditioning = hasAirConditioning;
	    return (B) this;
	}

	@SuppressWarnings("unchecked")
	public B hasPremiumSoundSystem(Boolean hasPremiumSoundSystem) {
	    this.hasPremiumSoundSystem = hasPremiumSoundSystem;
	    return (B) this;
	}

	@SuppressWarnings("unchecked")
	public B hasTouchScreen(Boolean hasTouchScreen) {
	    this.hasTouchScreen = hasTouchScreen;
	    return (B) this;
	}

	@SuppressWarnings("unchecked")
	public B hasCollisionAlert(Boolean hasCollisionAlert) {
	    this.hasCollisionAlert = hasCollisionAlert;
	    return (B) this;
	}

	@SuppressWarnings("unchecked")
	public B hasCruiseControl(Boolean hasCruiseControl) {
	    this.hasCruiseControl = hasCruiseControl;
	    return (B) this;
	}
	
	public abstract T build();

}
