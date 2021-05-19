package principal;

import java.util.*;
import combate.Combate;
import personajes.*;

/**
 * Clase Principal.
 * 
 * @author Juan Ca�adas Ca�adillas
 * @author Guillermo Gonz�lez Mart�n
 * @version 1.0, 19/05/2021
 */
public class Principal {

	private static Scanner sc = new Scanner(System.in);
	private static ArrayList<Object> clases = new ArrayList<Object>();

	public static void main(String[] args) {

		Enemigo enemigo = null;

		elegirClase();
		System.out.println("Esta es la clase que has elegido:\n\t" + clases.get(0).toString());

		enemigo = generarEnemigo();
		System.out.println("Enemigo:\n\t" + enemigo.toString());
		System.out.println();

		System.out.println("Se va a comenzar el combate: ");
		menuCombate(enemigo);

		System.out.println("\n\t" + clases.get(0).toString());
		System.out.println("\n\t" + enemigo.toString());
		sc.close();
	} // Del main

	/**
	 * M�todo que comprueba si un n�mero introducido por teclado es o no un entero.
	 */
	private static void comprobarEntero() {
		while (!sc.hasNextInt()) {
			System.out.println("Eso no es un numero entero. Introduzca uno de nuevo: ");
			sc.next();
		} // Del while
	} // Del comprobarEntero

	/**
	 * M�todo que se encarga de crear un objeto de la clase Enemigo con unas
	 * estad�sticas nuevas.
	 */
	private static Enemigo generarEnemigo() {
		Enemigo e = new Enemigo();
		e.generarEstad�sticas();
		return e;
	} // Del generarEnemigo

