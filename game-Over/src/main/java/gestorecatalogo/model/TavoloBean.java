package gestorecatalogo.model;

import java.io.Serializable;
import java.util.Date;

public class TavoloBean implements Serializable {
	private String tipo;
	public Date data;
    public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getIdTavolo() {
        return idTavolo;
    }

    public void setIdTavolo(int idTavolo) {
        this.idTavolo = idTavolo;
    }

    private int idTavolo;
    private int numeroPosti;

    public boolean isDisp() {
        return disp;
    }

    public void setDisp(boolean disp) {
        this.disp = disp;
    }

    private boolean disp;

    public int getNumeroPosti() {
        return numeroPosti;
    }

    public void setNumeroPosti(int numeroPosti) {
        this.numeroPosti = numeroPosti;
    }

    public double getPrezzoPosto() {
        return prezzoPosto;
    }

    public void setPrezzoPosto(double prezzoPosto) {
        this.prezzoPosto = prezzoPosto;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    private double prezzoPosto;
    private String ora;
    private String img;

    public TavoloBean() {

    }

}