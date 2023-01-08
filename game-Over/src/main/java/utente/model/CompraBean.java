package utente.model;

import java.io.Serializable;

public class CompraBean implements Serializable {
    private String username;
    private int idVideogioco;

    public CompraBean() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getIdVideogioco() {
        return idVideogioco;
    }

    public void setIdVideogioco(int idVideogioco) {
        this.idVideogioco = idVideogioco;
    }


}