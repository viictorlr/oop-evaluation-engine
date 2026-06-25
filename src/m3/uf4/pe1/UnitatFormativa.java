package m3.uf4.pe1;

public class UnitatFormativa {

	private String cicle;
	private String modul;
	private int num;
	private String titol;
	private int hores;

	public UnitatFormativa(String cicle, String modul, int num, String titol, int hores) {
		this.cicle = (cicle != null) ? cicle : "";
		this.modul = (modul != null) ? modul : "";
		this.num = (num >= 1) ? num : 1;
		this.titol = (titol != null) ? titol : "";
		this.hores = (hores >= 10) ? hores : 10;
	}

	public void setCicle(String cicle) {
		this.cicle = cicle;
	}

	public void setModul(String modul) {
		this.modul = modul;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setTitol(String titol) {
		this.titol = titol;
	}

	public void setHores(int hores) {
		this.hores = hores;
	}

	public String getCicle() {
		return cicle;
	}

	public String getModul() {
		return modul;
	}

	public int getNum() {
		return num;
	}

	public String getTitol() {
		return titol;
	}

	public int getHores() {
		return hores;
	}
}
