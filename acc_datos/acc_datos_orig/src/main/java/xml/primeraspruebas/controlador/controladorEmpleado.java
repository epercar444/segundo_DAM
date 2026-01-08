package xml.primeraspruebas.controlador;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import xml.primeraspruebas.modelo.Empleado;
import xml.primeraspruebas.repositorio.domEmpleado;
import xml.primeraspruebas.repositorio.domEmpleados;

public class controladorEmpleado {
	private static final Logger logger = LogManager.getLogger(controladorEmpleado.class);


	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		domEmpleado emp = new domEmpleado();
		domEmpleados emps = new domEmpleados();
		try {
			Empleado e = emp.leerEmpleadoDesdeXML("empleado.xml");
			List<Empleado> e1 = emps.leerEmpleadosDesdeXML("empleados.xml");
			logger.info(e.toString());
			logger.info(e1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
