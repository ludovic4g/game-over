package gestorepren.model;

import java.io.Serializable;

public class RiferiscePTBean implements Serializable {
    private int idPrenotazione;
    private int idTavolo;

    public int getIdPrenotazione() {
        return idPrenotazione;
    }

    public void setIdPrenotazione(int idPrenotazione) {
        this.idPrenotazione = idPrenotazione;
    }

    public int getIdTavolo() {
        return idTavolo;
    }

    public void setIdTavolo(int idTavolo) {
        this.idTavolo = idTavolo;
    }

    public RiferiscePTBean() {

    }
}