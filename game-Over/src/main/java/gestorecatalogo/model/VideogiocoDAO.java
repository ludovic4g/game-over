package gestorecatalogo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import connection.DriverManagerConnectionPool;

public class VideogiocoDAO {
    private static final String TABLE_NAME = "Videogioco";

    public VideogiocoBean doRetriveByKey(int codice) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from " + VideogiocoDAO.TABLE_NAME + " where id=?";
        VideogiocoBean b = new VideogiocoBean();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, codice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setNome(rs.getString("nome"));
                b.setPrezzo(rs.getDouble("prezzo"));
                b.setAnno(rs.getInt("anno"));
                b.setTipo(rs.getString("tipo"));
                b.setDescrizione(rs.getString("descrizione"));
                b.setImg1(rs.getString("img1"));
                b.setImg2(rs.getString("img2"));
                b.setImg3(rs.getString("img3"));
                b.setImg4(rs.getString("img4"));
                b.setImg5(rs.getString("img5"));

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

    public ArrayList<VideogiocoBean> doRetrieveAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<VideogiocoBean> ab = new ArrayList<VideogiocoBean>();
        String query = "select * from Videogioco";

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            VideogiocoBean b = new VideogiocoBean();
            while (rs.next()) {
                b.setNome(rs.getString("nome"));
                b.setPrezzo(rs.getDouble("prezzo"));
                b.setAnno(rs.getInt("anno"));
                b.setTipo(rs.getString("tipo"));
                b.setDescrizione(rs.getString("descrizione"));
                b.setImg1(rs.getString("img1"));
                b.setImg2(rs.getString("img2"));
                b.setImg3(rs.getString("img3"));
                b.setImg4(rs.getString("img4"));
                b.setImg5(rs.getString("img5"));

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

    public void doSave(VideogiocoBean utente) throws SQLException {
        String query = "insert into Videogioco values(?,?,?,?,?,?,?,?,?,?,?);";

        Connection con = null;
        PreparedStatement ps = null;


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setInt(1, utente.getId());
            ps.setString(2, utente.getNome());
            ps.setDouble(3, utente.getPrezzo());
            ps.setInt(4, utente.getAnno());
            ps.setString(5, utente.getTipo());
            ps.setString(6, utente.getDescrizione());
            ps.setString(7, utente.getImg1());
            ps.setString(8, utente.getImg2());
            ps.setString(9, utente.getImg3());
            ps.setString(10, utente.getImg4());
            ps.setString(11, utente.getImg5());

            ps.executeUpdate();


        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public void doUpdate(VideogiocoBean utente) throws SQLException {
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

    public void doDelete(VideogiocoBean utente) throws SQLException {
        String query = "delete from " + VideogiocoDAO.TABLE_NAME + " where id=?";
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