package gestorecatalogo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Connection.DriverManagerConnectionPool;

public class TavoloDAO {
    private static final String TABLE_NAME = "Tavolo";

    public TavoloBean doRetriveByKey(int codice) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from " + TavoloDAO.TABLE_NAME + " where idTavolo=?";
        TavoloBean b = new TavoloBean();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, codice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setIdTavolo(rs.getInt("idTavolo"));
                b.setNumeroPosti(rs.getInt("numeroPosti"));
                b.setPrezzoPosto(rs.getDouble("prezzoPosto"));
                b.setOra(rs.getString("ora"));
                b.setDisp(rs.getBoolean("disp"));
                b.setImg(rs.getString("img"));

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
            TavoloBean b = new TavoloBean();
            while (rs.next()) {
                b.setIdTavolo(rs.getInt("idTavolo"));
                b.setNumeroPosti(rs.getInt("numeroPosti"));
                b.setPrezzoPosto(rs.getDouble("prezzoPosto"));
                b.setOra(rs.getString("ora"));
                b.setDisp(rs.getBoolean("disp"));
                b.setImg(rs.getString("img"));

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
        String query = "insert into Tavolo values(?,?,?,?,?,?);";

        Connection con = null;
        PreparedStatement ps = null;


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, utente.getIdTavolo());
            ps.setInt(2, utente.getNumeroPosti());
            ps.setDouble(3, utente.getPrezzoPosto());
            ps.setString(4, utente.getOra());
            ps.setBoolean(5, utente.isDisp());
            ps.setString(6, utente.getImg());


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

    public void doDelete(TavoloBean utente) throws SQLException {
        String query = "delete from " + TavoloDAO.TABLE_NAME + " where idTavolo=?";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DriverManagerConnectionPool.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, utente.getIdTavolo());
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