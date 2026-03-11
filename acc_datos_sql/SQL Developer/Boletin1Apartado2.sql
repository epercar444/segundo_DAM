/*Creamos tipo VProductos*/
CREATE OR REPLACE TYPE VPRODUCTOS AS VARRAY(15) OF PRODUCTO;
/

/*Creación tipo tienda*/
CREATE OR REPLACE TYPE TIENDA AS OBJECT 
(
    ID NUMBER,
    NOMBRE VARCHAR2(200),
    PRODUCTOS VPRODUCTOS,
    
    /*Definimos el Member(ToString) que devolverá los valores con el formato que le demos*/
    MEMBER FUNCTION getProductos RETURN VARCHAR2,
    
    /*Definimos el constructor con los valores que no vamos a inicializar con un valor por defecto*/
    CONSTRUCTOR FUNCTION TIENDA (ID NUMBER, NOMBRE VARCHAR2,PRODUCTOS VPRODUCTOS)
    RETURN SELF AS RESULT
);
/

/*Definimos el cuerpo del tipo, lo que define sus constructores y cómo saldrán definidos los tipos Producto*/
CREATE OR REPLACE TYPE BODY TIENDA AS
    CONSTRUCTOR FUNCTION TIENDA(ID NUMBER, NOMBRE VARCHAR2, PRODUCTOS VPRODUCTOS) 
    RETURN SELF AS RESULT IS
    BEGIN
        SELF.ID := ID;
        SELF.NOMBRE := NOMBRE;
        SELF.PRODUCTOS := PRODUCTOS;
        RETURN;
    END;

    MEMBER FUNCTION getProductos RETURN VARCHAR2 IS
        v_retorno VARCHAR2(32767) := 'Tienda ' || ID || ': ' || NOMBRE || CHR(10);
    BEGIN
        FOR i IN 1..PRODUCTOS.COUNT LOOP
            v_retorno := v_retorno || PRODUCTOS(i).getInformacion() || CHR(10);
        END LOOP;
        RETURN v_retorno;
    END;
END;
/

/*Definimos la tabla*/
CREATE TABLE TIENDAS OF TIENDA (
    ID PRIMARY KEY
);

/*Creación de tiendas y productos*/
INSERT INTO TIENDAS VALUES (
    TIENDA(1, 'Tech World', VProductos(
        PRODUCTO(SEQ_PRODUCTOS.NEXTVAL, 'Teclado'),
        PRODUCTO(SEQ_PRODUCTOS.NEXTVAL, 'Monitor'),
        PRODUCTO(SEQ_PRODUCTOS.NEXTVAL, 'Raton'),
        PRODUCTO(SEQ_PRODUCTOS.NEXTVAL, 'Altavoces'),
        PRODUCTO(SEQ_PRODUCTOS.NEXTVAL, 'Microfono')
    ))
);
INSERT INTO TIENDAS VALUES (
    TIENDA(2, 'Gaming Center', VProductos(
        PRODUCTO(SEQ_PRODUCTOS.NEXTVAL, 'Silla Gamer'),
        PRODUCTO(SEQ_PRODUCTOS.NEXTVAL, 'Cascos 7.1'),
        PRODUCTO(SEQ_PRODUCTOS.NEXTVAL, 'Mando Pro'),
        PRODUCTO(SEQ_PRODUCTOS.NEXTVAL, 'Webcam 4K'),
        PRODUCTO(SEQ_PRODUCTOS.NEXTVAL, 'Alfombrilla LED')
    ))
);
INSERT INTO TIENDAS VALUES (
    TIENDA(3, 'Office Depot', VProductos(
        PRODUCTO(SEQ_PRODUCTOS.NEXTVAL, 'Laptop 15'),
        PRODUCTO(SEQ_PRODUCTOS.NEXTVAL, 'Impresora Laster'),
        PRODUCTO(SEQ_PRODUCTOS.NEXTVAL, 'Escaner'),
        PRODUCTO(SEQ_PRODUCTOS.NEXTVAL, 'Disco Externo'),
        PRODUCTO(SEQ_PRODUCTOS.NEXTVAL, 'Hub USB-C')
    ))
);

/*Consultas*/
SELECT t.NOMBRE FROM TIENDAS t; /*Devuelvo los nombres de todas las tiendas*/
SELECT p.ID,p.NOMBRE,p.PRECIO FROM TIENDAS t,TABLE(t.PRODUCTOS) p WHERE t.NOMBRE = 'Tech World'; /*Muestra los productos de aquella tienda que coincida con el nombre que hemos definido*/

/*Consulta todas las tiendas y todos los productos de las mismas. El resultado sale por consola, no como una consulta normal*/
SET SERVEROUTPUT ON;
BEGIN
    FOR t IN (SELECT VALUE(t) as obj FROM TIENDAS t) LOOP
        DBMS_OUTPUT.PUT_LINE(t.obj.getProductos());
    END LOOP;
END;
/

