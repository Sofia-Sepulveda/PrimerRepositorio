package com.exercisetickets;

public class TestersParkTicket extends TicketsPark {

	double adultTicket, childTicket, studentTicket, studentChildrenTicket, precioEspecial;
	int age;
	boolean student = false, descuentoEspecial = false;
	String priceDay, park;

	// Constructor
	public TestersParkTicket(double price, int personAge, boolean studentId) {
		super();
		age = personAge;
		student = studentId;
		adultTicket = price;
		childTicket = price * (.60);
		studentTicket = price * (.30);
		studentChildrenTicket = studentTicket * .60;
		priceDay = "Normal Day Price ";
		park = "Testers Park - ";
	}

	// Segundo constructor
	public TestersParkTicket(double price, boolean cupon) {
		super();
//		adultTicket = price;
//		childTicket = price * (.60);
//		studentTicket = price * (.30);
//		studentChildrenTicket = studentTicket * .60;
		priceDay = "Normal Day Price ";
		park = "Testers Park - ";
		descuentoEspecial = cupon;
		precioEspecial = price * (.20);
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
	@Override
	public double getTicketPrice() {
		double priceTicket;
		if (descuentoEspecial == true) {
			priceTicket = precioEspecial;
			System.out.println("Disccount  price (80% applied) : $ " + precioEspecial);
			return priceTicket;
		}
		if (student == true && age >= 18) {
			priceTicket = studentTicket;
			System.out.println("Student Price (70% applied): $ " + studentTicket);
		} else if (student == true && age < 18) {
			priceTicket = studentChildrenTicket;
			System.out.println("Student and Child Price (70% and 40% applied): $ " + studentChildrenTicket);
		} else if (age >= 18 && !student) {
			priceTicket = adultTicket;
			System.out.println("Adult Price $ " + adultTicket);

		} else {
			priceTicket = childTicket;
			System.out.println("Child Price (40% applied): $ " + childTicket);
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
