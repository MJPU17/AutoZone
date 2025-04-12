package co.edu.unbosque.pattern.builder;

import co.edu.unbosque.model.Motorcycle;

public class MotorcycleBuilder extends VehicleBuilder<Motorcycle, MotorcycleBuilder> {

	private Integer engineDisplacement;
	private Boolean isAutomatic, isCompactDesign, isSportsCar, hasFuelEfficiency;

	public MotorcycleBuilder() {
		// Default constructor
	}

	public MotorcycleBuilder engineDisplacement(Integer engineDisplacement) {
		this.engineDisplacement = engineDisplacement;
		return this;
	}

	public MotorcycleBuilder isAutomatic(Boolean isAutomatic) {
		this.isAutomatic = isAutomatic;
		return this;
	}

	public MotorcycleBuilder isCompactDesign(Boolean isCompactDesign) {
		this.isCompactDesign = isCompactDesign;
		return this;
	}

	public MotorcycleBuilder isSportsCar(Boolean isSportsCar) {
		this.isSportsCar = isSportsCar;
		return this;
	}

	public MotorcycleBuilder hasFuelEfficiency(Boolean hasFuelEfficiency) {
		this.hasFuelEfficiency = hasFuelEfficiency;
		return this;
	}

	@Override
	public Motorcycle build() {
		return new Motorcycle(id, type, brand, model, color, engine, year, price, hasFuelEfficiency, hasFuelEfficiency,
				hasFuelEfficiency, hasFuelEfficiency, hasFuelEfficiency, engineDisplacement, isAutomatic,
				isCompactDesign, isSportsCar, hasFuelEfficiency);
	}
}
