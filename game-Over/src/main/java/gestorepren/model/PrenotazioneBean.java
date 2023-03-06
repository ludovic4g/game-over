package gestorepren.model;

import java.io.Serializable;
import java.util.Date;

public class PrenotazioneBean implements Serializable {
    private int idPrenotazione;
    private String utente;
    private double prezzo;
    private int postiPrenotati;
    private String ora;
    private Date dataprenotazione;
    
    public Date getDataprenotazione() {
		return dataprenotazione;
	}

	public void setDataprenotazione(Date dataprenotazione) {
		this.dataprenotazione = dataprenotazione;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}


	private String stato;

    public int getIdPrenotazione() {
        return idPrenotazione;
    }

    public void setIdPrenotazione(int idPrenotazione) {
        this.idPrenotazione = idPrenotazione;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getPostiPrenotati() {
        return postiPrenotati;
    }

    public void setPostiPrenotati(int postiPrenotati) {
        this.postiPrenotati = postiPrenotati;
    }

    public String getOra() {
        return ora;
    }

    public void setOra(String ora) {
        this.ora = ora;
    }


    public PrenotazioneBean() {

    }

	public PrenotazioneBean(int idPrenotazione, String utente, double prezzo, int postiPrenotati, String ora,
			Date dataprenotazione, String stato) {
		super();
		this.idPrenotazione = idPrenotazione;
		this.utente = utente;
		this.prezzo = prezzo;
		this.postiPrenotati = postiPrenotati;
		this.ora = ora;
		this.dataprenotazione = dataprenotazione;
		this.stato = stato;
	}
    
    
    


}