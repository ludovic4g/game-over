import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class RiferiscePTDAO {
    private static final String TABLE_NAME="PrenotazioneTavolo";

    public RiferiscePTBean doRetrieveByTavolo(int codice) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+RiferiscePTDAO.TABLE_NAME+" where idTavolo=?";
        RiferiscePTBean b=new RiferiscePTBean();

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setString(1, codice);
            ResultSet rs= ps.executeQuery();

            while(rs.next()) {
                b.setIdTavolo(rs.getInt("idTavolo"));
                b.setIdPrenotazione(rs.getInt("idPrenotazione"));
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

    public RiferiscePTBean doRetrieveByPrenotazione(int codice) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+RiferiscePTDAO.TABLE_NAME+" where idPrenotazione=?";
        RiferiscePTBean b=new RiferiscePTBean();

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setString(1, codice);
            ResultSet rs= ps.executeQuery();

            while(rs.next()) {
                b.setIdTavolo(rs.getInt("idTavolo"));
                b.setIdPrenotazione(rs.getInt("idPrenotazione"));
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

    public ArrayList<RiferiscePTBean> doRetrieveAll() throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ArrayList<RiferiscePTBean> ab= new ArrayList<RiferiscePTBean>();
        String query= "select * from PrenotazioneTavolo";

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ResultSet rs= ps.executeQuery();
            RiferiscePTBean b=new RiferiscePTBean();
            while(rs.next()) {
                b.setIdTavolo(rs.getInt("idTavolo"));
                b.setIdPrenotazione(rs.getInt("idPrenotazione"));
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

    public void doSave(RiferiscePTBean utente) throws SQLException {
        String query="insert into PrenotazioneTavolo values(?,?);";

        Connection con=null;
        PreparedStatement ps=null;


        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setInt(1, utente.getIdTavolo());
            ps.setInt(2, utente.getIdPrenotazione());

            ps.executeUpdate();


        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public boolean doDelete(RiferiscePTBean utente) throws SQLException {
        String query="delete from "+ RiferiscePT.TABLE_NAME+" where idPrenotazione=?";
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