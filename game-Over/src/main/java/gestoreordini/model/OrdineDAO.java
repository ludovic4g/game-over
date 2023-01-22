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
                b.setDataAcquisto(rs.getDate("dataAcquisto"));
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
            OrdineBean b = new OrdineBean();
            while (rs.next()) {
                b.setIdOrdine(rs.getInt("idOrdine"));
                b.setUtente(rs.getString("utente"));
                b.setDataAcquisto(rs.getDate("dataAcquisto"));
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

    public void doUpdate(OrdineBean utente) throws SQLException {
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
                b.setDataAcquisto(rs.getDate("dataAcquisto"));
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