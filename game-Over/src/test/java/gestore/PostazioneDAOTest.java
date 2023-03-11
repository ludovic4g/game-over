package gestore;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gestorecatalogo.model.PostazioneBean;
import gestorecatalogo.model.PostazioneDAO;

public class PostazioneDAOTest {
	private PostazioneDAO  dao=new PostazioneDAO();
	private PostazioneBean bean = new PostazioneBean(); 
	
	@BeforeEach
	public void setUp() throws Exception{
		 dao.doSave(bean);
    }
	
	@AfterEach
    public void tearDown() throws Exception{
		dao.doDelete(bean.getIdPostazione());			
	}
	
	
	@Test
	public void retrieveByKeyTest(){	
		try {
		assertTrue(dao.doRetriveByKey((bean.getIdPostazione()))!=null);
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


	