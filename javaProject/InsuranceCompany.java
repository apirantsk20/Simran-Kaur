package bcit.ca.comp1451.assignment2;

/**
 * imports arraylist
 */
import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 * @author Simran
 *
 */
public class InsuranceCompany {
	private static double LABOUR_INSURANCE = .05;
	private static double LM_INSURANCE = .07;
	private static double LME_INSURANCE = .1;

	private String companyName;
	ArrayList<ProjectInvoice> invoice;

	/**
	 * 
	 * @param companyName sets the comapny name
	 */
	public InsuranceCompany(String companyName) {
		setCompanyName(companyName);
		invoice = new ArrayList<>();
	}

	/**
	 * 
	 * @return companyName gives the name of the company
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 
	 * @param companyName sets the company name
	 */
	public void setCompanyName(String companyName) {
		if (companyName != null && !companyName.isEmpty()) {
			this.companyName = companyName;
		} else {
			throw new IllegalArgumentException("Comapny Name cannot be null");
		}
	}

	/**
	 * 
	 * @param projectInvoice Method to add a project invoice object to the
	 *                       collection
	 */
	public void addInvoice(ProjectInvoice projectInvoice) {
		if (projectInvoice != null) {
			invoice.add(projectInvoice);
		}
	}

	/**
	 * 
	 * @param invoiceNum takes the invoice number from the user. search the
	 *                   collection and print that invoice details. If the invoice
	 *                   was not found a message stating that the invoice was not
	 *                   found will be displayed on the screen. If the passed
	 *                   parameter was null or less than 7 characters in length an
	 *                   InvalidInvoiceNumberException will be thrown
	 * @throws InvalidInvoiceNumberException
	 */
	public void displayProjectInvoice(String invoiceNum) throws InvalidInvoiceNumberException {
		if (invoiceNum != null && invoiceNum.length() >= 7) {
			for (ProjectInvoice list : invoice) {
				if (list.getInvoiceNumber().equalsIgnoreCase(invoiceNum)) {
					System.out.println(list.toString());
				}
			}
		} else {
			throw new InvalidInvoiceNumberException("Invoice Number is not valid");
		}
	}

	/**
	 * this method, calculate and return the total insurance fees of all projects
	 * depending on the project type as follows:
	 * 
	 * 
	 * If the project was labour only, the insurance will be 5% of the total cost If
	 * the project was labour and material then the insurance will be 7% of the
	 * total cost if the project was labour material and equipment then its 10% of
	 * the total cost
	 * 
	 * 
	 */
	public double calclulateTotalInsuranceFees() {
		double result = 0.0;
		for (ProjectInvoice list : invoice) {
			if (list instanceof Labour) {
				result = list.calculateTotalCost() * LABOUR_INSURANCE;
			} else if (list instanceof LabourAndMaterial) {
				result = list.calculateTotalCost() * LM_INSURANCE;
			} else if (list instanceof LabourAndMaterialAndEquipment) {
				result = list.calculateTotalCost() * LME_INSURANCE;
			}
		}
		return result;
	}

	/**
	 * Method to display only the invoice numbers and the cost of each project of
	 * all the projectInvoice objects sorted by the total cost 
	 */
	public void displaySortByCost() {
		Collections.sort(invoice);
		for (ProjectInvoice list : invoice) {
			list.compareTo(list);
			if (list instanceof Labour) {
				System.out.println(list.toString());
				System.out.println("Total cost is: " + list.calculateTotalCost());
				System.out.println();
			} else if (list instanceof LabourAndMaterial) {
				System.out.println(list.toString());
				System.out.println("Total cost is: " + list.calculateTotalCost());
				System.out.println();
			} else if (list instanceof LabourAndMaterialAndEquipment) {
				System.out.println(list.toString());
				System.out.println("Total cost is: " + list.calculateTotalCost());
				System.out.println();
			}
			list.toString();
		}

	}

}