package application;

import java.util.Scanner;

import entities.Agenda;
import entities.Contato;
import model.exceptions.AgendaCheiaException;
import model.exceptions.ContatoNaoExisteException;

public class AppExceptionsJava01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scString = new Scanner(System.in);
		Scanner sc = new Scanner(System.in);
		Agenda schedule = new Agenda();

		int op;
		op = 0;

		while (op != 3) {

			op = menuOption(scString);

			if (op == 1) { // Looking for contact
				consultarContato(scString, schedule);

			}

			else if (op == 2) { // Add contact
				adicionarContato(scString, schedule);
			}
		}

		sc.close();
		scString.close();

	}

	public static void adicionarContato(Scanner scString, Agenda schedule) {
		try {
			System.out.println("Creating a contact, enter the data: ");
			String name;
			name = readInfoString(scString, "Enter the contact name: ");
			String tel;
			tel = readInfoString(scString, "Enter the contact telephone: ");
			String email;
			email = readInfoString(scString, "Enter the contact email: ");

			Contato contact = new Contato();
			contact.setName(name);
			contact.setEmail(email);
			contact.setTel(tel);

			System.out.println("\n" + "Contact to be created: ");
			System.out.println(contact + "\n");

			schedule.adicionarContato(contact);
		}
		catch (AgendaCheiaException e) {
			System.out.println(e.getMessage());

			System.out.println("Schedule contacts: ");
			System.out.println(schedule);
		}
	}

	public static void consultarContato(Scanner scString, Agenda schedule) {
		String contactName;
		contactName = readInfoString(scString, "Enter the contact name for searching: ");
		try {
			if (schedule.consultaContato(contactName) >= 0) {
				System.out.println("The contact exist!");
			}
		} 
		catch (ContatoNaoExisteException e) {
			System.out.println(e.getMessage());

		}

	}

	public static String readInfoString(Scanner scString, String msg) {
		System.out.println(msg);
		String entr = scString.nextLine();
		return entr;
	}

	public static int menuOption(Scanner scString) {

		boolean validEntr = false;
		int op = 3;

		while (!validEntr) {
			System.out.println("Enter option: ");
			System.out.println("1: Look for a contact ");
			System.out.println("2: Add a contact ");
			System.out.println("3: Exit");

			try {
				String entrada;
				entrada = scString.nextLine();
				op = Integer.parseInt(entrada);

				if (op == 1 || op == 2 || op == 3) {
					validEntr = true;
				} else {
					throw new Exception("Invalid value.");
				}

			}

			catch (Exception e) {
				System.out.println("Invalid value, type again." + "\n");
			}
		}
		return op;

	}
}
