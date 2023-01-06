import java.io.Serializable;

public class PostazioneBean implements Serializable{
    private int idPostazione;
    private String ora;

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

    public PostazioneBean(){

    }


}