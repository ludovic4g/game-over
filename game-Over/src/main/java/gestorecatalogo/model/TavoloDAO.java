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
                b.setDisp(rs.getBoolean("disp"));

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
                b.setTipo(rs.getString("tipo"));
                b.setDisp(rs.getBoolean("disp"));

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
        String query = "INSERT INTO Tavolo(numeroPosti, prezzoPosto, ora,  tipo, disp) VALUES (?,?,?,?,?);";

        Connection con = null;
        PreparedStatement ps = null;


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, utente.getNumeroPosti());
            ps.setDouble(2, utente.getPrezzoPosto());
            ps.setString(3, utente.getOra());
            ps.setString(4, utente.getTipo());
            ps.setBoolean(5, utente.isDisp());


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
		String query="update tavolo set numeroposti=? where numero=?"; 
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
		String query="update tavolo set prezzoposto=? where numero=?"; 
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
		String query="update tavolo set ora=? where numero=?"; 
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
		String query="update tavolo set tipo=? where numero=?"; 
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
		String query="update tavolo set disp=? where numero=?"; 
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
    
	

}