import java.lang.StringBuffer;
import java.util.Scanner;

/*
 *  The program should do the following:
 * 		Take in user input for the desired measurement system, weight, and height.
 * 		Using the provided BMI formulas and official weight categories, 
 *  	calculate the BMI and BMI category of the user input.
 *  	Print out the BMI and BMI category.
 */

public class BMICalculator 
{
	// Create Instance Variables
	private Scanner scanner = new Scanner(System.in);
	private double weight;
	private double height;
	private double bmi;
	private StringBuffer unitType = new StringBuffer();
	private StringBuffer bmiCategory = new StringBuffer();
	
	// Create Constructor
	
	public BMICalculator()
	{
		this.weight = 0.0;
		this.height = 1.0;
	}
	
	// Getter and Setter Functions
	public double getWeight()
	{
		return this.weight;
	}
	
	public void setWeight(double weight)
	{
		if (weight < 0.0)
		{
			System.out.println("Invalid weight!");
			System.exit(-1);
		}
		this.weight = weight;
	}
	
	public double getHeight()
	{
		return this.height;
	}
	
	public void setHeight(double height)
	{
		if (height <= 0.0)
		{
			System.out.println("Invalid height!");
			System.exit(-1);
		}

		this.height = height;
	}
	
	public double getBmi()
	{
		return this.bmi;
	}
	
	public String getBmiCategory()
	{
		return this.bmiCategory.toString();
	}
	
	// Receive input data from the user
	public void readUserData()
	{
		readUnitType();
		readMeasurementData();
	}
	
	private void readUnitType()
	{	
		
		// Prompt the user until a valid input is received
		while(true)
		{
			System.out.print("Enter what system (metric/imperial) your measurements are in: ");
			String userInput = this.scanner.nextLine();
			
			if ((userInput.equalsIgnoreCase("imperial")) || (userInput.equalsIgnoreCase("metric")))
			{
				this.unitType.append(userInput);
				break;
			}
			
			System.out.println("Invalid measurement type!");
		}
		
	}
	
	private void readMeasurementData()
	{
		String unitType = this.unitType.toString();
		
		// Check for the type of units
		if (unitType.equalsIgnoreCase("imperial"))
		{
			readImperialData();
		}
		else if (unitType.equalsIgnoreCase("metric"))
		{
			readMetricData();
		}
	}
	
	// Take in weight and height in kilograms and meters
	private void readMetricData()
	{
		System.out.println("You have picked the metric system.");
		
		System.out.print("Enter your weight in kilograms: ");
		double weight = this.scanner.nextDouble();
		setWeight(weight);
		
		System.out.print("Enter your height in meters: ");
		double height = this.scanner.nextDouble();
		setHeight(height);
	}
	
	// Take in weight and height in pounds and inches
	private void readImperialData()
	{
		System.out.println("You have picked the imperial system.");
		
		System.out.print("Enter your weight in pounds: ");
		double weight = this.scanner.nextDouble();
		setWeight(weight);
		
		System.out.print("Enter your height in inches: ");
		double height = this.scanner.nextDouble();
		setHeight(height);
	}
	
	public void calculateBmi()
	{
		// Calculate the BMI
		String measurementSystem = this.unitType.toString();
		
		if(measurementSystem.equalsIgnoreCase("metric"))
		{
			this.bmi = weight / (height * height);
		}
		if(measurementSystem.equalsIgnoreCase("imperial"))
		{
			this.bmi = (703.0 * weight) / (height * height);
		}
		
		// Calculate the BMI category
		calculateBmiCategory(this.bmi);
	}
	
	private void calculateBmiCategory(double bmi)
	{
		// Check for which category the BMI is under
		if (bmi < 18.5)
		{
			this.bmiCategory.append("Underweight");
		}
		else if ((bmi >= 18.5) && (bmi < 25.0))
		{
			this.bmiCategory.append("Normal weight");
		}
		else if ((bmi >= 25.0) && (bmi < 30.0))
		{
			this.bmiCategory.append("Overweight");
		}
		else if (bmi >= 30.0)
		{
			this.bmiCategory.append("Obesity");
		}
	}
	
	// Print out the BMI and BMI category
	public void displayBmi()
	{
		System.out.printf("BMI: %f\n", getBmi());
		System.out.printf("BMI Category: %s\n", getBmiCategory());
	}
	
	// Testing main() function
	//
	// public static void main(String[] args) 
	// {
	//	 BMICalculator app = new BMICalculator();
	//	 app.readUserData();
	//	 app.calculateBmi();
	//	 app.displayBmi();
	// }

}
