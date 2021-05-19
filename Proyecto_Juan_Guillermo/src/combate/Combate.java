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
	 * @param aliado Personaje con el que estamos jugando.
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
		vidaRestante = ((Base) defensor).getVida()
				- ((2 * ((Base) atacante).getAtaque()) - ((Base) defensor).getDefensa());
		if (vidaRestante > vidaActual)
			vidaRestante = vidaActual;
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
		vidaRestante = ((Base) defensor).getVida()
				- ((2 * ((Base) atacante).getMagia()) - ((Base) defensor).getDefensa());
		if (vidaRestante > vidaActual)
			vidaRestante = vidaActual;
		((Base) defensor).setVida(vidaRestante);
	} // Del calcularDanioMagico
} // Del class