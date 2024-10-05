## Documentación con el Rol de Desarrollador

Para iniciar el proyecto primero debemos tener instalado java version >= openjdk 17.0.12

Clonar el repositorio:
```
git clone https://github.com/juanignaciocasais/Programacion-Avanzada-2-TP1.git
```
Luego parados en la raiz del proyecto ejecutamos:
```
./mvnw spring-boot:run --quiet
```

### Endpoints:
- GET    http://localhost:8080/queue (Para ver la cola con cada uno de sus nodos/mensajes)
- POST   http://localhost:8080/queue/push (Agrega mensajes a la cola)
- DELETE http://localhost:8080/queue/pop (Obtiene el mensaje correspondiente de la cola con el concepto FIFO)

Ejemplo de los parámetros del body agregar mensajes a la cola

| Parámetro   | Tipo de Dato  | Descripción                                                         |
|:------------|:--------------|:--------------------------------------------------------------------|
| message     | [string]      | Mensaje a envíar (Tarea pendiente n°1)                              |
| to          | [string]      | Indica a que Consiumer corresponde el mensaje (Tarea pendiente n°2) |
| state       | [string]      | Indica el estado del Mensaje (Tarea pendiente n°3)                  |
| priority    | [string]      | Indica la prioridad del Mensaje                                     |
| userId      | [string]      | Indica el ID del usuario (Producer) del mensaje                     |
| contentType | [string]      | Indica el tipo de tato que contiene el mensaje                      |
| expiryTime  | [int]         | Indica el tiempo de expiración del mensaje                          |

Body en formato JSON
```json
    {
        "message": "este es mi mensaje",
        "to": "mp",
        "state": "creado",
        "priority": 1,
        "userId": "1",
        "contentType": "json",
        "replyTo": "ecommerce",
        "expiryTime": "25"
    }
```
Ejemplo de respuesta JSON al crear el mensaje en el Broker con el enpoint push o al obtener un mensaje con el método pop 
```json
{
    "message": "este es mi mensaje",
    "to": "mp",
    "state": "creado",
    "priority": 1,
    "creationTime": "2024-10-05T01:13:01.028093715",
    "messageId": 2,
    "userId": "1",
    "contentType": "json",
    "replyTo": "ecommerce",
    "expiryTime": "25"
}
```
#### Tareas pendientes
1. El atributo mensaje debe permitir un formato Json para darle flexibilidad a los mensajes.
2. Crear un filtro en el método GET y DELETE para el atributo "to" para poder obtener los mensajes que correspondan a 
cada Consumer y flexibilidad al Broker para manejar Producers y Consumers de diferente necesidad
3. Crear la clase State para ir cambiando los estados de los mensajes desde el Broker y que al crearse estén seteados 
como AVAILABLE
