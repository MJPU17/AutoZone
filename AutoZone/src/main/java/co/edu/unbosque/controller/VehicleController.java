package co.edu.unbosque.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import co.edu.unbosque.model.Vehicle;
import co.edu.unbosque.pattern.abstractfactory.VehicleAbstractFactory;
import co.edu.unbosque.pattern.factory.BrandFactory;
import co.edu.unbosque.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/vehicle")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:8081", "*" })
@Transactional
@Tag(name = "AutoZone API", description = "API for vehicle management operations")
public class VehicleController {

	@Autowired
	private VehicleService vehicleServ;

	@Schema(description = "Data transfer object for vehicle creation and response")
	public record VehicleDefault(
			@Parameter(description = "Unique vehicle ID") Long id, 
			@Parameter(description = "Vehicle type (CAR, MOTORCYCLE, TRUCK)") String type, 
			@Parameter(description = "Vehicle brand (FORD, TOYOTA, CHEVROLET)") String brand, 
			@Parameter(description = "Vehicle model") String model, 
			@Parameter(description = "Vehicle color") String color, 
			@Parameter(description = "Vehicle engine") String engine,
			@Parameter(description = "Manufacturing year") Integer year, 
			@Parameter(description = "Vehicle price") Double price, 
			@Parameter(description = "Has air conditioning") Boolean hasAirConditioning, 
			@Parameter(description = "Has premium sound system") Boolean hasPremiumSoundSystem,
			@Parameter(description = "Has touch screen") Boolean hasTouchScreen, 
			@Parameter(description = "Has collision alert") Boolean hasCollisionAlert, 
			@Parameter(description = "Has cruise control") Boolean hasCruiseControl
			) {}

	public VehicleController() {
	}

	@Operation(summary = "Create a new vehicle", description = "Creates a new vehicle with the provided data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Vehicle created successfully"),
            @ApiResponse(responseCode = "406", description = "Not acceptable data (existing ID, invalid brand or type)"),
            @ApiResponse(responseCode = "400", description = "Bad request format")
    })
	@PostMapping(path = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> create(@RequestBody VehicleDefault vehicle) {
		if (vehicleServ.exist(vehicle.id)) {
			return new ResponseEntity<String>("The id entered already exists, please try another one.",
					HttpStatus.NOT_ACCEPTABLE);
		} else if (vehicle.id <= 0) {
			return new ResponseEntity<String>("Please enter an id greater than 0.", HttpStatus.NOT_ACCEPTABLE);
		} else if (!vehicleServ.validateBrand(vehicle.brand.toUpperCase())) {
			return new ResponseEntity<String>(
					"Unregistered trademark enter one of the following options FORD, TOYOTA or CHEVROLET.",
					HttpStatus.NOT_ACCEPTABLE);
		} else if (!vehicleServ.validateType(vehicle.type.toUpperCase())) {
			return new ResponseEntity<String>(
					"Unregistered type enter one of the following options CAR, MOTORCYCLE or TRUCK.",
					HttpStatus.NOT_ACCEPTABLE);
		}
		String brand = vehicle.brand.toUpperCase();
		String type = vehicle.type.toUpperCase();

		VehicleAbstractFactory factory = BrandFactory.getFactory(brand);
		vehicleServ.create(factory.createVehicle(vehicle.id, type, brand, vehicle.model, vehicle.color, vehicle.engine,
				vehicle.year, vehicle.price));
		return new ResponseEntity<String>("Vehicle create successfully.", HttpStatus.CREATED);
	}
	
	@Operation(summary = "Get all vehicles", description = "Returns a list of all registered vehicles")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of vehicles found"),
            @ApiResponse(responseCode = "204", description = "No vehicles registered")
    })
	@GetMapping(path = "/getall")
	public ResponseEntity<List<Vehicle>> getAll() {
		List<Vehicle> vehicle = vehicleServ.getAll();
		if (vehicle.isEmpty()) {
			return new ResponseEntity<List<Vehicle>>(vehicle, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Vehicle>>(vehicle, HttpStatus.OK);
	}

	@Operation(summary = "Delete vehicle by ID", description = "Deletes a vehicle by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehicle deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Vehicle not found")
    })
	@DeleteMapping(path = "/deletebyid/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		if (vehicleServ.exist(id)) {
			vehicleServ.deleteById(id);
			return new ResponseEntity<String>("Vehicle deleted successfully.", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Vehicle id not found.", HttpStatus.NOT_FOUND);
	}

	@Operation(summary = "Get vehicle by ID", description = "Returns a vehicle by its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Vehicle found"),
            @ApiResponse(responseCode = "404", description = "Vehicle not found")
    })
	@GetMapping(path = "/getbyid/{id}")
	public ResponseEntity<Vehicle> getById(@PathVariable Long id) {
		if (vehicleServ.exist(id)) {
			Vehicle vehicle = vehicleServ.getById(id);
			return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@Operation(summary = "Get vehicles by brand", description = "Returns a list of vehicles by the specified brand")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of vehicles found"),
            @ApiResponse(responseCode = "204", description = "No vehicles for the specified brand"),
            @ApiResponse(responseCode = "406", description = "Invalid brand")
    })
	@GetMapping(path = "/getbybrand/{brand}")
	public ResponseEntity<List<Vehicle>> getByBrand(@PathVariable String brand) {
		if (!vehicleServ.validateBrand(brand.toUpperCase())) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		List<Vehicle> vehicle = vehicleServ.getAll();
		List<Vehicle> vehicleByBrand = new ArrayList<Vehicle>();
		for (Vehicle aux : vehicle) {
			if (aux.getBrand().equals(brand.toUpperCase())) {
				vehicleByBrand.add(aux);
			}
		}
		if (vehicleByBrand.isEmpty()) {
			return new ResponseEntity<List<Vehicle>>(vehicleByBrand, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Vehicle>>(vehicleByBrand, HttpStatus.OK);
	}

	 @Operation(summary = "Get vehicles by brand and type", description = "Returns a list of vehicles by the specified brand and type")
	    @ApiResponses(value = {
	            @ApiResponse(responseCode = "200", description = "List of vehicles found"),
	            @ApiResponse(responseCode = "204", description = "No vehicles matching criteria"),
	            @ApiResponse(responseCode = "406", description = "Invalid brand or type")
	    })
	@GetMapping(path = "/get/brand/{brand}/type{type}")
	public ResponseEntity<List<Vehicle>> getByBrandAndMark(@PathVariable String brand, @PathVariable String type) {
		if (!vehicleServ.validateBrand(brand.toUpperCase()) || !vehicleServ.validateType(type.toUpperCase())) {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
		List<Vehicle> vehicle = vehicleServ.getAll();
		List<Vehicle> vehicleByBrandAndType = new ArrayList<Vehicle>();
		for (Vehicle aux : vehicle) {
			if (aux.getBrand().equals(brand.toUpperCase()) && aux.getType().equals(type.toUpperCase())) {
				vehicleByBrandAndType.add(aux);
			}
		}
		if (vehicleByBrandAndType.isEmpty()) {
			return new ResponseEntity<List<Vehicle>>(vehicleByBrandAndType, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Vehicle>>(vehicleByBrandAndType, HttpStatus.OK);
	}

}
