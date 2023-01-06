import java.io.Serializable;

public class TavoloBean implements Serializable{
    public int getIdTavolo() {
        return idTavolo;
    }

    public void setIdTavolo(int idTavolo) {
        this.idTavolo = idTavolo;
    }

    private int idTavolo;
        private int numeroPosti;

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

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    private double prezzoPosto;
        private String ora;
        private int img;

        public TavoloBean(){

        }

}