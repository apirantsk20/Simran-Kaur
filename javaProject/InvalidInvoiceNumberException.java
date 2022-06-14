package bcit.ca.comp1451.assignment2;
/**
 * 
 * @author Simran
 * This class extends the class Exception
 */
public class InvalidInvoiceNumberException extends Exception {
/**
 * 
 * @param m
 */
	public InvalidInvoiceNumberException(String m) {
		super(m);
	}
}
