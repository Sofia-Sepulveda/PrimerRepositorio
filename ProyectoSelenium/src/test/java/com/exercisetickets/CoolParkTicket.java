package com.exercisetickets;

public class CoolParkTicket extends TicketsPark {

	double adultTicket, childTicket, studentTicket, studentChildTicket;
	int age;
	boolean student = false;
	String priceDay, park;

	// Constructor
	public CoolParkTicket(double price, int personAge, boolean studentId) {
		super();
		age = personAge;
		student = studentId;
		adultTicket = price;
		childTicket = price * (.80);
		studentTicket = price * (.50);
		studentChildTicket = (studentTicket) * (.80);
		priceDay = "Normal Day Price ";
		park = "Cool Park - ";

	}

	// ENCAPSULAMIENTO

	// SETTER
	private void setPriceDay(String priceDay) {
		this.priceDay = priceDay;
	}

	// GETTER
	private String getPriceDay(String priceDay) {
		return priceDay;
	}

	// METODO
	// para indicar que el metodo se hereda
	@Override
	public double getTicketPrice() {
		double priceTicket;
		if (student == true && age >= 18) {
			priceTicket = studentTicket;
			System.out.println("Student Price (50% applied): $ " + studentTicket);
		} else if (student == true && age < 18) {
			priceTicket = studentChildTicket;
			System.out.println("Student and Child Price (50% and 20% applied): $ " + studentChildTicket);
		} else if (age >= 18) {
			priceTicket = adultTicket;
			System.out.println("Adult Price $ " + adultTicket);
		} else {
			priceTicket = childTicket;
			System.out.println("Child Price (20% applied): $ " + childTicket);
		}
		return priceTicket;
	}

	// METODO SOLO IMPRESION
	@Override
	public void printPriceDay() {
		System.out.println(welcomeMessageString() + park + getPriceDay(priceDay));
	}

	// SOBRECARGA
	@Override
	public void printPriceDay(String keyManager, String priceDay) {
		setPriceDay(priceDay);
		System.out.println(welcomeMessageString() + park + getPriceDay(priceDay));
	}
}
