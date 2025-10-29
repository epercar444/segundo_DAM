package xml.primeraspruebas.controlador;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import xml.primeraspruebas.DOM.domEmpleado;
import xml.primeraspruebas.modelo.Empleado;

public class controladorEmpleado {
	private static final Logger logger = LogManager.getLogger(controladorEmpleado.class);


	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		domEmpleado emp = new domEmpleado();
		try {
			Empleado e = emp.leerEmpleadoDesdeXML("empleado.xml");
			logger.info(e.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
