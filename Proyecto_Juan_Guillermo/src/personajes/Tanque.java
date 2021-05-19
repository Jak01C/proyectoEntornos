package personajes;

/**
 * Clase de personaje Tanque que nos permite crear objetos tanque y establecer
 * todas sus estad�sticas.
 * 
 * @author Juan Ca�adas Ca�adillas
 * @author Guillermo Gonz�lez Mart�n
 * @version 1.0, 19/05/2021
 */
public class Tanque extends Base {

	private String clase;

	/**
	 * Constructor que recibe los valores de la clase padre.
	 */
	public Tanque() {
		super();
		clase = "Tanque";
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
	 * M�todo que modifica el valor base de los puntos m�gicos.
	 * 
	 * @return mp - puntos m�gicos modificados.
	 */
	public double modificarMp() {
		return mp = getMp() * 0.5;
	} // Del modificarMp

	/**
	 * M�todo que modifica el valor base del ataque.
	 * 
	 * @return ataque - ataque modificado.
	 */
	public double modificarAtaque() {
		return ataque = getAtaque() * 1.15;
	} // Del modificarAtaque

	/**
	 * M�todo que modifica el valor base de la vida.
	 * 
	 * @return vida - vida modificada.
	 */
	public double modificarVida() {
		return vida = getVida() * 1.35;
	} // Del modificarVida

	/**
	 * M�todo que modifica el valor base de la defensa.
	 * 
	 * @return defensa - defensa modificada.
	 */
	public double modificarDefensa() {
		return defensa = getDefensa() * 1.25;
	} // Del modificarDefensa

	/**
	 * M�todo que modifica el valor base de la magia.
	 * 
	 * @return magia - magia modificada.
	 */
	public double modificarMagia() {
		return magia = getMagia() * 0.5;
	} // Del modificarMagia

	/**
	 * M�todo que modifica el valor base de la velocidad.
	 * 
	 * @return velocidad - velocidad modificada.
	 */
	public double modificarVelocidad() {
		return velocidad = getVelocidad() * 0.85;
	} // Del modificarVelocidad

	/**
	 * M�todo que llama al resto de m�todos para modificar todas las estad�sticas.
	 */
	public void generarEstadisticas() {
		modificarMp();
		modificarDefensa();
		modificarVida();
		modificarAtaque();
		modificarVelocidad();
		modificarMagia();
	} // Del generarEstadisticas

	@Override
	public String toString() {
		return "Tanque [clase=" + clase + ", vida=" + vida + ", mp=" + mp + ", ataque=" + ataque + ", defensa="
				+ defensa + ", magia=" + magia + ", velocidad=" + velocidad + "]";
	} // Del toString
} // Del class