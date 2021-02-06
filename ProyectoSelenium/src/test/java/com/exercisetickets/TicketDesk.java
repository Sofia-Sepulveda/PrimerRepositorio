package com.exercisetickets;

public class TicketDesk {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double precioCoolPark = 100;
		double precioTestersPark= 110;
		int age=25;
		boolean student = false;
		
		
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
		ticket.getTicketPrice();
		
		ticket = new TestersParkTicket (precioTestersPark, age, student); //LINEA DE POLIMORFISMO
		ticket.printPriceDay("codigoseguridad","Dia de Madres");
		ticket.getTicketPrice();
	}

}
