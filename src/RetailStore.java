
/**
 * In here importing class, which are belong from java.util.package;
 */
import java.util.ArrayList;

/**
 * @author Vishwas creating a class named RetailStore as mentioned
 */
public class RetailStore {
	String storeName;
	// in here creating an ArrayList, that will have Customer class object.
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	// in here again creating an ArrayList, that will have Product class object.
	ArrayList<Product> productList = new ArrayList<Product>();

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public RetailStore(String storeName) {
		super();
		this.storeName = storeName;
	}

	/**
	 * @return creating generateCustomerID method to generates the customerID;
	 */
	public int generateCustomerID() {
		// in here taking a variable counting with value zero;
		int counting = 0;
		// value of Customer Id is initially setting zero as mentioned in
		// question;
		int customerID = 0;
		/**
		 * check the customer list size, if it is 0, start ID with 1 otherwise
		 * count the customers and increase the ID by 1 and it will return
		 * customerID as mentioned in question;
		 */
		if (customerList.size() == 0)
			customerID = 1;
		else {
			for (Customer customer : customerList) {
				counting++;
				if (counting == customerList.size()) {
					customerID = customer.getCustomerID() + 1;
					break;
				}
			}
		}
		return customerID;

	}

	/**
	 * @return creating generateProductID method to generates the productID as
	 *         mentioned in question;
	 */
	public int generateProductID() {
		// in here taking a variable counting with value zero;
		int counting = 0;
		// value of productID is initially setting zero as mentioned in
		// question;
		int productID = 0;
		/**
		 * check the product list size, if it is 0, start ID with 1 otherwise
		 * count the customers and increase the ID by 1 and it will return
		 * productID as mentioned in question;
		 */
		if (productList.size() == 0)
			productID = 1;
		else {
			for (Product prod : productList) {
				counting++;
				if (counting == productList.size()) {
					productID = prod.getProductID() + 1;
					break;
				}
			}
		}
		return productID;

	}

	/**
	 * This function adds a new customer. We'll ask from the customer their name
	 * and contact number.
	 * 
	 * @param name
	 * @param contactNo
	 */

	public void addCustomer(String name, String contactNo) {
		// creating the customerId,by using generateCustomerID method.
		int customerID = generateCustomerID();

		// creating a customer object and then adding into the customerList..

		Customer cust = new Customer(customerID, contactNo, name);
		customerList.add(cust);

		System.out.println("Customer \"" + name + "\" added.");
	}

	/**
	 * This function adds new product by asking...
	 * 
	 * @param name
	 * @param status
	 * @param price
	 */
	public void addProduct(String name, String status, double price) {
		// creating the product ID,by using generateProductID method.
		int prodID = generateProductID();
		// creating a Product object and then adding into the productList..
		Product prod = new Product(prodID, name, price);
		prod.getProductStatus(status);
		productList.add(prod);
		System.out.println("Product \"" + name + "\" added.");
	}

	/**
	 * This method will check product availability..
	 * 
	 * @param ProductName
	 * @return
	 */
	public int checkProductAvailability(String ProductName) {
		int StartCount =0;

		// loop through products
		for (Product prod : productList)
			// if product is available, increase StartCount counter
			if ((prod.getProductName().equals(ProductName)) && (prod.getProductStatus(null).equals("Available"))) {
				StartCount++;
			}
		// check and print if available
		if (StartCount > 0) {
			System.out.println("available");
		}

		return StartCount;
	}

	/**
	 * It displays the customer details and product details on the console.
	 */
	public void display() {
		// now in here initializing the customerList
		for (Customer cust : customerList) {
			//printing detail of customer..
			System.out.println("Customer Name: " + cust.getCustomerName() + "\t\nCustomer Number :  " + cust.getContactNumber() + "\t\nCustomer ID: "
					+ cust.getCustomerID());
		}
		// now in here initializing the productList
		for (Product prod : productList) {
			//printing detail of Product..
			System.out.println("\nProduct name : " + prod.getProductName() + "\t\nProduct Price  : " + prod.getProductPrice()
					+ "\t\nProduct ID   : " + prod.getProductID() + "\t\nproduct Status   :" + prod.getProductStatus(null));

		}

	}

	/**
	 * This method checks for the availability of the given product in the
	 * productList of retail store...
	 * 
	 * @param CustomerID
	 *            Customer ID
	 * @param ProductName
	 *            Product Name
	 * @param NumberOfProduct
	 *            Number of products
	 * @return
	 */
	public int bookProduct(int CustomerID, String ProductName, int NumberOfProduct) {
		// now in here initializing availProduct with value -1..
		//and starting customer counting and product counting with 0;
		int availProduct = -1;
		int countCustomer = 0;
		int countProduct = 0;
		availProduct = checkProductAvailability(ProductName);
		System.out.println("Availability: " + availProduct);
		int countAvail = availProduct;
		int countNoP = NumberOfProduct;

		loop: for (Customer cust : customerList) {
			countCustomer++;
			if (cust.getCustomerID() == CustomerID) {
				for (Product prod : productList) {
					countProduct++;
					if (prod.getProductName().equals(ProductName)) {

						if (availProduct <= NumberOfProduct) {
							cust.addBookedProduct(prod);
							countAvail--;
							if (countAvail == 0)
								break loop;
						}
						if (availProduct > NumberOfProduct)

						{
							availProduct = NumberOfProduct;
							cust.addBookedProduct(prod);
							countNoP--;
							if (countNoP == 0)
								break loop;
						}

					} else if (countProduct == productList.size()) {
						availProduct = 0;
						break loop;
					}
				}

			} else if (countCustomer == customerList.size()) {
				availProduct = -1;
				break loop;
			}
		}
		// returning the count of products
		return availProduct;
	}

	/**
	 * this method calculates discount percentage and returns the net 
	 * amount that the customer need to pay for the entire booking he has made.
	 * @param customerID
	 * @param discount
	 * @return
	 */

	public double calculateNetAmount(int customerID, double discount) {
		System.out.println("Discount: " + discount);
		//declaring variable as mentioned question..
		double cost = 0;
		// in here initializing customerList..
		for (Customer cust : customerList) {
			// now here applying condition for getting the customerId..
			if (cust.getCustomerID() == customerID) {
				//printing the cost of product..
				System.out.println("Cost 1: " + cost);
				/**
				 * creating an arrayList for product this arrayList will
				 * put booked product by customer..
				 */
				ArrayList<Product> prodList1 = cust.bookedProductList;
				/**
				 * here initializing booked productList and then printing product 
				 * name and product price..
				 * and then getting the price of booked product and increasing 
				 * cost..
				 */
				for (Product prod : prodList1) {
					System.out.println(prod.getProductName() + " price = " + prod.getProductPrice());
					cost+= prod.getProductPrice();
				}
				System.out.println("Cost 2: " + cost);
				break;
			}
		}
		//calculation for discount..
		cost = cost - (cost * discount)/100;
		System.out.println("Net amount " + cost);
		return cost;
	}

}