	/**
	 * M�todo que nos va a permitir elegir la clase de nuestro personaje y que la
	 * a�adir� a una lista con la misma.
	 */
	private static void elegirClase() {
		int opcion;
		System.out.println("�Qu� personaje quieres elegir?");
		System.out.println("\t1. Guerrero\n\t2. Mago\n\t3. Tanque");
		do {
			comprobarEntero();
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				Guerrero c = new Guerrero();
				c.generarEstad�sticas();
				clases.add(c);
				break;
			case 2:
				Mago m = new Mago();
				m.generarEstad�sticas();
				clases.add(m);
				break;
			case 3:
				Tanque t = new Tanque();
				t.generarEstad�sticas();
				clases.add(t);
				break;
			default:
				System.out.println("Error, elija una opcion correcta.");
				System.out.println("\t1. Guerrero\n\t2. Mago\n\t3. Tanque");
				break;
			} // Del switch
		} while (opcion != 1 && opcion != 2 && opcion != 3); // Del do-while
	} // Del elegirClase

	/**
	 * M�todo creado para no repetir todo el rato el mismo c�digo al mostrar las
	 * opciones.
	 */
	private static void mostrarRepeticion() {
		System.out.println("Elija que quiere hacer: ");
		System.out.println("\t1. Ataque f�sico.\n\t2. Ataque m�gico.\n\t3. Huir del combate.");
	} // Del mostrarRepeticion

	/**
	 * M�todo en el cual se desarrolla el combate. Posee un men� con las diferentes
	 * opciones de combate.
	 */
	private static void menuCombate(Enemigo enemigo) {
		Combate combate = new Combate();
		int opcion;
		mostrarRepeticion();
		System.out.println();
		do {
			comprobarEntero();
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				combateFisico(combate, enemigo);
				break;
			case 2:
				combateMagico(combate, enemigo);
				break;
			case 3:
				System.out.println("Ha decidido huir.");
				break;
			default:
				System.out.println("ERROR");
				mostrarRepeticion();
				System.out.println();
			} // Del switch
		} while (enemigo.getVida() > 0 && opcion != 3 && ((Base) clases.get(0)).getVida() > 0);
	} // Del menuCombate

	/**
	 * M�todo que desarrolla el combate si eliges "Ataque f�sico".
	 * 
	 * @param combate objeto que importas para poder utilizar los m�todos de la
	 *                clase combate.
	 * @param enemigo enemigo con el que vas a combatir.
	 */
	private static void combateFisico(Combate combate, Enemigo enemigo) {
		if (combate.comprobarVelocidad(clases.get(0), enemigo)) {
			System.out.println("Somos m�s r�pidos.");
			System.out.println("Turno aliado");
			combate.calcularDanioFisico(clases.get(0), enemigo);
			System.out.println("Vida restante del enemigo: " + enemigo.getVida() + "\n");
			if (enemigo.getVida() > 0) {
				System.out.println("Turno enemigo");
				combate.calcularDanioFisico(enemigo, clases.get(0));
				System.out.println("Vida restante del personaje: " + ((Base) clases.get(0)).getVida() + "\n");
				if (((Base) clases.get(0)).getVida() <= 0) {
					System.out.println("Has perdido.");
					System.exit(0);
				} // Del if
				mostrarRepeticion();
			} // Del if
			else
				System.out.println("El enemigo ha muerto, enhorabuena.");
		} // Del if
		else {
			System.out.println("Somos mas lentos.");
			System.out.println("Turno enemigo");
			combate.calcularDanioFisico(enemigo, clases.get(0));
			System.out.println("Vida restante del personaje: " + ((Base) clases.get(0)).getVida() + "\n");
			if (((Base) clases.get(0)).getVida() > 0) {
				System.out.println("Turno aliado");
				combate.calcularDanioFisico(clases.get(0), enemigo);
				System.out.println("Vida restante del enemigo: " + enemigo.getVida() + "\n");
				if (enemigo.getVida() <= 0)
					System.out.println("El enemigo ha muerto, enhorabuena.");
				mostrarRepeticion();
			} // Del if
			else
				System.out.println("Has perdido.");
		} // Del else
	} // Del combateFisico

	/**
	 * M�todo que desarrolla el combate si eliges "Ataque m�gico".
	 * 
	 * @param combate objeto que importas para poder utilizar los m�todos de la
	 *                clase combate.
	 * @param enemigo enemigo con el que vas a combatir.
	 */
	private static void combateMagico(Combate combate, Enemigo enemigo) {
		if (combate.comprobarVelocidad(clases.get(0), enemigo)) {
			System.out.println("Somos m�s r�pidos.");
			System.out.println("Turno aliado");
			combate.calcularDanioMagico(clases.get(0), enemigo);
			System.out.println("Vida restante del enemigo: " + enemigo.getVida() + "\n");
			if (enemigo.getVida() > 0) {
				System.out.println("Turno enemigo");
				combate.calcularDanioMagico(enemigo, clases.get(0));
				System.out.println("Vida restante del personaje: " + ((Base) clases.get(0)).getVida() + "\n");
				if (((Base) clases.get(0)).getVida() <= 0) {
					System.out.println("Has perdido.");
					System.exit(0);
				} // Del if
				mostrarRepeticion();
			} // Del if
			else
				System.out.println("El enemigo ha muerto, enhorabuena.");
		} // Del if
		else {
			System.out.println("Somos mas lentos.");
			System.out.println("Turno enemigo");
			combate.calcularDanioMagico(enemigo, clases.get(0));
			System.out.println("Vida restante del personaje: " + ((Base) clases.get(0)).getVida() + "\n");
			if (((Base) clases.get(0)).getVida() > 0) {
				System.out.println("Turno aliado");
				combate.calcularDanioMagico(clases.get(0), enemigo);
				System.out.println("Vida restante del enemigo: " + enemigo.getVida() + "\n");
				if (enemigo.getVida() <= 0)
					System.out.println("El enemigo ha muerto, enhorabuena.");
				mostrarRepeticion();
			} // Del if
			else
				System.out.println("Has perdido.");
		} // Del else
	} // Del combateMagico
} // Del class