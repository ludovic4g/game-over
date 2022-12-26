import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import Connection.DriverManagerConnectionPool;

public class IndirizzoDAO {
    private static final String TABLE_NAME="Indirizzo";

    public IndirizzoBean doRetrieveByKey(int codice) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+IndirizzoDAO.TABLE_NAME+" where idIndirizzo=?";
        IndirizzoBean b=new IndirizzoBean();

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setString(1, codice);
            ResultSet rs= ps.executeQuery();

            while(rs.next()) {
                b.setId(rs.getString("idIndirizzo"));
                b.setVia(rs.getString("via"));
                b.setCAP(rs.getInt("CAP"));
                b.setCitta(rs.getString("citta"));
                b.setProvincia(rs.getString("provincia"));
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

    public ArrayList<IndirizzoBean> doRetrieveAll() throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ArrayList<IndirizzoBean> ab= new ArrayList<IndirizzoBean>();
        String query= "select * from Indirizzo";

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ResultSet rs= ps.executeQuery();
            IndirizzoBean b=new IndirizzoBean();
            while(rs.next()) {
                b.setId(rs.getString("idIndirizzo"));
                b.setVia(rs.getString("via"));
                b.setCAP(rs.getInt("CAP"));
                b.setCitta(rs.getString("citta"));
                b.setProvincia(rs.getString("provincia"));

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

    public void doSave(IndirizzoBean utente) throws SQLException {
        String query="insert into Indirizzo values(?,?,?,?,?);";

        Connection con=null;
        PreparedStatement ps=null;


        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setInt(1, utente.getId());
            ps.setString(2, utente.getVia());
            ps.setInt(3, utente.getCAP());
            ps.setString(4, utente.getCitta());
            ps.setString(5, utente.getProvincia());

            ps.executeUpdate();


        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public int doUpdate(IndirizzoBean utente) throws SQLException {
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

    public boolean doDelete(IndirizzoBean utente) throws SQLException {
        String query="delete from "+ IndirizzoBean.TABLE_NAME+" where idIndirizzo=?";
        Connection con=null;
        PreparedStatement ps=null;

        try {
            con= DriverManagerConnectionPool.getConnection();
            ps=con.prepareStatement(query);
            ps.setString(1, utente.getId());
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