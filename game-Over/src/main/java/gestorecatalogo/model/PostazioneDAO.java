package gestorecatalogo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.DriverManagerConnectionPool;


public class PostazioneDAO {
    private static final String TABLE_NAME = "Postazione";

    public PostazioneBean doRetriveByKey(int codice) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from " + PostazioneDAO.TABLE_NAME + " where id=?";
        PostazioneBean b = new PostazioneBean();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, codice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setIdPostazione(rs.getInt("id"));
                b.setOra(rs.getString("ora"));

                b.setPrezzo(rs.getDouble("prezzo"));
                b.setDisp(rs.getBoolean("disp"));
                b.setTipo(rs.getString("tipo"));

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

    public ArrayList<PostazioneBean> doRetrieveAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<PostazioneBean> ab = new ArrayList<PostazioneBean>();
        String query = "select * from Postazione";

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
            	PostazioneBean b = new PostazioneBean();
                b.setIdPostazione(rs.getInt("id"));
                b.setOra(rs.getString("ora"));

                b.setPrezzo(rs.getDouble("prezzo"));
                b.setDisp(rs.getBoolean("disp"));
                b.setTipo(rs.getString("tipo"));

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

    public void doSave(PostazioneBean utente) throws SQLException {
        String query = "INSERT INTO Postazione(ora,tipo, prezzo, disp) values(?,?,?,?);";

        Connection con = null;
        PreparedStatement ps = null;


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setString(1, utente.getOra());
            ps.setString(2, utente.getTipo());
            ps.setDouble(3, utente.getPrezzo());
            ps.setBoolean(4, utente.isDisp());

            ps.executeUpdate();


        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public void doUpdate(PostazioneBean utente) throws SQLException {
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

    public void doDelete(int id) throws SQLException {
        String query = "delete from " + PostazioneDAO.TABLE_NAME + " where id=?";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DriverManagerConnectionPool.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ps.execute();
        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }
    
    //////////////////////////////////////////////////
    public void ModifyPrezzo(int idpf, double nome) throws SQLException{
		String query="update postazione set prezzo=? where id=?"; 
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
    
    public void ModifyOra(int idpf, String nome) throws SQLException{
		String query="update postazione set ora=? where id=?"; 
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
    
    public void ModifyDisp(int idpf, boolean nome) throws SQLException{
		String query="update postazione set disp=? where id=?"; 
		Connection con=null; 
		PreparedStatement ps=null; 
		
		try {
			con= DriverManagerConnectionPool.getConnection(); 
			
			ps=con.prepareStatement(query); 
			ps.setInt(2, idpf);
			ps.setBoolean(1, nome);
			ps.executeUpdate();

		}finally {
			try {
				if(ps!=null) ps.close(); 
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		
	}
    
    public void ModifyTipo(int idpf, String nome) throws SQLException{
		String query="update postazione set tipo=? where id=?"; 
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

}