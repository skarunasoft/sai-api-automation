package context;

import java.util.HashMap;
import java.util.Map;

public class AppData {
	
	
	
	public Map<String, String> empFilterByName() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("first_name", "Sachin");
		params.put("last_name", "Tendulkar");
		
		return params;
	}
	
	
	
	

}
