package pkg;

public class Categoria {
	private int cotaInf;
	private int cotaSup;
	private int id;

	private Corredor oro;
	private Corredor plata;
	private Corredor bronce;
	
	public Categoria(int id, int cotaInf, int cotaSup) {
		this.id = id;
		this.cotaInf = cotaInf;
		this.cotaSup = cotaSup;
	}
	
	public void premiarCorredor(Corredor c) {
		if (oro == null)
			oro = c;
		else if (plata == null)
			plata = c;
		else if (bronce == null)
			bronce = c;
	}

	public int getCotaInf() {
		return cotaInf;
	}

	public void setCotaInf(int cotaInf) {
		this.cotaInf = cotaInf;
	}

	public int getCotaSup() {
		return cotaSup;
	}

	public void setCotaSup(int cotaSup) {
		this.cotaSup = cotaSup;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Corredor getOro() {
		return oro;
	}

	public void setOro(Corredor oro) {
		this.oro = oro;
	}

	public Corredor getPlata() {
		return plata;
	}

	public void setPlata(Corredor plata) {
		this.plata = plata;
	}

	public Corredor getBronce() {
		return bronce;
	}

	public void setBronce(Corredor bronce) {
		this.bronce = bronce;
	}
	
}
