package personajes;

/**
 * Clase de personaje Enemigo que nos permite crear objetos enemigos y
 * establecer todas sus estad�sticas.
 * 
 * @author Juan Ca�adas Ca�adillas
 * @author Guillermo Gonz�lez Mart�n
 * @version 1.0, 19/05/2021
 */
public class Enemigo extends Base {

	private String nombre;

	/**
	 * Constructor que recibe los valores de la clase padre.
	 */
	public Enemigo() {
		super();
		nombre = "Enemigo";
	} // Del constructor

	/**
	 * M�todo que devuelve la clase.
	 * 
	 * @retun nombre - el nombre del enemigo.
	 */
	public String getNombre() {
		return nombre;
	} // Del getNombre

	/**
	 * M�todo que nos permite modificar el nombre del enemigo.
	 * 
	 * @param nombre- nombre del enemigo.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	} // Del setNombre

	/**
	 * M�todo que modifica el valor base de la vida. Var�a un �15% respecto a la
	 * estad�stica base.
	 * 
	 * @return vida - vida modificada.
	 */
	public double modificarVida() {
		double min = (getVida() * 85) / 100;
		double max = (getVida() * 115) / 100;
		double aux = min + (Math.random() * (max - min));
		return vida = Math.round(aux * 100.00) / 100.00;
	} // Del modificarVida

	/**
	 * M�todo que modifica el valor base de los mp. Var�an un �15% respecto a la
	 * estad�stica base.
	 * 
	 * @return mp - mp modificados.
	 */
	public double modificarMp() {
		double min = (getMp() * 85) / 100;
		double max = (getMp() * 115) / 100;
		double aux = min + (Math.random() * (max - min));
		return mp = Math.round(aux * 100.00) / 100.00;
	} // Del modificarMp

	/**
	 * M�todo que modifica el valor base del ataque. Var�a un �15% respecto a la
	 * estad�stica base.
	 * 
	 * @return ataque - ataque modificado.
	 */
	public double modificarAtaque() {
		double min = (getAtaque() * 85) / 100;
		double max = (getAtaque() * 115) / 100;
		double aux = min + (Math.random() * (max - min));
		return ataque = Math.round(aux * 100.00) / 100.00;
	} // Del modificarAtaque

	/**
	 * M�todo que modifica el valor base de la defensa. Var�a un �15% respecto a la
	 * estad�stica base.
	 * 
	 * @return defensa - defensa modificada.
	 */
	public double modificarDefensa() {
		double min = (getDefensa() * 85) / 100;
		double max = (getDefensa() * 115) / 100;
		double aux = min + (Math.random() * (max - min));
		return defensa = Math.round(aux * 100.00) / 100.00;
	} // Del modificarDefensa

	/**
	 * M�todo que modifica el valor base de la magia. Var�a un �15% respecto a la
	 * estad�stica base.
	 * 
	 * @return magia - magia modificada.
	 */
	public double modificarMagia() {
		double min = (getMagia() * 85) / 100;
		double max = (getMagia() * 115) / 100;
		double aux = min + (Math.random() * (max - min));
		return magia = Math.round(aux * 100.00) / 100.00;
	} // Del modificarMagia

	/**
	 * M�todo que modifica el valor base de la velocidad. Var�a un �15% respecto a
	 * la estad�stica base.
	 * 
	 * @return velocidad - velocidad modificada.
	 */
	public double modificarVelocidad() {
		double min = (getVelocidad() * 85) / 100;
		double max = (getVelocidad() * 115) / 100;
		double aux = min + (Math.random() * (max - min));
		return velocidad = Math.round(aux * 100.00) / 100.00;
	} // Del modificarVelocidad

	/**
	 * M�todo que llama al resto de m�todos para modificar todas las estad�sticas.
	 */
	public void generarEstad�sticas() {
		modificarMp();
		modificarDefensa();
		modificarVida();
		modificarAtaque();
		modificarVelocidad();
		modificarMagia();
	} // Del generarEstad�sticas

	@Override
	public String toString() {
		return "Enemigo [nombre=" + nombre + ", vida=" + vida + ", mp=" + mp + ", ataque=" + ataque + ", defensa="
				+ defensa + ", magia=" + magia + ", velocidad=" + velocidad + "]";
	} // Del toString
} // Del class