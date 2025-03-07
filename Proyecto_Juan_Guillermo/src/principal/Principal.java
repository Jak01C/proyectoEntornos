package principal;

import java.text.DecimalFormat;
import java.util.*;
import combate.*;
import personajes.*;
import entradaSalida.*;

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
	private static boolean huir = true;
	private static String datosJugador;
	private static double vidaMax, mpMax;
	private static int contador = 1;
	private static EntradaSalida io = new EntradaSalida();

	/**
	 * M�todo principal.
	 * 
	 * @param args Argumentos que se le pueden pasar de manera previa al programa.
	 */
	public static void main(String[] args) {

		Enemigo enemigo = null;

		System.out.println("::::::::::: :::::::::: :::    ::: ::::::::::: :::::::::  :::::::::   ::::::::  \r\n"
				+ "    :+:     :+:        :+:    :+:     :+:     :+:    :+: :+:    :+: :+:    :+: \r\n"
				+ "    +:+     +:+         +:+  +:+      +:+     +:+    +:+ +:+    +:+ +:+        \r\n"
				+ "    +#+     +#++:++#     +#++:+       +#+     +#++:++#:  +#++:++#+  :#:        \r\n"
				+ "    +#+     +#+         +#+  +#+      +#+     +#+    +#+ +#+        +#+   +#+# \r\n"
				+ "    #+#     #+#        #+#    #+#     #+#     #+#    #+# #+#        #+#    #+# \r\n"
				+ "    ###     ########## ###    ###     ###     ###    ### ###         ########  \r\n" + "\r\n" + "");

		elegirClase();
		System.out.println("Esta es la clase que has elegido:\n\t" + clases.get(0).toString());

		enemigo = generarEnemigo();

		do {
			System.out.println();
			vidaMax = ((Base) clases.get(0)).getVida();
			mpMax = ((Base) clases.get(0)).getMp();
			System.out.println("-----VA A COMENZAR EL COMBATE N�MERO " + contador + "-----\n");
			System.out.println("Estad�sticas del enemigo:\n\t" + enemigo.toString() + "\n");
			menuCombate(enemigo);
			if (huir) {
				contador++;
				subirNivel(contador, ((Base) clases.get(0)));
				System.out.println("�Has subido al nivel " + contador + "!");
				System.out.println(clases.get(0).toString() + "\n");
				enemigo = generarEnemigo();
				subirNivel(contador, enemigo);
			} // Del if
		} while (huir); // Del do-while
		if (!huir) {
			exportarDatos();
		} // Del if
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
	 * 
	 * @return e - Enemigo ya generado.
	 */
	private static Enemigo generarEnemigo() {
		Enemigo e = new Enemigo();
		e.generarEstadisticas();
		return e;
	} // Del generarEnemigo

	/**
	 * M�todo que nos va a permitir elegir la clase de nuestro personaje y que la
	 * a�adir� a una lista con la misma.
	 */
	private static void elegirClase() {
		int opcion;
		System.out.println("�Qu� personaje quieres elegir?");
		System.out
				.println("\t1. Guerrero\t|\t2. Mago\n\t-------------\t|\t-------------\n\t3. Tanque\t|\t4. Aleatorio");
		do {
			comprobarEntero();
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				Guerrero g = new Guerrero();
				g.generarEstadisticas();
				clases.add(g);
				imprimirAscii(clases.get(0));
				break;
			case 2:
				Mago m = new Mago();
				m.generarEstadisticas();
				clases.add(m);
				imprimirAscii(clases.get(0));
				break;
			case 3:
				Tanque t = new Tanque();
				t.generarEstadisticas();
				clases.add(t);
				imprimirAscii(clases.get(0));
				break;
			case 4:
				int min = 0, max = 2, aux;
				aux = (int) (min + (Math.random() * (max - min + 1)));
				if (aux == 0) {
					Guerrero gAux = new Guerrero();
					gAux.generarEstadisticas();
					clases.add(gAux);
					imprimirAscii(clases.get(0));
				} // Del if
				else if (aux == 1) {
					Mago mAux = new Mago();
					mAux.generarEstadisticas();
					clases.add(mAux);
					imprimirAscii(clases.get(0));
				} // Del else-if
				else {
					Tanque tAux = new Tanque();
					tAux.generarEstadisticas();
					clases.add(tAux);
					imprimirAscii(clases.get(0));
				} // Del else
				break;
			default:
				System.out.println("Error, elija una opcion correcta.");
				System.out.println(
						"\t1. Guerrero\t|\t2. Mago\n\t-------------\t|\t-------------\n\t3. Tanque\t|\t4. Aleatorio");
				break;
			} // Del switch
		} while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4); // Del do-while
	} // Del elegirClase

	/**
	 * M�todo creado para no repetir todo el rato el mismo c�digo al mostrar las
	 * opciones.
	 */
	private static void mostrarRepeticion() {
		System.out.println("Elija que quiere hacer: ");
		System.out.println(
				"\t1. Ataque f�sico.\n\t2. Ataque m�gico.\n\t3. Defender.\n\t4. Curar.\n\t5. Huir del combate.");
	} // Del mostrarRepeticion

	/**
	 * M�todo en el cual se desarrolla el combate. Posee un men� con las diferentes
	 * opciones de combate.
	 * 
	 * @param enemigo Enemigo con el que combates.
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
				defenderCombate(combate, enemigo);
				break;
			case 4:
				curarCombate(combate, enemigo);
				break;
			case 5:
				System.out.println("Ha decidido huir.");
				huir = false;
				break;
			default:
				System.out.println("ERROR");
				mostrarRepeticion();
				System.out.println();
			} // Del switch
		} while (enemigo.getVida() > 0 && opcion != 5 && ((Base) clases.get(0)).getVida() > 0 && huir);
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
			mostrarVidaMpEnemigo(enemigo);
			if (enemigo.getVida() > 0) {
				System.out.println("Turno enemigo");
				calcularTipoDanioEnemigo(enemigo, combate);
				mostrarVidaMpPersonaje();
				if (((Base) clases.get(0)).getVida() <= 0) {
					System.out.println("Has perdido.");
					exportarDatos();
					System.exit(0);
				} // Del if
				mostrarRepeticion();
			} // Del if
			else {
				System.out.println("El enemigo ha muerto, enhorabuena.");
				clases.add(enemigo);
			} // Del else
		} // Del if
		else {
			System.out.println("Somos mas lentos.");
			System.out.println("Turno enemigo");
			calcularTipoDanioEnemigo(enemigo, combate);
			mostrarVidaMpPersonaje();
			if (((Base) clases.get(0)).getVida() > 0) {
				System.out.println("Turno aliado");
				combate.calcularDanioFisico(clases.get(0), enemigo);
				mostrarVidaMpEnemigo(enemigo);
				if (enemigo.getVida() <= 0) {
					System.out.println("El enemigo ha muerto, enhorabuena.");
					clases.add(enemigo);
				} // Del if
				mostrarRepeticion();
			} // Del if
			else {
				System.out.println("Has perdido.");
				exportarDatos();
				System.exit(0);
			} // Del else
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
			mostrarVidaMpEnemigo(enemigo);
			if (enemigo.getVida() > 0) {
				System.out.println("Turno enemigo");
				calcularTipoDanioEnemigo(enemigo, combate);
				mostrarVidaMpPersonaje();
				if (((Base) clases.get(0)).getVida() <= 0) {
					System.out.println("Has perdido.");
					exportarDatos();
					System.exit(0);
				} // Del if
				mostrarRepeticion();
			} // Del if
			else {
				System.out.println("El enemigo ha muerto, enhorabuena.");
				clases.add(enemigo);
			} // Del else
		} // Del if
		else {
			System.out.println("Somos mas lentos.");
			System.out.println("Turno enemigo");
			calcularTipoDanioEnemigo(enemigo, combate);
			mostrarVidaMpPersonaje();
			if (((Base) clases.get(0)).getVida() > 0) {
				System.out.println("Turno aliado");
				combate.calcularDanioMagico(clases.get(0), enemigo);
				mostrarVidaMpEnemigo(enemigo);
				if (enemigo.getVida() <= 0) {
					System.out.println("El enemigo ha muerto, enhorabuena.");
					clases.add(enemigo);
				} // Del if
				mostrarRepeticion();
			} // Del if
			else {
				System.out.println("Has perdido.");
				exportarDatos();
				System.exit(0);
			} // Del else
		} // Del else
	} // Del combateMagico

	/**
	 * M�todo que desarrolla el combate si eliges "Defender".
	 * 
	 * @param combate objeto que importas para poder utilizar los m�todos de la
	 *                clase combate.
	 * 
	 * @param enemigo enemigo con el que vas a combatir.
	 */
	private static void defenderCombate(Combate combate, Enemigo enemigo) {
		System.out.println("Vamos a defendernos.");
		combate.defender(enemigo, clases.get(0), mpMax);
		mostrarVidaMpPersonaje();
		if (((Base) clases.get(0)).getVida() <= 0) {
			System.out.println("Has perdido.");
			exportarDatos();
			System.exit(0);
		} // Del if
		mostrarRepeticion();
	} // Del defenderCombate

	/**
	 * M�todo que desarrolla el combate si eliges "Curar".
	 * 
	 * @param combate objeto que importas para poder utilizar los m�todos de la
	 *                clase combate.
	 * @param enemigo enemigo con el que vas a combatir.
	 */
	private static void curarCombate(Combate combate, Enemigo enemigo) {
		System.out.println("Vamos a curarnos.");
		combate.curar(enemigo, clases.get(0), vidaMax);
		mostrarVidaMpPersonaje();
		mostrarRepeticion();
	} // Del curarCombate

	/**
	 * M�todo por el cual el enemigo siempre atacar� con el tipo de da�o mas eficaz.
	 * 
	 * @param combate objeto que importas para poder utilizar los m�todos de la
	 *                clase combate.
	 * @param enemigo enemigo con el que se calcula el da�o.
	 */
	private static void calcularTipoDanioEnemigo(Enemigo enemigo, Combate combate) {
		if (enemigo.getAtaque() > enemigo.getMagia())
			combate.calcularDanioFisico(enemigo, clases.get(0));
		else
			combate.calcularDanioMagico(enemigo, clases.get(0));
	} // Del calcularTipoDanioEnemigo

	/**
	 * M�todo al cual le pasas por argumento un dato en double y te devuelve un
	 * String del mismo s�lo con dos decimales.
	 * 
	 * @param dato dato que le mandas para darle formato.
	 * @return formato - String con el dato truncado.
	 */
	private static String mostrarDosDecimales(double dato) {
		DecimalFormat df = new DecimalFormat("##.##");
		String formato = df.format(dato);
		return formato;
	} // Del mostrarDosDecimales

	/**
	 * M�todo que sirve para subir de nivel tanto al personaje como al enemigo.
	 * 
	 * @param nivel Nivel de la ronda en la que estamos.
	 * @param aux   Personaje o enemigo al que queremos subir de nivel.
	 */
	private static void subirNivel(int nivel, Object aux) {
		if (aux instanceof Guerrero) {
			((Guerrero) aux).resetearEstadisticas();
			((Guerrero) aux).generarEstadisticas();
			((Guerrero) aux).aumentarEstadisticas(nivel);
		} // Del if
		else if (aux instanceof Mago) {
			((Mago) aux).resetearEstadisticas();
			((Mago) aux).generarEstadisticas();
			((Mago) aux).aumentarEstadisticas(nivel);
		} // Del else-if
		else if (aux instanceof Tanque) {
			((Tanque) aux).resetearEstadisticas();
			((Tanque) aux).generarEstadisticas();
			((Tanque) aux).aumentarEstadisticas(nivel);
		} // Del else-if
		else {
			((Enemigo) aux).aumentarEstadisticas(nivel + 0.2);
		} // Del else
	} // Del subirNivel

	/**
	 * M�todo que genera el String con los datos que luego escribiremos en el
	 * archivo de records.
	 * 
	 * @return datosJugador - String con el nombre, el n�mero de rondas y el
	 *         personaje que ha utilizado el jugador.
	 */
	private static String pedirDatos() {
		String nombre;
		System.out.print("Escriba su nombre: ");
		sc.nextLine();
		nombre = sc.nextLine();
		return datosJugador = "Jugador: " + nombre + "\tN�mero de rondas: " + (contador) + "\n\tPersonaje: "
				+ clases.get(0).toString() + "\n";
	} // Del pedirDatos

	/**
	 * M�todo que realiza la secuencia de acciones para escribir el fichero con los
	 * datos de los jugadores y posteriormente leerlo si es oportuno.
	 */
	private static void exportarDatos() {
		char respuesta;
		System.out.println("\n");
		System.out.println(
				" ::::::::      :::     ::::    ::::  ::::::::::       ::::::::  :::     ::: :::::::::: :::::::::  \r\n"
						+ ":+:    :+:   :+: :+:   +:+:+: :+:+:+ :+:             :+:    :+: :+:     :+: :+:        :+:    :+: \r\n"
						+ "+:+         +:+   +:+  +:+ +:+:+ +:+ +:+             +:+    +:+ +:+     +:+ +:+        +:+    +:+ \r\n"
						+ ":#:        +#++:++#++: +#+  +:+  +#+ +#++:++#        +#+    +:+ +#+     +:+ +#++:++#   +#++:++#:  \r\n"
						+ "+#+   +#+# +#+     +#+ +#+       +#+ +#+             +#+    +#+  +#+   +#+  +#+        +#+    +#+ \r\n"
						+ "#+#    #+# #+#     #+# #+#       #+# #+#             #+#    #+#   #+#+#+#   #+#        #+#    #+# \r\n"
						+ " ########  ###     ### ###       ### ##########       ########      ###     ########## ###    ### \r\n"
						+ "\r\n" + "");
		pedirDatos();
		io.escribir(datosJugador);
		System.out.println("�Quiere revisar el hist�rico de jugadores? (S/N)");
		respuesta = sc.next().toUpperCase().charAt(0);
		System.out.println();
		if (respuesta == 'S') {
			System.out.println("Se va a proceder a leer el archivo");
			io.leer();
			delaySegundos();
		} // Del if
		sc.close();
	} // Del exportarDatos

	/**
	 * M�todo que imprime un dibujo en ASCII de cada clase.
	 * 
	 * @param aux Objeto de tipo Base para saber que dibujo realizar.
	 */
	private static void imprimirAscii(Object aux) {
		if (aux instanceof Guerrero) {
			System.out.println("Has elegido Guerrero");
			System.out.println("    _,.\r\n" + "    ,` -.)\r\n" + "   ( _/-\\\\-._\r\n"
					+ "  /,|`--._,-^|            ,\r\n" + "  \\_| |`-._/||          ,'|\r\n"
					+ "    |  `-, / |         /  /\r\n" + "    |     || |        /  /\r\n"
					+ "     `r-._||/   __   /  /\r\n" + " __,-<_     )`-/  `./  /\r\n" + "'  \\   `---'   \\   /  /\r\n"
					+ "    |           |./  /\r\n" + "    /           //  /\r\n" + "\\_/' \\         |/  /\r\n"
					+ " |    |   _,^-'/  /\r\n" + " |    , ``  (\\/  /_\r\n" + "  \\,.->._    \\X-=/^\r\n"
					+ "  (  /   `-._//^`\r\n" + "   `Y-.____(__}\r\n" + "    |     {__)\r\n" + "          ()");
		} // Del if
		else if (aux instanceof Mago) {
			System.out.println("Has elegido Mago");
			System.out.println("              _,-'|\r\n" + "           ,-'._  |\r\n" + " .||,      |####\\ |\r\n"
					+ "\\.`',/     \\####| |\r\n" + "= ,. =      |###| |\r\n" + "/ || \\    ,-'\\#/,'`.\r\n"
					+ "  ||     ,'   `,,. `.\r\n" + "  ,|____,' , ,;' \\| |\r\n" + " (3|\\    _/|/'   _| |\r\n"
					+ "  ||/,-''  | >-'' _,\\\\\r\n" + "  ||'      ==\\ ,-'  ,'\r\n" + "  ||       |  V \\ ,|\r\n"
					+ "  ||       |    |` |\r\n" + "  ||       |    |   \\\r\n" + "  ||       |    \\    \\\r\n"
					+ "  ||       |     |    \\\r\n" + "  ||       |      \\_,-'\r\n" + "  ||       |___,,--\")_\\\r\n"
					+ "  ||         |_|   ccc/\r\n" + "  ||        ccc/\r\n" + "  ||             ");
		} // Del else-if
		else {
			System.out.println("Has elegido Tanque");
			System.out.println("  ,   A           {}\r\n" + " / \\, | ,        .--.\r\n" + "|    =|= >      /.--.\\\r\n"
					+ " \\ /` | `       |====|\r\n" + "  `   |         |`::`|\r\n"
					+ "      |     .-;`\\..../`;_.-^-._\r\n" + "     /\\\\/  /  |...::..|`   :   `|\r\n"
					+ "     |:'\\ |   /'''::''|   .:.   |\r\n" + "      \\ /\\;-,/\\   ::  |..:::::..|\r\n"
					+ "      |\\ <` >  >._::_.| ':::::' |\r\n" + "      | `\"\"`  /   ^^  |   ':'   |\r\n"
					+ "      |       |       \\    :    /\r\n" + "      |       |        \\   :   /\r\n"
					+ "      |       |___/\\___|`-.:.-`\r\n" + "      |        \\_ || _/    `\r\n"
					+ "      |        <_ >< _>\r\n" + "      |        |  ||  |\r\n" + "      |        |  ||  |\r\n"
					+ "      |       _\\.:||:./_\r\n" + "      |      /____/\\____\\");
		} // Del else
	} // Del imprimirAscii

	/**
	 * M�todo que imprime dos String, uno con la vida y otro con los mp del
	 * personaje.
	 */
	private static void mostrarVidaMpPersonaje() {
		System.out.println("Vida del personaje: " + mostrarDosDecimales(((Base) clases.get(0)).getVida()));
		System.out.println("Mp del personaje: " + mostrarDosDecimales(((Base) clases.get(0)).getMp()) + "\n");
	} // Del mostrarVidaMpPersonaje

	/**
	 * M�todo que imprime dos String, uno con la vida y otro con los mp del enemigo.
	 * 
	 * @param enemigo Enemigo del cual queremos mostrar los datos.
	 */
	private static void mostrarVidaMpEnemigo(Enemigo enemigo) {
		System.out.println("Vida del enemigo: " + mostrarDosDecimales(enemigo.getVida()) + "\n");
	} // Del mostrarVidaMpEnemigo

	/**
	 * M�todo que duerme el proceso del programa durante 5s antes de que se cierre.
	 */
	private static void delaySegundos() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println("Ha habido un problema.");
			e.printStackTrace();
		} // Del try-catch
	} // Del delaySegundos
} // Del class