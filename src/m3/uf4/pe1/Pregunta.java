package m3.uf4.pe1;

public abstract class Pregunta {
	public static double PUNTUACIO_DEFECTE = 1.0;
	private String text;
	private double puntuacio;

	public Pregunta(String text, double puntuacio) {
		this.text = (text != null) ? text : "";
		this.puntuacio = (puntuacio >= 0) ? puntuacio : PUNTUACIO_DEFECTE;
	}

	public Pregunta(String text) {
		this(text, PUNTUACIO_DEFECTE);
	}

	public String getText() {
		return text;
	}

	public double getPuntuacio() {
		return puntuacio;
	}
	
	
	public void setText(String text) {
		this.text = text;
	}

	public void setPuntuacio(double puntuacio) {
		this.puntuacio = puntuacio;
	}

	public abstract String getEnunciatPregunta(int num);

}
