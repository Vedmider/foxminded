import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestServerResponse1 {	
	static URLConnection test;
	
	@BeforeClass
	public static void setUp() {
		test = new URLConnection();
	}
	
	@Test
	public void testA01ResponceCodeWith5765Amount() {
		//URLConnection test = new URLConnection();
		String expected = "responseCode=A01";	
		String responce = test.getWithAccountData("amount", 5765);
		assertTrue(responce.contains(expected));
	}
	
	@Test
	public void testD03ResponceCodeWith12550Amount() {
		String expected = "responseCode=D03";
		String responce = test.getWithAccountData("amount", 12550);
		assertTrue(responce.contains(expected));		
	}
	
	@Test
	public void testD05ResponceCodeWith7547AmountAndTrackData() {
		String expected = "responseCode=D05";
		String responce = test.getWithTrackData("amount", 7547);
		assertTrue(responce.contains(expected));
	}
	
	@Test
	public void testE02ResponceCodeWith13854AmountAndTrackData() {
		String expected = "responseCode=E02";
		String responce = test.getWithTrackData("amount", 13854);
		assertTrue(responce.contains(expected));
	}
	
	@Test
	public void test00AVSResponceCode() {
		String expected = "avsResponseCode=00";
		String responce = test.getWithAccountData("zipCode", 11111);
		assertTrue(responce.contains(expected));
	}
	
	@Test
	public void test46AVSResponceCode() {
		String expected = "avsResponseCode=46";
		String responce = test.getWithAccountData("zipCode", 22222);
		assertTrue(responce.contains(expected));
	}
	
	@Test
	public void test43AVSResponceCodeWithTrackData() {
		String expected = "avsResponseCode=43";
		String responce = test.getWithTrackData("zipCode", 33333);
		assertTrue(responce.contains(expected));
	}
	
	@Test
	public void test40AVSResponceCodeWithTrackData() {
		String expected = "avsResponseCode=40";
		String responce = test.getWithTrackData("zipCode", 44444);
		assertTrue(responce.contains(expected));
	}
	
	@Test
	public void test_M_CSCResponceCode() {
		String expected = "cscResponseCode=M";
		String responce = test.getWithAccountData("csc", 111);
		assertTrue(responce.contains(expected));
	}
	
	@Test
	public void test_N_CSCResponceCodeWith5000Amount() {
		String expected = "cscResponseCode=N";
		String responce = test.getWithAccountData("csc", 222);
		assertTrue(responce.contains(expected));
	}
	
	@Test
	public void test_P_CSCResponceCodeWithTrackData() {
		String expected = "cscResponseCode=P";
		String responce = test.getWithTrackData("csc", 333);
		assertTrue(responce.contains(expected));
	}
	
	@Test
	public void test_S_CSCResponceCodeWithTrackData() {
		String expected = "cscResponseCode=S";
		String responce = test.getWithTrackData("csc", 444);
		assertTrue(responce.contains(expected));
	}

}
