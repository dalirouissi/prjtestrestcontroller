package com.example;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/vehicles")
public class VehicleController {

	private static final Log logger = LogFactory.getLog(VehicleController.class);
	
	
	@RequestMapping("/info")
	public void displayBookmarkInfo(@RequestBody Vehicle vehicle){
		logger.info("The object id   =   "+vehicle.getId());
		logger.info("The object Name  =  "+vehicle.getModel());
		logger.info("The object version  =  "+vehicle.getManufacture());
	}
}
