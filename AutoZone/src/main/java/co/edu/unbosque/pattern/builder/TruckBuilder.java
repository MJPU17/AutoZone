package co.edu.unbosque.pattern.builder;

import co.edu.unbosque.model.Truck;

public class TruckBuilder extends VehicleBuilder<Truck, TruckBuilder> {

	private Boolean isSUV, has4x4Traction, isDiesel, hasAutomaticTransmission, isLightweight;
	private Integer loadCapacity;

	public TruckBuilder() {
		// Default constructor
	}

	public TruckBuilder isSUV(Boolean isSUV) {
		this.isSUV = isSUV;
		return this;
	}

	public TruckBuilder has4x4Traction(Boolean has4x4Traction) {
		this.has4x4Traction = has4x4Traction;
		return this;
	}

	public TruckBuilder isDiesel(Boolean isDiesel) {
		this.isDiesel = isDiesel;
		return this;
	}

	public TruckBuilder hasAutomaticTransmission(Boolean hasAutomaticTransmission) {
		this.hasAutomaticTransmission = hasAutomaticTransmission;
		return this;
	}

	public TruckBuilder isLightweight(Boolean isLightweight) {
		this.isLightweight = isLightweight;
		return this;
	}

	public TruckBuilder loadCapacity(Integer loadCapacity) {
		this.loadCapacity = loadCapacity;
		return this;
	}

	@Override
	public Truck build() {
		return new Truck(
			id, type, brand, model, color, engine, year, price,
			has4x4Traction, has4x4Traction, has4x4Traction, has4x4Traction, has4x4Traction,
			isSUV, has4x4Traction, isDiesel, hasAutomaticTransmission, isLightweight,
			loadCapacity
		);
	}
}

