package Dominio;

//ALEX
public class Mesa implements Estados {

	private String estado;
	private Comanda comanda_asociada;
	private int numero;
	private int plazas;
	private Camarero_Mesa camarero_asociado;

	public Mesa() {

	}

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

	/*
	 * @param camarero_asociado
	 */
	public void setCamarero_asociado(Camarero_Mesa camarero_asociado) {
		this.camarero_asociado = camarero_asociado;
	}

	public Comanda getComanda_asociada() {
		return comanda_asociada;
	}

	public void setComanda_asociada(Comanda comanda_asociada) {
		this.comanda_asociada = comanda_asociada;
	}

	public void secuenciarEstado() {
		switch (estado) {
		case "Libre":
			setEstado(Estados.OCUPADO);
			break;
		case "Ocupado":
			setEstado(Estados.PIDIENDO);
			break;
		case "Pidiendo":
			setEstado(Estados.EN_ESPERA);
			break;
		case "En espera":
			setEstado(Estados.SERVIDOS);
			break;
		case "Servidos":
			setEstado(Estados.ESPERANDO);
			break;
		case "Esperando":
			setEstado(Estados.PAGANDO);
			break;
		case "Pagando":
			setEstado(Estados.EN_PREPARACION);
			break;
		case "En preparacion":
			setEstado(Estados.LIBRE);
			break;
		}

	}
}


