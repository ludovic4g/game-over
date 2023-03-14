package gestorepren.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connection.DriverManagerConnectionPool;
import gestoreordini.model.OrdineBean;

public class PrenotazioneDAO {
    private static final String TABLE_NAME = "Prenotazione";

    public PrenotazioneBean doRetrieveByKey(int codice) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from " + PrenotazioneDAO.TABLE_NAME + " where id=?";
        PrenotazioneBean b = new PrenotazioneBean();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, codice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setIdPrenotazione(rs.getInt("id"));
                b.setUtente(rs.getString("utente"));
                b.setPrezzo(rs.getDouble("prezzoTotale"));
                b.setPostiPrenotati(rs.getInt("postiPrenotati"));
                b.setOra(rs.getString("ora"));
                b.setDataprenotazione(new java.util.Date(rs.getDate("dataprenotazione").getTime()));
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

    public ArrayList<PrenotazioneBean> doRetrieveAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<PrenotazioneBean> ab = new ArrayList<PrenotazioneBean>();
        String query = "select * from Prenotazione";

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
           
            while (rs.next()) {
            	 PrenotazioneBean b = new PrenotazioneBean();
                b.setIdPrenotazione(rs.getInt("id"));
                b.setUtente(rs.getString("utente"));
                b.setPrezzo(rs.getDouble("prezzoTotale"));
                b.setPostiPrenotati(rs.getInt("postiPrenotati"));
                b.setOra(rs.getString("ora"));
                b.setDataprenotazione(rs.getDate("dataprenotazione"));
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

    public void doSave(PrenotazioneBean utente) throws SQLException {
        String query = "insert into Prenotazione values(?,?,?,?,?,?,?);";

        Connection con = null;
        PreparedStatement ps = null;


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, utente.getIdPrenotazione());
            ps.setString(2, utente.getUtente());
            ps.setDouble(3, utente.getPrezzo());
            ps.setInt(4, utente.getPostiPrenotati());
            ps.setString(5, utente.getOra());
            ps.setDate(6, new java.sql.Date(utente.getDataprenotazione().getTime()));
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

    public void doUpdate(int id, String s) throws SQLException {
        String query = "update prenotazione set stato=? where id=?";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(2, id);
			ps.setString(1, s);

            ps.execute();
        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public void doDelete(PrenotazioneBean utente) throws SQLException {
        String query = "delete from " + PrenotazioneDAO.TABLE_NAME + " where id=?";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DriverManagerConnectionPool.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, utente.getIdPrenotazione());
            ps.execute();
        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }
    
    /////////////////////////////////////
    public ArrayList<PrenotazioneBean> doRetriveByDates(String codice1, String d2) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from prenotazione where dataprenotazione>? AND dataprenotazione<?";
       ArrayList<PrenotazioneBean> ab = new ArrayList<PrenotazioneBean>();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setString(1, codice1);
            ps.setString(2, d2);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	PrenotazioneBean b = new PrenotazioneBean();
            	 b.setIdPrenotazione(rs.getInt("id"));
                 b.setUtente(rs.getString("utente"));
                 b.setPrezzo(rs.getDouble("prezzoTotale"));
                 b.setPostiPrenotati(rs.getInt("postiPrenotati"));
                 b.setOra(rs.getString("ora"));
                 b.setDataprenotazione(new java.util.Date(rs.getDate("dataprenotazione").getTime()));
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
    
    
    public ArrayList<PrenotazioneBean> doRetriveUsernameAZ() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from prenotazione order by prenotazione.utente ASC;";
       ArrayList<PrenotazioneBean> ab = new ArrayList<PrenotazioneBean>();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	PrenotazioneBean b = new PrenotazioneBean();
            	 b.setIdPrenotazione(rs.getInt("id"));
                 b.setUtente(rs.getString("utente"));
                 b.setPrezzo(rs.getDouble("prezzoTotale"));
                 b.setPostiPrenotati(rs.getInt("postiPrenotati"));
                 b.setOra(rs.getString("ora"));
                 b.setDataprenotazione(new java.util.Date(rs.getDate("dataprenotazione").getTime()));
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
    
    public ArrayList<PrenotazioneBean> doRetriveUsernameZA() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from prenotazione order by prenotazione.utente DESC;";
       ArrayList<PrenotazioneBean> ab = new ArrayList<PrenotazioneBean>();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	PrenotazioneBean b = new PrenotazioneBean();
            	 b.setIdPrenotazione(rs.getInt("id"));
                 b.setUtente(rs.getString("utente"));
                 b.setPrezzo(rs.getDouble("prezzoTotale"));
                 b.setPostiPrenotati(rs.getInt("postiPrenotati"));
                 b.setOra(rs.getString("ora"));
                 b.setDataprenotazione(new java.util.Date(rs.getDate("dataprenotazione").getTime()));
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
    
    public ArrayList<PrenotazioneBean> doRetriveAllByKey(String name) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from prenotazione where utente=?;";
       ArrayList<PrenotazioneBean> ab = new ArrayList<PrenotazioneBean>();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
            	PrenotazioneBean b = new PrenotazioneBean();
            	 b.setIdPrenotazione(rs.getInt("id"));
                 b.setUtente(rs.getString("utente"));
                 b.setPrezzo(rs.getDouble("prezzoTotale"));
                 b.setPostiPrenotati(rs.getInt("postiPrenotati"));
                 b.setOra(rs.getString("ora"));
                 b.setDataprenotazione(new java.util.Date(rs.getDate("dataprenotazione").getTime()));
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