package com.exercisetickets;

//ABSTRACT QUE ES UNA CLASE ABSTRACTA, ES LA CLASE PADRE
public abstract class TicketsPark {
	
	String welcomeMessage;
	
	//CONSTRUCTOR
	public TicketsPark() {
		this.welcomeMessage = "Welcome Cooltesters Park - ";
	}
	
	
	// METODO 
	public String welcomeMessageString () {
		return this.welcomeMessage;  
	}
	
	//ABSTRACCION -- Se encarga de transformar un objeto en otro objeto
	public abstract double getTicketPrice ();
	public abstract void printPriceDay();
	public  abstract void printPriceDay (String keyManager, String priceDay);
}

