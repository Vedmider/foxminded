import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StringAnagramReverseTestFinal {
	
	static StringAnagramReverse test;
	
	@BeforeAll
	public static void setUp() {
		test = new StringAnagramReverse();
	
	}
	
	@Test
	void testMakeWordAnagram() {
		String expected = "margana";
		String testingText = "anagram";
		String actual = test.makeAnagram(testingText);
				
		assertNotNull(test.makeAnagram(testingText));
		assertEquals(expected, actual);
	}
	
	@Test
	void testMakeAnagramWithNumbers() {
		String expected = "2352346";
		String testingText = "2352346";
		String actual = test.makeAnagram(testingText);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testNullPointerExeptionWhenMakingAnagramWithNullText() {
		        assertThrows(NullPointerException.class, () -> {
					test.makeAnagram(null);
				});
	}
	
	@Test
	void testMakeAnagramWithOneLetterAndSpaces() {
		String expected = "a";
		String testingText = "     a";
		String actual = test.makeAnagram(testingText);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testMakeAnagramWithOneLetterAndNumbers() {
		String expected = "876a";
		String testingText = "876a";
		String actual = test.makeAnagram(testingText);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testMakeAnagramWithOneLetterAndSigns() {
		String expected = "876a!@#$";
		String testingText = "876a!@#$";
		String actual = test.makeAnagram(testingText);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testMakeAnagramWithSpacesOnly() {
		String expected = "";
		String testingText = "      ";
		String actual = test.makeAnagram(testingText);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testMakeAnagramWithManyWordsDifferentInText() {
		String expected = "yra5m dah a e3lttil bm76al";
		String testingText = "mar5y had a l3ittle la76mb";
		String actual = test.makeAnagram(testingText);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testMakeAnagramWithTwoWords() {
		String expected = "gnikooL rof";
		String testingText = "Looking for";
		String actual = test.makeAnagram(testingText);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testMakeAnagramWithTwoWordsWithLettersAndNumbers() {
		String expected = "gnikooL 123454231";
		String testingText = "Looking 123454231";
		String actual = test.makeAnagram(testingText);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testMakeAnagramWithTwoWordsWithNumbersAndLetters() {
		String expected = "123454231 drowssap";
		String testingText = "123454231 password";
		String actual = test.makeAnagram(testingText);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testMakeAnagramWithTwoWordsWithLetters() {
		String expected = "987654 123454231";
		String testingText = "987654 123454231";
		String actual = test.makeAnagram(testingText);
		
		assertEquals(expected, actual);
	}

}
