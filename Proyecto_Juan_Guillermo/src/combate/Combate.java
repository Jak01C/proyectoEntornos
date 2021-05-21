package combate;

import personajes.*;

/**
 * Clase Combate en la cual se van a programas los m�todos referidos al combate.
 * 
 * @author Juan Ca�adas Ca�adillas
 * @author Guillermo Gonz�lez Mart�n
 * @version 1.0, 19/05/2021
 */
public class Combate {

	/**
	 * M�todo que comprueba la prioridad de los turnos en funci�n de la velocidad.
	 * 
	 * @param aliado  Personaje con el que estamos jugando.
	 * @param enemigo Enemigo contra el que nos enfrentamos.
	 * @return vasPrimero - true si somos nosotros los m�s r�rpidos, flase en caso
	 *         contrario.
	 */
	public boolean comprobarVelocidad(Object aliado, Object enemigo) {
		boolean vasPrimero = false;
		if (((Base) aliado).getVelocidad() >= ((Base) enemigo).getVelocidad()) {
			vasPrimero = true;
		} // Del if
		return vasPrimero;
	} // Del comprobarVelocidad

	/**
	 * M�todo que calcula la vida restante del defensor tras recibir un ataque
	 * f�sico.
	 * 
	 * @param atacante Personaje que ataca.
	 * @param defensor Personaje que defiende.
	 */
	public void calcularDanioFisico(Object atacante, Object defensor) {
		double vidaRestante = 0;
		double vidaActual = ((Base) defensor).getVida();
		if (evadir()) {
			System.out.println("�El ataque ha fallado!");
			vidaRestante = vidaActual;
		} // Del if
		else {
			if (golpeCritico()) {
				System.out.println("�Golpe cr�tico!");
				vidaRestante = ((Base) defensor).getVida()
						- ((1.5 * 2 * ((Base) atacante).getAtaque()) - ((Base) defensor).getDefensa());
			} // Del if
			else
				vidaRestante = ((Base) defensor).getVida()
						- ((2 * ((Base) atacante).getAtaque()) - ((Base) defensor).getDefensa());
			if (vidaRestante > vidaActual)
				vidaRestante = vidaActual;
		} // Del else
		((Base) defensor).setVida(vidaRestante);
	} // Del calcularDanioFisico

	/**
	 * M�todo que calcula la vida restante del defensor tras recibir un ataque
	 * m�gico.
	 * 
	 * @param atacante Personaje que ataca.
	 * @param defensor Personaje que defiende.
	 */
	public void calcularDanioMagico(Object atacante, Object defensor) {
		double vidaRestante = 0;
		double vidaActual = ((Base) defensor).getVida();
		if (evadir()) {
			System.out.println("�El ataque ha fallado!");
			vidaRestante = vidaActual;
		} // Del if
		else {
			if (golpeCritico()) {
				System.out.println("�Golpe cr�tico!");
				vidaRestante = ((Base) defensor).getVida()
						- ((1.5 * 2 * ((Base) atacante).getMagia()) - ((Base) defensor).getDefensa());
			} // Del if
			else
				vidaRestante = ((Base) defensor).getVida()
						- ((2 * ((Base) atacante).getMagia()) - ((Base) defensor).getDefensa());
			if (vidaRestante > vidaActual)
				vidaRestante = vidaActual;
		} // Del else
		((Base) defensor).setVida(vidaRestante);
	} // Del calcularDanioMagico

