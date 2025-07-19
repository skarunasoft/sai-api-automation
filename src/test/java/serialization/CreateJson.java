package serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateJson {
	
	
	public static void main(String[] args) throws JsonProcessingException {
		
		Serialization ser = new Serialization();
		ser.setVehicle("car");
		ser.setBrand("Kia");
		ser.setPrice(1000000);
		
		ObjectMapper objMapper = new ObjectMapper();
		
		String json = objMapper.writeValueAsString(ser);
		
		System.out.println(json);
		
		
		
		
		
	}
	
	
	
	
	

}
