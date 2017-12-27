package adServer.test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import adServer.core.AdService;
import adServer.model.AdDataDTO;
import adServer.model.ValidationException;

@ContextConfiguration(locations = { "classpath*:/spring_test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class AdApplicationTest {
	
    @Autowired
	AdService service;

    @Test
    public void firstThree() throws ValidationException{
    	createNewAdTest();
    	getAdTest();
    	getAllAdTest();
    }
    public void createNewAdTest() throws ValidationException{

        AdDataDTO request = new AdDataDTO();
		request.setPartnerId("12345");
		request.setDurationInSeconds(10);
		request.setDispalyContent("My New Ad");
		String s = null;
		try {
			 s = service.newAd(request);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("success", s);
		
        System.out.println("Hello");
    }
    
	
	public void getAdTest() 
	{
		Map <String, Object> entry = service.getAd("12345");
        List<AdDataDTO> list = (List<AdDataDTO>) entry.get("partnerResponse");
        assertEquals("12345",list.get(0).getPartnerId());
	}

	
	public void getAllAdTest() 
	{
		
		Map<String, Object> response = service.getAllAdData();
		List<AdDataDTO> list = (List<AdDataDTO>) response.get("partnerResponse");
	    assertEquals("12345",list.get(0).getPartnerId());

	}

}
