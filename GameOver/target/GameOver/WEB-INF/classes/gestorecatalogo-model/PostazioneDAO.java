import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;


public class PostazioneDAO {
    private static final String TABLE_NAME="Postazione";

    public PostazioneBean doRetriveByKey(int codice) throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        String query= "select * from "+PostazioneDAO.TABLE_NAME+" where idPostazione=?";
        PostazioneBean b=new PostazioneBean();

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setString(1, codice);
            ResultSet rs= ps.executeQuery();

            while(rs.next()) {
                b.setIdPostazione(rs.getInt("idPostazione"));
                b.setOra(rs.getString("ora"));
                b.setPrezzo(rs.getDouble("prezzo"));
                b.setImg(rs.getString("img"));

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

    public ArrayList<PostazioneBean> doRetrieveAll() throws SQLException {
        Connection con=null;
        PreparedStatement ps=null;
        ArrayList<PostazioneBean> ab= new ArrayList<PostazioneBean>();
        String query= "select * from Postazione";

        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ResultSet rs= ps.executeQuery();
            PostazioneBean b=new PostazioneBean();
            while(rs.next()) {
                b.setIdPostazione(rs.getInt("idPostazione"));
                b.setOra(rs.getString("ora"));
                b.setPrezzo(rs.getDouble("prezzo"));
                b.setImg(rs.getString("img"));

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

    public void doSave(PostazioneBean utente) throws SQLException {
        String query="insert into Postazione values(?,?,?,?,);";

        Connection con=null;
        PreparedStatement ps=null;


        try {
            con= DriverManagerConnectionPool.getConnection();

            ps=con.prepareStatement(query);
            ps.setInt(1, utente.getIdPostazione());
            ps.setString(2, utente.getOra());
            ps.setDouble(3, utente.getPrezzo());
            ps.setString(4, utente.getImg());

            ps.executeUpdate();


        }finally {
            try {
                if(ps!=null) ps.close();
            }finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public int doUpdate(PostazioneBean utente) throws SQLException {
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

    public boolean doDelete(PostazioneBean utente) throws SQLException {
        String query="delete from "+ PostazioneBean.TABLE_NAME+" where idPostazione=?";
        Connection con=null;
        PreparedStatement ps=null;

        try {
            con= DriverManagerConnectionPool.getConnection();
            ps=con.prepareStatement(query);
            ps.setString(1, utente.getIdPostazione());
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