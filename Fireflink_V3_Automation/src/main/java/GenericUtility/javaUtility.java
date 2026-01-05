package GenericUtility;

import java.util.Random;

public class javaUtility {
	
	public StringBuilder getRandomName() {
		int  n = 9;
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqurstuvwxyz";
		StringBuilder sb = new StringBuilder(n);
		for(int i=0;i<n;i++) {
			int index = (int)(AlphaNumericString.length()* Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb;
	}
	
	public int togetRandomNumber() {
		Random random = new Random();
		int randomNum = random.nextInt(1000);
		return randomNum;
	}

}
