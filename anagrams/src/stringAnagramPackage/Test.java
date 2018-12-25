package stringAnagramPackage;

public class Test {

	public static void main(String[] args) {
		TextWithSpaces("   a");
		StringAnagramReverse ter = new StringAnagramReverse();
		ter.makeAnagram("a     a");
		
	}
	
	private static void TextWithSpaces(String text) {
			String[] array = text.split("\\s+");
			System.out.println(array.length);
			for(String s : array) {
				System.out.println(s);
			}
		}

}
