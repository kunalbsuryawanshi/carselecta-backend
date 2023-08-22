package org.program.controller;

import java.io.IOException;
import java.util.List;

import org.program.entity.NewCar;
import org.program.service.NewCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
public class NewCarController {

	@Autowired
	private NewCarService newCarService;
	
	@PostMapping("/add-new-car")
	public void addNewCar(
			@RequestParam("carImage") MultipartFile carImage,
			@RequestParam("carName") String carName,
			@RequestParam("carModel") String carModel,
			@RequestParam("carBrand") String carBrand,
			@RequestParam("carType") String carType,
			@RequestParam("carPrice") String carPrice,
			@RequestParam("ARAIMileage") String ARAIMileage,
			@RequestParam("cityMileage") String cityMileage,
			@RequestParam("highwayMileage") String highwayMileage,
			@RequestParam("fuelType") String fuelType,
			@RequestParam("transmission") String transmission,
			@RequestParam("modelYear") String modelYear,
			@RequestParam("description") String description,
			@RequestParam("exShowroomPrice") String exShowroomPrice,
			@RequestParam("roadTax") String roadTax,
			@RequestParam("insurance") String insurance,
			@RequestParam("otherCharges") String otherCharges,
			@RequestParam("optionalCharges") String optionalCharges,
			@RequestParam("EMI") String EMI,
			@RequestParam("username") String username
			) throws IOException 
	{
		newCarService.addNewCarService(
				carImage,
				carName,
				carModel,
				carBrand,
				carType,
		        Double.parseDouble(carPrice),
		        ARAIMileage,
		        cityMileage,
		        highwayMileage,
		        fuelType,
		        transmission,
		        modelYear,
		        description,
		        Double.parseDouble(exShowroomPrice),
		        Double.parseDouble(roadTax),
		        Double.parseDouble(insurance),
		        Double.parseDouble(otherCharges),
		     	Double.parseDouble(optionalCharges),
		     	EMI,
		     	username
				);
		
	}
	
	@PostMapping("/search-by-model-name")
	public List<NewCar> searchByModelName(@RequestParam("carName") String carName) {
		return newCarService.searchByModelNameService(carName);
	}
	@PostMapping("/search-by-model-type")
	public List<NewCar> searchByModelType(@RequestParam("carType") String carType) {
		return newCarService.searchByModelTypeService(carType);
	}
	@PostMapping("/search-by-brand-name")
	public List<NewCar> searchByBrandName(@RequestParam("carBrand") String carBrand) {
		return newCarService.searchByBrandNameService(carBrand);
	}
	
