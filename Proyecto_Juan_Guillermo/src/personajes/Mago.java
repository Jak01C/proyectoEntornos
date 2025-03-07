package personajes;

/**
 * Clase de personaje Mago que nos permite crear objetos mago y establecer todas
 * sus estad�sticas.
 * 
 * @author Juan Ca�adas Ca�adillas
 * @author Guillermo Gonz�lez Mart�n
 * @version 1.0, 19/05/2021
 */
public class Mago extends Base {

	private String clase;

	/**
	 * Constructor que recibe los valores de la clase padre.
	 */
	public Mago() {
		super();
		clase = "Mago";
	} // Del constructor

	/**
	 * M�todo que devuelve la clase.
	 * 
	 * @return clase - la clase del personaje.
	 */
	public String getClase() {
		return clase;
	} // Del getClase

	/**
	 * M�todo que nos permite modificar la clase del personaje.
	 * 
	 * @param clase clase ala cual lo quieres cambiar.
	 */
	public void setClase(String clase) {
		this.clase = clase;
	} // Del setClase

	/**
	 * M�todo que modifica el valor base del ataque.
	 * 
	 * @return ataque - ataque modificado.
	 */
	public double modificarAtaque() {
		return ataque = getAtaque() * 0.75;
	} // Del modificarAtaque

	/**
	 * M�todo que modifica el valor base de los puntos m�gicos.
	 * 
	 * @return mp - puntos m�gicos modificados.
	 */
	public double modificarMp() {
		return mp = getMp() * 1.15;
	} // Del modificarMp

	/**
	 * M�todo que modifica el valor base de la defensa.
	 * 
	 * @return defensa - defensa modificada.
	 */
	public double modificarDefensa() {
		return defensa = getDefensa() * 0.75;
	} // Del modificarDefensa

	/**
	 * M�todo que modifica el valor base de la velocidad.
	 * 
	 * @return velocidad - velocidad modificada.
	 */
	public double modificarVelocidad() {
		return velocidad = getVelocidad() * 1.1;
	} // Del modificarVelocidad

	/**
	 * M�todo que modifica el valor base de la magia.
	 * 
	 * @return magia - magia modificada.
	 */
	public double modificarMagia() {
		return magia = getMagia() * 1.35;
	} // Del modificarMagia

	/**
	 * M�todo que llama al resto de m�todos para modificar todas las estad�sticas.
	 */
	public void generarEstadisticas() {
		modificarDefensa();
		modificarMp();
		modificarAtaque();
		modificarMagia();
		modificarVelocidad();
	} // Del generarEstadisticas

	@Override
	public String toString() {
		return "Mago [clase=" + clase + ", vida=" + ((double) Math.round(vida * 100d) / 100d) + ", mp="
				+ ((double) Math.round(mp * 100d) / 100d) + ", ataque=" + ((double) Math.round(ataque * 100d) / 100d)
				+ ", defensa=" + ((double) Math.round(defensa * 100d) / 100d) + ", magia="
				+ ((double) Math.round(magia * 100d) / 100d) + ", velocidad="
				+ ((double) Math.round(velocidad * 100d) / 100d) + "]";
	} // Del toString
} // Del class