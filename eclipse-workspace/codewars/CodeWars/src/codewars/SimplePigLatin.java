package codewars;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimplePigLatin {
	/*Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
	Examples

	pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
	pigIt('Hello world !');     // elloHay orldway !  */
	
	public String modString(String sentence) {
	
	
	
	String [] sentArray=sentence.split(" ");
	
	String modifiedString="";
	
	String noFirstLter="";
	
	String firstLter="";
	
	String finalString="";
	
	String regex = "[^a-zA-Z0-9]+";
	
	Pattern p = Pattern.compile(regex);
	
	Matcher m = null;
	
	for(int i=0;i<sentArray.length;i++) {
		noFirstLter=sentArray[i].substring(1);
		firstLter=String.valueOf(sentArray[i].charAt(0));
		m = p.matcher(sentArray[i]);
		if(m.matches()) {
			modifiedString=noFirstLter.concat(firstLter);
			if(i!=sentArray.length-1) {
			finalString=finalString.concat(modifiedString)+" ";
			}
			else {
				finalString=finalString.concat(modifiedString);
			}
		}else {
			modifiedString=noFirstLter.concat(firstLter).concat("ay");
			
			if(i!=sentArray.length-1) {
			finalString=finalString.concat(modifiedString)+" ";
			}else {
				finalString=finalString.concat(modifiedString);
			}
		}
		
	}
	
	return finalString;
	}
}
