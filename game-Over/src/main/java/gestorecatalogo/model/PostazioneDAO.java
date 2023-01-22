package gestorecatalogo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.DriverManagerConnectionPool;


public class PostazioneDAO {
    private static final String TABLE_NAME = "Postazione";

    public PostazioneBean doRetriveByKey(int codice) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from " + PostazioneDAO.TABLE_NAME + " where idPostazione=?";
        PostazioneBean b = new PostazioneBean();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, codice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setIdPostazione(rs.getInt("idPostazione"));
                b.setOra(rs.getString("ora"));
                b.setPrezzo(rs.getDouble("prezzo"));
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

    public ArrayList<PostazioneBean> doRetrieveAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<PostazioneBean> ab = new ArrayList<PostazioneBean>();
        String query = "select * from Postazione";

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            PostazioneBean b = new PostazioneBean();
            while (rs.next()) {
                b.setIdPostazione(rs.getInt("idPostazione"));
                b.setOra(rs.getString("ora"));
                b.setPrezzo(rs.getDouble("prezzo"));
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

    public void doSave(PostazioneBean utente) throws SQLException {
        String query = "INSERT INTO Postazione(ora, prezzo, disp, img) values(?,?,?,?);";

        Connection con = null;
        PreparedStatement ps = null;


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setString(1, utente.getOra());
            ps.setDouble(2, utente.getPrezzo());
            ps.setBoolean(3, utente.isDisp());
            ps.setString(4, utente.getImg());

            ps.executeUpdate();


        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public void doUpdate(PostazioneBean utente) throws SQLException {
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

    public void doDelete(PostazioneBean utente) throws SQLException {
        String query = "delete from " + PostazioneDAO.TABLE_NAME + " where idPostazione=?";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DriverManagerConnectionPool.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, utente.getIdPostazione());
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