package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import exceptions.IDNumberException;
import exceptions.UnderAgeException;
import model.MiniMarket;

public class Menu {
	private final static int ADD_PERSON = 1;
	private final static int SHOW_TOTAL_PEOPLE = 2;
	private final static int EXIT = 3;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private MiniMarket miniMarket;
	
	public Menu() {
		miniMarket = new MiniMarket();
	}
	
	public void showMenu() {
		System.out.println("(1) Registrar nueva persona");
		System.out.println("(2) Mostrar la cantidad de personas que han intentado ingresar al minimercado");
		System.out.println("(3) Salir del programa");
	}
	
	public int readOption() throws NumberFormatException, IOException {
		int choice = Integer.parseInt(br.readLine());
		return choice;
	}
	
	public void readAddPerson() throws NumberFormatException, IOException {
		System.out.println("Elige el tipo de documento de identificacion:\n"+"(1) Tarjeta de Identidad\n"+"(2) Cedula de Ciudadania\n"+"(3) Pasaporte\n"+"(4) Cedula de Extranjeria");
		int type = Integer.parseInt(br.readLine());
		System.out.println("Digite el numero de identificacion:");
		String id = br.readLine();
		
		boolean added = false;
		try {
			added = miniMarket.addPerson(type, id);
			System.out.println(added? "Se ha registrado exitosamente el ingreso" : "");
		} catch (UnderAgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("No se permite el ingreso a menores de edad");
		} catch (IDNumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("La identificacion ingresada NO cumple con el pico y cedula de la normativa gubernamental");
		}
	}
	
	public void doOperation(int choice) {
		switch(choice) {
			case ADD_PERSON:
				try {
					readAddPerson();
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case SHOW_TOTAL_PEOPLE:
				System.out.println(miniMarket.getContAttempts()+" personas han intentado ingresar al minimercado.");
				break;
			case EXIT:
				System.out.println("¡Adios!");
				break;
			default:
				System.out.println("Opcion invalida, repita nuevamente");
		}
	}
	
	public void startProgram() throws NumberFormatException, IOException  {
		System.out.println("¡Bienvenido a Mi Barrio Te Quiere Minimarket!");
		int option;
		do {
			showMenu();
			option = readOption();
			doOperation(option);
		} while(option != EXIT);
	}
}
