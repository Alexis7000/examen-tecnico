# examen-tecnico
Desarrollo backend - microservicios

## Instalación

Sigue estos pasos para instalar y ejecutar el proyecto en tu entorno local.

1. Clonar el repositorio:
   git clone https://github.com/Alexis7000/examen-tecnico.git
2. ejecutar en el id

## USO

cuerpo del json desde el postman (h2 nos proporciona una base de datos temporal):

POST /tarea
{
    "titulo": "Nueva Tarea",
    "descripcion": "Descripción de la tarea",
    "estado": "PENDIENTE",
    "fechaVencimiento": "2024-12-31"
}

## Control de errores
para llevar el control de errores hacemos lo siguiente

ENTRADA:

POST /tarea
{
    "descripcion": "Descripción de la tarea",
    "estado": "PENDIENTE",
    "fechaVencimiento": "2024-12-31"
}

SALIDA:

{
    "message": "El título de la tarea no puede estar vacío."
}

