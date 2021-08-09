
import java.util.ArrayList;

/**
 *
 *  @author  Jean Emmanuel Yannick Messey-Elouma
 *  @Course   Msc Computer science
 *  @StudentID  1985618
 *  
 */



public class Salaries {

	
private ArrayList<double[]> allSalaries;

public Salaries() { allSalaries = new ArrayList<double[]>();
	
}


public void add(double[] employeeSalaries) {
	allSalaries.add(employeeSalaries);
}


/**
 *  The method computes the average salary for an employee. 
 *  array of type double [].
 *  @param a An arbitrary non-empty array of type double[].
 *  @return The average value  of all the values in employeeSalaries.
 */
public static double average(double[] employeeSalaries){
	double total_Salary = 0;
	int total_Months = 0;
	
	
	for (int i=0; i<employeeSalaries.length; i++) {
		if (employeeSalaries[i] > 0) {
			total_Salary += employeeSalaries[i];
			total_Months++;
		
		}
	}
		if (total_Salary == 0) { throw new IllegalArgumentException("The employee was not renumerated");}
		
		

	return total_Salary/total_Months;
	
}


/**
*  The method to generate all the ArrayList storing the average salary of all employees with at least a non-zero monthly salary 
*  @return The average value  of all the values in employeeSalaries
*/	

public ArrayList<Double> averageSalaries(){
	ArrayList<Double> averageSalaries = new ArrayList<Double>();
	
		for(int i=0; i<allSalaries.size(); i++) {
			    
			try {
				double avgEmployeeSalary = average(allSalaries.get(i));
			    averageSalaries.add(avgEmployeeSalary);	    
		
	} catch (IllegalArgumentException e) { System.out.println("");
	
	}
		}
	return averageSalaries;
	}


public boolean not3TimesHigher() {
    ArrayList<Double> avg_Sa = averageSalaries();
    
    if (allSalaries.size() ==1) {
	 return true;}
			 
			 
 
    for (int i=0; i<avg_Sa.size(); i++) {

        double employee = avg_Sa.get(i);
        avg_Sa.remove(i);

        double[] allOtherEmployees = new double[avg_Sa.size()];

        for (int j=0; j<allOtherEmployees.length; j++) {
            allOtherEmployees[j] = avg_Sa.get(j);
        }  
        if (employee > (average(allOtherEmployees) * 3)) {
            return false;
        }
    } return true;
}


	
	public static void main(String[] args) {
		

	    double[] Kwame = { 1700, 1700, 2000, 2000, 0, 0, 0, 0, 0, 0, 0, 0 };
	    double[] Sekou = { 0, 1400, 1400, 2200, 0, 2310, 1550, 1700, 0, 0, 0, 0 };
	    double[] Cheick = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1600, 1600 };
	    double[] Coovi =  { 1800, 1800, 2000, 2000, 1520, 2310, 1550, 1600, 1700, 2300, 1300, 1550 };
	    
	    Salaries bham = new Salaries();
	    
	    bham.add(Kwame);
	    
	    bham.add(Sekou);
	    
	    bham.add(Cheick);
	    
	    bham.add(Coovi);
	    
	    System.out.println(Salaries.average(Kwame));

	    System.out.println(bham.averageSalaries());

	    System.out.println(bham.not3TimesHigher());
		
		
	}

}
