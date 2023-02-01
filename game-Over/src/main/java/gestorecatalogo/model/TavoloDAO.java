package gestorecatalogo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.DriverManagerConnectionPool;

public class TavoloDAO {
    private static final String TABLE_NAME = "Tavolo";

    public TavoloBean doRetriveByKey(int codice) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from " + TavoloDAO.TABLE_NAME + " where numero=?";
        TavoloBean b = new TavoloBean();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, codice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setIdTavolo(rs.getInt("numero"));
                b.setNumeroPosti(rs.getInt("numeroPosti"));
                b.setPrezzoPosto(rs.getDouble("prezzoPosto"));
                b.setOra(rs.getString("ora"));
                b.setData(rs.getDate("data"));
                b.setDisp(rs.getBoolean("disp"));
                b.setImg(rs.getString("img"));

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

    public ArrayList<TavoloBean> doRetrieveAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<TavoloBean> ab = new ArrayList<TavoloBean>();
        String query = "select * from Tavolo";

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
            	TavoloBean b = new TavoloBean();
                b.setIdTavolo(rs.getInt("numero"));
                b.setNumeroPosti(rs.getInt("numeroPosti"));
                b.setPrezzoPosto(rs.getDouble("prezzoPosto"));
                b.setOra(rs.getString("ora"));
                b.setData(rs.getDate("data"));
                b.setTipo(rs.getString("tipo"));
                b.setDisp(rs.getBoolean("disp"));
                b.setImg(rs.getString("img"));

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

    public void doSave(TavoloBean utente) throws SQLException {
        String query = "INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora, data,  tipo, disp, img) VALUES (?,?,?,?,?,?,?);";

        Connection con = null;
        PreparedStatement ps = null;


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, utente.getNumeroPosti());
            ps.setDouble(2, utente.getPrezzoPosto());
            ps.setString(3, utente.getOra());
            ps.setDate(4, new java.sql.Date(utente.getData().getTime()));
            ps.setString(5, utente.getTipo());
            ps.setBoolean(6, utente.isDisp());
            ps.setString(7, utente.getImg());


            ps.executeUpdate();
        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public void doUpdate(TavoloBean utente) throws SQLException {
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
        String query = "delete from " + TavoloDAO.TABLE_NAME + " where numero=?";
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
    
    /////////////////////////////////////7
    public void ModifyNumeroPosti(int idpf, int nome) throws SQLException{
		String query="update tavolo set numeroposti=? where id=?"; 
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
    
    public void ModifyPrezzoPosto(int idpf, double nome) throws SQLException{
		String query="update tavolo set prezzoposto=? where id=?"; 
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
		String query="update tavolo set ora=? where id=?"; 
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
    
    public void ModifyTipo(int idpf, String nome) throws SQLException{
		String query="update tavolo set tipo=? where id=?"; 
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
    
    public void ModifyDisponibilita(int idpf, boolean nome) throws SQLException{
		String query="update tavolo set disp=? where id=?"; 
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
    
    public void ModifyImg(int idpf, String nome) throws SQLException{
		String query="update tavolo set img=? where id=?"; 
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