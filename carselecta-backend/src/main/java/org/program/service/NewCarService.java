package org.program.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.program.entity.Admin;
import org.program.entity.CarPricing;
import org.program.entity.NewCar;
import org.program.repository.AdminRepository;
import org.program.repository.CarPricingRepository;
import org.program.repository.NewCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Service
public class NewCarService {

	@Autowired
	private NewCarRepository carRepository;

	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private CarPricingRepository carPricingRepository;

	public void addNewCarService(MultipartFile carImage, String carName, String carModel, String carBrand,
			String carType, double carPrice, String ARAIMileage, String cityMileage, String highwayMileage,
			String fuelType, String transmission, String modelYear, String description, double exShowroomPrice,
			double roadTax, double insurance, double otherCharges, double optionalCharges, String EMI, String username)
			throws IOException {
		NewCar car = new NewCar();
		car.setCarImage(carImage.getBytes());

		car.setCarName(carName);
		car.setCarModel(carModel);
		car.setCarBrand(carBrand);
		car.setCarType(carType);
		car.setCarPrice(carPrice);
		car.setARAIMileage(ARAIMileage);
		car.setCityMileage(cityMileage);
		car.setHighwayMileage(highwayMileage);
		car.setFuelType(fuelType);
		car.setTransmission(transmission);
		car.setModelYear(modelYear);
		car.setDescription(description);

		CarPricing carPricing = new CarPricing();
		carPricing.setExShowroomPrice(exShowroomPrice);
		carPricing.setRoadTax(roadTax);
		carPricing.setInsurance(insurance);
		carPricing.setOtherCharges(otherCharges);
		carPricing.setOptionalCharges(optionalCharges);
		carPricing.setOnRoadPrice(exShowroomPrice + roadTax + insurance + otherCharges);
		carPricing.setEMI(EMI);
		Admin admin = adminRepository.findByUsername(username);

		car.setCarPricing(carPricing);
		carPricing.setNewCar(car);
		carPricing.setAdmin(admin);
		car.setAdmin(admin);
		carRepository.save(car);
	}

	public List<NewCar> searchByCarNameService(String carName) {
		
		return carRepository.findByCarName(carName);

	}

	public List<NewCar> searchByCarTypeService(String carType) {
		return carRepository.findByCarType(carType);

	}

	public List<NewCar> searchByBrandNameService(String carBrand) {
		return carRepository.findByCarBrand(carBrand);

	}

	public List<NewCar> searchByModelYearService(String modelYear) {

		return carRepository.findByModelYear(modelYear);
	}

	public Map<String, Object> findCarById(int id) {
		
		NewCar newCar = carRepository.findByNewCarId(id);
		Map<String, Object> response = new HashMap<>();
		response.put("newCar", newCar);
	    response.put("carPricing", newCar.getCarPricing());
	    return response;
	}
//
//	public void updateCarService(int newCarId, String carName, String modelBrand, String modelType, double carPrice,
//			String mileage, String fuelType, String transmission, String modelYear, String description,
//			MultipartFile carImage) throws IOException {
//		Optional<NewCar> optional = carRepository.findById(newCarId);
//		NewCar car = new NewCar();
//		car = optional.get();
//
//		car.setCarName(carName);
//		car.setCarBrand(modelBrand);
//		car.setCarType(modelType);
//		car.setCarPrice(carPrice);
////		car.setMileage(mileage);
//		car.setFuelType(fuelType);
//		car.setTransmission(transmission);
//		car.setModelYear(modelYear);
//		car.setDescription(description);
//		car.setCarImage(carImage.getBytes());
//
//		carRepository.save(car);
//
//	}
//
//	public List<NewCar> getAllNewCarsService() {
//
//		return carRepository.findAll();
//
//	}
//
//	public List<NewCar> getNewCarBySearch(String modelName) {
//
//		return carRepository.findByModelName(modelName);
//	}
//
//	public void deleteNewCarService(int newCarId) {
//		carRepository.deleteById(newCarId);
//	}
//
	public List<NewCar> searchCarByPriceAndTypeService(double minPrice, double maxPrice, String modelType) {
		
		return carRepository.searchCarByPriceAndType(minPrice, maxPrice, modelType);


	}

	public Map<String, Object> getCarsByCarName(String carName) {
		List<NewCar> newCars = carRepository.findByCarName(carName);
		Map<String, Object> map = new HashMap<>();
		List<CarPricing> carPricings = new ArrayList<>();
		for (NewCar newCar : newCars) {
			carPricings.add(newCar.getCarPricing());
		}
		map.put("newCar", newCars);
		map.put("carPricing", carPricings);
		return map;
		
	}

	public Map<String, Object> getCarsByFuelTypeAndCarName(String fuelType, String carName) {
		List<NewCar> newCars = carRepository.findByFuelTypeAndCarName(fuelType,carName);
		Map<String, Object> map = new HashMap<>();
		List<CarPricing> carPricings = new ArrayList<>();
		for (NewCar newCar : newCars) {
			carPricings.add(newCar.getCarPricing());
		}
		map.put("newCar", newCars);
		map.put("carPricing", carPricings);
		return map;
	}

	public Map<String, Object> getCarsByTransmissionAndCarName(String transmission, String carName) {
		List<NewCar> newCars = carRepository.findByCarNameAndTransmission(carName,transmission);
		Map<String, Object> map = new HashMap<>();
		List<CarPricing> carPricings = new ArrayList<>();
		for (NewCar newCar : newCars) {
			carPricings.add(newCar.getCarPricing());
		}
		map.put("newCar", newCars);
		map.put("carPricing", carPricings);
		return map;
	}


}
