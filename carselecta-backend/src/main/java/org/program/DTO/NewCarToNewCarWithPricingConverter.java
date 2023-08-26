package org.program.DTO;

import org.program.entity.NewCar;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class NewCarToNewCarWithPricingConverter implements Converter<NewCar, NewCarWithPricing> {

	@Override
	public NewCarWithPricing convert(NewCar source) {
		NewCarWithPricing newCarWithPricing = new NewCarWithPricing();
		newCarWithPricing.setNewCar(source);
		newCarWithPricing.setCarPricing(source.getCarPricing()); // Assuming you have a getter for carPricing in NewCar

		return newCarWithPricing;
	}
}
