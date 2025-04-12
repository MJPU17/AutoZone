package co.edu.unbosque.pattern.factory;

import co.edu.unbosque.pattern.abstractfactory.ChevroletFactory;
import co.edu.unbosque.pattern.abstractfactory.FordFactory;
import co.edu.unbosque.pattern.abstractfactory.ToyotaFactory;
import co.edu.unbosque.pattern.abstractfactory.VehicleAbstractFactory;

public class BrandFactory {
	
	public static VehicleAbstractFactory getFactory(String brand) {
        switch (brand) {
            case "TOYOTA":
                return new ToyotaFactory();
            case "FORD":
                return new FordFactory();
            case "CHEVROLET":
                return new ChevroletFactory();
            default:
                throw new IllegalArgumentException("Unsupported brand: " + brand);
        }
    }

}
