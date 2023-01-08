package gestoreordini.model;

import java.io.Serializable;
import java.util.Date;

public class OrdineBean implements Serializable {
    private int idOrdine;
    private String utente;
    private Date dataAcquisto;
    private double prezzoTotale;
    private double iva;
    private String lista;
    
    public String getListaProdotti() {
    	return lista;
    }
    
    public void setListaProdotti(String lista) {
    	this.lista=lista;
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    public Date getDataAcquisto() {
        return dataAcquisto;
    }

    public void setDataAcquisto(Date dataAcquisto) {
        this.dataAcquisto = dataAcquisto;
    }

    public double getPrezzoTotale() {
        return prezzoTotale;
    }

    public void setPrezzoTotale(double prezzoTotale) {
        this.prezzoTotale = prezzoTotale;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public int getNumeroProdotti() {
        return numeroProdotti;
    }

    public void setNumeroProdotti(int numeroProdotti) {
        this.numeroProdotti = numeroProdotti;
    }

    private int numeroProdotti;

    public OrdineBean() {

    }
}