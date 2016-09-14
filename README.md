# Bodega

###Tarea de Sistemas Operacionales.
####Integrantes: Andrés Felipe Piñeros y Johan David Ballesteros.
####Descripción: Un proceso donde concurrentemente dos actores realizan acciones sobre una bodega con unas restricciones.
---
**Actores:** Recolector **(R)** y Depositador **(D)**.
**Problema:** En una bodega existe un proceso de realización de paquetes de artículos. Existen dos tipos de articulos.  
* **Articulo Tipo Uno:** Es un articulo que se deposita en la bodega cuyo volumen es 10m^3 por articulo.
* **Articulo Tipo Dos:** Es un articulo que se deposita en la bodega cuyo volumen es 15m^3 por articulo.  

Con la descripción anterior un depositador puede colocar un articulo en ella de cualquier tipo. Mientras que un recolector puede crear un paquete (un paquete consta de 3 articulos tipo uno y 4 articulos tipo dos). La bodega tiene una capacidad máxima de 200m^3.

---

**Diagrama de Clases:** 
![alt text](https://github.com/DavidPDP/Bodega/blob/master/Imagenes/Clase.PNG "Diagrama de Clases Bodega")  

---

**Funcionamiento:** La solución que se realizó se basó en la creación de dos hilos, los cuales consumiran los servicios a los que corresponden, **R** o **D**, cada uno con sus restricciones de interacción con el sistema. El depositador puede alojar la cantidad de articulos de cualquier tipo que desee siempre y cuando tenga en cuenta la restricción de que la bodega solo puede soportar 200m^3, por lo tanto si no se llega a cumplir el depositador tiene que esperar activamente hasta que haya espacio. Mientras que el recolector puede crear los paquetes que desee siempre y cuando hayan 3 articulos de tipo uno y 4 del tipo 2, sino se cumplen que haya esta cantidad, el recolector espera activamente hasta que en la bodega se encuentren los tipos especificados. Existe una clase principal que es la encargada de coordinar todo el proceso explicado anteriormente.  

**Solución:** Existe una clase principal que es la encargada de inicializar el proceso, esto se refiere a los hilos Recolector y Depositador, esto a su vez se encarga de todo momento solicitar los servicios de sus perfiles al principal. El principal expone los servicios que se encuentran en la clase bodega, esta se encarga de realizar las validaciones de las restricciones que tiene cada servicio, como también de contabilizar y brindar la capacidad del almacén en el momento. Finalmente los actores poseen randoms para la espera (se duerme el hilo por un tiempo random máximo de 3 segundos), y el actor **D** posee otro random que es el encargado de definirle el tipo de producto a depositar en la bodega.

**Fallas:** Si el depositador solo aloja productos de un tipo especifico, se llegará a un momento donde los dos actores se queden esperando, uno por espacio en la bodega y el otro por la cantidad del otro producto para armar los paquetes. La eficiencia del proceso es baja debido a la cantidad de recursos que gasta en la espera del otro actor por ser de modo activa.

---

**Captura de Pantalla:**  
![alt text](https://github.com/DavidPDP/Bodega/blob/master/Imagenes/Captura.PNG "Resultado de la solución")  

---
