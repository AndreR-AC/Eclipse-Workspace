package codewars;

public class Numbers {

	
		/*If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.

    Note: If the number is a multiple of both 3 and 5, only count it once. Also, if a number is negative, return 0(for languages that do have them)
*/
		
	public int countMultiples(int range) {
		int sum=0;
		int counter=range-1;
		
		if(counter<0) {
			return 0;
		}
		while(counter>0) {
			if(counter%5==0 && counter%3==0) {
				sum=counter+sum;
				counter--;
			}
			if(counter%5==0) {
				sum=counter+sum;
				counter--;
			}
			if(counter%3==0) {
				sum=counter+sum;
				counter--;
			}
			if(counter%5!=0 && counter%3!=0) {
				counter--;
			}
			
			
			
		}
		
		
		return sum;
	}
	
	

	

}
