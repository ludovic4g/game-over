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
		for(PostazioneBean o : postazioni) {
		if(p.getIdPostazione()==o.getIdPostazione())
			return;
		}
		postazioni.add(p);
		
	}
	
	public void addTavolo(TavoloBean p) {
		for(TavoloBean o : tavoli) {
			if(p.getIdTavolo()==o.getIdTavolo())
				return;
			}
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
		double total= 0.00;
		
		
		for(VideogiocoBean f : games) {
			total+=f.getPrezzo()*f.getQuantita();
		}
		
		for(PostazioneBean f : postazioni) {
			total+=f.getPrezzo();
		}
		
		for(TavoloBean f : tavoli) {
			total+=f.getPrezzoPosto()*f.getNumeroPosti();
		}
		
		
		
		return total;
	}
	
	public boolean isEmpty() {
		return games.isEmpty() &&postazioni.isEmpty() && tavoli.isEmpty();
	}
}
