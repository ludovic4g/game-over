package gestore;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gestorecatalogo.model.VideogiocoBean;
import gestorecatalogo.model.VideogiocoDAO;

public class VideogiocoDAOTest {
	private VideogiocoDAO  dao=new VideogiocoDAO();
	private VideogiocoBean bean = new VideogiocoBean(34, "Hogwarts Legacy", 0, 59.99, 2023, "PC" , 30, "Hogwarts Legacy è il nuovo gioco RPG di Harry Potter dove....", "https://immaginehl_1.jpg","https://immaginehl_2.jpg","https://immaginehl_3.jpg","https://immaginehl_4.jpg","https://immaginehl_5.jpg");
	
	@BeforeEach
	public void setUp() throws Exception{
		 dao.doSave(bean);
    }
	
	@AfterEach
    public void tearDown() throws Exception{
		dao.doDelete(bean.getId());			
	}
	
	
	@Test
	public void retrieveByKeyTest(){	
		try {
		assertTrue(dao.doRetriveByKey((bean.getId()))!=null);
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
	public void retrieveByNameTest(){	
		try {
		assertTrue(dao.doRetriveByName(bean.getNome())!=null);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	

        }


	