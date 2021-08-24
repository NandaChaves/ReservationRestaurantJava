/**
 * 
 */
package Restaurante;

/**
 * @author delseysilva
 *
 */
public class Mesa {
	private int id;
	private int nLugares;
	private Mesa proxMesa;
	
	public Mesa(int id, int nLugares) {
		this.id = id;
		this.nLugares = nLugares;
	}
	/**
	 * @return the nLugares
	 */
	public int getnLugares() {
		return nLugares;
	}
	/**
	 * @param nLugares the nLugares to set
	 */
	public void setnLugares(int nLugares) {
		this.nLugares = nLugares;
	}
	/**
	 * @return the proxMesa
	 */
	public Mesa getProxMesa() {
		return proxMesa;
	}
	/**
	 * @param proxMesa the proxMesa to set
	 */
	public void setProxMesa(Mesa proxMesa) {
		this.proxMesa = proxMesa;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Mesa=" + id + 
				", nLugares=" + nLugares;
	}
	
}
