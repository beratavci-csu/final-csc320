import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;


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
	
	private static void copyCar(String[] carInfo) {
		Path path = Path.of("Autos.txt");
		
		try {
			Files.write(path, Arrays.asList(carInfo));
			System.out.println("File Saved!");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {	

		try {
			Automobile myCar = new Automobile("Toyota", "4Runner", "Green", 2002, 50000);
			
			for (String carAttribute : myCar.getAutomobile()) {
				System.out.println(carAttribute);
			};
			
			System.out.println(myCar.removeAutomobile());
		}
        catch (Exception e) {
        	System.out.println("ERROR Failed to update vehicle: " + e.getMessage());
        }
	

	}
	
}


////System.out.println();