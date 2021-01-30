package com.Jaava;

public class Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Aritmeticos
		int x= 6;
		int y= 4;
		
		int z = x % y;
		
		System.out.println("Este es   el valor de x: " +z);
		
		//Unarios Cambian directamente el valor incrementan o decrementan el valor(++ y --)
		
		int A  = 1;
		int B = 2;
		
		System.out.println(++B);
		
		//Relacionales
		if(A != B) {
			System.out.println("A y  B son valores diferentes");
		}
		
		if(A == B) {
			System.out.println("A y B son valores iguales");
	}
		if (A <= B) {
			System.out.println("A es menor igual a B");
		}

		// Condicionales
		
		int var1 =  5;
		int var2 = 6;
		int var3 = 5;
		int var4 = 5;
		
		if (var1  == var2 || var3 == var4 ){
			System.out.println("BLOCK CODE");
		}
		
	}
}
