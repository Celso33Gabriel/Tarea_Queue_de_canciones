#  Music Queue Handler - Simulación de Spotify (Data Structures)

Este proyecto consiste en una simulación de reproducción de música tipo Spotify, desarrollada en **Java** utilizando una arquitectura modular con **Maven**. Implementa una estructura de datos de cola (FIFO) desde cero, cumpliendo con los requisitos de ingeniería de software y manejo de memoria manual.

---

##  Guía de Compilación e Instalación Local

Es fundamental seguir el orden de instalación para que el proyecto consumidor reconozca la librería de estructura de datos.

### 1. Instalar la Librería Core (`queue`)
Navega a la carpeta de la librería y regístrala en tu repositorio local de Maven (`.m2`):
1. `cd umg.edu.gt.data-structure.queue`
2. `mvn clean install`

> **Importante:** Esto generará el archivo `.jar` y lo hará disponible para el Handler.

### 2. Compilar el Handler (`queueHandler`)
Navega a la carpeta del motor de reproducción:
1. `cd ../queueHandler`
2. `mvn clean package`

---

##  Ejecución desde Consola

Para iniciar la simulación y ver los logs en tiempo real, ejecuta el siguiente comando dentro de la carpeta `queueHandler`:

'''bash
mvn exec:java -Dexec.mainClass="umg.edu.gt.data_structure.queueHandler.queueHandler.Main"


## Explicación del Diseño y Decisiones Técnicas
Arquitectura Modular
Se utilizó un diseño separado por responsabilidades:

Librería (queue): Implementación genérica QueueLinked<T> basada en nodos enlazados.

Consumidor (queueHandler): Aplicación final que gestiona la lógica de las canciones.

### Detalles de la Estructura de Datos
Nodos Enlazados: Se creó una clase Node<T> con referencias privadas.

Eficiencia O(1): Las operaciones enqueue y dequeue mantienen una complejidad constante al usar punteros head y tail, evitando recorrer la lista.

Encapsulamiento: No se exponen los nodos internos, cumpliendo con los principios de POO.


## Sistema de Prioridad (Parte C)
Para cumplir con la regla de no usar PriorityQueue de Java y no romper el FIFO, se implementó la técnica de Colas de Prioridad Multinivel:

El sistema instancia dos colas independientes: highPriorityQueue (Prioridad 1) y normalPriorityQueue (Prioridad 2).

Al cargar las canciones, estas se clasifican automáticamente según su atributo priority.

El motor de ejecución procesa de forma primordial la cola de Alta prioridad antes de pasar a la Normal.

Esto garantiza que si dos canciones tienen la misma prioridad, se respete estrictamente el orden de llegada.


## Simulación de Duración y Logs (Parte D)
Se implementó una simulación realista basada en el atributo duration (5 a 30 segundos) de la clase Song:

Simulación Segundo a Segundo: Se utiliza Thread.sleep(1000) para pausar la ejecución y emular el tiempo real.

Barra de Progreso Visual: Se renderiza dinámicamente una barra en consola: [#####-----] 5s / 10s.

Tiempo Total Acumulado: Al finalizar todas las canciones, el programa muestra el tiempo total de reproducción y el conteo de canciones procesadas.
