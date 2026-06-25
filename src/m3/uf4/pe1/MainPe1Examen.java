package m3.uf4.pe1;

/**
 * Clase principal (Punto de entrada) utilizada como banco de pruebas (Test Bench).
 * Se encarga de instanciar el modelo, simular la creación de exámenes y validar 
 * los algoritmos de inserción, borrado y evaluación del motor de objetos.
 */
public class MainPe1Examen {

    public static void main(String[] args) {
        
        // ==========================================
        //       1. INICIALIZACIÓN DE CONTEXTO
        // ==========================================
        
        // Creación de las unidades formativas (metadatos de los exámenes)
        UnitatFormativa m3damUf4 = new UnitatFormativa("DAM", "M03. Programació", 4, "Programació orientada a objectes (POO). Fonaments", 35);
        UnitatFormativa m7asixUf2 = new UnitatFormativa("ASIX", "M07. Planificació i Administració de Xarxes", 2, "Administració de dispositius de xarxa", 55);

        // Instanciación de un examen vacío para verificar el estado inicial
        Examen pe1Uf1M7 = new Examen(m7asixUf2);

        // Validación preventiva: Un examen sin preguntas no debe ser almacenable/evaluable (puntuación acumulada = 0)
        if (!pe1Uf1M7.esAvaluable()) {
            System.out.println("1. \"pe1Uf1M7\" no és avaluable");
        }

        // ==========================================
        //      2. PRUEBAS DE FLUJO Y ALGORITMOS
        // ==========================================
        
        Examen pe1Uf4M3 = new Examen(m3damUf4);

        // La salida secuencial por consola compone una palabra clave de éxito ("És correcte!") 
        // si los retornos booleanos de los métodos del examen responden exactamente como se espera.
        System.out.print("2. ");
        
        // Intento de borrado en posición vacía -> Debe retornar false (no imprime nada)
        if (pe1Uf4M3.esborrarPregunta(2)) System.out.print("É");
        
        // Inserciones válidas consecutivas -> Retornan true e imprimen caracteres secuenciales
        if (pe1Uf4M3.afegirPreguntaOberta("Explica què és una classe abstracte, quines característiques té i les diferències respecte una classe normal.", 1.5)) System.out.print("És");
        if (pe1Uf4M3.afegirPreguntaOberta("Lorem ipsum dolor sit amet, consectetuer adipiscing elit...", 2)) System.out.print(" ");
        
        if (pe1Uf4M3.afegirPreguntaOpcions("Marca la resposta correcte. Exemples de tipus de dades primitives poden ser:", 1.0,
                                        new String[] {"int, double, String.", "char, double, float.", "Char, Float, Boolean." })) System.out.print("c");
        
        if (pe1Uf4M3.afegirPreguntaOpcions("Marca la resposta correcte. La millor manera per comparar el text \"Hola\" amb la variable de tipus String hola és:", 1.0,
                                        new String[] {"\"Hola\" == html", "hola.equals(\"Hola\")", "\"Hola\".equals(hola)", "Cap de les anteriors" })) System.out.print("o");
        
        if (pe1Uf4M3.afegirPreguntaOpcions("Marca la resposta correcte. L'ordre correcte dels elements dins una classe és:", 1.0,
                                        new String[] {  "atributs > constructor > getters/setters > altres mètodes.",
                                                        "atributs > getters/setters > constructor > altres mètodes.",
                                                        "atributs > altres mètodes > constructor > getters/setters.",
                                                        "altres mètodes > getters/setters > constructor > atributs." })) System.out.print("r");
        
        if (pe1Uf4M3.afegirPreguntaOberta("Descriu l'esquema jeràrquic de classes que implementa el llenguatge Java i les seves característiques principals. Posa exemples concrets.", 2)) System.out.print("r");
        
        // Límite de rangos: Borrado con índice negativo -> Debe retornar false, se niega (!) para confirmar el comportamiento seguro e imprime 'e'
        if (!pe1Uf4M3.esborrarPregunta(-1)) System.out.print("e");
        
        // Borrado válido de la pregunta en posición 2 (libera un espacio en el array estático) -> Retorna true e imprime 'c'
        if (pe1Uf4M3.esborrarPregunta(2)) System.out.print("c");
        
        // Reinserción en el hueco recién liberado -> Retorna true e imprime 't'
        if (pe1Uf4M3.afegirPreguntaOberta("Proposa el diagrama UML complet d'una classe que representi una persona", 2.5)) System.out.print("t");
        
        // Última inserción permitida (completa el cupo máximo de MAX_PREGUNTES = 7) -> Retorna true e imprime 'e'
        if (pe1Uf4M3.afegirPreguntaOpcions("Marca la resposta correcte. Suposa que \"b=1==1;\", quin seria el resultat de:  \"String s = (b?\"S\":\"N\");\"  ", 1.0,
                new String[] {  "\"SN\"", "\"S\"", "\"N\"", "Cap de les anteriors" })) System.out.print("e");
        
        // Desbordamiento del array: Intento de añadir la octava pregunta -> Debe retornar false, se niega (!) e imprime '!' cerrando la traza
        if (!pe1Uf4M3.afegirPreguntaOberta("Lorem ipsum dolor sit amet, consectetuer adipiscing elit...", 2)) {
            System.out.println("!");
        }

        // ==========================================
        //       3. RENDERIZADO Y SALIDA FINAL
        // ==========================================
        
        // Si el examen ha acumulado preguntas válidas, se procede a imprimir el documento maquetado por consola
        if (pe1Uf4M3.esAvaluable()) {
            System.out.println("3. Enunciat \"pe1Uf4M3\"" + System.lineSeparator());
            System.out.println(pe1Uf4M3.getTitol());
            System.out.println(pe1Uf4M3.getEnunciat());
        }
    }
}