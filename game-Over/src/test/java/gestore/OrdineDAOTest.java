package gestore;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gestoreordini.model.OrdineBean;
import gestoreordini.model.OrdineDAO;

public class OrdineDAOTest {
	private OrdineDAO  dao=new OrdineDAO();
	private OrdineBean bean = new OrdineBean(109, "lucietta", new Date(2023,9,3), 89,90, "Hogwarts Legacy, FIFA 23", "In stato di conferma", 2); 
	
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
		assertTrue(dao.doRetriveByKey((bean.getIdOrdine()))!=null);
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
	public void retrieveAllByUsernameTest(){	
		try {
		assertTrue(!dao.doRetrieveAllbyUsername(bean.getUtente()).isEmpty());
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
        }


	