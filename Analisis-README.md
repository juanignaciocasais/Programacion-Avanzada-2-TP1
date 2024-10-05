## Documentación con el Rol de Analista

En este proyecto realizaré una implementacion del protocolo AMQP para simular la necesidad de una tienda ecommerce al
utilizar un servicio de pagos similar a Mercado Pago.

Se debe crear un Broker para simular la implementación de un protocolo AMQP simil RabbitMQ. 
En este caso el Productor (Producer) que enviará los mensajes lo hará desde Postman simulando un checkout enviando
el mensaje (en este caso un pago) para que el Broker lo encole y aguarde el pedido del Consumer que en este caso será
también desde Postman.

### Tareas a desarrollar:
1. Setup Inicial proyecto con Java Spring
2. Crear una clase Node con sus atributos, getters y setters, 
3. Crear el constructor que obtenga la fecha y hora de creación y el id incremental del mensaje nuevo.
4. Crear un BrokerService que maneje los métodos para agregar un mensaje (addNode) a la cola, otro para obtener todos 
los mensajes de la cola (getNsdes) y un último método para obtener el primer mensaje de la cola y eliminarlo (removeNode)

Todo esto disponibilizarlo con los endpoints con los métodos GET, POST y DELETE

### Estimación del esfuerzo por cada punto detallado anteriormente:
1. 3 Puntos
2. 2 Puntos
3. 1 Punto
4. 1 Punto
