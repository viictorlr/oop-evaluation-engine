# 📝 OOP Evaluation Engine (Java Core Framework)

Este proyecto es una implementación modular en Java orientada a demostrar los principios fundamentales y avanzados de la **Programación Orientada a Objetos (POO)**. Consiste en un motor backend capaz de modelar, gestionar y formatear exámenes y unidades formativas, resolviendo toda la lógica de negocio mediante abstracción, encapsulamiento y herencia jerárquica.

---

## 🎯 Pilares de POO Demostrados

El diseño arquitectónico de este componente se centra en la aplicación estricta de las buenas prácticas de desarrollo de software:

* **Contratos mediante Interfaces:** Implementación de la interfaz `Avaluable` para desacoplar el comportamiento de los componentes calificables y asegurar un diseño extensible.
* **Clases Abstractas y Herencia:** Uso de una clase base abstracta `Pregunta` para la reutilización de lógica común (gestión de texto y pesos) y la declaración de métodos obligatorios.
* **Polimorfismo Dinámico:** Especialización de la renderización y maquetación de enunciados a través de las subclases derivadas (`PreguntaOberta` y `PreguntaOpcions`), resolviendo el comportamiento en tiempo de ejecución.
* **Integración de Dependencias Externas:** Uso de utilidades de formateo avanzado a través de la librería **Apache Commons Lang (`WordUtils`)** para resolver el ajuste dinámico de textos en consola (*text wrapping*).
* **Gestión Eficiente de Estructuras Fijas:** Control de algoritmos de inserción, validación de rangos, control de desbordamiento y borrado lógico sobre arrays estáticos.

---

## 🛠️ Tecnologías Utilizadas

* **Lenguaje:** Java 8+
* **Framework / Librerías:** Apache Commons Lang 3
* **Conceptos Clave:** Encapsulamiento, Abstracción, Herencia, Polimorfismo y Sobrecarga de Constructores (Constructor Chaining).

---

## 📁 Arquitectura de Clases y Paquetes

El proyecto se estructura bajo el paquete `m3.uf4.pe1` y consta de las siguientes piezas:

* `Avaluable` *(Interface)*: Contrato que define las operaciones indispensables para cualquier elemento evaluable del plan de estudios.
* `Pregunta` *(Clase Abstracta)*: Raíz jerárquica que encapsula los atributos nativos de una cuestión.
* `PreguntaOberta` *(Subclase)*: Especialización para preguntas de desarrollo con maquetación de cajas de texto manuscritas.
* `PreguntaOpcions` *(Subclase)*: Especialización encargada de iterar y estructurar cuestionarios de opción múltiple.
* `Examen` *(Controlador)*: Gestor central del ciclo de vida de las preguntas, encargado de computar las puntuaciones totales y orquestar el renderizado final.
* `UnitatFormativa` *(POJO)*: Clase de modelo que encapsula los metadatos del módulo formativo (siglas, horas, título).
