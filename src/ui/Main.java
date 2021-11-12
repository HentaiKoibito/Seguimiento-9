package ui;

import java.util.Scanner;
import exceptions.UnderageException;
import exceptions.NumberWrongException;
import model.Market;

public class Main {
	public Scanner scanner;
	public Market market;
	
	public Main(){
		scanner = new Scanner(System.in);
		market = new Market();
	}

	public static void main(String[] args) {
		Main objMain = new Main();
		objMain.mainMenu();
	}
	
	public void mainMenu() {
		boolean menu = true;
		int selection;
		while(menu) {
			System.out.println("\n Seleccione una opcion" + "\n 1. Registrar ingreso" + "\n 2. Mostrar ingresos" + "\n 3. Salir");
		selection = Integer.parseInt(scanner.nextLine());
		if(selection == 1){
			selectId();
		}else if(selection == 2){
			showAttempts();
		}else if(selection == 3){
			menu = false;
		}else {
			System.out.println("Seleccion no admitida");
		}
	
		}
	}

	public void showAttempts() {
		System.out.println("Total ingresos: "+market.getTotal());
	}
	
	public void selectId() {
		int selection;
		System.out.println("\n Escoja el tipo de identificacion:\n" +"\n 1. TI - Tarjeta de Identidad" + "\n 2. CC - Cedula de ciudadania" + "\n 3. PP - Pasaporte" + "\n 4. CE - Cedula de Extranjeria" + "\n 5. Atras");
		selection = Integer.parseInt(scanner.nextLine());
		if(selection != 5){
			writeNumber(selection);
		}else {
			mainMenu();
		}
	}

	
	public void writeNumber(int selection) {
		int number;
		System.out.println("\n Escriba el numero de identificacion:\n");
		number = Integer.parseInt(scanner.nextLine());
		showMessages(selection, number);
	}

	public void showMessages(int selection, int number){
		try {
			if(market.register(selection, number)){
				System.out.println("Agregado");
			}else{
				System.out.println("No agregado");
			}
		} catch (UnderageException uae) {
			System.out.println("No es mayor de edad");
			System.err.println(uae.getMessage());
			uae.printStackTrace();
		} catch (NumberWrongException nwe) {
			System.out.println("Penultimo numero no coincide con el dia actual");
			System.err.println(nwe.getMessage());
			nwe.printStackTrace();
		}
	}
	
	
}

