import java.util.Arrays;

/**
 * 
 * @author Lisovets Andrii
 * This program can be used only to find palindrom consisted of five digits simple numbers
 *
 */

public class PalindromFromFiveDigitNumbers {
	private static final int MAX_NUMBER = 100000;
	private static final int MIN_NUMBER = 9999;

	public long[] getNumbers() {
		long[] resultArray = new long[3];
		long[] tempLongArray;
		long multiplicands = 0;
		long multiplier = 0;
		long product = 0;
		int length;
		long tempInt = 0;
		
		tempLongArray = makeSimpleNumberArray();
		length = tempLongArray.length;
		
		for(int i = length - 1; i >= 0; i--) {
			for(int k = i; k >= 0; k--) {
				if(isPalindrom(tempLongArray[i] * tempLongArray[k])) {
					tempInt = tempLongArray[i] * tempLongArray[k];
				}
				
				if(tempInt > product) {
					product = tempInt;
					multiplicands = tempLongArray[i];
					multiplier = tempLongArray[k];
				}
			}
		}
		
		resultArray[0] = multiplicands;
		resultArray[1] = multiplier;
		resultArray[2] = product;
		return resultArray;
	}
	
	private long[] makeSimpleNumberArray() {
		boolean[] tempBoolArray = new boolean[MAX_NUMBER];
		long[] tempLongArray = {};
		Arrays.fill(tempBoolArray, true);
		int length;
		
		tempBoolArray[0] = false;
		tempBoolArray[1] = false;
		length = tempBoolArray.length;
		
		for(int i = 2; i < length; i++) {
			if(tempBoolArray[i]) {
				if(i > MIN_NUMBER ) {
					tempLongArray = addToLongArray(tempLongArray, i);
				}
				
				for(int k = i * i; k < length; k += i) {
					if(k < 0) {
						break;
					}
					tempBoolArray[k] = false;
				}
			}
		}
		return tempLongArray;
	}
	
	private long[] addToLongArray(long[] sourceLongArray, int numberToAdd) {
		int length = sourceLongArray.length + 1;
		long[] destinationIntArray = new long[length];
		System.arraycopy(sourceLongArray, 0, destinationIntArray, 0, sourceLongArray.length);
		destinationIntArray[sourceLongArray.length] = numberToAdd;
		return destinationIntArray;	
	}
	
	private boolean isPalindrom(long numberToCheck) {
		long [] tempLongArray = longToArray(numberToCheck);
		int length = tempLongArray.length;
		
		for(int i = 0, d = length - 1; i < length / 2; i++) {
			if(tempLongArray[i] != tempLongArray[d]) {
				return false;
			}
			d--;
		}
		return true;
	} 
	
	private long[] longToArray(long numberToConvert) {
		long[] tempIntArray;
		int count = 0;
		
		if(numberToConvert == 0) {
			return new long[1];
		}
		 
        for (long i = numberToConvert; i != 0; i /= 10) {
        	count++;
        }
        tempIntArray = new long[count];
        
        for(int i = count - 1; i >= 0; i--) {
        	tempIntArray[i] = numberToConvert % 10;
        	numberToConvert /= 10;
        }
        
        return tempIntArray;
	}		
}
