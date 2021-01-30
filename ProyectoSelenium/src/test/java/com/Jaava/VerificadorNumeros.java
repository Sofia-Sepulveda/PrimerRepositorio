//Escribe un método que se llame imprimirVerificadorNumeros con 3 parámetros de tipo int.El método no debe devolver nada(vacío).
//
//Si uno de los parámetros es menor que 0,imprima el texto"Valor no válido".
//
//Si todos los números son iguales,imprima el texto"Todos los números son iguales"
//
//Si todos los números son diferentes,imprima el texto"Todos los números son diferentes".
//
//De lo contrario,imprima"Ni todos son iguales ni diferentes".
//
//EJEMPLOS DE ENTRADA/SALIDA:
//
//*printEqual(1,1,1);debe imprimir texto Todos los números son iguales
//
//*printEqual(1,1,2);deben imprimir texto Ni todos son iguales o diferentes
//
//*printEqual(-1,-1,-1);debe imprimir el texto Valor no válido
//
//*printEqual(1,2,3);debe imprimir texto Todos los números son diferentes

package com.Jaava;

public class VerificadorNumeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		imprimirVerificadorNumeros(1, 1, 2);
	}

	public static int imprimirVerificadorNumeros(int a, int b, int c) {
		if (a < 0 || b < 0 || c < 0) {
			System.out.println("Valor no válido");
		} else if (a == b && b == c) {
			System.out.println("Todos los números son iguales");
		} else if (a != b && b != c && c != a) {
			System.out.println("Todos los números son diferentes");
		} else {
			System.out.println("Ni todos son iguales ni diferentes");
		}
		return 0;
	}
}
