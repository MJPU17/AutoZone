package co.edu.unbosque.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.model.Vehicle;
import co.edu.unbosque.pattern.singleton.DBConnection;
import co.edu.unbosque.repository.VehicleRepository;
import jakarta.annotation.PreDestroy;

@Service
public class VehicleService implements CRUDOperation<Vehicle> {

	@Autowired
	private VehicleRepository vehicleRepo;
	private DBConnection dbcon;
	
	public VehicleService() {
		dbcon=DBConnection.getInstance("jdbc:mysql://localhost:3306/autozone_database", "root", "p3r4o");
		dbcon.getConnection();
	}

	@Override
	public void create(Vehicle data) {
		vehicleRepo.save(data);
	}

	@Override
	public List<Vehicle> getAll() {
		return vehicleRepo.findAll();
	}

	@Override
	public void deleteById(Long id) {
		Optional<Vehicle> found = vehicleRepo.findById(id);
		vehicleRepo.delete(found.get());
	}

	@Override
	public boolean exist(Long id) {
		return vehicleRepo.existsById(id);
	}

	public VehicleRepository getVehicleRepo() {
		return vehicleRepo;
	}

	public void setVehicleRepo(VehicleRepository vehicleRepo) {
		this.vehicleRepo = vehicleRepo;
	}

	public boolean validateBrand(String brand) {
		return brand.equals("TOYOTA") || brand.equals("FORD") || brand.equals("CHEVROLET");
	}
	
	public boolean validateType(String type) {
		return type.equals("CAR") || type.equals("MOTORCYCLE") || type.equals("TRUCK");
	}
	
	public Vehicle getById(Long id) {
		Optional<Vehicle> found = vehicleRepo.findById(id);
		return found.get();
	}
	
	@PreDestroy
	public void closeConnection() {
		dbcon.closeConnection();
	}

}
