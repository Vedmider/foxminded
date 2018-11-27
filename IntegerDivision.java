package com.foxminded.integerDivision;

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
		
		if(divisor == 1) {
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
		
		if(dividend < divisor) {
			while(tempInt < divisor) {
				tempInt = parseToInt(tempInt, 0);
			}
		}
		
		numberOfChars = lengthOfInt(tempInt) - lengthOfInt(tempInt - (tempInt % divisor));
		tempString += getCharString(numberOfChars, " ");
		spacesCounter = dividendAsArray.length - (intToArray(tempInt)).length;
		tempInt = tempInt - (tempInt % divisor);
		tempString += tempInt;
		tempString += getCharString(spacesCounter, " ");
		tempString += "|";
		/*length = divisor >= dividend / divisor ? lengthOfInt(divisor) : lengthOfInt(dividend / divisor);
		tempString += getCharString(length, "-");*/
		return tempString;	
	}
	
	private String makeThirdGraphicString(int dividend, int divisor) {
		String tempString = " ";
		int result = dividend / divisor;
		int [] dividendAsArray = intToArray(dividend);
		int tempInt = dividendAsArray[0];
		int spacesCounter;
		
		if(divisor == 1) {
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
		
		if(dividend < divisor) {
			while(tempInt < divisor) {
				tempInt = parseToInt(tempInt, 0);
			}
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
		int[] tempMinuedArray = {};
		String[] tempNumbersArray = {};
		int[] tempResultArray = {};
		String tempString = "";
		int tempMinued;
		int tempSubtrahend;
		int numberOfChars = 0;
		String parsedResult = "";
		int count = 0;
		
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		dividendAsArray = intToArray(dividend);
		tempMinued = dividendAsArray[0];
		
		if(dividend < divisor) {
			int remainder = dividend;
			while(remainder < divisor) {
				remainder = parseToInt(remainder, 0);
				count++;
			}
			numberOfChars = lengthOfInt(remainder) - lengthOfInt(dividend);
		}
		
		graphicFrame.add("_" + dividend  + getCharString(numberOfChars , " ") + "|" + divisor);
		graphicFrame.add(makeSecondGraphicString(dividend, divisor));
		graphicFrame.add(makeThirdGraphicString(dividend, divisor));
		
		if(dividend == 0 || divisor == 1) {
			tempStringArray = graphicFrame.toArray(new String[3]);
			return tempStringArray;
		} 
		
		for(int i = 1; i < dividendAsArray.length; i++) {
			if(tempMinued > divisor || dividend < divisor) {
				break;
			}
			tempMinued = parseToInt(tempMinued, dividendAsArray[i]);	
		}
		
		
		//build other graphicStrings 
		for(int i = lengthOfInt(tempMinued) - 1; i < dividendAsArray.length; i++) {
			if(dividend < divisor) {
				break;
			}
			if(i == lengthOfInt(tempMinued) - 1) {
				numberOfChars = lengthOfInt(tempMinued) - lengthOfInt(tempMinued % divisor);
				tempString = getCharString(numberOfChars, " ");
				tempMinued = tempMinued % divisor;
				continue;
			}
			
			if(tempMinued == 0) {
				tempString += " ";
			}
			
			tempMinued = parseToInt(tempMinued, dividendAsArray[i]);
			graphicFrame.add(tempString + "_" + tempMinued);
			tempSubtrahend = tempMinued - (tempMinued % divisor);
			graphicFrame.add(tempString + " " + getCharString(lengthOfInt(tempMinued) - lengthOfInt(tempSubtrahend), " ") + tempSubtrahend);	
			graphicFrame.add(tempString + " " + getCharString(lengthOfInt(tempMinued), "-"));
			numberOfChars = lengthOfInt(tempMinued) - lengthOfInt(tempMinued % divisor);
			tempString += getCharString(numberOfChars, " ");
			tempMinued = tempMinued % divisor;
			
		}
		
		//build remainder graphicStrings
		if(dividend < divisor) {
			tempMinued = dividend;
		}
		
		for(int i = 0; i < 9; i++) {
			if(tempMinued == 0) {
				break;
			}
			
			if(findLoop(tempMinuedArray, parseToInt(tempMinued, 0)) != -1) {
				break;
			}
			
			tempMinued = parseToInt(tempMinued, 0);
			parsedResult += "" + tempMinued / divisor;
			tempResultArray = addToArray(tempResultArray, tempMinued / divisor);
			tempMinuedArray = addToArray(tempMinuedArray, tempMinued);
			tempNumbersArray = addToArray(tempNumbersArray, parsedResult);
			tempSubtrahend = tempMinued - (tempMinued % divisor);
			
			if(i >= count) {
			graphicFrame.add(tempString + "_" + tempMinued);	
			graphicFrame.add(tempString + " " + getCharString(lengthOfInt(tempMinued) - lengthOfInt(tempSubtrahend), " ") + tempSubtrahend);	
			graphicFrame.add(tempString + " " + getCharString(lengthOfInt(tempMinued), "-"));
			}
			
			numberOfChars = lengthOfInt(tempMinued) - lengthOfInt(tempMinued % divisor);
			tempString += getCharString(numberOfChars, " ");
			tempMinued = tempMinued % divisor;
			
		}
		
		graphicFrame.add(tempString + " " + tempMinued);	
		tempStringArray = new String[graphicFrame.size()];
		graphicFrame.toArray(tempStringArray);
		
		tempString = "";
		if(findLoop(tempMinuedArray, parseToInt(tempMinued, 0)) == 0) {
			tempString = "." + "(";
			
			for(int i = findLoop(tempMinuedArray, parseToInt(tempMinued, 0)); i < tempResultArray.length; i++) {
				tempString += tempResultArray[i];
			}			
			tempString += ")";
			
		} else if(findLoop(tempMinuedArray, parseToInt(tempMinued, 0)) > 0) {
			tempString = "." + tempNumbersArray[findLoop(tempMinuedArray, parseToInt(tempMinued, 0)) - 1] + "(";
			
			for(int i = findLoop(tempMinuedArray, parseToInt(tempMinued, 0)); i < tempResultArray.length; i++) {
				tempString += tempResultArray[i];
			}
			
			tempString += ")";
		} else if(!parsedResult.equals("")){
			tempString = "." + parsedResult;
		}
		
		tempStringArray[2] += tempString;
		tempString += dividend / divisor;
		
		if(lengthOfInt(divisor) >= tempString.length()) {
			numberOfChars = lengthOfInt(divisor);
		} else {
			numberOfChars = tempString.length();
		}
		
		tempStringArray[1] += getCharString(numberOfChars, "-");
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
	
	private int[] addToArray(int[] arrayToAdd, int intToAdd) {
		int[] tempIntArray = new int[arrayToAdd.length + 1];
		System.arraycopy(arrayToAdd, 0, tempIntArray, 0, arrayToAdd.length);
		tempIntArray[arrayToAdd.length] = intToAdd;
		return tempIntArray;	
	}
	
	private String[] addToArray(String[] arrayToAdd, String StringToAdd) {
		String[] tempStringArray = new String[arrayToAdd.length + 1];
		System.arraycopy(arrayToAdd, 0, tempStringArray, 0, arrayToAdd.length);
		tempStringArray[arrayToAdd.length] = StringToAdd;
		return tempStringArray;	
	}
	
	private int findLoop(int[] arrayWithLoop, int findNumber) {
		int length = arrayWithLoop.length;
		for(int i = 0; i < length; i++) {
			if(arrayWithLoop[i] == findNumber) {
				return i;
			}
		}
		
		return -1;
	}
		
}


