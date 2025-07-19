package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	
	public static ThreadLocal<Scenario> threadScenario = new ThreadLocal<Scenario>();
	
	@Before
	public void beforeScenario(Scenario scenario) {
	//	getScenario = scenario;
		threadScenario.set(scenario);
		
		
		System.out.println("running before the scenario..........");
		
	}
	
	
	@After
	public void afterScenario() {
		System.out.println("running after the scenario..........");
		
	}
	
	
	
	
	
	

}
