package bcit.ca.comp1451.assignment2;

/**
 * imports scanner
 */
import java.util.Scanner;

/**
 * 
 * @author Simran This class contains main method
 */
public class Driver {
	private static Scanner input;

	/**
	 * 
	 * @param args
	 * @throws InvalidInvoiceNumberException
	 */
	public static void main(String[] args) throws InvalidInvoiceNumberException {
		/**
		 * creates the object of Scanner which can take any type of input from user
		 */
		input = new Scanner(System.in);
		/**
		 * Create an InsuranceCompany object
		 */
		InsuranceCompany insuranceCompany = new InsuranceCompany("Insurance");
		/**
		 * two objects of Labour class
		 */
		Labour labour1 = new Labour("firstProject of Labour", 10, 14.30, 1000, "regular", "experienced");
		Labour labour2 = new Labour("2ndProject of Labour", 20, 16.00, 2000, "over time", "inexperienced");
		/**
		 * two objects of LabourAndMaterial class
		 */
		LabourAndMaterial LandM1 = new LabourAndMaterial("1st project of labour and material", 10, 14.30, 1000,
				"regular", "inexperienced", 247.80, 2, 1000);
		LabourAndMaterial LandM2 = new LabourAndMaterial("2nd project of labour and material", 60, 30.80, 2000,
				"over time", "experienced", 3456.90, 8, 7000);
		/**
		 * two objects of LabourAndMaterialAndEquipment class
		 */
		LabourAndMaterialAndEquipment LandMandE1 = new LabourAndMaterialAndEquipment(
				"1st project of labour and material and equipment", 50, 14.30, 1000, "over time", "inexperienced",
				247.80, 2, 1000, 5000, 72);
		LabourAndMaterialAndEquipment LandMandE2 = new LabourAndMaterialAndEquipment(
				"2nd project of labour and material and equipment", 20, 40.80, 6000, "over time", "experienced", 800,
				10, 1000, 10000, 90);
		/**
		 * Add two objects of Labour class , two objects of LabourAndMaterial class and
		 * two objects of LabourAndMaterialAndEquipment class to the arrayList in
		 * InsuranceCompany object
		 */
		insuranceCompany.addInvoice(labour1);
		insuranceCompany.addInvoice(labour2);
		insuranceCompany.addInvoice(LandM1);
		insuranceCompany.addInvoice(LandM2);
		insuranceCompany.addInvoice(LandMandE1);
		insuranceCompany.addInvoice(LandMandE2);
		/**
		 * display all the invoice numbers and total cost of all projects sorted by the
		 * total cost display the total insurance fees of all projects
		 */
		insuranceCompany.displaySortByCost();
		/**
		 * Create a while loop to do the following: Ask the user to enter an invoice
		 * number (using the Scanner class) Call method displayInvoice() to display the
		 * project invoice of the given invoice number. If the invoice number was
		 * invalid an exception will be thrown from method getInvoice(), the exception
		 * will be handled properly and it will not break the while loop. If the invoice
		 * number was valid the invoice of that project will be displayed
		 * 
		 * The while loop will ask the user if he/she want to enter another invoice
		 * number and will stop if the users respond was no
		 * 
		 * 
		 */
		String quit = "";
		do {
			System.out.println("Enter invoice number: ");
			while (input.hasNext()) {
				String accountNumber = input.next().toUpperCase();
				insuranceCompany.displayProjectInvoice(accountNumber);
				System.out.println("");
				System.out.println("Would you like to enter another invoice number? (Y/N)");
				quit = input.next();
				quit.toLowerCase();
			}

		} while (quit.equals("n"));
		System.out.println("You are at end of loop.");
		System.exit(0);
	}

}
