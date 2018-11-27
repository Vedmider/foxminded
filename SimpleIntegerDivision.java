import java.util.ArrayList;

public class IntegerDivision {
			
	public String divide (int dividend, int divisor) {
		if(divisor == 0) {
			throw new IllegalArgumentException("Division by zero is a big no-no in mathematics");
		}
		
		String[] tempStringArray;
		String tempString = "";
		
		tempStringArray = makeGraphicFrame(dividend, divisor);
		
		for(String s : tempStringArray) {
			tempString += s + "\n";
		}
		return tempString;
	}
		
	private int[] intToArray(int dividendNumber) {
		int[] tempIntArray;
		int count = 0;
		
		dividendNumber = Math.abs(dividendNumber);
		if(dividendNumber == 0) {
			return new int[1];
		}
		 
        for (int tempNumber = dividendNumber; tempNumber != 0; tempNumber /= 10) {
        	count++;
        }
        tempIntArray = new int[count];
        
        for(int i = count - 1; i >= 0; i--) {
        	tempIntArray[i] = dividendNumber % 10;
        	dividendNumber /= 10;
        }
        
        return tempIntArray;
	}
	
	private int parseToInt (int firstNumber, int secondNumber) {
		String tempString = "";
		int tempInt;
		
		tempString += firstNumber + "" + secondNumber;
		tempInt = Integer.parseInt(tempString);
		return tempInt;	
	}
	
	private String makeSecondGraphicString(int dividend, int divisor) {
		String tempString = " ";
		int spacesCounter;
		int[] dividendAsArray;
		int tempInt;
		int numberOfChars;
		int length;
		
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		dividendAsArray = intToArray(dividend);
		tempInt = dividendAsArray[0];
		if((dividend < divisor) || (divisor == 1)) {
			tempString += getCharString(dividendAsArray.length, " "); 
			tempString += "|";
			length = divisor >= dividend / divisor ? lengthOfInt(divisor) : lengthOfInt(dividend / divisor);
			tempString += getCharString(length, "-");
			return tempString;
		}
		
		for(int i = 1; i < dividendAsArray.length; i++) {
			if(tempInt > divisor) {
				break;
			}
			tempInt = parseToInt(tempInt, dividendAsArray[i]);	
		}
		
		numberOfChars = lengthOfInt(tempInt) - lengthOfInt(tempInt - (tempInt % divisor));
		tempString += getCharString(numberOfChars, " ");
		spacesCounter = dividendAsArray.length - (intToArray(tempInt)).length;
		tempInt = tempInt - (tempInt % divisor);
		tempString += tempInt;
		tempString += getCharString(spacesCounter, " ");
		tempString += "|";
		length = divisor >= dividend / divisor ? lengthOfInt(divisor) : lengthOfInt(dividend / divisor);
		tempString += getCharString(length, "-");
		return tempString;	
	}
	
	private String makeThirdGraphicString(int dividend, int divisor) {
		String tempString = " ";
		int result = dividend / divisor;
		int [] dividendAsArray = intToArray(dividend);
		int tempInt = dividendAsArray[0];
		int spacesCounter;
		
		if((dividend < divisor) || (divisor == 1)) {
			tempString += getCharString(dividendAsArray.length, " ");
			tempString += "|" + result;
			return tempString;
		}
		
		for(int i = 1; i < dividendAsArray.length; i++) {
			if(tempInt > divisor) {
				break;
			}
			tempInt = parseToInt(tempInt, dividendAsArray[i]);	
		}
		
		tempString += getCharString(lengthOfInt(tempInt), "-");
		tempInt = (intToArray(tempInt)).length;
		spacesCounter = dividendAsArray.length - tempInt;
		
		tempString += getCharString(spacesCounter, " ");
		tempString += "|" + result;
		return tempString;
	}
	
	private String[] makeGraphicFrame(int dividend, int divisor) {
		ArrayList<String> graphicFrame = new ArrayList<String>();
		String[] tempStringArray;
		int[] dividendAsArray;
		String tempString = "";
		int tempMinued;
		int tempSubtrahend;
		int numberOfChars;
		
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		dividendAsArray = intToArray(dividend);
		tempMinued = dividendAsArray[0];
		graphicFrame.add("_" + dividend + "|" + divisor);
		graphicFrame.add(makeSecondGraphicString(dividend, divisor));
		graphicFrame.add(makeThirdGraphicString(dividend, divisor));
		
		if((dividend < divisor) || (dividend == 0) || divisor == 1) {
			tempStringArray = graphicFrame.toArray(new String[3]);
			return tempStringArray;
		} 
		
		for(int i = 1; i < dividendAsArray.length; i++) {
			if(tempMinued > divisor) {
				break;
			}
			tempMinued = parseToInt(tempMinued, dividendAsArray[i]);	
		}
		
		
		//build other graphicStrings 
		for(int i = lengthOfInt(tempMinued) - 1; i < dividendAsArray.length; i++) {
			if(i == lengthOfInt(tempMinued) - 1) {
				numberOfChars = lengthOfInt(tempMinued) - lengthOfInt(tempMinued % divisor);
				tempString = getCharString(numberOfChars, " ");
				tempMinued = tempMinued % divisor;
				continue;
			}
			
			tempMinued = parseToInt(tempMinued, dividendAsArray[i]);
			
			if(tempMinued < divisor) {
				continue;
			}
			
			graphicFrame.add(tempString + "_" + tempMinued);
			tempSubtrahend = tempMinued - (tempMinued % divisor);
			graphicFrame.add(tempString + " " + tempSubtrahend);
			graphicFrame.add(tempString + " " + getCharString(lengthOfInt(tempMinued), "-"));
			numberOfChars = lengthOfInt(tempMinued) - lengthOfInt(tempMinued % divisor);
			tempString += getCharString(numberOfChars, " ");
			if(tempMinued == tempSubtrahend) {
				tempString += " ";
			}
			tempMinued = tempMinued % divisor;
			
		}
		if (tempMinued == (tempMinued - tempMinued % divisor)) {
				graphicFrame.add(tempString  + tempMinued);
			} else {
				graphicFrame.add(tempString + " " + tempMinued);
			}
		
		tempStringArray = new String[graphicFrame.size()];
		graphicFrame.toArray(tempStringArray);
		return tempStringArray;
	}
	
	private int lengthOfInt(int intToFindLength) {
		return String.valueOf(intToFindLength).length();
	}
	
	private String getCharString(int numberOfChars, String charToInsert) {
		String tempString = "";

		for(int i = 0; i < numberOfChars; i++) {
			tempString += charToInsert;
		}
		return tempString;
	}
		
}
