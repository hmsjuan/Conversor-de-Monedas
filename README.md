### Challenge ONE Back End - Java
#Crea tu propio conversor de moneda.
##### Practicando con Java: Challenge Conversor de Monedas

- Esta app Puede convertir entre las siguientes monedas-Dólar Americano - Libras Esterlinas - Yen Japones - Euro - Won Surcoreano 
- Se selecciona una moneda de entrada en un campo desplegable con todas las opciones y luego otra entrada donde se deberá seleccionar la moneda de conversión a elegir. Agregar una cantidad y dar click al botón Convertir. El programa se encargará de realizar llamadas API a fuentes externas a a través de internet, el cual utiliza como datos para calcular la conversión. 


Para nuestro actual desafío, hemos elegido la API "Exchange Rate API" por sus tasas de cambio en tiempo real, proporcionando información precisa y actualizada para nuestras conversiones de moneda. .
:fa-money:https://www.exchangerate-api.com/

Para consumir esta API usamos la libreria Java Google Json (Gson).
**com.google.code.gson
Version 2.10.1**
Gson es una biblioteca de Java que se puede utilizar para convertir objetos Java en su representación JSON. También se puede utilizar para convertir una cadena JSON en un objeto Java equivalente. Gson puede trabajar con objetos Java arbitrarios, incluidos objetos preexistentes de los que no tiene código fuente.

Existen algunos proyectos de código abierto que pueden convertir objetos Java a JSON. Sin embargo, la mayoría de ellos requieren que coloques anotaciones Java en tus clases; algo que no puedes hacer si no tienes acceso al código fuente. La mayoría tampoco soporta completamente el uso de Java Generics. Gson considera que ambos son objetivos de diseño muy importantes.

Nota
> Gson se encuentra actualmente en modo de mantenimiento; Se corregirán los errores existentes, pero es probable que no se agreguen funciones nuevas importantes. Si desea agregar una nueva función, primero busque problemas existentes en GitHub o cree uno nuevo para analizar la función y obtener comentarios.

![](https://github.com/hmsjuan/Conversor-de-Monedas/blob/59a915e4938e806ed260fb361f7c18dab03f587e/Capturas/Captura%202.png)

![](https://github.com/hmsjuan/Conversor-de-Monedas/blob/59a915e4938e806ed260fb361f7c18dab03f587e/Capturas/Captura%201.png)

![](https://github.com/hmsjuan/Conversor-de-Monedas/blob/59a915e4938e806ed260fb361f7c18dab03f587e/Capturas/Captura%203.png)
