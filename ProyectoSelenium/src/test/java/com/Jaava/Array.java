package com.Jaava;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// ARREGLOS

		String[] dias = { "L", "M", "Mi", "J", "V", "S", "D" };

		System.out.println(dias[2]);

		String diaSemana = dias[2]; // Inicializar un arreglo, la variable va ser igual al valor Miercoles
		System.out.println("El valor de la  variable diaSemana es: " + diaSemana);

		for (int i = 0; i < 7; i++) {
			System.out.println(dias[i]);
		}

		String[][] amigo = new String[2][2]; // Arreglos bidimensionales
		amigo[0][0] = "Ricardo";
		amigo[0][1] = "Leonardo";
		amigo[1][0] = "Carlos";
		amigo[1][1] = "Alex";

		System.out.println(amigo[1][0]);
	}

	public static void metodo() {
		System.out.println("Este es mi metodo");
	}

	public static int suma(int x, int y) {
		return x + y;
	}

	public static String Frases(int a, int b, String Frase) {
		return a + " " + b + " " + Frase;
	}
	public static void wrapperMethod () { //WRAPPER METODO
		metodo();
		suma(1,2);
	}
	
	public static int suma(int x, int y, int z) {  //SOBRECARGA DE METODOS CON OTRA SUMA
		return x + y+ z;
	}
}
