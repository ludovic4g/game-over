import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class RiferiscePPDAO {
    private static final String TABLE_NAME="PrenotazionePostazione";

    public RiferiscePPBean doRetrieveByPostazione(int codice) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+RiferiscePPDAO.TABLE_NAME+" where idPostazione=?";
        RiferiscePPBean b=new RiferiscePPBean();

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setString(1, codice);
            ResultSet rs= ps.executeQuery();

            while(rs.next()) {
                b.setIdPrenotazione(rs.getInt("idPrenotazione"));
                b.setIdPostazione(rs.getInt("idPostazione"));
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
    public RiferiscePPBean doRetrieveByPrenotazione(int codice) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+RiferiscePPDAO.TABLE_NAME+" where idPrenotazione=?";
        RiferiscePPBean b=new RiferiscePPBean();

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setString(1, codice);
            ResultSet rs= ps.executeQuery();

            while(rs.next()) {
                b.setIdPrenotazione(rs.getInt("idPrenotazione"));
                b.setIdPostazione(rs.getInt("idPostazione"));
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

    public ArrayList<RiferiscePPBean> doRetrieveAll() throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ArrayList<RiferiscePPBean> ab= new ArrayList<RiferiscePPBean>();
        String query= "select * from PrenotazionePostazione";

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ResultSet rs= ps.executeQuery();
            RiferiscePPBean b=new RiferiscePPBean();
            while(rs.next()) {
                b.setIdPrenotazione(rs.getInt("idPrenotazione"));
                b.setIdPostazione(rs.getInt("idPostazione"));
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

    public void doSave(RiferiscePPBean utente) throws SQLException {
        String query="insert into PrenotazionePostazione values(?,?);";

        Connection con=null;
        PreparedStatement ps=null;


        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setInt(1, utente.getIdPrenotazione());
            ps.setInt(2, utente.getIdPostazione());

            ps.executeUpdate();


        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public boolean doDelete(RiferiscePPBean utente) throws SQLException {
        String query="delete from "+ RiferiscePP.TABLE_NAME+" where idPrenotazione=?";
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