package codewars;

public class StringManipul {
	/*Complete the method/function so that it converts dash/underscore delimited words into camel casing. The first word within the output should be capitalized only if the original word was capitalized (known as Upper Camel Case, also often referred to as Pascal case).
	Examples

	"the-stealth-warrior" gets converted to "theStealthWarrior"
	"The_Stealth_Warrior" gets converted to "TheStealthWarrior"*/
	
	public String toCamelCase(String s){
		String regexSymbols = "[^a-zA-Z0-9]+";
		String wordRay[]= s.split(regexSymbols);
		String finalString="";
		for(int i=0;i<wordRay.length;i++) {
			//System.out.println(wordRay[i]);
			if(i==0) {
			finalString=finalString.concat(wordRay[i]);
			}else {
			String firstCharUp=wordRay[i].replace(wordRay[i].charAt(0), Character.toUpperCase(wordRay[i].charAt(0)));
			finalString=finalString.concat(firstCharUp);	
			}
		}
		
		
		
	    return finalString;
	  }
	
	public String splitCamelCase(String input) {
		String finalString="";
		String[] inputArray=input.split("");
		
		for(int i=0;i<inputArray.length;i++) {
			
			if(Character.isUpperCase(inputArray[i].charAt(0))) {
				finalString= input.substring(0, i)+" "+input.substring(i, input.length());
			}
		}
		
		return finalString;
	}
		
}
