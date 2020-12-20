package Dominio;

public abstract class Camarero {
//CUALQUIERA
	protected String experiencia_laboral;
	protected int identificador;
	
	public Camarero(String experiencia_laboral, int identificador) {
		this.identificador= identificador;
		this.experiencia_laboral=experiencia_laboral;
		// TODO Auto-generated constructor stub
	}

	public Camarero() {
		// TODO Auto-generated constructor stub
	}

	public String getExperiencia_laboral() {
		return experiencia_laboral;
	}

	public void setExperiencia_laboral(String experiencia_laboral) {
		this.experiencia_laboral = experiencia_laboral;
	}

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

}