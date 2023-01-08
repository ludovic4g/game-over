package utente.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.DriverManagerConnectionPool;

public class CompraDAO {
    private static final String TABLE_NAME = "Compra";

    public CompraBean doRetrieveByUsername(String codice) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from " + CompraDAO.TABLE_NAME + " where username=?";
        CompraBean b = new CompraBean();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setString(1, codice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setUsername(rs.getString("username"));
                b.setIdVideogioco(rs.getInt("id"));
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

    public CompraBean doRetrieveByVideogioco(int codice) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from " + CompraDAO.TABLE_NAME + " where id=?";
        CompraBean b = new CompraBean();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, codice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setUsername(rs.getString("username"));
                b.setIdVideogioco(rs.getInt("id"));
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

    public ArrayList<CompraBean> doRetrieveAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<CompraBean> ab = new ArrayList<CompraBean>();
        String query = "select * from Compra";

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            CompraBean b = new CompraBean();
            while (rs.next()) {
                b.setUsername(rs.getString("username"));
                b.setIdVideogioco(rs.getInt("id"));

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

    public void doSave(CompraBean utente) throws SQLException {
        String query = "insert into Compra values(?,?);";

        Connection con = null;
        PreparedStatement ps = null;


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setString(1, utente.getUsername());
            ps.setInt(2, utente.getIdVideogioco());
            ps.executeUpdate();


        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }


    public void doDelete(CompraBean utente) throws SQLException {
        String query = "delete from " + CompraDAO.TABLE_NAME + " where id=?";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DriverManagerConnectionPool.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, utente.getIdVideogioco());
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