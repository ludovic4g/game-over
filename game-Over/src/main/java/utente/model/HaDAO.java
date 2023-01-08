package utente.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import connection.DriverManagerConnectionPool;


public class HaDAO {
    private static final String TABLE_NAME = "Ha";

    public HaBean doRetrieveByIndirizzo(int codice) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from " + HaDAO.TABLE_NAME + " where idIndirizzo=?";
        HaBean b = new HaBean();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, codice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setUsername(rs.getString("username"));
                b.setIdIndirizzo(rs.getInt("idIndirizzo"));
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

    public HaBean doRetrieveByUsername(String codice) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from " + HaDAO.TABLE_NAME + " where username=?";
        HaBean b = new HaBean();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setString(1, codice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setUsername(rs.getString("username"));
                b.setIdIndirizzo(rs.getInt("idIndirizzo"));
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

    public ArrayList<HaBean> doRetrieveAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<HaBean> ab = new ArrayList<HaBean>();
        String query = "select * from Ha";

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            HaBean b = new HaBean();
            while (rs.next()) {
                b.setUsername(rs.getString("username"));
                b.setIdIndirizzo(rs.getInt("idIndirizzo"));

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

    public void doSave(HaBean utente) throws SQLException {
        String query = "insert into utente values(?,?)";

        Connection con = null;
        PreparedStatement ps = null;


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, utente.getIdIndirizzo());
            ps.setString(2, utente.getUsername());

            ps.executeUpdate();


        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public void doDelete(HaBean utente) throws SQLException {
        String query = "delete from " + HaDAO.TABLE_NAME + " where ordine=?";
        Connection con = null;
        PreparedStatement ps = null;
        boolean ctrl = false;

        try {
            con = DriverManagerConnectionPool.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, utente.getIdIndirizzo());
            ps.execute();
            ctrl = true;
        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

}