# Programación concurrente, condiciones de carrera y sincronización de hilos.

En este laboratorio observaremos las condiciones de carrera y sincronización de hilos, imlementando lock(), el cual utilizamos pata manejar la sincronización de hilos de manera más flexible y avanzada que el uso de la palabra clave, Syncronized. 

Esta nos permite tener un mejor control de acceso a recursos compartidos. Para ellos vamos a observar el programa antes de la implementación y así mismo después de esta para poder ver de manera más clara su comportamiento. 

Dentro de este laboratorio tenemos dos tipos de programas, los cuales son Consumer e Inmortal, para llamarlos de forma general.

Java.
JUnit.
Threads y sincronización con wait(), notify(), notifyAll(), lock().

## Descripción de las aplicaciones 📖

# Consumer And Producter

Esta aplicación tiene como objetivo observar el rendimiento de la CPU teniendo en cuenta la velocidad de producción. 

![image](https://github.com/user-attachments/assets/a5d55de2-285a-404d-97f4-effdaa3ee8f7)

Al inicio podemos observar que el uso de cpu es de 8.5% así que vamos a cambiar esto para mejorar la eficiencia del programa. }

![image](https://github.com/user-attachments/assets/6e3b019d-eaab-492b-8519-ab7b58010802)

Se agregó un syncronized para asegurar que solo un hilo puede acceder a la cola a la vez.
El producto espera lock.wait() hasta que el consumidor notifique que hay espacio disponible en la cola, lock.notifyAll().
Esto evita que el productor siga intentando agregar elementos a la cola cuando ya está llena, lo que mejora la eficiencia del uso de la CPU.

# Immortal

Dentro de la aplicación encontraremos Immortals, los cuales van a pelear hasta que alguno pierda la vida totalmente. Por cada golpe realizado aumenta vida al atacando y disminuye al atacado.



Se asignó la funcionalidad del botón 'Stop' y así mismo de 'Pause an check'

## Comenzando 🚀

Las siguientes instrucciones le permitirán obtener una copia del proyecto en funcionamiento.

### Tecnologías usadas ⚙️

* [Java](https://www.java.com/es/) : Lenguaje de programación robusto para backend y aplicaciones empresariales.

### Instalación 📦

Realice los siguientes pasos para clonar el proyecto en su máquina local.

```
git clone https://github.com/Pau993/TallerARSW03.git
cd TallerARSW03
git checkout main
mvn clean compile
```

### Ejecutando la aplicación ⚙️

Para abrir los archivos y ejecutarlo siga la siguiente instrucción.
Dentro de main encontrará el archivo con el programa de primos y dentro de la rama Snake encontrará el programa del juego de la serpiendte

https://github.com/user-attachments/assets/40c25085-cff8-4962-96df-861f5230b95c

Siguiendo las instrucciones podrá clonar el repositorio y ejecutar los programas satisfactoriamente.

## Características principales: ⚙️

1. Validación de Objetos Nulos
Antes de realizar cualquier operación con objetos (como invocar métodos o acceder a propiedades),
valida que estos no sean nulos. Esto es crucial cuando trabajas con arrays o colecciones que pueden contener
referencias no inicializadas.

2. Manejo de Excepciones
Aunque no es ideal depender únicamente de excepciones,
puedes incluir bloques try-catch para capturar y manejar errores inesperados.

3. Singleton Seguro (Para SnakeApp)
Si estás utilizando el patrón Singleton para la clase SnakeApp, asegúrate de implementarlo
 correctamente para garantizar que siempre exista una instancia válida.

4. Robustez y Control de Calidad
Implementa pruebas y verificaciones para garantizar que los elementos clave del juego estén en un estado
válido antes de comenzar el juego:

Comprueba que todas las serpientes estén inicializadas.
Verifica que el tablero tenga dimensiones correctas.
Asegúrate de que los métodos del juego se ejecutan en el orden esperado.
## Muestra de la aplicación 🧩

https://github.com/user-attachments/assets/c4e7d1fb-52b4-441c-9925-88ee582abb26

## Autores ✒️

* **Paula Natalia Paez Vega* **Manuel Felipe Barrera Barrera - *Initial work* - [Paulinguis993](https://github.com/Paulinguis993)

## Licencia 📄

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
