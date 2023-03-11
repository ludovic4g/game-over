package gestore;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gestorepren.model.PrenotazioneBean;
import gestorepren.model.PrenotazioneDAO;

public class PrenotazioneDAOTest {
	private PrenotazioneDAO  dao=new PrenotazioneDAO();
	private PrenotazioneBean bean = new PrenotazioneBean(220, "lucietta", 5.99, 2, "14:30-16:30", new Date(2023,3,8), "In stato di conferma"); 
	
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
		assertTrue(dao.doRetrieveByKey((bean.getIdPrenotazione()))!=null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void retrieveAllTest(){	
		try {
		assertTrue(!dao.doRetrieveAll().isEmpty());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void retrieveByDatesTest(){	
		try {
		assertTrue(!dao.doRetriveByDates("2021-09-03", "2023-08-16").isEmpty());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void retrieveUsernamAZTest(){	
		try {
		assertTrue(!dao.doRetriveUsernameAZ().isEmpty());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void retrieveUsernamZATest(){	
		try {
		assertTrue(!dao.doRetriveUsernameZA().isEmpty());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void retrieveAllByKeyTest(){	
		try {
		assertTrue(!dao.doRetriveAllByKey(bean.getUtente()).isEmpty());
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
        }


	