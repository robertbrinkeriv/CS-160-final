package pack;

import java.util.Scanner;
import java.lang.reflect.*;
import java.util.Arrays;

public class OrderEntry {
	 static Scanner scanner = new Scanner(System.in);
	private static String number;
	
	/**
	 * Request information for a given object
	 * @param o
	 * @return
	 */
	public static boolean newObject(Object o) {
		boolean created = false;
		Field[] fields = o.getClass().getDeclaredFields();
		System.out.println("Creating new Order:");
		for(Field field : fields) {
			System.out.println("Enter value for " + field.getName() + ": ");
			String entry = scanner.nextLine();
			try {				
				if(field.getType().toString().toLowerCase().contains("string"))
					field.set(o, entry.trim());
				
				else if(field.getType().toString().toLowerCase().contains("int"))
					field.set(o, Integer.parseInt(entry.trim()));
				
				else if(field.getType().toString().toLowerCase().contains("boolean"))
					field.set(o, Boolean.parseBoolean(entry.trim()));
				
				else if(field.getType().toString().toLowerCase().contains("char"))
					field.set(o, entry.charAt(0));
				
				else if(field.getType().toString().contains("double"))
					field.set(o, Double.parseDouble(entry.trim()));
				
				else if(field.getType().toString().toLowerCase().contains("float"))
					field.set(o, Float.parseFloat(entry.trim()));
				
				else if(field.getType().toString().toLowerCase().contains("long"))
					field.set(o, Long.parseLong(entry.trim()));
				
				else if(field.getType().toString().toLowerCase().contains("short"))
					field.set(o, Short.parseShort(entry.trim()));
				
				else if(field.getType().toString().toLowerCase().contains("byte"))
					field.set(o, Byte.parseByte(entry.trim()));
				
				else
					throw new Exception("Unable to set " + field.getName());
				
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
		return created;
	}
	
	/**
	 * Print object information
	 * @param o
	 * @return
	 */
	public static boolean printObject(Object o) {
		boolean created = false;
		Field[] fields = o.getClass().getDeclaredFields();
		for(Field field : fields) {
			try {				
				System.out.print(field.getName() + ": ");
				System.out.println(field.get(o));
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
		return created;
	}
	

	public static boolean changeObject(Object o) {
		  boolean created = false;
			         
			   try { 
			  
			        // Create the User class object 
			         
			  
			        // Get the marks field object 
			        Field field 
			            = Order.class.getField("Status"); 
			 
			        // Apply getLong Method on User Object 
			        // to get the value of HighScore field 
			        String value = field.get(o).toString(); 
			        
			        // print result 
			        System.out.println("Current Status is: "
			                            + value); 
			    
			 
		
			
		}
		catch(Exception e) {
		System.err.println(e.getMessage());
		}
		return created; 
} 
  
// sample class 

  
    // static values 
     

		//eld[] fields = o.getClass().getDeclaredFields();
		 {
		//ry {				
				 //for(int i = 4; i < fields.length; i++) {
			           //ystem.out.println("Field = " + fields.length[4]); }
			
					//System.out.println("Enter value for " + o.status + ": ");
				
					//System.out.println("Enter value for " + field.get() + ": ");
					
				    //o.status = scanner.nextLine();
			
			//tch(Exception e) {
			//ystem.err.println(e.getMessage());
			}

	
		//created;
///
	
	/**
	 * Expand array as new objects are added
	 * @param objects
	 * @param o
	 * @return
	 */
	public static Object[] addObjectToArray(Object[] objects, Object o) {
		if(Arrays.asList(objects).contains(null)) {
			for(int i = 0; i < objects.length; i++) {
				if(objects[i] == null) {
					objects[i] = o;
					return objects;
				}
			}
		}
		else {
			Object[] temp = new Object[objects.length + 2];
			temp = objects.clone();
			temp[temp.length - 2] = o;
			return temp;
		}
		
		return null;
	}
	
	/**
	 * A method to select whether to create a new order or find an existing order.
	 * @return option 1 to create new order, 2 to search existing order
	 * or -1 if the option wasn't understood.
	 */
	public static int selectOption() {
		System.out.println("Available Options:\n1 = Enter New Order\n2 = Print Existing Orders\n3 = Change Existing Order\n-1 = End Program");
		System.out.println("Please select an option(1, 2, 3, -1):");
		while(scanner.hasNextLine()) {
			try {
				int entry = Integer.parseInt(scanner.nextLine());
				switch(entry) {
					case 1: 
						return 1;
					case 2:
						return 2;
					case 3:
						return 3;
					case -1:
						return -1;
					default:
						throw new Exception("The value was not between -1 or 3.");
				}
			}
			catch(NumberFormatException e) {
				System.err.println("You must enter a valid number. Try again:");
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return -1;
	}
}
