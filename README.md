Descripción del Proyecto:

Este programa es un simulador de consola basado en el universo de Pokémon, desarrollado para el Taller 2 de Programación.
El objetivo principal es aplicar conceptos de Programación Orientada a Objetos en un entorno de juego RPG.

Integrantes:
Millaray Zepeda - RUT: 220639940 - Usuario GitHub: millazs12

Vicente Rojas - RUT: 21.895.251-2 - Usuario GitHub: VicenteRojasMalhue

1. Paquete modelo:
   
Este paquete contiene las clases que representan las entidades del mundo Pokémon:  

Pokemon: Clase base que define las propiedades de cada criatura, incluyendo su nombre, porcentaje de aparición, estadísticas base (stats), tipo y su estado (vivo o debilitado).  

Jugador: Gestiona la información del usuario, su colección de Pokémon en el PC, su Equipo activo (limitado a 6 integrantes), el conteo de medallas y las acciones de intercambio o curación.  

Habitat: Representa las zonas donde habitan los Pokémon y contiene la lógica para añadir habitantes y buscar encuentros salvajes.

LiderGimnasio / ListaGimnasios: El líder posee un equipo de 3 a 6 Pokémon y un estado para verificar si ha sido derrotado. La ListaGimnasios agrupa a los 8 líderes que el jugador debe enfrentar. 

 MiembroAltoMando / AltoMando: Estructura a los 4 entrenadores de élite de la Liga Pokémon y la lista que los contiene para el desafío final.
  
2. Paquete logica:

Contiene las clases encargadas de procesar la ejecución del programa y las reglas de juego: 

SistemaPokemon:Es el motor principal del proyecto. Se encarga de cargar los datos base, gestionar la sesión del jugador (perfil), guardar la partida y ejecutar el menú principal de interacción.  

GestorBatalla: Clase especializada en simular los combates entre dos Pokémon, calculando los resultados según sus estadísticas y la efectividad de tipos.  

TablaDeTipos: Almacena las constantes de efectividad y proporciona el método para obtener la eficacia de un ataque según el tipo del atacante y el defensor.  


Instrucionde de ejecucion:

 1. Ubicación de Archivos de Datos
    
Para que el programa inicie correctamente, los siguientes archivos deben estar en la raíz del proyecto(fuera de la carpeta src):

* Pokedex.txt

* Habitats.txt
  
* Registros.txt

2. Configuración del Entorno (IDE / Eclipse)
   
El código utiliza Java 21. En caso de errores de configuración en el IDE:

Compiler Compliance: En las Propiedades del Proyecto -> Java Compiler, verifique que el nivel sea 21.
JRE System Library [unbound]: Si aparece este error en el Java Build Path*:

  1. Seleccione JRE System Library.
     
  2. Haga clic en Edit.
     
  3. Elija la opción Workspace default JRE (asegurándose de que apunte a una versión compatible con Java 21).
