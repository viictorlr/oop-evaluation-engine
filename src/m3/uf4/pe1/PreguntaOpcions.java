package m3.uf4.pe1;

import org.apache.commons.lang3.text.WordUtils;

public class PreguntaOpcions extends Pregunta {
	private String[] opcions;
	
	public PreguntaOpcions(String text, double puntuacio, String[] opcions) {
		super(text, puntuacio);
		this.opcions = (opcions != null) ? opcions : new String[0];
	}
	
	public String[] getOpcions() {
		return opcions;
	}

	public void setOpcions(String[] opcions) {
		this.opcions = opcions;
	}

	public PreguntaOpcions(String text, String[] opcions) {
		this(text, PUNTUACIO_DEFECTE, opcions);
	}
	
	@Override
	public String getEnunciatPregunta(int num) {
		StringBuilder stringBuilder = new StringBuilder();
		String enunciat = WordUtils.wrap(getText(), 70);

		stringBuilder.append(String.format("Pregunta %d. Puntuació: %.1f\n%s\n", num, getPuntuacio(), enunciat));
		
		for (int i = 0; i < opcions.length; i++) {
		stringBuilder.append(String.format("[%d] %s\n", i + 1, opcions[i]));
		}
		
		return stringBuilder.toString();
	}
}
