package gestore;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gestorecatalogo.model.TavoloBean;
import gestorecatalogo.model.TavoloDAO;

public class TavoloDAOTest {
	private TavoloDAO  dao=new TavoloDAO();
	private TavoloBean bean = new TavoloBean("Gioco di carte", 34, 4, false, 4.99, "11:30 - 13:30", "https://immagine.jpg") ; 
	
	@BeforeEach
	public void setUp() throws Exception{
		 dao.doSave(bean);
    }
	
	@AfterEach
    public void tearDown() throws Exception{
		dao.doDelete(bean.getIdTavolo());			
	}
	
	
	@Test
	public void retrieveByKeyTest(){	
		try {
		assertTrue(dao.doRetriveByKey((bean.getIdTavolo()))!=null);
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
	

        }


	