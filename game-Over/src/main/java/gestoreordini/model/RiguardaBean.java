package gestoreordini.model;

import java.io.Serializable;

public class RiguardaBean implements Serializable {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    private int idOrdine;

    public RiguardaBean() {

    }

	public RiguardaBean(int id, int idOrdine) {
		super();
		this.id = id;
		this.idOrdine = idOrdine;
	}
    
    


}