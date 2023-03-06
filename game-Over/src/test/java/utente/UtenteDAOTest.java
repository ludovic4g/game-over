package utente;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utente.model.UtenteBean;
import utente.model.UtenteDAO;

public class UtenteDAOTest {
	private UtenteDAO  dao=new UtenteDAO();
	private UtenteBean bean=new UtenteBean("lucietta", "Lucia11.", "lucia@gmail.com", "Lucia", "Cognome", new Date(1994,07,03), "Salerno", false, false, false, "Femmina");
	
	@BeforeEach
	public void setUp() throws Exception{
		 dao.doSave(bean);
    }
	
	@AfterEach
    public void tearDown() throws Exception{
		dao.doDelete(bean);			
	}
	
	
	@Test
	public void retrieveByKeyTest(){	
		try {
		assertTrue(dao.doRetrieveByKey(bean.getUsername())!=null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void retrieveAllTest() {
		try {
			assertTrue(dao.doRetrieveAll()!=null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void loginTest() {
		try {
			assertTrue(dao.login(bean.getUsername(), bean.getPassword())!=null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void doRetrieveByMailTest() {
		try {
			assertTrue(dao.doRetrieveByMail(bean.getEmail())!=null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void doRetrieveRispostaTest() {
		try {
			assertTrue(dao.doRetrieveRisposta(bean.getUsername())!=null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	@Test
	public void doRetrievePasswordTest() {
		try {
			assertTrue(dao.doRetrievePassword(bean.getUsername())!=null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
        }


	