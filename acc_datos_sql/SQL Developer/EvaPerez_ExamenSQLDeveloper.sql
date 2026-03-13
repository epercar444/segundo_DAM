/*Comienzo Apartado 1*/
/*Creamos el tipo VEMAIL dónde se guardarán los emails del grupo musical*/
CREATE OR REPLACE TYPE VEMAILS AS VARRAY(5) OF VARCHAR2(50);
/

/*Creamos el tipo GrupoMusical*/
CREATE OR REPLACE TYPE GRUPOMUSICAL AS OBJECT
(
    COD VARCHAR2(200),
    NOMBRE VARCHAR2(200),
    NUM_INTENGRANTES NUMBER,
    EMAILS VEMAILS
);
/

/*Creamos la tabla asociada al tipo que acabamos de crear*/
CREATE TABLE GRUPOSMUSICALES OF GRUPOMUSICAL (
    COD NOT NULL PRIMARY KEY,
    NOMBRE NOT NULL
);


/*Pruebas de insercción en la tabla GRUPOSMUSICALES*/
INSERT INTO GRUPOSMUSICALES (COD, NOMBRE, NUM_INTENGRANTES, EMAILS)
VALUES ('GRP001', 'Vetusta Morla', 6, VEMAILS('contacto@vetustamorla.com',
'contacto1@vetustamorla.com'));

INSERT INTO GRUPOSMUSICALES (COD, NOMBRE, NUM_INTENGRANTES, EMAILS)
VALUES ('GRP002', 'Izal', 5, VEMAILS('info@izalband.com'));

INSERT INTO GRUPOSMUSICALES (COD, NOMBRE, NUM_INTENGRANTES, EMAILS)
VALUES ('GRP003', 'Love of Lesbian', 5, VEMAILS('contacto@loveoflesbian.com',
'manager@loveoflesbian.com'));
COMMIT;
/
/*Final Apartado 1*/

/*Comienzo Apartado 2*/
/*Creación del tipo Concierto*/
CREATE OR REPLACE TYPE CONCIERTO AS OBJECT
(
    IDENTIFICADOR NUMBER,
    FECHA DATE,
    DESCRIPCION VARCHAR2(200),
    ESCENARIO VARCHAR2(200),
    GRUPO_MUSICAL GRUPOMUSICAL,
    
    /*Generamos el método constructor que nos pide el enunciado*/
    CONSTRUCTOR FUNCTION CONCIERTO(IDENTIFICADOR NUMBER,FECHA DATE,DESCRIPCION VARCHAR2,ESCENARIO VARCHAR2,GRUPO_MUSICAL GRUPOMUSICAL) RETURN SELF AS RESULT,
    
    /*Definimos el setter para el atributo fecha*/
    MEMBER PROCEDURE SET_FECHA(NUEVA_FECHA DATE) 
);
/

/*Creación tabla Conciertos para establecer las condiciones de los atributos*/
CREATE TABLE CONCIERTOS OF CONCIERTO (
    IDENTIFICADOR NOT NULL PRIMARY KEY
);

/*Definimos el body dónde llevaremos a cabo los métodos pedidos*/
CREATE OR REPLACE TYPE BODY CONCIERTO AS
/*Desarrollamos el constructor del tipo Concierto*/
    CONSTRUCTOR FUNCTION CONCIERTO(IDENTIFICADOR NUMBER,FECHA DATE,DESCRIPCION VARCHAR2,ESCENARIO VARCHAR2,GRUPO_MUSICAL GRUPOMUSICAL) RETURN SELF AS RESULT IS
    BEGIN
        SELF.IDENTIFICADOR := IDENTIFICADOR;
        SELF.DESCRIPCION := DESCRIPCION;
        SELF.ESCENARIO := ESCENARIO;
        SELF.GRUPO_MUSICAL := GRUPO_MUSICAL;
        /*LLamamos al método set_fecha para la validación de la misma*/
        SELF.SET_FECHA(FECHA);
        RETURN;
    END;
        
        /*Desarrollamos el setter del tipo fecha para su validación*/
        MEMBER PROCEDURE SET_FECHA(NUEVA_FECHA DATE) IS
        BEGIN
        IF NUEVA_FECHA > SYSDATE THEN
        SELF.FECHA := SYSDATE;
        ELSE 
        SELF.FECHA := NUEVA_FECHA;
        END IF;
        END;
    END;
/

/*Pruebas insercciones en la tabla Concierto*/
INSERT INTO CONCIERTOS (IDENTIFICADOR, FECHA, DESCRIPCION, ESCENARIO, GRUPO_MUSICAL)
    VALUES (1, TO_DATE('2024-06-15', 'YYYY-MM-DD'), 'Gran apertura con Vetusta Morla',
      'PRINCIPAL',GRUPOMUSICAL('GRP001', 'Vetusta Morla', 6, VEMAILS('contacto@vetustamorla.com',
    'contacto1@vetustamorla.com')));

INSERT INTO CONCIERTOS (IDENTIFICADOR, FECHA, DESCRIPCION, ESCENARIO, GRUPO_MUSICAL)
    VALUES (2, TO_DATE('2024-06-16', 'YYYY-MM-DD'), 'Noche indie con Izal',
    'ESCENARIO SECUNDARIO',GRUPOMUSICAL('GRP002', 'Izal', 5, VEMAILS('info@izalband.com')));
    
COMMIT; -- Guardamos los cambios
/

/*Comienzo Apartado 3*/
/*Creamos la tabla requerida con las condiciones que nos dice el enunciado*/
CREATE TABLE RESERVA(
    IDENTIFICADOR_RESERVA NUMBER PRIMARY KEY,
    FECHA_RESERVA DATE NOT NULL,
    CONCIERTO_RESERVA CONCIERTO
);

/*Pruebas de insercción*/
BEGIN
INSERT INTO RESERVA (IDENTIFICADOR_RESERVA,FECHA_RESERVA,CONCIERTO_RESERVA)
    VALUES (1,
    TO_DATE('2024-05-20', 'YYYY-MM-DD'),
    CONCIERTO(1, TO_DATE('2024-06-15', 'YYYY-MM-DD'), 'Gran apertura con Vetusta
    Morla', 'PRINCIPAL',GRUPOMUSICAL('GRP001', 'Vetusta Morla', 6, VEMAILS('contacto@vetustamorla.com',
    'contacto1@vetustamorla.com')))
    );
INSERT INTO  RESERVA (IDENTIFICADOR_RESERVA,FECHA_RESERVA,CONCIERTO_RESERVA)
    VALUES (2,
    TO_DATE('2024-05-21', 'YYYY-MM-DD'),
    CONCIERTO(2, TO_DATE('2024-06-16', 'YYYY-MM-DD'), 'Noche indie con Izal',
   'ESCENARIO SECUNDARIO',GRUPOMUSICAL('GRP002', 'Izal', 5, VEMAILS('info@izalband.com')))
    );
COMMIT;
END;










