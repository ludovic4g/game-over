import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class PrenotazioneDAO {
    private static final String TABLE_NAME="Prenotazione";

    public PrenotazioneBean doRetrieveByKey(int codice) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+PrenotazioneDAO.TABLE_NAME+" where idPrenotazione=?";
        PrenotazioneBean b=new PrenotazioneBean();

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setString(1, codice);
            ResultSet rs= ps.executeQuery();

            while(rs.next()) {
                b.setIdPrenotazione(rs.getInt("idPrenotazione"));
                b.setUtente(rs.getString("utente"));
                b.setPrezzo(rs.getDouble("prezzo"));
                b.setPostiPrenotati(rs.getInt("postiPrenotati"));
                b.setOra(rs.getString("ora"));

            }
            rs.close();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }

        }
        return b;
    }

    public ArrayList<PrenotazioneBean> doRetrieveAll() throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ArrayList<PrenotazioneBean> ab= new ArrayList<PrenotazioneBean>();
        String query= "select * from Prenotazione";

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ResultSet rs= ps.executeQuery();
            PrenotazioneBean b=new PrenotazioneBean();
            while(rs.next()) {
                b.setIdPrenotazione(rs.getInt("idPrenotazione"));
                b.setUtente(rs.getString("utente"));
                b.setPrezzo(rs.getDouble("prezzo"));
                b.setPostiPrenotati(rs.getInt("postiPrenotati"));
                b.setOra(rs.getString("ora"));

                ab.add(b);
            }
            rs.close();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }

        }
        return ab;
    }

    public void doSave(PrenotazioneBean utente) throws SQLException {
        String query="insert into Prenotazione values(?,?,?,?,?);";

        Connection con=null;
        PreparedStatement ps=null;


        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setInt(1, utente.getIdPrenotazione());
            ps.setString(2, utente.getUtente());
            ps.setDouble(3, utente.getPrezzo());
            ps.setInt(4, utente.getPostiPrenotati());
            ps.setString(5, utente.getOra());

            ps.executeUpdate();


        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public int doUpdate(PrenotazioneBean utente) throws SQLException {
        String query="???????";
        Connection con=null;
        PreparedStatement ps=null;

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setString(1, );
            ps.setString(2, );
            ps.execute();
            ctrl=1;
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public boolean doDelete(PrenotazioneBean utente) throws SQLException {
        String query="delete from "+ PrenotazioneBean.TABLE_NAME+" where idPrenotazione=?";
        Connection con=null;
        PreparedStatement ps=null;

        try {
            con= DriverManagerConnectionPool.getConnection();
            ps=con.prepareStatement(query);
            ps.setString(1, utente.getIdPrenotazione());
            ps.execute();
        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

}