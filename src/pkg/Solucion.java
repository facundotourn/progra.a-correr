package pkg;

import input.LectorArchivo;

public class Solucion {
	private LectorArchivo lector;

	private int cantCorredores;
	private Corredor[] corredores;
	
	private Corredor[] terminaron;
	private int cantTerminaron;
	
	private int cantCategoriasFemeninas;
	private Categoria[] categoriasFemeninas;
	
	private int cantCategoriasMasculinas;
	private Categoria[] categoriasMasculinas;
	
	public Solucion(String path) {
		lector = new LectorArchivo(path);
		
		cargarDatos();
		lector.cerrarLeerArchivo();
	}
	
	private void cargarDatos() {
		cantCorredores = (int) lector.siguienteNumero();
		corredores = new Corredor[cantCorredores];
		
		cantCategoriasFemeninas = (int) lector.siguienteNumero();
		categoriasFemeninas = new Categoria[cantCategoriasFemeninas];
		
		cantCategoriasMasculinas = (int) lector.siguienteNumero();
		categoriasMasculinas = new Categoria[cantCategoriasMasculinas];
		
		cantTerminaron = (int) lector.siguienteNumero();
		terminaron = new Corredor[cantTerminaron];
		
		// carga de categorías
		for (int i = 0; i < cantCategoriasFemeninas; i++)
			categoriasFemeninas[i] = new Categoria(i + 1, (int)lector.siguienteNumero(), (int)lector.siguienteNumero());
		
		for (int i = 0; i < cantCategoriasMasculinas; i++)
			categoriasMasculinas[i] = new Categoria(i + 1, (int)lector.siguienteNumero(), (int)lector.siguienteNumero());
		
		// carga de corredores
		for (int i = 0; i < cantCorredores; i++) {
			corredores[i] = new Corredor(i + 1, (int)lector.siguienteNumero(), lector.siguienteLetra());
		}
		
		// carga de corredores que terminaron la carrera
		for (int i = 0; i < cantTerminaron; i++)
			terminaron[i] = corredores[(int)lector.siguienteNumero() - 1];
	}
	
	public void calcularPremios() {
		for (int i = 0; i < cantTerminaron; i++) { 
			if (terminaron[i].getSexo().equals("F")) {
				// Buscar en las categorias femeninas
				for (int j = 0; j < cantCategoriasFemeninas; j++) {
					if (terminaron[i].getEdad() >= categoriasFemeninas[j].getCotaInf() && 
						terminaron[i].getEdad() <= categoriasFemeninas[j].getCotaSup()) {
						categoriasFemeninas[j].premiarCorredor(terminaron[i]);
					}
				}
			} else {
				// Buscar en las categorias masculinas
				for (int j = 0; j < cantCategoriasMasculinas; j++) {
					if (terminaron[i].getEdad() >= categoriasMasculinas[j].getCotaInf() && 
						terminaron[i].getEdad() <= categoriasMasculinas[j].getCotaSup()) {
						categoriasMasculinas[j].premiarCorredor(terminaron[i]);
					}
				}
			}
		}
	}

	public void mostrarPremios() {
		for (int i = 0; i < categoriasFemeninas.length; i++) {
			Corredor oro = categoriasFemeninas[i].getOro();
			Corredor plata = categoriasFemeninas[i].getPlata();
			Corredor bronce = categoriasFemeninas[i].getBronce();			
			
			System.out.print(categoriasFemeninas[i].getId() + " ");
			System.out.print(oro == null ? "0 " : oro.getNumero() + " ");
			System.out.print(plata == null ? "0 " : plata.getNumero() + " ");
			System.out.print(bronce == null ? "0 " : bronce.getNumero() + " ");
			System.out.println();
		}
		
		for (int i = 0; i < categoriasMasculinas.length; i++) {
			Corredor oro = categoriasMasculinas[i].getOro();
			Corredor plata = categoriasMasculinas[i].getPlata();
			Corredor bronce = categoriasMasculinas[i].getBronce();			
			
			System.out.print(categoriasMasculinas[i].getId() + " ");
			System.out.print(oro == null ? "0 " : oro.getNumero() + " ");
			System.out.print(plata == null ? "0 " : plata.getNumero() + " ");
			System.out.print(bronce == null ? "0 " : bronce.getNumero() + " ");
			System.out.println();
		}
	}
}
