import java.io.Serializable;

public class IncludeBean implements Serializable{
    public int getIdPrenotazione() {
        return idPrenotazione;
    }

    public void setIdPrenotazione(int idPrenotazione) {
        this.idPrenotazione = idPrenotazione;
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    private int idPrenotazione;
    private int idOrdine;
    public IncludeBean(){

    }


}