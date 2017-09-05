
import java.util.ArrayList;

/**
 * 
 * @author Vishwas 1.creating a class Customer; 2.and declaring variables
 *         customerID,customerName, contactNumber; 3.than generated getter and
 *         setter for customerID,customerName,contactNumber; 4.and then created
 *         a Constructor to create Customer object with the given id,name &
 *         contact no as mentioned in the question; 9.Creating an
 *         addBookedProduct - Public void addBookedProduct(Product obj): The
 *         method will adds the product which is booked by the customer to his
 *         bookedProductList.
 * 
 */
// 1.
public class Customer {

	// 2.
	public int customerID;
	String contactNumber;
	String customerName;
	// 10
	ArrayList<Product> bookedProductList = new ArrayList<Product>();

	// 9.
	public void addBookedProduct(Product obj) {
		bookedProductList.add(obj);
		obj.setProductStatus("Booked");
	}

	// 3.
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	// 4.
	public Customer(int customerID, String contactNumber, String customerName) {
		super();
		this.customerID = customerID;
		this.contactNumber = contactNumber;
		this.customerName = customerName;
	}

}

/**
 * 
 * @author Vishwas 5.creating an another class named ProductID as mentioned in
 *         question. 6.declaring variables of product class
 *         productID,productName,productStatus and productPrice. 7.and initially
 *         the status of the product is set to “Available”. 8.and then creating
 *         the constructor to initializing the value of productID, name & price
 *         with the given values as mentioned in the project
 *
 */
// 5.
class Product { // 6.
	int productID;
	String productName;
	double productPrice;
	// 7
	String productStatus = "Available";

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductStatus(String status) {
		return productStatus;
	}

	public void setProductStatus(String productStatus) {
		this.productStatus = productStatus;
	}

	// 8.
	public Product(int productID, String productName, double productPrice) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
	}

}
