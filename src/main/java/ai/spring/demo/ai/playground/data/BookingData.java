package ai.spring.demo.ai.playground.data;

import java.util.ArrayList;
import java.util.List;

public class BookingData {

	private List<Customer> customers = new ArrayList<>();

	private List<Booking> bookings = new ArrayList<>();

	private List<InventoryDetails> inventoryDetails = new ArrayList<>();

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	public List<InventoryDetails> getInventoryDetails() {
		return inventoryDetails;
	}

	public void setInventoryDetails(List<InventoryDetails> inventoryDetails) {
		this.inventoryDetails = inventoryDetails;
	}
}
