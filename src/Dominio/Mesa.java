package Dominio;
//ALEX
public class Mesa implements Estados {

	private String estado;
	private Comanda comanda_asociada;
	private int numero;
	private int plazas;
	private Camarero_Mesa camarero_asociado;

	public String getEstado() {
		return this.estado;
	}

	/**
	 * 
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Mesa() {
	}

	public Comanda getComanda_asociada() {
		return comanda_asociada;
	}

	public void setComanda_asociada(Comanda comanda_asociada) {
		this.comanda_asociada = comanda_asociada;
	}

	public int getNumero() {
		return this.numero;
	}

	/**
	 * 
	 * @param numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPlazas() {
		return this.plazas;
	}

	/**
	 * 
	 * @param plazas
	 */
	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public Camarero_Mesa getCamarero_asociado() {
		return camarero_asociado;

	}

	/**
	 * 
	 * @param camarero_asociado
	 */
	public void setCamarero_asociado(Camarero_Mesa camarero_asociado) {

	}

}