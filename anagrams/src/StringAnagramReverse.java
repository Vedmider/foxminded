
public class StringAnagramReverse {

	private int[] counterValuesInit(String word) {
		int[] tempCounterArrayIn = new int[word.length()];
		int[] tempCounterArrayOut;
		int positions = 0;

		for (int i = 0; i < word.length(); i++) {

			if (Character.isAlphabetic(word.charAt(i))) {
				tempCounterArrayIn[positions] = i;
				positions++;
			}
		}

		tempCounterArrayOut = new int[positions];
		System.arraycopy(tempCounterArrayIn, 0, tempCounterArrayOut, 0, positions);
		return tempCounterArrayOut;

	}

	private String[] wordsReverse(String textToReverse) {
		String[] tempArray = textToReverse.split("\\s+");
		String[] wordsArray = new String[tempArray.length];

		for (int i = 0; i < wordsArray.length; i++) {
			int index = 0;
			int[] counterValuesArray = counterValuesInit(tempArray[i]);
			StringBuilder word = new StringBuilder(tempArray[i]);

			for (int j = tempArray[i].length() - 1; j >= 0; j--) {
				char tempCharForWrite = tempArray[i].charAt(j);

				if (!Character.isAlphabetic(tempCharForWrite)) {
					continue;
				}

				int position = counterValuesArray[index];
				word.setCharAt(position, tempCharForWrite);
				index++;
			}

			wordsArray[i] = word.toString();
		}

		return wordsArray;
	}

	public String makeAnagram(String text) {
		String[] wordsArray = wordsReverse(text);
		String textReversed = "";

		for (int i = 0, d = wordsArray.length; i < d; i++) {
			if(wordsArray[i].equals("")) {
				continue;
			}
			textReversed += wordsArray[i];
			if(i != (d - 1)) {
				textReversed += " ";
			}
			    
		}

		return textReversed;
	}

}
