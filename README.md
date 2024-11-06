
# API - SPRING - CURSOS

Este proyecto incluye una API hecha en Spring Boot, tambien incluye el uso de ORM, con el proveedor Hibernate, la Base de Datos a usar es MySQL.

<div style="display: flex;">
<img src="https://cdn.worldvectorlogo.com/logos/spring-3.svg" alt="Logo" width="200"/>
<img src="https://upload.wikimedia.org/wikipedia/commons/2/22/Hibernate_logo_a.png" alt="Logo" width="400" />
<img src="https://media.licdn.com/dms/image/v2/C4E12AQGGhbcIA5Mi9g/article-cover_image-shrink_720_1280/article-cover_image-shrink_720_1280/0/1638274303566?e=2147483647&v=beta&t=MFSfnJ0Vv9a_Q3jX6sKieq2fubakC4-uimUEYLG5lRE" alt="Logo" width="400" />
</div>

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

