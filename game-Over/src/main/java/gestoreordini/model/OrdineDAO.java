package gestoreordini.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.DriverManagerConnectionPool;
public class OrdineDAO {
    private static final String TABLE_NAME = "Ordine";

    public OrdineBean doRetriveByKey(int codice) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from " + OrdineDAO.TABLE_NAME + " where idOrdine=?";
        OrdineBean b = new OrdineBean();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, codice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setIdOrdine(rs.getInt("idOrdine"));
                b.setUtente(rs.getString("utente"));
                b.setDataAcquisto(new java.util.Date(rs.getDate("dataAcquisto").getTime()));
                b.setPrezzoTotale(rs.getDouble("prezzoTotale"));
                b.setIva(rs.getDouble("iva"));
                b.setNumeroProdotti(rs.getInt("numeroProdotti"));
                b.setStato(rs.getString("stato"));
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

    public ArrayList<OrdineBean> doRetrieveAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<OrdineBean> ab = new ArrayList<OrdineBean>();
        String query = "select * from Ordine";

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
            	OrdineBean b = new OrdineBean();
                b.setIdOrdine(rs.getInt("idOrdine"));
                b.setUtente(rs.getString("utente"));
                b.setDataAcquisto(new java.util.Date(rs.getDate("dataAcquisto").getTime()));
                b.setPrezzoTotale(rs.getDouble("prezzoTotale"));
                b.setIva(rs.getDouble("iva"));
                b.setNumeroProdotti(rs.getInt("numeroProdotti"));
                b.setStato(rs.getString("stato"));

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

    public void doSave(OrdineBean utente) throws SQLException {
        String query = "insert into Ordine values(?,?,?,?,?,?,?);";

        Connection con = null;
        PreparedStatement ps = null;


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, utente.getIdOrdine());
            ps.setString(2, utente.getUtente());
            ps.setDate(3, (java.sql.Date) utente.getDataAcquisto());
            ps.setDouble(4, utente.getPrezzoTotale());
            ps.setDouble(5, utente.getIva());
            ps.setInt(6, utente.getNumeroProdotti());
            ps.setString(7, utente.getStato());

            ps.executeUpdate();


        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public void doUpdate(int id, String stato) throws SQLException {
        String query = "update ordine set stato=? where idOrdine=?";
        Connection con=null; 
		PreparedStatement ps=null; 
		
		try {
			con= DriverManagerConnectionPool.getConnection(); 
			
			ps=con.prepareStatement(query); 
			ps.setInt(2, id);
			ps.setString(1, stato);
			ps.executeUpdate();

		}finally {
			try {
				if(ps!=null) ps.close(); 
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
    }

    public void doDelete(OrdineBean utente) throws SQLException {
        String query = "delete from " + OrdineDAO.TABLE_NAME + " where idOrdine=?";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DriverManagerConnectionPool.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, utente.getIdOrdine());
            ps.execute();
        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }
    
    
    
    public ArrayList<OrdineBean> doRetrieveAllbyUsername(String user) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<OrdineBean> ab = new ArrayList<OrdineBean>();
        String query = "select * from Ordine where utente=?";

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            OrdineBean b = new OrdineBean();
            while (rs.next()) {
                b.setIdOrdine(rs.getInt("idOrdine"));
                b.setUtente(rs.getString("utente"));
                b.setDataAcquisto(new java.util.Date(rs.getDate("dataAcquisto").getTime()));
                b.setPrezzoTotale(rs.getDouble("prezzoTotale"));
                b.setIva(rs.getDouble("iva"));
                b.setNumeroProdotti(rs.getInt("numeroProdotti"));
                b.setStato(rs.getString("stato"));

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
    
    
    ///////////////////////////////////
    
    public ArrayList<OrdineBean> doRetriveByDates(String codice1, String d2) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from ordine where dataAcquisto>? AND dataAcquisto<?";
       ArrayList<OrdineBean> ab = new ArrayList<OrdineBean>();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setString(1, codice1);
            ps.setString(2, d2);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	 OrdineBean b = new OrdineBean();
                b.setIdOrdine(rs.getInt("idOrdine"));
                b.setUtente(rs.getString("utente"));
                b.setDataAcquisto(new java.util.Date(rs.getDate("dataAcquisto").getTime()));
                b.setPrezzoTotale(rs.getDouble("prezzoTotale"));
                b.setIva(rs.getDouble("iva"));
                b.setNumeroProdotti(rs.getInt("numeroProdotti"));
                b.setStato(rs.getString("stato"));
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
    
    
    public ArrayList<OrdineBean> doRetriveUsernameAZ() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from ordine order by ordine.utente ASC;";
       ArrayList<OrdineBean> ab = new ArrayList<OrdineBean>();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	OrdineBean b = new OrdineBean();
                b.setIdOrdine(rs.getInt("idOrdine"));
                b.setUtente(rs.getString("utente"));
                b.setDataAcquisto(new java.util.Date(rs.getDate("dataAcquisto").getTime()));
                b.setPrezzoTotale(rs.getDouble("prezzoTotale"));
                b.setIva(rs.getDouble("iva"));
                b.setNumeroProdotti(rs.getInt("numeroProdotti"));
                b.setStato(rs.getString("stato"));
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
    
    public ArrayList<OrdineBean> doRetriveUsernameZA() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from ordine order by ordine.utente DESC;";
       ArrayList<OrdineBean> ab = new ArrayList<OrdineBean>();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	OrdineBean b = new OrdineBean();
                b.setIdOrdine(rs.getInt("idOrdine"));
                b.setUtente(rs.getString("utente"));
                b.setDataAcquisto(new java.util.Date(rs.getDate("dataAcquisto").getTime()));
                b.setPrezzoTotale(rs.getDouble("prezzoTotale"));
                b.setIva(rs.getDouble("iva"));
                b.setNumeroProdotti(rs.getInt("numeroProdotti"));
                b.setStato(rs.getString("stato"));
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
}

