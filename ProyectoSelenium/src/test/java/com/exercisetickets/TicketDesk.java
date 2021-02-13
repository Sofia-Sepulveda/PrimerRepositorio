package com.exercisetickets;

public class TicketDesk {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double precioCoolPark = 100;
		double precioTestersPark= 110;
		int age=1;
		boolean student = true;
		//boolean  cupon = true; // linea tarea 2
		
		
	//	LINEAS SIN POLIMORFISMO
		
		//CLASE OBJETO = NEW QUE VOY A CREAR UN OBJETO Y LUEGO VARIABLES DE CONSTRUCTOR
//		CoolParkTicket coolPark = new CoolParkTicket(precioCoolPark, age, student); // CREACION DE OBJETO
//		coolPark.getTicketPrice();
//		coolPark.printPriceDay("xyz", "Dia del niño");
//
//		TestersParkTicket testersPark = new TestersParkTicket(precioTestersPark, age, student); // CREACION DE OBJETO
//		testersPark.getTicketPrice();
//		testersPark.printPriceDay();
		
		TicketsPark ticket = new CoolParkTicket (precioCoolPark, age, student);
		ticket.printPriceDay();
		double ticket1= ticket.getTicketPrice();
		
		ticket = new TestersParkTicket (precioTestersPark,age, student); //LINEA DE POLIMORFISMO
		//ticket = new TestersParkTicket (precioTestersPark, cupon); //linea tarea 2
		ticket.printPriceDay();
		double ticket2 = ticket.getTicketPrice();
		double total = sumaTickets(ticket1, ticket2);
		System.out.println("El total a pagar es de: $ " +total);
	}
	public static double sumaTickets (double ticketTester, double ticketCool) {
		return ticketTester + ticketCool;
	}
	
}
