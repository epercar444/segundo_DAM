/*Creación del tipo DIRECCIÓN*/
CREATE OR REPLACE TYPE DIRECCION AS OBJECT
(
    CIUDAD VARCHAR2(200),
    CALLE VARCHAR2(200),
    NUMERO NUMBER,
    CODIGO_POSTAL NUMBER,
    
    /*Definimos los métoodos que vamos a necesitar de este tipo*/
    MEMBER FUNCTION getDireccion RETURN VARCHAR2
);
/

/*Definimos el body del tipo que acabamos de crear*/
CREATE OR REPLACE TYPE BODY DIRECCION AS
    MEMBER FUNCTION getDireccion RETURN VARCHAR2 IS
        v_retorno VARCHAR2(32767) := CIUDAD || ',' || CALLE || ',' || NUMERO || '(' || CODIGO_POSTAL || ')' || CHR(10);
    BEGIN
        RETURN v_retorno;
    END;
END;
/

/*Creamos el tipo VArray de Teléfonos*/
CREATE OR REPLACE TYPE VTELEFONOS AS VARRAY(3) OF NUMBER(14);
/

/*Creamos la secuencia que hará autogenerados los identificadores de nuestros clientes*/
CREATE SEQUENCE cliente_sec
	START WITH 1
	INCREMENT BY 1
	MAXVALUE 99999
	MINVALUE 1
	NOCYCLE;
/

/*Creación del tipo Cliente*/
CREATE OR REPLACE TYPE CLIENTE AS OBJECT 
(
    IDENTIFICADOR NUMBER,
    DNI VARCHAR2(9),
    NOMBRE VARCHAR2(200),
    C_DIRECCION DIRECCION,
    TELEFONOS VTELEFONOS,
    
    /*Creamos el constructor por defecto con todos sus atributos*/
    CONSTRUCTOR FUNCTION CLIENTE (IDENTIFICADOR NUMBER, DNI VARCHAR2, NOMBRE VARCHAR2,C_DIRECCION DIRECCION,TELEFONOS VTELEFONOS)
    RETURN SELF AS RESULT,
    
    /*Creamos el constructor personalizado, sin el identificador*/
    CONSTRUCTOR FUNCTION CLIENTE (NOMBRE VARCHAR2,DNI VARCHAR2,C_DIRECCION DIRECCION,TELEFONOS VTELEFONOS)
    RETURN SELF AS RESULT,
    
    /*Creamos la función que nos devolverá los números de teléfonos*/
    MEMBER FUNCTION getTelefonos RETURN VARCHAR2
);
/

/*Definimos el body del tipo Cliente*/
CREATE OR REPLACE TYPE BODY CLIENTE AS
    CONSTRUCTOR FUNCTION CLIENTE(IDENTIFICADOR NUMBER, DNI VARCHAR2, NOMBRE VARCHAR2, C_DIRECCION DIRECCION, TELEFONOS VTELEFONOS) 
    RETURN SELF AS RESULT IS
    BEGIN
        SELF.IDENTIFICADOR := IDENTIFICADOR;
        SELF.DNI := DNI;
        SELF.NOMBRE := NOMBRE;
        SELF.C_DIRECCION := C_DIRECCION;
        SELF.TELEFONOS := TELEFONOS;
        RETURN;
    END;
    
    CONSTRUCTOR FUNCTION CLIENTE(NOMBRE VARCHAR2, DNI VARCHAR2, C_DIRECCION DIRECCION, TELEFONOS VTELEFONOS) 
    RETURN SELF AS RESULT IS
    BEGIN
        SELF.IDENTIFICADOR := cliente_sec.NEXTVAL;
        SELF.DNI := DNI;
        SELF.NOMBRE := NOMBRE;
        SELF.C_DIRECCION := C_DIRECCION;
        SELF.TELEFONOS := TELEFONOS;
        RETURN;
    END;
    
    /*Formato de salida de los teléfonos del cliente*/
    MEMBER FUNCTION getTelefonos RETURN VARCHAR2 IS
      auxVariable VARCHAR2(32767) := NULL; -- 14*3+2 3 teléfonos de 14 caracters + los dos []
      BEGIN
          IF SELF.TELEFONOS IS NOT NULL THEN
            auxVariable := '[';
            FOR i IN 1..SELF.TELEFONOS.COUNT LOOP
              auxVariable := CONCAT(auxVariable , SELF.TELEFONOS(i));
              IF i < SELF.TELEFONOS.COUNT THEN
                auxVariable := CONCAT(auxVariable , ', ');
              END IF;
            END LOOP;
            auxVariable := CONCAT(auxVariable , ']');
          END IF;
     RETURN  auxVariable ;
        END;
END;
/

