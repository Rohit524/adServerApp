package adServer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import adServer.core.AdService;
import adServer.model.AdDataDTO;
import adServer.model.AdResponseDTO;
import adServer.model.ValidationException;



@RestController
//@RequestMapping("/adServer")
public class AdController {
	
	@Autowired
	AdService adService;
	
	   @RequestMapping(value = "/homePage", method = RequestMethod.GET)
	   public ModelAndView student() {
	      return new ModelAndView("homePage", "command", new AdDataDTO());
	   }
	

		@RequestMapping(value="/ad", method={RequestMethod.POST})
		public @ResponseBody ResponseEntity<AdResponseDTO> createNewAd(@ModelAttribute AdDataDTO requestDTO) {
			
			AdResponseDTO responseBody = new AdResponseDTO();
			if(!checkNullValueString(requestDTO.getDispalyContent()) || requestDTO.getDurationInSeconds() == null || !checkNullValueString(requestDTO.getPartnerId()))
			{
				responseBody.setStatuscode(400);
				responseBody.setStatusDesc("Bad Request");
				return new ResponseEntity<AdResponseDTO>(responseBody, HttpStatus.BAD_GATEWAY);
			}
			String response;
			try {
				response = adService.newAd(requestDTO);
			} catch (ValidationException e) {
				// TODO Auto-generated catch block
				responseBody.setStatuscode(500);
				responseBody.setStatusDesc(e.getMessage());
				return new ResponseEntity<AdResponseDTO>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			
			if(response.equals("success")){
				responseBody.setStatuscode(200);
				responseBody.setStatusDesc("Ad request successful");
				return new ResponseEntity<AdResponseDTO>(responseBody, HttpStatus.OK);
			}else{
				responseBody.setStatuscode(503);
				responseBody.setStatusDesc("Service Unavailable");
				return new ResponseEntity<AdResponseDTO>(responseBody, HttpStatus.SERVICE_UNAVAILABLE);	
			}
		}

		   @RequestMapping(value = "/ad/getAllAds", method = RequestMethod.GET)
		   public @ResponseBody ResponseEntity<Map<String,Object>> getAllAds() {
			   
			   return new ResponseEntity<Map<String,Object>>(adService.getAllAdData(),HttpStatus.OK);
		    // return adService.getAllAdData();
		   }
		
		   @RequestMapping(value = "/ad/{partnerId}", method = RequestMethod.GET)
		   public @ResponseBody ResponseEntity<Map<String,Object>> getAd(@PathVariable String partnerId) {
			   
				
				AdResponseDTO responseBody = new AdResponseDTO();
				if(!checkNullValueString(partnerId))
				{
					Map<String, Object> failResponse = new HashMap<String, Object>();
					responseBody.setStatuscode(400);
					responseBody.setStatusDesc("Bad Request");
					 failResponse.put("error", responseBody);
					 return new ResponseEntity<Map<String,Object>>(failResponse,HttpStatus.BAD_REQUEST);
				}
			   
		     return new ResponseEntity<Map<String,Object>>(adService.getAd(partnerId),HttpStatus.OK);
		   }

			public boolean checkNullValueString(String input) {

				// It can't contain only numbers if it's null or empty...
				if (input == null || input.length() == 0)
					return false;


				return true;
			}


	}


