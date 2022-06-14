package bcit.ca.comp1451.assignment2;

/**
 * 
 * @author Simran class Labour Extends class ProjectInvoice
 */
public class Labour extends ProjectInvoice {

	private static String REGULAR = "regular";
	private static String OVERTIME = "over time";
	private static String HOLIDAY = "holiday";
	private static String EXP = "experienced";
	private static String INEXP = "inexperienced";
	private static double HOURLYCOST = 1.2;
	private static double OVERTIME_INCREMENT = 1.5;
	private static double HOLIDAY_INCREMENT = 3;
	private static double SALES_TAX = 1.05;

	private int travelledDistanceInKM;
	private String hourlyRateCriteria;
	private String typeOfLabour;

	/**
	 * 
	 * @param projectName           is for super class
	 * @param numberOfWorkingHours  is for super class
	 * @param hourlyRate            is for super class
	 * @param travelledDistanceInKM sets the distance travelled in KM
	 * @param hourlyRateCriteria    sets Hourly rate
	 * @param typeOfLabour          stes the type of labour
	 */
	public Labour(String projectName, int numberOfWorkingHours, double hourlyRate, int travelledDistanceInKM,
			String hourlyRateCriteria, String typeOfLabour) {
		super(projectName, numberOfWorkingHours, hourlyRate);
		setTravelledDistanceInKM(travelledDistanceInKM);
		setHourlyRateCriteria(hourlyRateCriteria);
		setTypeOfLabour(typeOfLabour);
	}

	/**
	 * 
	 * @return travelledDistanceInKM which shows distance travelled in KM
	 */
	public int getTravelledDistanceInKM() {
		return travelledDistanceInKM;
	}

	/**
	 * 
	 * @param travelledDistanceInKM sets the distance travelled in KM
	 */
	public void setTravelledDistanceInKM(int travelledDistanceInKM) {
		if (travelledDistanceInKM >= 0) {
			this.travelledDistanceInKM = travelledDistanceInKM;
		} else {
			throw new IllegalArgumentException("Ditance travelled cannot be negative");
		}
	}

	/**
	 * 
	 * @return hourlyRateCriteria tells the wages of employee per hour
	 */
	public String getHourlyRateCriteria() {
		return hourlyRateCriteria;
	}

	/**
	 * 
	 * @param hourlyRateCriteria sets the hourly wages
	 */
	public void setHourlyRateCriteria(String hourlyRateCriteria) {
		if (hourlyRateCriteria != null && (hourlyRateCriteria.equalsIgnoreCase(REGULAR)
				|| hourlyRateCriteria.equalsIgnoreCase(OVERTIME) || hourlyRateCriteria.equalsIgnoreCase(HOLIDAY))) {
			this.hourlyRateCriteria = hourlyRateCriteria;
		} else {
			this.hourlyRateCriteria = REGULAR;
		}
	}

	/**
	 * 
	 * @return typeOfLabour tells the type of labour
	 */
	public String getTypeOfLabour() {
		return typeOfLabour;
	}

	/**
	 * 
	 * @param typeOfLabour let the user choose between three types of labour
	 */
	public void setTypeOfLabour(String typeOfLabour) {
		if (typeOfLabour != null && (typeOfLabour.equalsIgnoreCase(EXP) || typeOfLabour.equalsIgnoreCase(INEXP))) {
			this.typeOfLabour = typeOfLabour;
		} else {
			this.typeOfLabour = INEXP;
		}
	}

	/**
	 * 
	 * @return travelledDistanceCost gives the cost of distance travelled in KM in
	 *         total
	 */
	public double calculateTravelledDistanceCost() {
		double travelledDistanceCost = (HOURLYCOST * travelledDistanceInKM);
		return travelledDistanceCost;
	}

	/**
	 * Implement method calculateTotalCost () to calculate the cost as follows:
	 * 
	 * if the hourly rate criteria was regular then the cost will be: hourly rate *
	 * number of working hours
	 * 
	 * if the hourly rate criteria was overtime then the cost will be: (1.5 * hourly
	 * rate * number of working hours)
	 * 
	 * if the hourly rate criteria was holiday then the cost will be: (3 * hourly
	 * rate * number of working hours)
	 * 
	 * Add the travelled distance cost and the (5%) sales tax to the calculated fees
	 * and return the result.
	 * 
	 */
	@Override
	public double calculateTotalCost() {
		double hourlyTotal = 1;
		if (getHourlyRateCriteria().equalsIgnoreCase(REGULAR)) {
			hourlyTotal = getHourlyRate() * getNumberOfWorkingHours();
		} else if (getHourlyRateCriteria().equalsIgnoreCase(OVERTIME)) {
			hourlyTotal = OVERTIME_INCREMENT * getHourlyRate() * getNumberOfWorkingHours();
		} else if (getHourlyRateCriteria().equalsIgnoreCase(HOLIDAY)) {
			hourlyTotal = HOLIDAY_INCREMENT * getHourlyRate() * getNumberOfWorkingHours();
		}
		return calculateTravelledDistanceCost() + SALES_TAX * hourlyTotal;
	}

	/**
	 * Override toString () to add the following to the super class’s toString()
	 * method, hourly rate criteria, type of labour, cost of labour, travelled distance
	 * cost and total cost
	 */
	@Override
	public String toString() {
		return super.toString() + "Hourly Rate Criteria  is: " + getHourlyRateCriteria() + "\n" + "Type Of Labour is: "
				+ getTypeOfLabour() + "\n" + "Travelled distance cost is: " + calculateTravelledDistanceCost() + "\n"
				+ "Total cost is: " + calculateTotalCost() + "\n";
	}

}
