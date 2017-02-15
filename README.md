# WiFiDirect
Esta aplicación nos permite la comunicación entre dispositivos mediante Wi-Fi Direct con sistemas operativos Android 4.4 o superiores.

# Chat FIS
Información:

Wi-Fi Direct MultiChat es una aplicacion demo Android's que  
Intente superar algunas limitaciones de Wi-Fi Direct.
Por el momento,las aplicaciones convencionales no permite que un dispositivo participe simultáneamente en dos grupos de Wi-Fi Direct.

Esta aplicación trata de superar esta limitación, de hecho, un usuario puede comunicarse con un gran número de personas cercanas sin conexión a Internet, utilizando las comunicaciones punto a punto.
El objetivo principal es la gestión de múltiples chats, cola de mensajes enviados cuando la conexión no está disponible y enviarlos al mismo tiempo tan pronto como sea posible.

Chat-Fis requiere Android 4.4 KitKat (API 19) o superior. Esta elección está relacionada con el hecho de que en versiones anteriores, este protocolo era inestable y poco fiable.

Es importante recordar que se trata de una aplicación de demostración, por lo que características como la gestión de la rotación de la pantalla, dispositivo de espera, wifi no disponible y así sucesivamente, no se gestionan como un producto comercial

Los principales problemas son la "Fase de Descubrimiento" de este protocolo y la implementación de Wi-Fi Direct en Android, fueron: 
1. El tiempo de descubrimiento es demasiado alto cuando el número de dispositivos aumenta
2. Después de un tiempo determinado, un dispositivo ya no puede ser detectado por otros, por lo que necesita reiniciar la fase de detección en todos los dispositivos
3. A veces, especialmente en KitKat, la parte WiFi de Android se bloquea y la única manera de resolver este problema molesto es un reinicio completo del dispositivo

Esto demuestra que es posible ampliar el protocolo Wi-Fi Direct en Android en algunos escenarios específicos y limitados, por ejemplo, un chat

 Caracteristicas
1. Cambiar el nombre del dispositivo 
2. Mostrar una lista de dispositivos cercanos 
3. Gestionar la conexión y la desconexión entre dispositivos 
4. Mostrar la dirección IP de un dispositivo, también si es un cliente (no disponible en la API oficial de Android) 
5. Bloquear los mensajes entrantes si son demasiado cortos o vacíos (habilitados por defecto)
6. Enviar mensajes en un chat, previamente detenido, si el dispositivo asociado es detectable 
7. Pone en espera los mensajes si el dispositivo no es detectable, y envíelos todos en el siguiente intento de reconectarse 

Uso general
1. Active Wi-Fi en todos los dispositivos
2. Abra esta aplicación en todos los dispositivos
3. Toque el "boton" bajo las palabras "This Device" para elegir el nombre del dispositivo
2. Espere a que se descubran los dispositivos
3. Conecte su dispositivo a otro que toque un elemento de la lista con las palabras "Otros dispositivos"
4. Charla con este dispositivo
