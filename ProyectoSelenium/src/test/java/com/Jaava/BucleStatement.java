package com.Jaava;

public class BucleStatement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// While

		int numero = 1;

		while (numero <= 10) {
			System.out.println("El número es " + numero);
			++numero;
		}

		// Do While ¿Cuantas veces tiene que sumar un mismo número para llegar a 100?

		int numeroLimite = 1;
		int sumTotal = 0;
		int count = 0;
		do {
			sumTotal += numeroLimite;
			++count;
		} while (sumTotal < 100);

		System.out.println("El número se sumo: " + count);
		int numeroFor = 10;
		for (int i = 1; i <= numeroFor; i++) {
			System.out.println("El  numero del FOR es " + i);
		}
	}

}
