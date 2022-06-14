package bcit.ca.comp1451.assignment2;

/**
 * 
 * @author Simran This class extends class LabourAndMaterial
 */
public class LabourAndMaterialAndEquipment extends LabourAndMaterial {
	private static double HOUR_EQUIP_RATE = .05;
	private static double TRAINING_FEE = .02;
	private static double COST_RATE = .05;

	private double equipmentValueInCAD;
	private int numberOfHoursRented;

	/**
	 * 
	 * @param projectName               is for super class
	 * @param numberOfWorkingHours      is for super class
	 * @param hourlyRate                is for super class
	 * @param travelledDistanceInKM     is for super class
	 * @param hourlyRateCriteria        is for super class
	 * @param typeOfLabour              is for super class
	 * @param materialPurchasePrice     is for super class
	 * @param materialVolumeInCubicFoot is for super class
	 * @param conveyingDistanceInKM     is for super class
	 * @param equipmentValueInCAD       tells the value of equipment in CAD
	 * @param numberOfHoursRented       tells the number of hours the equipment is
	 *                                  rented
	 */
	public LabourAndMaterialAndEquipment(String projectName, int numberOfWorkingHours, double hourlyRate,
			int travelledDistanceInKM, String hourlyRateCriteria, String typeOfLabour, double materialPurchasePrice,
			double materialVolumeInCubicFoot, int conveyingDistanceInKM, double equipmentValueInCAD,
			int numberOfHoursRented) {
		super(projectName, numberOfWorkingHours, hourlyRate, travelledDistanceInKM, hourlyRateCriteria, typeOfLabour,
				materialPurchasePrice, materialVolumeInCubicFoot, conveyingDistanceInKM);
		setEquipmentValueInCAD(equipmentValueInCAD);
		setNumberOfHoursRented(numberOfHoursRented);
	}

	/**
	 * 
	 * @return equipmentValueInCAD
	 */
	public double getEquipmentValueInCAD() {
		return equipmentValueInCAD;
	}

	/**
	 * 
	 * @param equipmentValueInCAD
	 */
	public void setEquipmentValueInCAD(double equipmentValueInCAD) {
		if (equipmentValueInCAD >= 0) {
			this.equipmentValueInCAD = equipmentValueInCAD;
		} else {
			throw new IllegalArgumentException("Value of equipment cannot be negative");
		}
	}

	/**
	 * 
	 * @return numberOfHoursRented
	 */
	public int getNumberOfHoursRented() {
		return numberOfHoursRented;
	}

	/**
	 * 
	 * @param numberOfHoursRented
	 */
	public void setNumberOfHoursRented(int numberOfHoursRented) {
		if (numberOfHoursRented >= 0) {
			this.numberOfHoursRented = numberOfHoursRented;
		} else {
			throw new IllegalArgumentException("Value of time rented cannot be negative");
		}
	}

	/**
	 * 
	 * The method will calculate and return the rental fees. Rental fees will be
	 * calculated as follows:
	 *
	 * The hourly rental rate will be 5% equipment value in CAD
	 *
	 * Total rental fee will be the hourly rental rate multiplied by the number of
	 * hours rented.
	 *
	 */
	public double calculateRentalFees() {
		double result = 0;
		double hourlyRentalRate = HOUR_EQUIP_RATE * getEquipmentValueInCAD();
		result = hourlyRentalRate * getNumberOfHoursRented();
		return result;
	}

	/**
	 * if the labour type was experienced no fees will apply
	 *
	 * If the labour type was inexperienced training fees will apply. It will be
	 * calculated as follows:
	 *
	 * equipment value in CAD * 2% of the equipment value
	 * 
	 * 
	 */
	public double calculateTrainingFees() {
		double fees = 0;
		if (super.getTypeOfLabour().equalsIgnoreCase("inexperienced")) {
			fees = TRAINING_FEE * getEquipmentValueInCAD();
		}
		return fees;
	}

	/**
	 * Override method calculateTotalcost() to add the following to the previous
	 * calculations: trainingFees, rentalFees and 5% tax of those fees to the total
	 * cost.
	 *
	 *
	 */
	@Override
	public double calculateTotalCost() {
		double cost = super.calculateTotalCost() + calculateTrainingFees() + calculateRentalFees()
				+ (COST_RATE * super.calculateTotalCost());
		return cost;
	}

	/**
	 * Override method toString add the following: number of hours rented, equipment
	 * rental fees, training fees if applicable
	 *
	 */
	@Override
	public String toString() {
		return super.toString() + "Number of hours rented is: " + getNumberOfHoursRented() + "\n" + "Rental fees is: "
				+ calculateRentalFees() + "\n" + "Training fees is: " + calculateTrainingFees() + "\n";
	}

}
