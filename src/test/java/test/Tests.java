package test;

import org.testng.annotations.Test;

public class Tests {
	
	
	
	@Test
	public void atest1() {
		
		
		String a ="dfd df df df"+"\r\n"
				+ "fdfdf dfdfdf "
				+ "8894 0949"+"\r\n"+"09490404040"
				+ "fdfdfdf";
		
		System.out.println(a);
		System.out.println("=============");
		
		String cleaned = a.replaceAll("[\\s\\r\\n\\t]", "");
		
		
		
		
		
		System.out.println(cleaned);
		
		
	}
	
	@Test
	public void btest2() {
		
		System.out.println(2);
		
	}

	
	@Test
	public void ctest3() {
		
		System.out.println(3);
		
	}
}
