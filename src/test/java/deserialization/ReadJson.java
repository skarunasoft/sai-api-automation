package deserialization;

import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ReadJson
{
	
	

	
	
	
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		String carJson="{\"vehicle\":\"Bus\",\"brand\":\"TATA\",\"price\":1000000}\r\n";
		
		ObjectMapper objMapper = new ObjectMapper();
		DeSerialization des = objMapper.readValue(carJson, DeSerialization.class);
		
		
		System.out.println(des.getVehicle());
		System.out.println(des.getBrand());
		System.out.println(des.getPrice());
		
		
	}
	
	
	
	

}
