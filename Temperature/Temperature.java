/** 
 *
 *  In this file we have a class Temperature that finds the first day of the year with the lowest temperature using a 1-dimensional arrays  
 * 
 *  @author  Jean Emmanuel Yannick Messey-Elouma
 *  @Course   Msc Computer science
 *  @StudentID  1985618
 *  
 *  
 */

public class Temperature {
	
	/**
    *  The method computes the coldest day  of a non-empty one-dimensional
    *  array of type double [].
    *  @param a An arbitrary non-empty array of type double[].
    *  @return The value of all the values in temperatures.
    */
	public static int coldest(double[] temperatures){
		int coldest_Day = 1;
		
		for (int i=0; i<temperatures.length; i++){
			if (temperatures[i]<temperatures[coldest_Day]){
				
				coldest_Day = i;
				}
		}
				return  coldest_Day +1;
		
	}
	
	/** Main method that computing the lowest temperature and the coldest day of year. 
     */
	// 

	public static void main(String[] args) {
		
		double[] temperatures = new double[365];
		
		temperatures [45]= - 6;
		
		System.out.println("The lowest temperature is " +temperatures [45] + " degrees");

        System.out.println("The coldest day is  " + Temperature.coldest(temperatures));
				
		
		

	}

}
