# API PARA INDITEX

En este proyecto abordaremos la creación de una API desde cero.

## Tabla de Contenidos
1. [Instalación](#instalación)
2. [Ejercicios](#ejercicios)
3. [Contacto](#contacto)


## Instalación

Instrucciones de uso:
1. Ejecuta los comandos: 
    ```bash
    ./mvnw clean install
    ```
    ```bash
    ./mvnw spring-boot:run
    ```

Requisitos mínimos:
- Java Version: 17
- Spring Boot Version: 3.4.0


## Ejercicios

Al inicio de la aplicación, se cargan automáticamente los archivos schema.sql y data.sql, que insertam en la base de datos H2 la tabla de ejemplo con datos (PRICES), que utilizaremos a modo de ejemplo.

Los endpoints están securizados, por lo que es necesario Basic Auth para acceder a ellos.

Tenemos dos tipos de usuarios:
- Username: user, Password: password, Role: USER.
- Username: admin, Password: admin, Role: ADMIN.


### Ejercicio 1

Crear un endpoint rest que acepte como parámetros de entrada: fecha de aplicación, identificador de producto, identificador de cadena.
Devuelva como datos de salida: identificador de producto, identificador de cadena, tarifa a aplicar, fechas de aplicación y precio final a aplicar.


## Tests

En la clase PriceApplicationTests hay tests unitarios que prueban el endpoint con los diferentes datos de entrada pedidos en el enunciado.


## Contacto

Prueba realizada por Iván Acebedo Herrera.

Email de contacto: iacebedoherrera@gmail.com