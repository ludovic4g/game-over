package utente.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.DriverManagerConnectionPool;

public class UtenteDAO {
    private static final String TABLE_NAME = "Utente";

    public UtenteBean doRetrieveByKey(String codice) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from " + UtenteDAO.TABLE_NAME + " where username=?";
        UtenteBean b = new UtenteBean();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setString(1, codice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setUsername(rs.getString("username"));
                b.setPassword(rs.getString("password"));
                b.setEmail(rs.getString("email"));
                b.setNome(rs.getString("nome"));
                b.setCognome(rs.getString("cognome"));
                b.setBday(rs.getDate("ddn"));
                b.setRisposta(rs.getString("risposta"));
                b.setGestoreCatalogo(rs.getBoolean("ammin1"));
                b.setGestorePrenotazioni(rs.getBoolean("ammin2"));
                b.setGestoreOrdini(rs.getBoolean("ammin3"));
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

    public ArrayList<UtenteBean> doRetrieveAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<UtenteBean> ab = new ArrayList<UtenteBean>();
        String query = "select * from Utente";

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            UtenteBean b = new UtenteBean();
            while (rs.next()) {
                b.setUsername(rs.getString("username"));
                b.setPassword(rs.getString("password"));
                b.setEmail(rs.getString("email"));
                b.setNome(rs.getString("nome"));
                b.setCognome(rs.getString("cognome"));
                b.setBday(rs.getDate("ddn"));
                b.setRisposta(rs.getString("risposta"));
                b.setGestoreCatalogo(rs.getBoolean("ammin1"));
                b.setGestorePrenotazioni(rs.getBoolean("ammin2"));
                b.setGestoreOrdini(rs.getBoolean("ammin3"));

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

    public void doSave(UtenteBean utente) throws SQLException {
        String query = "insert into utente values(?,?,?,?,?,?,?,?,?,?);";

        Connection con = null;
        PreparedStatement ps = null;


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setString(1, utente.getUsername());
            ps.setString(2, utente.getPassword());
            ps.setString(3, utente.getEmail());
            ps.setString(4, utente.getNome());
            ps.setString(5, utente.getCognome());
            ps.setDate(6, (java.sql.Date) utente.getBday());
            ps.setString(7, utente.getRisposta());
            ps.setBoolean(8, utente.isGestoreCatalogo());
            ps.setBoolean(9, utente.isGestorePrenotazioni());
            ps.setBoolean(10, utente.isGestoreCatalogo());

            ps.executeUpdate();


        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public void doUpdate(UtenteBean utente) throws SQLException {
        String query = "update " + UtenteDAO.TABLE_NAME + " set password=? where username=?";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setString(1, utente.getUsername());
            ps.setString(2, utente.getPassword());
            ps.execute();

        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }

    }

    public void doDelete(UtenteBean utente) throws SQLException {
        String query = "delete from " + UtenteDAO.TABLE_NAME + " where username=?";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DriverManagerConnectionPool.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, utente.getUsername());
            ps.execute();
        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public UtenteBean login(String username, String password) {
        UtenteBean utente=null;
        PreparedStatement pst;
        ResultSet rs;
        Connection con=null;

        try {
            con= DriverManagerConnectionPool.getConnection();
            String query= "select * from utente where username=? and password=?";
            pst= con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2,password);
            rs= pst.executeQuery();
            if(rs.next()) {
                utente = new UtenteBean();
                utente.setUsername(rs.getString("username"));
                utente.setPassword(rs.getString("password"));
                utente.setEmail(rs.getString("email"));
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));
                utente.setBday(new java.util.Date(rs.getDate("ddn").getTime()));
                utente.setRisposta(rs.getString("risposta"));
                utente.setGestoreCatalogo(rs.getBoolean("ammin1"));
                utente.setGestorePrenotazioni(rs.getBoolean("ammin2"));
                utente.setGestoreOrdini(rs.getBoolean("ammin3"));
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return utente;
    }

}
