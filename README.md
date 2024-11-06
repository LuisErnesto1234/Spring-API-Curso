
# API - SPRING - CURSOS

Este proyecto incluye una API hecha en Spring Boot, tambien incluye el uso de ORM, con el proveedor Hibernate, la Base de Datos a usar es MySQL.


![Logo](https://cdn.worldvectorlogo.com/logos/spring-3.svg)


## API Referencia

#### Obtener todos los registros sobre alumnos

```http
  GET http://localhost:8080/api/alumnos
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Tu llave API |

#### Obtener un solo alumno

```http
  GET http://localhost:8080/api/alumnos/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

#### add(1, 2)

#### Editar alumno

```http
  PUT http://localhost:8080/api/alumnos/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. ID del alumno |

#### Editar alumno

```http
  DELETE http://localhost:8080/api/alumnos/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `INTEGER` | **Required**. ID del alumno |

Para las rutas de cursos y registros la API recibe los datos de la siguiente manera:

#### Obtener todos los registros sobre cursos

```http
  GET http://localhost:8080/api/cursos
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Tu llave API |

#### Obtener todos los registros sobre alumnos

```http
  GET http://localhost:8080/api/registros
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Tu llave API |

El cuerpo JSON para el registro se ve asi:

```http
[
    {
        "id": 1,
        "alumno": {
            "id": 1,
            "nombre": "Juan",
            "apellido": "Pérez",
            "correo": "juan.perez@example.com",
            "telefono": "123456789",
            "fechaNacimiento": "2000-01-01",
            "perfilUrl": "uploads/navidad/1.jpg"
        },
        "curso": {
            "idCurso": 1,
            "nombreCurso": "Programación en PHP",
            "descripcion": "Curso básico de programación en PHP",
            "duracionHoras": 40,
            "id": 1
        },
        "fechaRegistro": "2024-11-06",
        "estadoRegistro": "activo"
    }
]
```
## Soporte

Para soporte escribir a: email 1343451@senati.pe.


## Authors

- [@LuisErnesto1234](https://github.com/LuisErnesto1234)

