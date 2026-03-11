/*Creación tipo */
CREATE OR REPLACE TYPE PRODUCTO AS OBJECT 
(
    ID NUMBER,
    NOMBRE VARCHAR(200),
    PRECIO NUMBER,
    
    /*Definimos el Member(ToString) que devolverá los valores con el formato que le demos*/
    MEMBER FUNCTION getInformacion RETURN VARCHAR,
    
    /*Definimos el constructor con los valores que no vamos a inicializar con un valor por defecto*/
    CONSTRUCTOR FUNCTION PRODUCTO (ID NUMBER, NOMBRE VARCHAR)
    RETURN SELF AS RESULT
);
/

/*Definición de la secuencia que hará que nuestro id sea autogenerado*/
CREATE SEQUENCE SEQ_PRODUCTOS START WITH 1 INCREMENT BY 1;

/*Creación tabla dónde definimos las condiciones de nuestros atributos*/
CREATE TABLE PRODUCTOS OF PRODUCTO
(
    ID DEFAULT SEQ_PRODUCTOS.NEXTVAL PRIMARY KEY
);

/*Creamos un body para Producto donde inicializamos sus atributos, contando con el que tiene un valor determinado*/
/*Definimos también el ToString(Java) con el formato de salida, en SQL se le conoce como MEMBER FUNCTION*/
CREATE OR REPLACE TYPE BODY PRODUCTO AS
    CONSTRUCTOR FUNCTION PRODUCTO(ID NUMBER, NOMBRE VARCHAR) 
    RETURN SELF AS RESULT IS
    BEGIN
        SELF.ID := ID;
        SELF.NOMBRE := NOMBRE;
        SELF.PRECIO := 1;
        RETURN;
    END;

    MEMBER FUNCTION getInformacion RETURN VARCHAR IS
    BEGIN
        RETURN 'Producto ' || id || ': ' || nombre || ', Precio: ' || precio;
    END;
END;
/

/*Insertamos un valor para comprobar la funcionalidad de nuestros métodos*/
INSERT INTO PRODUCTOS VALUES (PRODUCTO(SEQ_PRODUCTOS.NEXTVAL, 'Ratón Óptico'));
SELECT * FROM PRODUCTOS;
SELECT p.getInformacion() FROM PRODUCTOS p;
