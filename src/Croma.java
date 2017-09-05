import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
/**
 * 
 * @author Vishwas
 * creating class named as croma..
 *
 */
public class Croma {
		//main method
	public static void main(String[] args) throws IOException {		
		/**
		 * Creating BufferedReader class to reads text from a character-input stream,
		 * buffering characters so as to provide for the.. 
		 * efficient reading of characters, arrays, and line.
		 */
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		//now in here creating a RetailStore class object..
		RetailStore reStore = new RetailStore("Croma");
		//window console for croma tag line..
		System.out.print("\t\t\tCroma A TATA Enterprise\n\t\t\t    We Help You Buy\n\t\t\tIn-Store | Online | Mobile\n");
		System.out.print("\t------------------------------------------------------------\n");
		System.out.print("\t\t24 Hours Croma Customer Care No. 7207 666 000\n");
		
		
		int id = 0;
		String name = ""; 
		String status = "";

		String number;
		int ProductsNo = 1;

		int option;
		do {
			System.out.print("=========================================================================\n");
			System.out.println("\n\t\tEnter the option");
			//window console for option menu..
			System.out.println("\tEnter 1 to Add customer\n\tEnter 2 to Add product\n\t"
					+"Enter 3 to Check product availability\n\tEnter 4 to Display The Detail\n\tEnter 5 to Book product\n\tEnter 6 to Calculate net amount\n\tEnter 7 to Exit\n");
			option = Integer.parseInt(bufferedReader.readLine());
			switch (option) {
			case 1://this case is used for Customer Addition
				System.out.println("\t\tCustomer Addition\n\t------------------------------------");
				System.out.println("please enter customer name :");
				name = bufferedReader.readLine();
				System.out.println("Please enter contact number");
				number = bufferedReader.readLine();
				reStore.addCustomer(name, number);
				break;

			case 2://this case is used for Product Addition..
				System.out.println("\t\tProduct Addition\n\t---------------------------------------");
				System.out.println("Please enter product name:");
				name = bufferedReader.readLine();
				System.out.println("Please enter the price of product  :");
				double price = Double.parseDouble(bufferedReader.readLine());
				System.out.println("Please enter the status ( Available ) ");
				status = bufferedReader.readLine();
				reStore.addProduct(name, status, price);

				break;

			case 3://this case is used for Check Availability..
				System.out.println("\t\tCheck Availability\n\t-------------------------------------");
				System.out.println("Please enter the product name:");
				name = bufferedReader.readLine();
				int number1 = reStore.checkProductAvailability(name);
				System.out.println("Available product = " + number1);
				break;
			case 4://this case is used for Display Detail..
				System.out.println("\t\tDisplay Detail\n\t----------------------------------------");
				// here calling display method
				reStore.display();
				break;
			case 5://this case is used for Book Product..
				System.out.println("\t\tBook Product\n\t------------------------------------------");
				System.out.println("Please enter the customer id:");
				id = Integer.parseInt(bufferedReader.readLine());
				System.out.println("Please enter the product name");
				name = bufferedReader.readLine();
				System.out.println("Please enter the number of products:");
				ProductsNo = Integer.parseInt(bufferedReader.readLine());
				System.out.println("Product booked status = " + reStore.bookProduct(id, name, ProductsNo));
				break;
			case 6://this case is used for Calculate cost..
				System.out.println("\t\tCalculate cost\n\t-----------------------------------------");
				System.out.println("Please enter the customer id:");
				id = Integer.parseInt(bufferedReader.readLine());
				System.out.println("Please enter the discount:");
				double discount = Double.parseDouble(bufferedReader.readLine());
				double cost = reStore.calculateNetAmount(id, discount);
				System.out.println("Total cost=" + cost*ProductsNo);
				break;
				
			case 7://this case is used for Exited.
				System.out.println("Exited!");
				break;
				
			default://print if customer enter invalid option
				System.out.println("You Have Enter Invalid option!!");

			}

		} while (option != 7);
	}
}
