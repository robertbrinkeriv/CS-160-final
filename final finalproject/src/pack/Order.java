package pack;

public class Order {
	
	String orderDate;
	String salesAssociate;
    int customerNumber;
    double totalCost;
  
    
	
	int packagesOrdered;
	static short number;
	String address;
	
	
	// static long values 
    public static String Status; 
   
  
    public static String getStatus() 
    { 
        return Status; 
    } 
  
    public static void setStatus(String Status) 
    { 
        Order.Status = Status; 
    } 
}