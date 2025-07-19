package payload;

import java.util.HashMap;
import java.util.Map;

public class EmployeePayloadJson {
	
	
	
	public static String createEmployee(String firstName, String lastName, String email, String phone) {
		
		return "{"
				+ "    \"first_name\": \""+firstName+"\","
				+ "    \"last_name\": \""+lastName+"\","
				+ "    \"email\": \""+email+"\","
				+ "    \"phone\": \""+phone+"\""
				+ "  }";
	}
	
	
	
	
	public static String modifyEmp(String firstName, String lastName, String email, String phone) {
		
		return "{"
				+ "    \"first_name\": \""+firstName+"\","
				+ "    \"last_name\": \""+lastName+"\","
				+ "    \"email\": \""+email+"\","
				+ "    \"phone\": \""+phone+"\""
				+ "  }";
	}
	
public static String partialModifyEmp(String phone) {
		
		return "{"
				+ "    \"phone\": \""+phone+"\""
				+ "  }";
	}
	
	
	
	
	public static Map<String, String> filterByEmpId(String id) {
		Map<String, String> filter = new HashMap<String, String>();
		filter.put("id", id);		
		return filter;
	}
	
	
	

}
