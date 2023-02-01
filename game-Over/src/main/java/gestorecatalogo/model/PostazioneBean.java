package gestorecatalogo.model;

import java.io.Serializable;
import java.util.Date;

public class PostazioneBean implements Serializable {
    private int idPostazione;
    private Date data;
    public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	private String ora;

    public boolean isDisp() {
        return disp;
    }

    public void setDisp(boolean disp) {
        this.disp = disp;
    }

    private boolean disp;

    public int getIdPostazione() {
        return idPostazione;
    }

    public void setIdPostazione(int idPostazione) {
        this.idPostazione = idPostazione;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    private double prezzo;
    private String img;

    public PostazioneBean() {

    }


}