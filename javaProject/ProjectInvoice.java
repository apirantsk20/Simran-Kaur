package bcit.ca.comp1451.assignment2;

/*It is an abstract class.*/

/**
 * @author Simran
 * This is abstract class
 * class ProjectInvoice implements comparable.
 */
public abstract class ProjectInvoice implements Comparable<ProjectInvoice> {
	private static int counter = 100;

	private String invoiceNumber;
	private String projectName;
	private int numberOfWorkingHours;
	private double hourlyRate;

	/**
	 * 
	 * @param projectName          sets the project name.
	 * @param numberOfWorkingHours sets the number of working hours
	 * @param hourlyRate           sets the hourly rate
	 */

	public ProjectInvoice(String projectName, int numberOfWorkingHours, double hourlyRate) {
		setProjectName(projectName);
		setNumberOfWorkingHours(numberOfWorkingHours);
		setHourlyRate(hourlyRate);
		setInvoiceNumber(invoiceNumber);
	}

	/**
	 * @return the hourlyRate
	 */

	public double getHourlyRate() {
		return hourlyRate;
	}

	/**
	 * @param hourlyRate the hourlyRate to set
	 */
	public void setHourlyRate(double hourlyRate) {
		if (hourlyRate > 0) {
			this.hourlyRate = hourlyRate;
		} else {
			this.hourlyRate = 14.30;
		}
	}

	/**
	 * @return the projectName
	 */
	public String getProjectName() {
		return projectName;
	}

	/**
	 * @param projectName the projectName to set
	 */
	public void setProjectName(String projectName) {
		if (projectName != null) {
			this.projectName = projectName;
		} else {
			this.projectName = "Unknown Project Name";
		}
	}

	/**
	 * @return the numberOfWorkingHours
	 */

	public int getNumberOfWorkingHours() {
		return numberOfWorkingHours;
	}

	/**
	 * @param numberOfWorkingHours the numOfWorkingHours to set
	 */
	public void setNumberOfWorkingHours(int numberOfWorkingHours) {
		if (numberOfWorkingHours >= 0) {
			this.numberOfWorkingHours = numberOfWorkingHours;
		} else {
			this.numberOfWorkingHours = 0;
		}
	}

	/**
	 * @return invoiceNumber to give invoice number that has been generated
	 */
	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	/**
	 * 
	 * @return counter increment. it act as part of methd to set invoice number.
	 */
	public int createInvoiceNumber() {
		return counter++;

	}

	/**
	 * 
	 * @param invoiceNumber which is taken from the method create invoice number.
	 */
	public void setInvoiceNumber(String invoiceNumber) {
		invoiceNumber = Integer.toString(createInvoiceNumber());
		this.invoiceNumber = "INVC" + invoiceNumber;
	}

	/**
	 * 
	 * this is an abstract method
	 */
	public abstract double calculateTotalCost();

	/**
	 * this is overridden method of class comparable
	 */
	@Override
	public int compareTo(ProjectInvoice obj) {
		return (int) (this.calculateTotalCost() - obj.calculateTotalCost());
	}

	/**
	 * this is an overridden method of java util package
	 */
	@Override
	public String toString() {
		return "\n" + "The invoice number is: " + getInvoiceNumber() + "\n" + "The project name is: " + getProjectName()
				+ "\n" + "The number of working hours are: " + getNumberOfWorkingHours() + "\n"
				+ "And the hourly rate is: " + getHourlyRate() + "\n";
	}

}
