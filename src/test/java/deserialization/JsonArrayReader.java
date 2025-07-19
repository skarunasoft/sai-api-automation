package deserialization;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonArrayReader {
	
	
	
	public static void main(String[] args) throws IOException {

		ObjectMapper objMapper = new ObjectMapper();
		
		String dir = System.getProperty("user.dir")+"/src/test/resources/person.json";
		//String os = System.getProperty("os.name");
		//System.out.println(dir+os);
		//String personJson = "./src/test/resources/person.json";
		
		
		File personFile = new File(dir);
		List<Person> person = objMapper.readValue(personFile, new TypeReference<List<Person>>() {
		});

		System.out.println(person.size());

		for (Person per : person) {
			System.out.println("ID:" + per.getId());
			System.out.println("Name:" + per.getName());
			System.out.println("Country:" + per.getCountry());
		}

	}

}
