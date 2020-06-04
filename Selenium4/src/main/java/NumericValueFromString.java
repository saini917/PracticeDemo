
public class NumericValueFromString {

	static String s="deepak1987saini20july";
	static StringBuffer sb=new StringBuffer();
	
	public static void main(String[] args) {
		
		for(int strlength=0;strlength<s.length();strlength++){
			if(Character.isAlphabetic(s.charAt(strlength))){
				sb.append(s.charAt(strlength));
			}
		}
		System.out.println(sb);
		
		
		for(int strlength=0;strlength<s.length();strlength++){
			if(Character.isDigit(s.charAt(strlength))){
				sb.append(s.charAt(strlength));
			}
		}
		System.out.println(sb);
	}
}
