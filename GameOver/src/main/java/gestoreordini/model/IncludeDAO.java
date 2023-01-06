package gestoreordini.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Connection.DriverManagerConnectionPool;

public class IncludeDAO {
    private static final String TABLE_NAME = "OrdinePrenotazione";

    public IncludeBean doRetrieveByOrdine(int codice) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from " + IncludeDAO.TABLE_NAME + " where idOrdine=?";
        IncludeBean b = new IncludeBean();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, codice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setIdPrenotazione(rs.getInt("idPrenotazione"));
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

    public IncludeBean doRetrieveByPrenotazione(int codice) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from " + IncludeDAO.TABLE_NAME + " where idPrenotazione=?";
        IncludeBean b = new IncludeBean();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, codice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setIdPrenotazione(rs.getInt("idPrenotazione"));
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

    public ArrayList<IncludeBean> doRetrieveAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<IncludeBean> ab = new ArrayList<IncludeBean>();
        String query = "select * from OrdinePrenotazione";

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            IncludeBean b = new IncludeBean();
            while (rs.next()) {
                b.setIdPrenotazione(rs.getInt("idPrenotazione"));
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

    public void doSave(IncludeBean utente) throws SQLException {
        String query = "insert into OrdinePrenotazione values(?,?);";

        Connection con = null;
        PreparedStatement ps = null;


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, utente.getIdPrenotazione());
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

    public void doDelete(IncludeBean utente) throws SQLException {
        String query = "delete from " + IncludeDAO.TABLE_NAME + " where idPrenotazione=?";
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

}