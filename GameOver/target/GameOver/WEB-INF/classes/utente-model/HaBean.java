import java.io.Serializable;

public class HaBean implements Serializable{
    private int idIndirizzo;
    private String username;

    public HaBean(){

    }

    public int getIdIndirizzo() {
        return idIndirizzo;
    }

    public void setIdIndirizzo(int idIndirizzo) {
        this.idIndirizzo = idIndirizzo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



}