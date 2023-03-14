package utente.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.DriverManagerConnectionPool;

public class IndirizzoDAO {
    private static final String TABLE_NAME = "Indirizzo";

    public IndirizzoBean doRetrieveByKey(int codice) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from " + IndirizzoDAO.TABLE_NAME + " where id=?";
        IndirizzoBean b = new IndirizzoBean();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, codice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setId(rs.getInt("id"));
                b.setNome(rs.getString("nome"));
                b.setVia(rs.getString("indirizzo"));
                b.setCAP(rs.getInt("cap"));
                b.setCitta(rs.getString("citta"));
                b.setProvincia(rs.getString("provincia"));
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

    public ArrayList<IndirizzoBean> doRetrieveAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<IndirizzoBean> ab = new ArrayList<IndirizzoBean>();
        String query = "select * from Indirizzo";

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
            	IndirizzoBean b = new IndirizzoBean();
            	 b.setId(rs.getInt("id"));
                 b.setNome(rs.getString("nome"));
                 b.setVia(rs.getString("indirizzo"));
                 b.setCAP(rs.getInt("cap"));
                 b.setCitta(rs.getString("citta"));
                 b.setProvincia(rs.getString("provincia"));

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

    public ArrayList<IndirizzoBean> doRetrieveAllById(int c) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<IndirizzoBean> ab = new ArrayList<IndirizzoBean>();
        String query = "select * from Indirizzo where id=?";

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, c);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
            	IndirizzoBean b = new IndirizzoBean();
            	 b.setId(rs.getInt("id"));
                 b.setNome(rs.getString("nome"));
                 b.setVia(rs.getString("indirizzo"));
                 b.setCAP(rs.getInt("cap"));
                 b.setCitta(rs.getString("citta"));
                 b.setProvincia(rs.getString("provincia"));

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
    public void doSave(IndirizzoBean utente) throws SQLException {
        String query = "insert into Indirizzo(nome, indirizzo, cap, citta, provincia) values(?,?,?,?,?);";

        Connection con = null;
        PreparedStatement ps = null;


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setString(1, utente.getNome());
            ps.setString(2, utente.getVia());
            ps.setInt(3, utente.getCAP());
            ps.setString(4, utente.getCitta());
            ps.setString(5, utente.getProvincia());

            ps.executeUpdate();


        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public void doUpdate(int id, String s1, String s2, int s3, String s4, String s5) throws SQLException {
        String query = "update indirizzo set nome=?, indirizzo=?, cap=?, citta=?, provincia=? where id=?";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(6, id);
            ps.setString(1, s1);
            ps.setString(2, s2);
            ps.setInt(3, s3);
            ps.setString(4, s4);
            ps.setString(5, s5);

            ps.execute();

        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public void doDelete(IndirizzoBean utente) throws SQLException {
        String query = "delete from " + IndirizzoDAO.TABLE_NAME + " where id=?";
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

}