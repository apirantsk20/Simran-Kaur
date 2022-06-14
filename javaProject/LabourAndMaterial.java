package bcit.ca.comp1451.assignment2;

/**
 * 
 * @author Simran this class Labour and implements Interface Transferable.
 */
public class LabourAndMaterial extends Labour implements Transferable {
	private static double MARK_UP;
	private static double MAT_VOL_UNDER_10 = 1.5;
	private static double MAT_VOL_OVER_10 = 2;
	private static double SALES_TAX = 1.05;

	private double materialPurchasePrice;
	private double materialVolumeInCubicFoot;
	private int conveyingDistanceInKM;

	/**
	 * 
	 * @param projectName               is for super class
	 * @param numberOfWorkingHours      is for super class
	 * @param hourlyRate                is for super class
	 * @param travelledDistanceInKM     is for super class
	 * @param hourlyRateCriteria        is for super class
	 * @param typeOfLabour              is for super class
	 * @param materialPurchasePrice     sets the price of material purchased
	 * @param materialVolumeInCubicFoot sets the volume of material in cubic foot
	 * @param conveyingDistanceInKM     sets the distance in KM
	 */

	public LabourAndMaterial(String projectName, int numberOfWorkingHours, double hourlyRate, int travelledDistanceInKM,
			String hourlyRateCriteria, String typeOfLabour, double materialPurchasePrice,
			double materialVolumeInCubicFoot, int conveyingDistanceInKM) {
		super(projectName, numberOfWorkingHours, hourlyRate, travelledDistanceInKM, hourlyRateCriteria, typeOfLabour);
		setMaterialPurchasePrice(materialPurchasePrice);
		setMaterialVolumeInCubicFoot(materialVolumeInCubicFoot);
		setConveyingDistanceInKM(conveyingDistanceInKM);
	}

	/**
	 * 
	 * @return materialPurchasePrice which tells the price of material
	 */
	public double getMaterialPurchasePrice() {
		return materialPurchasePrice;
	}

	/**
	 * 
	 * @param materialPurchasePrice sets the material purchase price
	 */
	public void setMaterialPurchasePrice(double materialPurchasePrice) {
		if (materialPurchasePrice >= 0) {
			this.materialPurchasePrice = materialPurchasePrice;
		} else {
			throw new IllegalArgumentException("Price of material purchased cannot be negative");
		}
	}

	/**
	 * 
	 * @return materialVolumeInCubicFoot tells material in cubic foot
	 */
	public double getMaterialVolumeInCubicFoot() {
		return materialVolumeInCubicFoot;
	}

	/**
	 * 
	 * @param materialVolumeInCubicFoot sets material volume in cubic foot
	 */
	public void setMaterialVolumeInCubicFoot(double materialVolumeInCubicFoot) {
		if (materialVolumeInCubicFoot >= 0) {
			this.materialVolumeInCubicFoot = materialVolumeInCubicFoot;
		} else {
			throw new IllegalArgumentException("Volume of material cannot be negative");
		}
	}

	/**
	 * 
	 * @return tells distance in KM
	 */
	public int getConveyingDistanceInKM() {
		return conveyingDistanceInKM;
	}

	/**
	 * 
	 * @param conveyingDistanceInKM sets distance in KM
	 */

	public void setConveyingDistanceInKM(int conveyingDistanceInKM) {
		if (conveyingDistanceInKM >= 0) {
			this.conveyingDistanceInKM = conveyingDistanceInKM;
		} else {
			throw new IllegalArgumentException("Distance cannot be negative");
		}
	}

	/**
	 * A method to calculate the total material cost which will be calculated as
	 * follows: The total material cost = the material purchase price + 15% markup
	 * on the purchase price.
	 * 
	 */
	public double calculateTotalMaterialCost() {
		return getMaterialPurchasePrice() + (MARK_UP * getMaterialPurchasePrice());
	}

	/**
	 * 
	 * Override method caculateConveyingFees() to calculate the material conveying
	 * fees. The fees are calculated as follows:
	 *
	 * if material volume >= 10 cubic Feet then conveying distance in Kilometers 2.
	 * if material volume < 10 cubic feet then conveying distance in Kilometers 1.5.
	 *
	 */
	@Override
	public double calculateConveyingFees() {
		double fees = 1.00;
		if (getMaterialVolumeInCubicFoot() >= 10) {
			fees = getConveyingDistanceInKM() * MAT_VOL_OVER_10;
		} else if (getMaterialVolumeInCubicFoot() < 10) {
			fees = getConveyingDistanceInKM() * MAT_VOL_UNDER_10;
		}
		return fees;
	}

	/**
	 * Method calculateTotalcost () will be overridden so that conveying fees,
	 * material cost and 5% sales tax of (conveying fees and material cost) will be
	 * added to the parent’s class calculate cost method
	 */
	@Override
	public double calculateTotalCost() {
		double fees = 0;
		fees = super.calculateTotalCost() + calculateConveyingFees()
				+ (SALES_TAX * (calculateConveyingFees() + calculateTotalMaterialCost()));
		return fees;
	}

	/**
	 * Override the toString() method to add material cost and conveying cost to the
	 * parent class toString method.
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" + "Material cost is: " + calculateTotalMaterialCost() + "\n"
				+ "Conveying cost is: " + calculateConveyingFees();
	}

}
