

class Automobile {
	
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;
    
    //Default Constructor
    public Automobile() {
    	make = "";
    	model = "";
    	color = "";
    	year = -1;
    	mileage = -1;			
    }
    
    //Parameterized Constructor
    public Automobile(String make, String model, String color, int year, int mileage) {
    	this.make = make;
    	this.model = model;
    	this.color = color;
    	this.year = year;
    	this.mileage = mileage;
    }
    
    //Add Vehicle
    public String addAutomobile(String make, String model, String color, int year, int mileage) {
        try {
            if (this.make == null || this.make.isEmpty()) {
                this.make = make;
                this.model = model;
                this.color = color;
                this.year = year;
                this.mileage = mileage;
                return "Vehicle added successfully.";
            } else {
                return "A vehicle already exists.";
            }
        } 
        catch (Exception e) {
            return "ERROR Failed to add vehicle: " + e.getMessage();
        }
    }
    
    //List Info
    public String[] getAutomobile() {
        try {
            String[] info = new String[5];
            info[0] = "Make: " + make;
            info[1] = "Model: " + model;
            info[2] = "Color: " + color;
            info[3] = "Year: " + year;
            info[4] = "Miles: " + mileage;
            return info;
        } 
        catch (Exception e) {
            String[] error = new String[1];
            error[0] = "ERROR Failed to show vehicle: " + e.getMessage();
            return error;
        }
    }
    
    //Remove Automobile
    public String removeAutomobile() {
        try {
            if (make != null && !make.isEmpty()) {
                make = "";
                model = "";
                color = "";
                year = -1;
                mileage = -1;
                return "Vehicle removed.";
            } else {
                return "No vehicle to remove!.";
            }
        } 
        catch (Exception e) {
            return "ERROR Failed to remove vehicle: " + e.getMessage();
        }
    }
    
    //Update Automobile
    public String updateAutomobile(String make, String model, String color, int year, int mileage) {
        try {
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
            return "Vehicle updated successfully!";
        } 
        catch (Exception e) {
            return "ERROR Failed to update vehicle: " + e.getMessage();
        }
    }
}



public class Main {
	public static void main(String[] args) {	


	

	}
	
}