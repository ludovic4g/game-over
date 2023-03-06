package utente.model;

import java.io.Serializable;

public class IndirizzoBean implements Serializable {
    private int id;
    private String via;
    private int CAP;
    private String citta;
    private String Provincia;
    private String nome;

    public String getNome() {
		return nome;
	}

   
	public IndirizzoBean(int id, String via, int cAP, String citta, String provincia, String nome) {
		super();
		this.id = id;
		this.via = via;
		CAP = cAP;
		this.citta = citta;
		Provincia = provincia;
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
        return CAP;
    }

    public void setCAP(int CAP) {
        this.CAP = CAP;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String provincia) {
        Provincia = provincia;
    }


}