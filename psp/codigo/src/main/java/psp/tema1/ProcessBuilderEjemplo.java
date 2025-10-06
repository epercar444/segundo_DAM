package psp.tema1;

import java.io.IOException;

public class ProcessBuilderEjemplo {

	public static void main(String[] args) {
		String[] comando = {"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"};
			    ProcessBuilder pb = new ProcessBuilder(comando);
			    try {
					Process p = pb.start();
					pb.start();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


	}

}
