package utente.model;

import java.util.ArrayList;

import gestorecatalogo.model.PostazioneBean;
import gestorecatalogo.model.TavoloBean;
import gestorecatalogo.model.VideogiocoBean;



public class Carrello {
	private ArrayList<VideogiocoBean> games;
	private ArrayList<PostazioneBean> postazioni;
	private ArrayList<TavoloBean> tavoli;
	
	public Carrello() {
		games= new ArrayList<VideogiocoBean>();
		postazioni = new ArrayList<PostazioneBean>();
		tavoli = new ArrayList<TavoloBean>();
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
	
	public void addPostazione(PostazioneBean p) {
		postazioni.add(p);
	}
	
	public void addTavolo(TavoloBean p) {
		tavoli.add(p);
	}
	
	public void removePostazione(PostazioneBean p) {
		postazioni.remove(p);
	}
	
	public void removeGame(VideogiocoBean prodotto) {
		games.remove(prodotto);
	}
	
	public void removeTavolo(TavoloBean prodotto) {
		tavoli.remove(prodotto);
	}
	
	public void clear() {
		games.clear();
		postazioni.clear();
		tavoli.clear();
	}
	
	public ArrayList<VideogiocoBean> getGames(){
		return games;
	}
	
	public ArrayList<TavoloBean> getTavoli(){
		return tavoli;
	}
	
	public ArrayList<PostazioneBean> getPostazioni(){
		return postazioni;
	}
	
	public double getTotal() {
		double fisici= 0.00;
		
		
		for(VideogiocoBean f : games) {
			fisici+=f.getPrezzo()*f.getQuantita();
		}
		
		for(PostazioneBean f : postazioni) {
			fisici+=f.getPrezzo();
		}
		
		for(TavoloBean f : tavoli) {
			fisici+=f.getPrezzoPosto()*f.getNumeroPosti();
		}
		
		
		
		return fisici;
	}
}
