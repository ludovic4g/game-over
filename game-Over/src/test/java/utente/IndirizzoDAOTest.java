package utente;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import utente.model.IndirizzoBean;
import utente.model.IndirizzoDAO;

public class IndirizzoDAOTest {
	private IndirizzoDAO  dao=new IndirizzoDAO();
	private IndirizzoBean bean= new IndirizzoBean(45, "Via Pozzilli 3", 84099, "San Cipriano Picentino", "SA",  "Lucia Genovese");
	
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
		assertTrue(dao.doRetrieveByKey((bean.getId()))!=null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void retrieveAllTest(){	
		try {
		assertTrue(dao.doRetrieveAll()!=null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void retrieveAllByIdTest(){	
		try {
		assertTrue(dao.doRetrieveAllById(bean.getId())!=null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

        }


	