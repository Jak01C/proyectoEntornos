package personajes;

/**
 * Clase Base para que hereden el resto de personajes. Guarda las estad�sticas
 * bases de todos.
 * 
 * @author Juan Ca�adas Ca�adillas
 * @author Guillermo Gonz�lez Mart�n
 * @version 1.0, 19/05/2021
 */
public class Base {

	protected double vida, mp, ataque, defensa, magia, velocidad;

	/**
	 * Constructor de la clase. Inicializa todas las estad�sticas base.
	 */
	public Base() {
		vida = 25.0;
		mp = 25.0;
		ataque = 10;
		defensa = 10;
		magia = 10;
		velocidad = 3;
	} // Del General

	/**
	 * M�todo que devuelve el valor de la vida.
	 * 
	 * @return vida - vida del personaje.
	 */
	public double getVida() {
		return vida;
	} // Del getVida

	/**
	 * M�todo que nos permite modificar la vida del personaje.
	 * 
	 * @param vida vida que queremos modificar.
	 */
	public void setVida(double vida) {
		this.vida = vida;
	} // Del setVida

	/**
	 * M�todo que devuelve el valor de los mp.
	 * 
	 * @return mp - mp del personaje.
	 */
	public double getMp() {
		return mp;
	} // Del getMp

	/**
	 * M�todo que nos permite modificar los mp del personaje.
	 * 
	 * @param mp mp que queremos modificar.
	 */
	public void setMp(double mp) {
		this.mp = mp;
	} // Del setMp

	/**
	 * M�todo que devuelve el valor del ataque.
	 * 
	 * @return ataque - ataque del personaje.
	 */
	public double getAtaque() {
		return ataque;
	} // Del getAtaque

	/**
	 * M�todo que nos permite modificar el ataque del personaje.
	 * 
	 * @param ataque ataque que queremos modificar.
	 */
	public void setAtaque(double ataque) {
		this.ataque = ataque;
	} // Del setAtaque

	/**
	 * M�todo que devuelve el valor de la defensa.
	 * 
	 * @return defensa - defensa del personaje.
	 */
	public double getDefensa() {
		return defensa;
	} // Del getDefensa

	/**
	 * M�todo que nos permite modificar la defensa del personaje.
	 * 
	 * @param defensa defensa que queremos modificar.
	 */
	public void setDefensa(double defensa) {
		this.defensa = defensa;
	} // Del setDefensa

	/**
	 * M�todo que devuelve el valor de la magia.
	 * 
	 * @return magia - magia del personaje.
	 */
	public double getMagia() {
		return magia;
	} // Del getMagia

	/**
	 * M�todo que nos permite modificar la magia del personaje.
	 * 
	 * @param magia magia que queremos modificar.
	 */
	public void setMagia(double magia) {
		this.magia = magia;
	} // Del setMagia

	/**
	 * M�todo que devuelve el valor de la velocidad.
	 * 
	 * @return velocidad - velocidad del personaje.
	 */
	public double getVelocidad() {
		return velocidad;
	} // Del getVelocidad

	/**
	 * M�todo que nos permite modificar la velocidad del personaje.
	 * 
	 * @param velocidad velocidad que queremos modificar.
	 */
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	} // Del setVelocidad

	public void resetearEstadisticas() {
		vida = 25.0;
		mp = 25.0;
		ataque = 10;
		defensa = 10;
		magia = 10;
		velocidad = 3;
	} // Del resetearEstadisticas

	public void aumentarEstadisticas(int nivel) {
		vida = getVida() * nivel;
		mp = getMp() * nivel;
		ataque = getAtaque() * nivel;
		defensa = getDefensa() * nivel;
		magia = getMagia() * nivel;
		velocidad = getVelocidad() * nivel;
	} // Del aumentarEstadisticas
} // Del class