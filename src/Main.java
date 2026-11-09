import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Scanner;

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
                return "Vehicle added successfully. \n";
            } else {
                return "A vehicle already exists. \n";
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
                return "Vehicle removed. \n";
            } else {
                return "No vehicle to remove! \n.";
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
            return "Vehicle updated successfully! \n";
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
	//Create an additional class to call your automobile class (e.g., Main or AutomobileInventory). Include a try..catch construct and print it to the console.
	public static void main(String[] args) {	
		String userChoice = "";
		
		try (Scanner scanner = new Scanner(System.in)) {
			Automobile myCar = new Automobile("Toyota", "4Runner", "Green", 2002, 50000);
			//Then call the method to list the values. Loop through the array and print to the screen.
			for (String carAttribute : myCar.getAutomobile()) {
				System.out.println(carAttribute);
			};

			
			//Call the remove vehicle method to clear the variables. Print the return value.
			System.out.println(myCar.removeAutomobile());
			
			//Add a new vehicle. Print the return value.
			System.out.println(myCar.addAutomobile("Honda", "Accord", "Blue", 2006, 120000));
			//Call the list method and print the new vehicle information to the screen.
			for (String carAttribute : myCar.getAutomobile()) {
				System.out.println(carAttribute);
			};
			//Update the vehicle. Print the return value.
			System.out.println(myCar.updateAutomobile("Honda", "Accord", "Blue", 2006, 122500));
			//Call the listing method and print the information to the screen.
			for (String carAttribute : myCar.getAutomobile()) {
				System.out.println(carAttribute);
			};
			
			//Display a message asking if the user wants to print the information to a file (Y or N).
			while (!userChoice.equalsIgnoreCase("N")) {
				System.out.print("Do you want to print the information to a file? (Y or N): ");
				userChoice = scanner.next();
				 if (userChoice.equalsIgnoreCase("Y")) {
			            System.out.println("Saving...");
			            copyCar(myCar.getAutomobile());
			        } 
				 else if (userChoice.equalsIgnoreCase("N")) {
			            System.out.println("Exiting...");
			            break;
			        } 
			     else {
			            System.out.println("Invalid input. Please enter Y or N.");
			            continue;
			        }
			}

		}
        catch (Exception e) {
        	System.out.println("ERROR: " + e.getMessage());
        }
	}
}


////System.out.println();