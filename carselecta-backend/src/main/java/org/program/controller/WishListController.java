package org.program.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Set;

import org.program.entity.NewCar;
import org.program.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class WishListController {
	
	@Autowired
	private WishListService wishListService;
	
	@PostMapping("/add-to-favorite")
	public void AddToWishList(@RequestBody Map<String, Object> requestBody) {
		List<Integer> favorites = (List<Integer>) requestBody.get("favoriteCarIds");
		String email = (String) requestBody.get("email");
		
		wishListService.addToWishListService(favorites,email);
	}
	
	@GetMapping("/get-favorite-cars")
	public Set<NewCar> getfavoriteCars(@RequestParam String email) {
		return wishListService.getFavoriteCarsService(email);
	}
	@GetMapping("/delete-from-favorite")
	public void deleteFromWishlist(@RequestParam String newCarId, @RequestParam String email) {
		wishListService.deleteFromWishlistService(Integer.parseInt(newCarId), email);
	}
}
