package personajes;

/**
 * Clase de personaje Guerrero que nos permite crear objetos guerrero y
 * establecer todas sus estad�sticas.
 * 
 * @author Juan Ca�adas Ca�adillas
 * @author Guillermo Gonz�lez Mart�n
 * @version 1.0, 19/05/2021
 */
public class Guerrero extends Base {

	private String clase;

	/**
	 * Constructor que recibe los valores de la clase padre.
	 */
	public Guerrero() {
		super();
		clase = "Guerrero";
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
		return mp = getMp() * 0.75;
	} // Del modificarMp()

	/**
	 * M�todo que modifica el valor base del ataque.
	 * 
	 * @return ataque - ataque modificado.
	 */
	public double modificarAtaque() {
		return ataque = getAtaque() * 1.35;
	} // Del modificarAtaque

	/**
	 * M�todo que modifica el valor base de la vida.
	 * 
	 * @return vida - vida modificada.
	 */
	public double modificarVida() {
		return vida = getVida() * 1.15;
	} // Del modificarVida

	/**
	 * M�todo que modifica el valor base de la magia.
	 * 
	 * @return magia - magia modificada.
	 */
	public double modificarMagia() {
		return magia = getMagia() * 0.75;
	} // Del modificarMagia

	/**
	 * M�todo que llama al resto de m�todos para modificar todas las estad�sticas.
	 */
	public void generarEstadisticas() {
		modificarMp();
		modificarVida();
		modificarAtaque();
		modificarMagia();
	} // Del generarEstadisticas

	@Override
	public String toString() {
		return "Guerrero [clase=" + clase + ", vida=" + ((double) Math.round(vida * 100d) / 100d) + ", mp="
				+ ((double) Math.round(mp * 100d) / 100d) + ", ataque=" + ((double) Math.round(ataque * 100d) / 100d)
				+ ", defensa=" + ((double) Math.round(defensa * 100d) / 100d) + ", magia="
				+ ((double) Math.round(magia * 100d) / 100d) + ", velocidad="
				+ ((double) Math.round(velocidad * 100d) / 100d) + "]";
	} // Del toString
} // Del class