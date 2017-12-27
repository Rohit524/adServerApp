package adServer.core;

import java.util.List;
import java.util.Map;

import adServer.model.AdDataDTO;
import adServer.model.ValidationException;




public interface AdService {

	public String newAd(AdDataDTO requestDTO) throws ValidationException;
	
	public Map<String, Object> getAllAdData();
	
	public Map<String, Object> getAd(String partnerId);
}
