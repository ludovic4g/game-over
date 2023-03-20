package utente.model;

import java.io.Serializable;

public class IndirizzoBean implements Serializable {
    private int id;
    private String via;
    private int cap;
    private String citta;
    private String provincia;
    private String nome;

    public String getNome() {
		return nome;
	}

   
	public IndirizzoBean(int id, String via, int cap, String citta, String provincia, String nome) {
		super();
		this.id = id;
		this.via = via;
		this.cap = cap;
		this.citta = citta;
		this.provincia = provincia;
		this.nome = nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public IndirizzoBean() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public int getCAP() {
        return cap;
    }

    public void setCAP(int cap) {
        this.cap = cap;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }


}