package adServer.core;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;


import adServer.model.AdDataDTO;
import adServer.model.ValidationException;
import adServer.model.ValidationExceptionMessage;



@Service
public class AdServiceImpl implements AdService {
	HashMap<String, List<AdDataDTO>> mapData = new HashMap<String, List<AdDataDTO>>(2); 


	//method for adding new ads
	public String newAd(AdDataDTO requestDTO) throws ValidationException {
		// TODO Auto-generated method stub
		try{
		Date currentDate = new Date();
		currentDate.setTime(currentDate.getTime() + (requestDTO.getDurationInSeconds()) * 1000);
		requestDTO.setExpiryDate(currentDate);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		requestDTO.setFormattedExpirtyDate(formatter.format(currentDate));
		// checking if ads exist for partner id
		if (mapData.get(requestDTO.getPartnerId()) == null) {
			List<AdDataDTO> adsList = new ArrayList<AdDataDTO>();
			adsList.add(requestDTO);
			mapData.put(requestDTO.getPartnerId(), adsList);
		} else {
			List<AdDataDTO> adsList = mapData.get(requestDTO.getPartnerId());
			adsList.add(requestDTO);
			mapData.put(requestDTO.getPartnerId(), adsList);
		}
		}catch(Exception e){
			ValidationException ve = new ValidationException(e.getMessage());
			ve.addValidationExceptionMessage(new ValidationExceptionMessage(e.getMessage()));
			throw ve;
		}
		return "success";
	}
		
	//method for getting all ads
	public Map<String, Object> getAllAdData() {
		// TODO Auto-generated method stub
		Map<String, Object> newMapData = new HashMap<String, Object>();
		List<AdDataDTO> list = new ArrayList<AdDataDTO>();

		// get all ads
		if (!mapData.isEmpty()) {
			for (Map.Entry<String, List<AdDataDTO>> data : mapData.entrySet()) {
				list.addAll((List<AdDataDTO>) data.getValue());
			}
			newMapData.put("partnerResponse", list);
		}
		// if no ads exist
		else {
			newMapData.put("partnerInvalidResponse", "No ads exist");
		}
		return newMapData;
	}

	//method for getting ads based on partner id
	public Map<String, Object> getAd(String partnerId) {
		// TODO Auto-generated method stub

		Map<String, Object> newMapData = new HashMap<String, Object>();
		List<AdDataDTO> list = new ArrayList<AdDataDTO>();

		if (mapData.get(partnerId) != null) {
				for (AdDataDTO partnerAds : mapData.get(partnerId)) {
					int compare = new Date().compareTo(partnerAds.getExpiryDate());
					if (compare == -1) {
						list.add(partnerAds);
					}
				}

			if (list.isEmpty()) {
				newMapData.put("partnerInvalidResponse", "No active ads exist for the Partner Id");
			} else {
				newMapData.put("partnerResponse", list);
			}
			return newMapData;
		} else {
			newMapData.put("partnerInvalidResponse", "Invalid partner id");
			return newMapData;
		}
	}


	

}
