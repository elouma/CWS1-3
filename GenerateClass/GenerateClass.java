/**
 *
 *  @author  Jean Emmanuel Yannick Messey-Elouma
 *  @Course   Msc Computer science
 *  @StudentID  
 *  
 */


/**  
 *  In this file we have a class GenerateClass to generate from the field variables a
 *  constructor, the setters, and the getters automatically 
 *  
 */


import java.io.FileWriter;
import java.io.IOException;



public class GenerateClass{
	
	private String classname;
	private String[] variableTypes;
	private String[] variableNames;
	

	public GenerateClass(String classname, String[] variableNames, String[] variableTypes){
		
		this.classname = classname;
		
		this.variableTypes = variableTypes;
		
		this.variableNames = variableNames;
		
	}
	
	/*
	 *  The method returns a String with a declaration of the corresponding field variables 
	 *  
	 */
	
	
	public String makeFields(){
		String u = "";
		for (int i=0; i<variableNames.length; i++){
			u += "  private " + variableTypes[i] + " " + variableNames[i] + ";\n";
		}
		return u+"\n";
	}


	/*
	 *  The method makeGetter returns a String with all getters. 
	 *  @return string value.
	 */
	
	
	public String makeConstructor(){
		String u = "  public " + classname + "(";
		
		if (variableNames.length==0) {
			return u + "){}\n";
		}
		
		for (int i=0; i<variableNames.length; i++){
			u += variableTypes[i] + " " + variableNames[i] + ", ";
		}

		u = u.substring(0,u.length()-2);
		
		u += "){";

		for (int i=0; i<variableNames.length; i++){
			u += "\n    this." + variableNames[i] + " = " 
			+ variableNames[i] + ";";
		}
		u += "\n  ";
		u += "}\n";
		return u;
	}

	/*
	 *  The method makeGetter returns a String with all getters. 
	 *  @return string value.
	 */
	
	public String makeGetters(){
		String u = "";
		
		for (int i=0; i<variableNames.length; i++){
			u += "  public " + variableTypes[i] + " get" 
			+ variableNames[i].substring(0,1).toUpperCase()
			+ variableNames[i].substring(1,variableNames[i].length()) + "(){\n"
			+ "    return " + variableNames[i] + ";\n  }\n";
		}

		return u;
	}

	/*
	 *  The method makeSetter returns a String with all setters in the order. 
	 *  @return string value.
	 */
	
	public String makeSetters(){
		String u = "";
		
		for (int i=0; i<variableNames.length; i++){
			u += "  public void set" + variableNames[i].substring(0,1).toUpperCase()
			+ variableNames[i].substring(1,variableNames[i].length()) + "("
			+ variableTypes[i] + " " + variableNames[i] + "){\n"
			+ "    this." + variableNames[i] + " = " 
			+ variableNames[i] + ";\n  }\n";
		}

		return u;
	}

	public void writeFile(){
		
		/** write a file e.g. Person.java
		 * 
		 */
		String u = "public class " + classname + "{\n"
					+ makeFields() + makeConstructor()
					+ makeGetters() + makeSetters() + "}";

		try {
	      FileWriter myWriter = new FileWriter(classname+".java");
	      
	      myWriter.write(u);
	      myWriter.close();
	      
	    } catch (IOException e) {System.out.println("Error occurred.");
	      
	      e.printStackTrace();
	    }
	}

	
	
	
	public static void main(String[] args){
		String classname = "Person";
		
		String[] variableNames = {"name", "dob"};
		
		String[] variableTypes = {"String", "Date"};
		
		GenerateClass f = new GenerateClass(classname, variableNames, variableTypes);
		f.writeFile();
		
		System.out.println(f.makeFields());
		
		System.out.println(f.makeConstructor());
		
		System.out.println(f.makeGetters());
		
		System.out.println(f.makeSetters());
		
	}
}
	


