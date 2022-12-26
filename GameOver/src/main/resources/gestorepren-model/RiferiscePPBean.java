import java.io.Serializable;

public class RiferiscePPBean implements Serializable{
    private int idPrenotazione;
    private int idPostazione;

    public int getIdPrenotazione() {
        return idPrenotazione;
    }

    public void setIdPrenotazione(int idPrenotazione) {
        this.idPrenotazione = idPrenotazione;
    }

    public int getIdPostazione() {
        return idTavolo;
    }

    public void setIdPostazione(int idPostazione) {
        this.idPostazione = idPostazione;
    }

    public RiferiscePPBean(){

    }
}