package utente.model;

import java.util.ArrayList;

import gestorecatalogo.model.VideogiocoBean;



public class Carrello {
	private ArrayList<VideogiocoBean> games;
	
	public Carrello() {
		games= new ArrayList<VideogiocoBean>();
	}
	
	public void addGame(VideogiocoBean v, int quantita) {
		for(VideogiocoBean f: games) {
			if(f.getId()==(v.getId())) {
				f.setQuantita(f.getQuantita() +quantita);
				return;
			}
		}
		v.setQuantita(quantita);
		games.add(v);
	}
	
	public void removeGame(VideogiocoBean prodotto) {
		games.remove(prodotto);
	}
	
	public void clear() {
		games.clear();
	}
	
	public ArrayList<VideogiocoBean> getGames(){
		return games;
	}
	
	public double getTotal() {
		double fisici= 0.00;
		
		
		for(VideogiocoBean f : games) {
			fisici+=f.getPrezzo()*f.getQuantita();
		}
		
		return fisici;
	}
}
