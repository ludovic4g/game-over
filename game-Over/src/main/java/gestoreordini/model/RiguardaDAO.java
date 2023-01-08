package gestoreordini.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connection.DriverManagerConnectionPool;

public class RiguardaDAO {
    private static final String TABLE_NAME = "Riguarda";

    public RiguardaBean doRetriveByVideogioco(int codice) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from " + RiguardaDAO.TABLE_NAME + " where id=?";
        RiguardaBean b = new RiguardaBean();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, codice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setId(rs.getInt("id"));
                b.setIdOrdine(rs.getInt("idOrdine"));
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

    public RiguardaBean doRetriveByOrdine(int codice) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from " + RiguardaDAO.TABLE_NAME + " where idOrdine=?";
        RiguardaBean b = new RiguardaBean();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, codice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setId(rs.getInt("id"));
                b.setIdOrdine(rs.getInt("idOrdine"));
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

    public ArrayList<RiguardaBean> doRetrieveAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<RiguardaBean> ab = new ArrayList<RiguardaBean>();
        String query = "select * from Riguarda";

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            RiguardaBean b = new RiguardaBean();
            while (rs.next()) {
                b.setId(rs.getInt("id"));
                b.setIdOrdine(rs.getInt("idOrdine"));
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

    public void doSave(RiguardaBean utente) throws SQLException {
        String query = "insert into Riguarda values(?,?);";

        Connection con = null;
        PreparedStatement ps = null;


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, utente.getId());
            ps.setInt(2, utente.getIdOrdine());

            ps.executeUpdate();


        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }


    public void doDelete(RiguardaBean utente) throws SQLException {
        String query = "delete from " + RiguardaDAO.TABLE_NAME + " where idOrdine=?";
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

}