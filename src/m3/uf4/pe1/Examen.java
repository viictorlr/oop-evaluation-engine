package m3.uf4.pe1;

/**
 * Entidad que modela un Examen dentro del sistema de evaluación.
 * Implementa la interfaz Avaluable y actúa como contenedor y gestor 
 * de un conjunto finito de objetos de tipo Pregunta.
 */
public class Examen implements Avaluable {

    // Constantes de configuración del formato y restricciones del examen
    public static final int MAX_PREGUNTES = 7;
    public static final int AMPLE_ENUNCIAT = 70;
    public static final int AMPLE_PUNTUACIO = 15;

    // Relaciones: Un examen contiene un array de preguntas y pertenece a una Unidad Formativa
    private Pregunta[] preguntes;
    private UnitatFormativa unitat;

    /**
     * Constructor principal del Examen.
     * Vincula el examen a su Unidad Formativa correspondiente e inicializa
     * el array de preguntas con una capacidad estática máxima.
     * * @param unitat La Unidad Formativa asociada al examen.
     */
    public Examen(UnitatFormativa unitat) {
        this.unitat = unitat;
        this.preguntes = new Pregunta[MAX_PREGUNTES];
    }

    // ==========================================
    //          MÉTODOS DE GESTIÓN (CRUD)
    // ==========================================

    /**
     * Añade una nueva pregunta de desarrollo (abierta) en el primer espacio disponible del array.
     * Aplica el concepto de polimorfismo instanciando un objeto hijo (PreguntaOberta) 
     * dentro de una referencia de la clase padre (Pregunta).
     * * @param text Cuerpo o enunciado de la pregunta.
     * @param puntuacio Peso de la pregunta en la nota final.
     * @return true si se añade con éxito, false si los datos son inválidos o el array está lleno.
     */
    public boolean afegirPreguntaOberta(String text, double puntuacio) {
        if (text == null || puntuacio <= 0) {
            return false;
        }
        
        for (int i = 0; i < MAX_PREGUNTES; i++) {
            if (preguntes[i] == null) {
                preguntes[i] = new PreguntaOberta(text, puntuacio);
                return true;
            }
        }
        return false;
    }

    /**
     * Añade una nueva pregunta de opción múltiple en el primer espacio disponible del array.
     * Aplica polimorfismo instanciando un objeto hijo de tipo PreguntaOpcions.
     * * @param text Cuerpo o enunciado de la pregunta.
     * @param puntuacio Peso de la pregunta en la nota final.
     * @param opcions Lista de opciones disponibles para responder.
     * @return true si se añade con éxito, false si hay datos nulos/inválidos o no hay espacio.
     */
    public boolean afegirPreguntaOpcions(String text, double puntuacio, String[] opcions) {
        if (text == null || puntuacio <= 0 || opcions == null) {
            return false;
        }
        
        for (int i = 0; i < MAX_PREGUNTES; i++) {
            if (preguntes[i] == null) {
                preguntes[i] = new PreguntaOpcions(text, puntuacio, opcions);
                return true;
            }
        }
        return false;
    }

    /**
     * Elimina una pregunta del array realizando un borrado lógico (asignando null) 
     * según su número de orden (base 1).
     * * @param num Número de la pregunta a eliminar (del 1 al MAX_PREGUNTES).
     * @return true si se elimina correctamente, false si el índice está fuera de rango o ya era nulo.
     */
    public boolean esborrarPregunta(int num) {
        if (num < 1 || num > MAX_PREGUNTES || preguntes[num - 1] == null) {
            return false;
        }
        preguntes[num - 1] = null;
        return true;
    }

    // ==========================================
    //      MÉTODOS OVERRIDE (INTERFAZ AVALUABLE)
    // ==========================================

    /**
     * Determina si el examen cumple las condiciones mínimas para ser calificado.
     * @return true si la puntuación acumulada de sus preguntas actuales es mayor que cero.
     */
    @Override
    public boolean esAvaluable() {
        return getPuntuacio() > 0;
    }

    /**
     * Genera el título formalizado del examen combinando datos de la Unidad Formativa.
     * @return Cadena de texto con el formato: "Examen MODULO. TITULO_UF".
     */
    @Override
    public String getTitol() {
        return "Examen " + unitat.getModul() + ". " + unitat.getTitol();
    }

    /**
     * Calcula la puntuación máxima total del examen recorriendo las preguntas existentes.
     * @return Suma acumulada de los pesos de todas las preguntas no nulas.
     */
    @Override
    public double getPuntuacio() {
        double totalPuntuacio = 0.0;
        for (Pregunta pregunta : preguntes) {
            if (pregunta != null) {
                totalPuntuacio += pregunta.getPuntuacio();
            }
        }
        return totalPuntuacio;
    }

    /**
     * Construye de manera eficiente la plantilla visual del examen completo en formato texto.
     * Invoca de manera polimórfica el método 'getEnunciatPregunta' de cada subclase.
     * * @return Un String estructurado listo para mostrar por consola o exportar.
     */
    @Override
    public String getEnunciat() {
        StringBuilder enunciat = new StringBuilder();
        enunciat.append("######################## ").append(getTitol()).append(" #########################\n");
        
        for (int i = 0; i < preguntes.length; i++) {
            if (preguntes[i] != null) {
                enunciat.append(preguntes[i].getEnunciatPregunta(i + 1)).append("\n");
            }
        }
        
        return enunciat.toString();
    }

    // ==========================================
    //            GETTERS Y SETTERS
    // ==========================================

    public Pregunta[] getPreguntes() {
        return preguntes;
    }

    public void setPreguntes(Pregunta[] preguntes) {
        this.preguntes = preguntes;
    }

    public UnitatFormativa getUnitat() {
        return unitat;
    }

    public void setUnitat(UnitatFormativa unitat) {
        this.unitat = unitat;
    }
}