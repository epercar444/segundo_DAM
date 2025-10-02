package Libreria.comparator;

import Libreria.modelo.Editorial;

public class Comparator implements java.util.Comparator<Editorial>{

	@Override
	public int compare(Editorial o1, Editorial o2) {
		// TODO Auto-generated method stub
		return o1.getEmail().compareTo(o2.getEmail());
	}

}
