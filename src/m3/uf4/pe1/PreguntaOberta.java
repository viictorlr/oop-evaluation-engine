package m3.uf4.pe1;

import org.apache.commons.lang3.text.WordUtils;

public class PreguntaOberta extends Pregunta {
	
	public PreguntaOberta(String text, double puntuacio) {
		super(text, puntuacio);
	}
	public PreguntaOberta(String text) {
		super(text);
	}
	@Override
	public String getEnunciatPregunta(int num) {
		String enunciat = WordUtils.wrap(getText(), 70);
		
			return String.format("%d. Puntuació: %.1f\n%s\n|------------------------------------"
					+ "---------------------|\n|\n|\n|\n|\n|---------------------------------------------------------|\n"
					, num, getPuntuacio(), enunciat);
	}
}