	/**
	 * M�todo que te permite defenderte por lo que recibes solamente un 50% del da�o
	 * del ataque. Adem�s te restaurar� 5 MP.
	 * 
	 * @param atacante Personaje que ataca.
	 * @param defensor Personaje que defiende.
	 * @param mpMax    M�ximos mp del personaje.
	 */
	public void defender(Enemigo atacante, Object defensor, double mpMax) {
		double vidaRestante = 0;
		double vidaActual = ((Base) defensor).getVida();
		double mpActual = ((Base) defensor).getMp();
		if (evadir()) {
			System.out.println("�El ataque ha fallado!");
			vidaRestante = vidaActual;
		} // Del if
		else {
			if (atacante.getAtaque() > atacante.getMagia()) {
				vidaRestante = ((Base) defensor).getVida()
						- (((2 * ((Base) atacante).getAtaque()) - ((Base) defensor).getDefensa()) / 2);
			} // Del if
			else {
				vidaRestante = ((Base) defensor).getVida()
						- (((2 * ((Base) atacante).getMagia()) - ((Base) defensor).getDefensa()) / 2);
			} // Del else
			if (vidaRestante > vidaActual)
				vidaRestante = vidaActual;
		} // Del else
		if (mpActual < mpMax)
			mpActual = mpActual + 5;
		if (mpActual > mpMax)
			mpActual = mpMax;
		((Base) defensor).setMp(mpActual);
		((Base) defensor).setVida(vidaRestante);
	} // Del defender

	/**
	 * M�todo que gasta mp para curarte antes de que nos ataquen.
	 * 
	 * @param atacante Personaje que ataca.
	 * @param defensor Objeto de la clase Base que representa al personaje.
	 * @param vidaMax  Vida m�xima del personaje.
	 */
	public void curar(Enemigo atacante, Object defensor, double vidaMax) {
		int costeMp = 7;
		double vidaCurada = 0;
		double vidaRestante = 0;
		double vidaActual = ((Base) defensor).getVida();
		double mpActual = ((Base) defensor).getMp();
		if (mpActual > costeMp) {
			vidaCurada = vidaActual + (vidaMax * 0.5);
			((Base) defensor).setMp(mpActual - costeMp);
		} // Del if
		else {
			System.out.println("No tienes suficientes Mp");
			vidaCurada = vidaActual;
		} // Del else
		if (vidaCurada > vidaMax)
			vidaCurada = vidaMax;
		((Base) defensor).setVida(vidaCurada);
		vidaActual = ((Base) defensor).getVida();
		System.out.println("�Nos hemos curado!");
		System.out.println("\tAhora tenemos " + ((double) Math.round(vidaActual * 100d) / 100d) + " de vida.");
		System.out.println("�Nos atacan!");
		if (evadir()) {
			System.out.println("�El ataque ha fallado!");
			vidaRestante = vidaActual;
		} // Del if
		else {
			if (atacante.getAtaque() > atacante.getMagia()) {
				vidaRestante = ((Base) defensor).getVida()
						- ((2 * ((Base) atacante).getAtaque()) - ((Base) defensor).getDefensa());
			} // Del if
			else {
				vidaRestante = ((Base) defensor).getVida()
						- ((2 * ((Base) atacante).getMagia()) - ((Base) defensor).getDefensa());
			} // Del else
			if (vidaRestante > vidaActual)
				vidaRestante = vidaActual;
		} // Del else
		((Base) defensor).setVida(vidaRestante);
	} // Del curar

	/**
	 * M�todo que calcula si un golpe es o no cr�tico.
	 * 
	 * @return esCritico - boolean que devuelve true si es cr�tico o false en caso
	 *         contrario.
	 */
	private boolean golpeCritico() {
		boolean esCritico = false;
		double min = 0, max = 100, aux;
		aux = min + (Math.random() * (max - min));
		if (aux > 0 && aux < 6.25)
			esCritico = true;
		return esCritico;
	} // Del golpeCritico

	/**
	 * M�todo que calcula si el ataque acierta.
	 * 
	 * @return evitado - boolean que devuelve true si es lo evita o false en caso
	 *         contrario.
	 */
	private boolean evadir() {
		boolean evitado = false;
		double min = 0, max = 100, aux;
		aux = min + (Math.random() * (max - min));
		if (aux > 0 && aux < 6.25)
			evitado = true;
		return evitado;
	} // Del evadir;
} // Del class