import java.util.Scanner;

public class Calculator {
	private static Scanner scanner = new Scanner(System.in);
	
	//method to read user input from command line
	private static double[] userInput(String action) {
		System.out.println("Please enter the numbers you would like to " + action + ":");
		System.out.println("Number One: ");
		double numberOne = scanner.nextDouble();
		System.out.println("Number Two: ");
		double numberTwo = scanner.nextDouble();
		return new double[] {numberOne, numberTwo};
	}
	
	//method to add two numbers
	private static double add(double numberOne, double numberTwo) {
		return numberOne + numberTwo;
	}
	
	//method to substract two numbers
	private static double subtract(double numberOne, double numberTwo) {
		return numberOne - numberTwo;
	}
	
	//method to multiply two numbers
	private static double multiply(double numberOne, double numberTwo) {
		return numberOne * numberTwo;
	}
	
	//method to divide two numbers
	private static double divide(double numberOne, double numberTwo) {
		// handling divided by zero error
		if (numberTwo == 0) {
			throw new ArithmeticException("Cannot divide by zero!");
		}
		return numberOne / numberTwo;
	}
	
	//implementing add functionality to read user input, perform calculation and display the output
	private static void addFunctionality() {
		double[] numbers = userInput("add");
		double result = add(numbers[0], numbers[1]);
		System.out.println("Your total by adding " + numbers[0] + " and " + numbers[1] + " is: " + result);
	}
	
	//implementing subtract functionality to read user input, perform calculation and display the output
	private static void subtractFunctionality() {
		double[] numbers = userInput("subtract");
		double result = subtract(numbers[0], numbers[1]);
		System.out.println("Your total by subtracting " + numbers[0] + " and " + numbers[1] + " is: " + result);
	}
	
	//implementing multiply functionality to read user input, perform calculation and display the output
	private static void multiplyFunctionality() {
		double[] numbers = userInput("multiply");
		double result = multiply(numbers[0], numbers[1]);
		System.out.println("Your total by multiplying " + numbers[0] + " and " + numbers[1] + " is: " + result);
	}
	
	//implementing divide functionality to read user input, perform calculation and display the output
	private static void divideFunctionality() {
		double[] numbers = userInput("divide");
		double result = divide(numbers[0], numbers[1]);
		System.out.println("Your total by dividing " + numbers[0] + " and " + numbers[1] + " is: " + result);
	}
	
	//main function
	public static void main(String[] args) {
		System.out.println("Welcome to Calculator App!");
		
		int userAction;
		do {
			//display intructions
			System.out.println("What would you like to do?");
			System.out.println("1. Add");
			System.out.println("2. Subtract");
			System.out.println("3. Multiply");
			System.out.println("4. Divide");
			System.out.println("5. Exit");
			
			// prompt for user input and read the input
			System.out.println("Please select an option! (eg: 2): ");
			userAction = scanner.nextInt();
			
			//based on user input call that specific functionality
			switch (userAction) {
				case 1:
					addFunctionality();
					break;
				case 2:
					subtractFunctionality();
					break;
				case 3:
					multiplyFunctionality();
					break;
				case 4:
					divideFunctionality();
					break;
				case 5:
					break;
				default:
					System.out.println("Please provide an option from the given actions.");
					break;
			}
			 
			if (userAction >= 1 && userAction <=4) {
				System.out.println("Press Enter key to continue...");
				scanner.nextLine();
				scanner.nextLine();
			}
			//end loop when user input is 5
		} while (userAction != 5);
		
		System.out.println("Bye!");
	}
}

