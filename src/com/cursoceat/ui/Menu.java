package com.cursoceat.ui;

import java.util.Scanner;

import java.util.ArrayList;

import com.cursoceat.controller.Contactos;

public class Menu extends Contactos {

static ArrayList<Contactos> agenda=new ArrayList<Contactos>();
	//metodo
static public void miMenu() {
		int opcion;
		do {
			System.out.println("|---Agenda electrónica---|");
			System.out.println("|------------------------|");
			System.out.println("|1- Añadir contacto      |");
			System.out.println("|2- Buscar contacto      |");
			System.out.println("|3- Mostrar contactos    |");
			System.out.println("|4- Salir                |");
			System.out.println("|------------------------|");

			opcion = new Scanner(System.in).nextInt();
			
			
			switch (opcion) {
			case 1 -> alta();
			case 2 -> buscar();
			case 3 -> mostrar();
			case 4 -> System.out.println("Adiós");
			default -> System.err.println("Opción no válida");
			}
		}while (opcion!=4);	
	}
//son static porque la clase desde donde se llaman tambien son estaticas
static void alta() {
	String nombre;
	String telefono;
	do {
		System.out.println("Indique el nombre del contacto");
		nombre= new Scanner(System.in).nextLine();
	}while(nombre.isEmpty());
	nombre=pasarMayus(nombre);
	do {
		System.out.println("Indique el telefono del contacto");
	telefono=new Scanner(System.in).nextLine();
	}while(validarTelefono(telefono));
//creamos un objeto y guardamos los datos que hemos pedido
Contactos unCtto=new Contactos(nombre,telefono);
agenda.add(unCtto);
}	
static void buscar() {
	
}	

static void mostrar() {
for(Contactos c:agenda) {
	System.out.println(c.getNombre()+ " --> "+ c.getTelefono());
	System.out.println("");
}
}
//metodo que pasa la primera letra a mayuscula(capitaliza)
static String pasarMayus(String cadena) {
	String[] arrayCadeStrings=cadena.split(" ");
	String temp="";
	for (int i=0; i < arrayCadeStrings.length;i++) {
		arrayCadeStrings[i]=arrayCadeStrings[i].substring(0,1).toUpperCase()+
				arrayCadeStrings[i].substring(1).toLowerCase();
		temp+=arrayCadeStrings[i]+ " ";
	}
	return temp;

}
static boolean validarTelefono(String telefono) {
	boolean correcto=false;
	if ( (!telefono.startsWith("9")&& !telefono.startsWith("6")&& !telefono.startsWith("7") )
		|| telefono.length()!=9 ) {
		correcto=true;
	}
        return correcto;
}


}