	@PostMapping("/search-by-model-year")
	public List<NewCar> searchByModelYear(@RequestParam("modelYear") String modelYear) {
		return newCarService.searchByModelYearService(modelYear);
	}
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/find-car-by-id")
	public NewCar findCar(@RequestParam String newCarId) {
		return newCarService.findCarById(Integer.parseInt(newCarId));
	}
//	
//	@PostMapping("/update-car-details")
//	public void updateCarDetails(@RequestParam("newCarId") String newCarId, @RequestParam("modelName") String modelName,
//			@RequestParam("modelBrand") String modelBrand, @RequestParam("modelType") String modelType,
//			@RequestParam("price") String price, @RequestParam("mileage") String mileage,
//			@RequestParam("fuelType") String fuelType, @RequestParam("transmission") String transmission,
//			@RequestParam("modelYear") String modelYear, @RequestParam("description") String description,
//			@RequestParam("carImage") MultipartFile carImage) throws NumberFormatException, IOException
//
//	{
//		newCarService.updateCarService(Integer.parseInt(newCarId), modelName, modelBrand, modelType, price, mileage, fuelType, transmission, modelYear, description, carImage);
//	}
//	
//	@GetMapping("/get-all-cars")
//	public List<NewCar> getAllNewCars() {
//		
//		return newCarService.getAllNewCarsService();
//	}
//	@PostMapping("/get-all-cars-for-update")
//	public List<NewCar> getAllCars() {
//		
//		return newCarService.getAllNewCarsService();
//	}
//	@GetMapping("/get-car-by-search")
//	public List<NewCar> getCarBySearch(@RequestParam String modelName) {
//		return null;
//	}
//	
//	@GetMapping("/delete-car-by-id")
//	public void deleteNewCar(@RequestParam String newCarId) {
//		newCarService.deleteNewCarService(Integer.parseInt(newCarId));
//	}
//	
	@PostMapping("/Hatchback")
	public List<NewCar> searchCarByType1(@RequestParam("minPrice") String minPrice, @RequestParam("maxPrice") String maxPrice, @RequestParam("modelType") String modelType){
		
		return newCarService.searchCarByPriceAndTypeService(Double.parseDouble(minPrice), Double.parseDouble(maxPrice), modelType);
		
	}
	@PostMapping("/Sedan")
	public List<NewCar> searchCarByType2(@RequestParam("minPrice") String minPrice, @RequestParam("maxPrice") String maxPrice, @RequestParam("modelType") String modelType){
		return newCarService.searchCarByPriceAndTypeService(Double.parseDouble(minPrice), Double.parseDouble(maxPrice), modelType);
		
	}
	@PostMapping("/SUV")
	public List<NewCar> searchCarByType3(@RequestParam("minPrice") String minPrice, @RequestParam("maxPrice") String maxPrice, @RequestParam("modelType") String modelType){
		return newCarService.searchCarByPriceAndTypeService(Double.parseDouble(minPrice), Double.parseDouble(maxPrice), modelType);
		
	}
	@PostMapping("/MUV")
	public List<NewCar> searchCarByType4(@RequestParam("minPrice") String minPrice, @RequestParam("maxPrice") String maxPrice, @RequestParam("modelType") String modelType){
		return newCarService.searchCarByPriceAndTypeService(Double.parseDouble(minPrice), Double.parseDouble(maxPrice), modelType);
		
	}
	@PostMapping("/Luxury")
	public List<NewCar> searchCarByType5(@RequestParam("minPrice") String minPrice, @RequestParam("maxPrice") String maxPrice, @RequestParam("modelType") String modelType){
		return newCarService.searchCarByPriceAndTypeService(Double.parseDouble(minPrice), Double.parseDouble(maxPrice), modelType);
		
	}
	@PostMapping("/Hybrid")
	public List<NewCar> searchCarByType6(@RequestParam("minPrice") String minPrice, @RequestParam("maxPrice") String maxPrice, @RequestParam("modelType") String modelType){
		return newCarService.searchCarByPriceAndTypeService(Double.parseDouble(minPrice), Double.parseDouble(maxPrice), modelType);
		
	}
	@PostMapping("/Electric")
	public List<NewCar> searchCarByType7(@RequestParam("minPrice") String minPrice, @RequestParam("maxPrice") String maxPrice, @RequestParam("modelType") String modelType){
		return newCarService.searchCarByPriceAndTypeService(Double.parseDouble(minPrice), Double.parseDouble(maxPrice), modelType);
		
	}
	@PostMapping("/Minivan")
	public List<NewCar> searchCarByType8(@RequestParam("minPrice") String minPrice, @RequestParam("maxPrice") String maxPrice, @RequestParam("modelType") String modelType){
		return newCarService.searchCarByPriceAndTypeService(Double.parseDouble(minPrice), Double.parseDouble(maxPrice), modelType);
		
	}
	@PostMapping("/Wagon")
	public List<NewCar> searchCarByType9(@RequestParam("minPrice") String minPrice, @RequestParam("maxPrice") String maxPrice, @RequestParam("modelType") String modelType){
		return newCarService.searchCarByPriceAndTypeService(Double.parseDouble(minPrice), Double.parseDouble(maxPrice), modelType);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
/*
 * <option value="Hatchback">Hatchback</option>
                      <option value="Sedan">Sedan</option>
                      <option value="SUV">SUV</option>
                      <option value="MUV">MUV</option>
                      <option value="Luxury">Luxury</option>
                      <option value="Hybrid">Hybrid</option>
                      <option value="Electric">Electric</option>
                      <option value="Minivan">Minivan</option>
                      <option value="Wagon">Wagon</option>
 * 
 * 
 * 
 * */