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



https://github.com/user-attachments/assets/63cec761-162a-4b62-bf94-39c7f395f405



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

## Características principales: Immortal⚙️

1- Interfaz Gráfica de Usuario (GUI):

La aplicación utiliza JFrame para crear una ventana principal (ControlFrame).
La ventana contiene un JToolBar con botones para controlar la simulación (Start, Pause and check, Resume, STOP).
Hay un JTextArea para mostrar la salida de la simulación y un JLabel para mostrar estadísticas.

2- Control de Inmortales:

La aplicación permite configurar el número de inmortales a través de un campo de texto (numOfImmortals).
Los inmortales se crean y se gestionan en una lista (immortals).

3- Acciones de los Botones:

Start: Inicia la simulación creando y comenzando los hilos de los inmortales.
Pause and check: Pausa la simulación y muestra la salud total de todos los inmortales.
Resume: Reanuda la simulación después de una pausa.
STOP: Detiene la simulación.

4- Actualización de la Interfaz:

La clase TextAreaUpdateReportCallback se utiliza para actualizar el JTextArea con los informes de los inmortales y desplazar automáticamente la barra de desplazamiento hacia abajo.

5- Simulación de Inmortales:

Cada inmortal es un hilo (Immortal) que tiene atributos como salud (DEFAULT_IMMORTAL_HEALTH) y valor de daño (DEFAULT_DAMAGE_VALUE).
Los inmortales interactúan entre sí, y sus estados se actualizan en la interfaz gráfica.

6- Manejo de Errores:

La aplicación maneja errores de formato de número al ingresar el número de inmortales y muestra un cuadro de diálogo en caso de error.


## Autores ✒️

* **Paula Natalia Paez Vega* **Manuel Felipe Barrera Barrera - *Initial work* - [Paulinguis993](https://github.com/Paulinguis993)

## Licencia 📄

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
