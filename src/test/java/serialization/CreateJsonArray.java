package serialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class CreateJsonArray {

	public static void main(String[] args) throws IOException {
		
		
		
		
		 
		
		
		
		
		
		

		Person per1 = new Person(134, "Sai", "INDIA");
		Person per2 = new Person(100, "Sachin", "INDIA");

		List<Person> personList = new ArrayList<>();
		personList.add(per1);
		personList.add(per2);

		ObjectMapper objMapper = new ObjectMapper();
		
		//objMapper.enable(SerializationFeature.INDENT_OUTPUT);

		//String personJson = objMapper.writeValueAsString(personList);
		String personJson = objMapper.writeValueAsString(personList);
		System.out.println(personJson);
		System.out.println(personJson.replaceAll("\"Sachin\",\"country\":\"INDIA\"", "\"Sachin\",\"country\":\"UK\""));
		
		
		//objMapper.writeValue(new File(""), personList);

	}

}
