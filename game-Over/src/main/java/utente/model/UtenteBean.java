package utente.model;

import java.io.Serializable;
import java.util.Date;
import java.util.regex.Pattern;

public class UtenteBean implements Serializable {
    private String username;
    private String password;
    private String email;
    private String nome;
    private String cognome;
    private Date bday;
    private String risposta;
    private boolean amm1;
    private boolean amm2;
    private boolean amm3;
    private String domanda;
    public String getDomanda() {
		return domanda;
	}

	public void setDomanda(String domanda) {
		this.domanda = domanda;
	}

	public UtenteBean(String username, String password, String email, String nome, String cognome, Date bday,
			String risposta, boolean amm1, boolean amm2, boolean amm3, String sex) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
		this.bday = bday;
		this.risposta = risposta;
		this.amm1 = amm1;
		this.amm2 = amm2;
		this.amm3 = amm3;
		this.sex = sex;
	}

	private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public UtenteBean() {
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getBday() {
        return bday;
    }

    public void setBday(Date bday) {
        this.bday = bday;
    }

    public String getRisposta() {
        return risposta;
    }

    public void setRisposta(String risposta) {
        this.risposta = risposta;
    }

    public boolean isGestoreCatalogo() {
        return amm1;
    }

    public void setGestoreCatalogo(boolean amm1) {
        this.amm1 = amm1;
    }

    public boolean isGestorePrenotazioni() {
        return amm2;
    }

    public void setGestorePrenotazioni(boolean amm2) {
        this.amm2 = amm2;
    }

    public boolean isGestoreOrdini() {
        return amm3;
    }

    public void setGestoreOrdini(boolean amm3) {
        this.amm3 = amm3;
    }

    public boolean passConferma(String s, String m) {
        if(s.equals(m)) return true;

        return false;
    }

    public boolean passControl(String f){
        if (f.length() < 8) return false;

        int charCount = 0;
        int numCount = 0;
        for (int i = 0; i < f.length(); i++) {

            char ch = f.charAt(i);

            if (is_Numeric(ch)) numCount++;
            else if (is_LetterSp(ch)) charCount++;
        }


        return (charCount >= 1 && numCount >= 1);
    }

    public boolean is_LetterSp(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= '!' && ch <= '/') || (ch>= ':' && ch <= '@') || (ch>= '-' && ch<='.');
    }


    public boolean is_Numeric(char ch) {

        return (ch >= '0' && ch <= '9');
    }

    public boolean mailIsValid(String m){
        //String pttrn = "^(.+)@(\\S+)$";
        return m.contains("@") && m.contains(".");
    }
    
    public boolean isValid(String g) {
    	for(int i=0; i<g.length(); i++) {
    		if(is_Numeric(g.charAt(i))) return false;
    		if(is_LetterSp(g.charAt(i))) return false;
    	}
    	
    	return true;
    }
    
    public boolean existLetterSp(String f) {
    	for(int i =0; i<f.length(); i++) {
    		if((f.charAt(i) >= '!' && f.charAt(i) <= '/') || (f.charAt(i)>= ':' && f.charAt(i) <= '@') || (f.charAt(i)>= '-' && f.charAt(i)<='.')) return true; 
    	}
    	
    	return false;
    }
    
    public boolean existLetter(String f) {
    	for(int i =0; i<f.length(); i++) {
    		if((f.charAt(i)>='a' && f.charAt(i)<='z') || (f.charAt(i)>='A' && f.charAt(i)<='Z')) return true;
    	}
    	return false;
    }


}