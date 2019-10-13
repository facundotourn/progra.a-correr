package input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class LectorArchivo {
	private String path;
	private Scanner sc;
	
	public LectorArchivo(String path) {
		this.path = path;
		try {
			sc = new Scanner(new File(this.path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.useLocale(Locale.ENGLISH);
	}
	
	public double siguienteNumero() {
		return sc.nextDouble();
	}

	public String siguienteLetra() {
		return sc.next();
	}
	
	public void cerrarLeerArchivo() {
		sc.close();
	}

}
