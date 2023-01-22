package gestorecatalogo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connection.DriverManagerConnectionPool;

public class VideogiocoDAO {
    private static final String TABLE_NAME = "Videogioco";

    public VideogiocoBean doRetriveByKey(int codice) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from " + VideogiocoDAO.TABLE_NAME + " where id=?";
        VideogiocoBean b = new VideogiocoBean();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, codice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	b.setId(rs.getInt("id"));
                b.setNome(rs.getString("nome"));
                b.setPrezzo(rs.getDouble("prezzo"));
                b.setAnno(rs.getInt("anno"));
                b.setQuantita(rs.getInt("quantita"));
                b.updateMagazzino(rs.getInt("magazzino"));
                b.setTipo(rs.getString("tipo"));
                b.setDescrizione(rs.getString("descrizione"));
                b.setImg1(rs.getString("img1"));
                b.setImg2(rs.getString("img2"));
                b.setImg3(rs.getString("img3"));
                b.setImg4(rs.getString("img4"));
                b.setImg5(rs.getString("img5"));

            }
            rs.close();
        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }

        }
        return b;
    }

    public ArrayList<VideogiocoBean> doRetrieveAll() throws SQLException {
    	ArrayList<VideogiocoBean> ab = new ArrayList<VideogiocoBean>();
        String query=null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs=null;
        try {
            con = DriverManagerConnectionPool.getConnection();
            query = "select * from Videogioco";
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
            	VideogiocoBean b = new VideogiocoBean();
            	b.setId(rs.getInt("id"));
                b.setNome(rs.getString("nome"));
                b.setPrezzo(rs.getDouble("prezzo"));
                b.setAnno(rs.getInt("anno"));
                b.setQuantita(rs.getInt("quantita"));
                b.updateMagazzino(rs.getInt("magazzino"));
                b.setTipo(rs.getString("tipo"));
                b.setDescrizione(rs.getString("descrizione"));
                b.setImg1(rs.getString("img1"));
                b.setImg2(rs.getString("img2"));
                b.setImg3(rs.getString("img3"));
                b.setImg4(rs.getString("img4"));
                b.setImg5(rs.getString("img5"));

                ab.add(b);
            }
            rs.close();
        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }

        }
        return ab;
    }

    public void doSave(VideogiocoBean utente) throws SQLException {
        String query = "INSERT INTO Videogioco(nome,prezzo,anno,quantita,magazzino,tipo,descrizione,img1,img2,img3,img4,img5) VALUES (?,?,?,?,?,?,?,?,?,?,?,?);";

        Connection con = null;
        PreparedStatement ps = null;


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setString(1, utente.getNome());
            ps.setDouble(2, utente.getPrezzo());
            ps.setInt(3, utente.getAnno());
            ps.setInt(4, utente.getQuantita());
            ps.setInt(5, utente.getMagazzino());
            ps.setString(6, utente.getTipo());
            ps.setString(7, utente.getDescrizione());
            ps.setString(8, utente.getImg1());
            ps.setString(9, utente.getImg2());
            ps.setString(10, utente.getImg3());
            ps.setString(11, utente.getImg4());
            ps.setString(12, utente.getImg5());

            ps.executeUpdate();


        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public void doUpdate(VideogiocoBean utente) throws SQLException {
        String query = "???????";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);

            ps.execute();


        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public void doDelete(VideogiocoBean utente) throws SQLException {
        String query = "delete from " + VideogiocoDAO.TABLE_NAME + " where id=?";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DriverManagerConnectionPool.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, utente.getId());
            ps.execute();
        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }
    
    public void ModifyQuantitaInMagazzino(int id, int qim) throws SQLException{
		String query="update Videogioco set magazzino=? where id=?"; 
		Connection con=null; 
		PreparedStatement ps=null; 
		
		try {
			con= DriverManagerConnectionPool.getConnection(); 
			
			ps=con.prepareStatement(query); 
			ps.setInt(2, id);
			ps.setInt(1, qim);
			ps.execute();

		}finally {
			try {
				if(ps!=null) ps.close(); 
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
	}
    
    
    /////////////////////////////////////////////
    public void ModifyNome(int idpf, String nome) throws SQLException{
		String query="update videogioco set nome=? where id=?"; 
		Connection con=null; 
		PreparedStatement ps=null; 
		
		try {
			con= DriverManagerConnectionPool.getConnection(); 
			
			ps=con.prepareStatement(query); 
			ps.setInt(2, idpf);
			ps.setString(1, nome);
			ps.executeUpdate();

		}finally {
			try {
				if(ps!=null) ps.close(); 
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
	}

    public void ModifyDescrizione(int idpf, String nome) throws SQLException{
		String query="update videogioco set descrizione=? where id=?"; 
		Connection con=null; 
		PreparedStatement ps=null; 
		
		try {
			con= DriverManagerConnectionPool.getConnection(); 
			
			ps=con.prepareStatement(query); 
			ps.setInt(2, idpf);
			ps.setString(1, nome);
			ps.executeUpdate();

		}finally {
			try {
				if(ps!=null) ps.close(); 
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
	}
    public void ModifyAnno(int idpf, int nome) throws SQLException{
		String query="update videogioco set anno=? where id=?"; 
		Connection con=null; 
		PreparedStatement ps=null; 
		
		try {
			con= DriverManagerConnectionPool.getConnection(); 
			
			ps=con.prepareStatement(query); 
			ps.setInt(2, idpf);
			ps.setInt(1, nome);
			ps.executeUpdate();

		}finally {
			try {
				if(ps!=null) ps.close(); 
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
	}
    
    public void ModifyPrezzo(int idpf, double nome) throws SQLException{
		String query="update videogioco set prezzo=? where id=?"; 
		Connection con=null; 
		PreparedStatement ps=null; 
		
		try {
			con= DriverManagerConnectionPool.getConnection(); 
			
			ps=con.prepareStatement(query); 
			ps.setInt(2, idpf);
			ps.setDouble(1, nome);
			ps.executeUpdate();

		}finally {
			try {
				if(ps!=null) ps.close(); 
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
	}
    
    public void ModifyPiattaforma(int idpf, String nome) throws SQLException{
		String query="update videogioco set piattaforma=? where id=?"; 
		Connection con=null; 
		PreparedStatement ps=null; 
		
		try {
			con= DriverManagerConnectionPool.getConnection(); 
			
			ps=con.prepareStatement(query); 
			ps.setInt(2, idpf);
			ps.setString(1, nome);
			ps.executeUpdate();

		}finally {
			try {
				if(ps!=null) ps.close(); 
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
	}
    
    public void ModifyImg12(int idpf, String nome, String nome2) throws SQLException{
		String query="update videogioco set img1=?, img2=? where id=?"; 
		Connection con=null; 
		PreparedStatement ps=null; 
		
		try {
			con= DriverManagerConnectionPool.getConnection(); 
			
			ps=con.prepareStatement(query); 
			ps.setInt(3, idpf);
			ps.setString(2, nome2);
			ps.setString(1, nome);
			ps.executeUpdate();

		}finally {
			try {
				if(ps!=null) ps.close(); 
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
	}
    public void ModifyImg345(int idpf, String nome, String nome2, String nome3) throws SQLException{
		String query="update videogioco set img1=?, img2=?, img3=? where id=?"; 
		Connection con=null; 
		PreparedStatement ps=null; 
		
		try {
			con= DriverManagerConnectionPool.getConnection(); 
			
			ps=con.prepareStatement(query); 
			ps.setInt(4, idpf);
			ps.setString(3, nome3);
			ps.setString(2, nome2);
			ps.setString(1, nome);
			ps.executeUpdate();

		}finally {
			try {
				if(ps!=null) ps.close(); 
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
	}
}