/*Definimos el tipo Coche*/
CREATE OR REPLACE TYPE COCHE AS OBJECT
(
    BASTIDOR VARCHAR2(17),
    MATRICULA VARCHAR2(6),
    MARCA VARCHAR2(200)
)
/

/*Definimos el tipo Reparación*/
CREATE OR REPLACE TYPE REPARACION AS OBJECT
(
    R_COCHE COCHE,
    F_INGRESO DATE,
    F_SALIDA DATE,
    R_REPARACIONES VARCHAR2(200),
    R_CLIENTE CLIENTE,
    
    /*Definimos los métodos de este tipo*/
    STATIC PROCEDURE INSERTAR(R_COCHE COCHE, F_INGRESO DATE, F_SALIDA DATE,R_REPARACIONES VARCHAR2,R_CLIENTE CLIENTE),
    
    STATIC PROCEDURE INSERTAR(REPARACION_INSERT REPARACION)
)
/

/*Creamos el body del tipo que acabamos de definir*/
CREATE OR REPLACE TYPE BODY REPARACION AS
    STATIC PROCEDURE INSERTAR(R_COCHE COCHE, F_INGRESO DATE, F_SALIDA DATE,R_REPARACIONES VARCHAR2,R_CLIENTE CLIENTE) IS
    BEGIN
        INSERT INTO REPARACIONES VALUES (R_COCHE, F_INGRESO, F_SALIDA, R_REPARACIONES, R_CLIENTE);
    END;
    
    STATIC PROCEDURE INSERTAR(REPARACION_INSERT REPARACION) IS
    BEGIN
        REPARACION.INSERTAR(
            REPARACION_INSERT.R_COCHE, 
            REPARACION_INSERT.F_INGRESO, 
            REPARACION_INSERT.F_SALIDA, 
            REPARACION_INSERT.R_REPARACIONES, 
            REPARACION_INSERT.R_CLIENTE
        );
    END;
END;
/

/*Creamos la tabla que contendrá las condiciones de los atributos de nuestra Reparacióm*/
CREATE TABLE REPARACIONES OF REPARACION 
(
    R_COCHE NOT NULL,
    F_INGRESO NOT NULL,
    R_CLIENTE NOT NULL
)
/

/*Comprobamos que los teléfonos se formatea de forma correcta*/
DECLARE
    clinull CLIENTE := NEW CLIENTE('Ana Nula',   '11111111A', NULL, NULL);
    cli0    CLIENTE := NEW CLIENTE('Pablo Vacio', '22222222B', NULL, NEW VTELEFONOS());
    cli1    CLIENTE := NEW CLIENTE('Luis Uno',    '33333333C', NULL, NEW VTELEFONOS(1111));
    cli2    CLIENTE := NEW CLIENTE('Rosa Dos',    '44444444D', NULL, NEW VTELEFONOS(1111, 2222));
BEGIN
    DBMS_OUTPUT.PUT_LINE(NVL(clinull.getTelefonos(), '(sin teléfonos)'));
    DBMS_OUTPUT.PUT_LINE(NVL(cli0.getTelefonos(),    '(sin teléfonos)'));
    DBMS_OUTPUT.PUT_LINE(cli1.getTelefonos());
    DBMS_OUTPUT.PUT_LINE(cli2.getTelefonos());
END;
/


/*Preparación de la tabla*/
DELETE FROM REPARACIONES;
COMMIT;
/

/*Insercción con parámetros sueltos*/
BEGIN
    REPARACION.INSERTAR(
        COCHE('No se el bastidor', 'SEISUN', 'Mercedes'), 
        TO_DATE('10/01/2023','DD/MM/YYYY'),
        TO_DATE('15/01/2023','DD/MM/YYYY'),
        'Cambio de aceite', 
        NEW CLIENTE('Pablo', '49494949A',
                    DIRECCION('Sevilla', 'C/ la mia', 1, 11111), 
                    VTELEFONOS(1111))
    );
    COMMIT;
END;
/

/*Insercción objeto completo*/
DECLARE
    reparacion1 REPARACION := NEW REPARACION(
        COCHE('muchos numeros', '2222', 'Audi'), 
        TO_DATE('10/01/2023','DD/MM/YYYY'),
        TO_DATE('15/01/2023','DD/MM/YYYY'),
        'Rueda pinchada', 
        NEW CLIENTE(cliente_sec.NEXTVAL, '11111111A', 'Ana',
                    DIRECCION('Sevilla', 'C/ la otra', 3, 11111), 
                    VTELEFONOS(NULL))
    );
BEGIN
    REPARACION.INSERTAR(reparacion1);
    COMMIT;
END;
/

/*Verificación datos*/
SELECT 
    r.R_COCHE.MARCA, 
    r.R_CLIENTE.NOMBRE, 
    r.R_CLIENTE.getTelefonos(), 
    r.R_REPARACIONES 
FROM REPARACIONES r;













