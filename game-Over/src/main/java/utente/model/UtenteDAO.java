package utente.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connection.DriverManagerConnectionPool;

public class UtenteDAO {
    private static final String TABLE_NAME = "Utente";

    public UtenteBean doRetrieveByKey(String codice) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from " + UtenteDAO.TABLE_NAME + " where username=?";
        UtenteBean b = new UtenteBean();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setString(1, codice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setUsername(rs.getString("username"));
                b.setPassword(rs.getString("password"));
                b.setEmail(rs.getString("email"));
                b.setNome(rs.getString("nome"));
                b.setCognome(rs.getString("cognome"));
                b.setBday(rs.getDate("ddn"));
                b.setSex((rs.getString("sex")));
                b.setRisposta(rs.getString("risposta"));
                b.setGestoreCatalogo(rs.getBoolean("ammin1"));
                b.setGestorePrenotazioni(rs.getBoolean("ammin2"));
                b.setGestoreOrdini(rs.getBoolean("ammin3"));
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

    public ArrayList<UtenteBean> doRetrieveAll() throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ArrayList<UtenteBean> ab = new ArrayList<UtenteBean>();
        String query = "select * from Utente";

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            UtenteBean b = new UtenteBean();
            while (rs.next()) {
                b.setUsername(rs.getString("username"));
                b.setPassword(rs.getString("password"));
                b.setEmail(rs.getString("email"));
                b.setNome(rs.getString("nome"));
                b.setCognome(rs.getString("cognome"));
                b.setBday(rs.getDate("ddn"));
                b.setSex((rs.getString("sex")));
                b.setRisposta(rs.getString("risposta"));
                b.setGestoreCatalogo(rs.getBoolean("ammin1"));
                b.setGestorePrenotazioni(rs.getBoolean("ammin2"));
                b.setGestoreOrdini(rs.getBoolean("ammin3"));

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

    public boolean doSave(UtenteBean utente) throws SQLException {
        String query = "insert into utente values(?,?,?,?,?,?,?,?,?,?,?);";

        Connection con = null;
        PreparedStatement ps = null;


        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setString(1, utente.getUsername());
            ps.setString(2, utente.getPassword());
            ps.setString(3, utente.getEmail());
            ps.setString(4, utente.getNome());
            ps.setString(5, utente.getCognome());
            ps.setDate(6, new java.sql.Date(utente.getBday().getTime()));
            ps.setString(7, utente.getSex());
            ps.setString(8, utente.getRisposta());
            ps.setBoolean(9, utente.isGestoreCatalogo());
            ps.setBoolean(10, utente.isGestorePrenotazioni());
            ps.setBoolean(11 ,utente.isGestoreCatalogo());

            ps.executeUpdate();


        }catch(Exception e) {
        	e.printStackTrace();
        	return false;
    }finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
        return true;
    }

    public void doUpdate(UtenteBean utente) throws SQLException {
        String query = "update " + UtenteDAO.TABLE_NAME + " set password=? where username=?";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setString(1, utente.getUsername());
            ps.setString(2, utente.getPassword());
            ps.execute();

        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }

    }

    public void doDelete(UtenteBean utente) throws SQLException {
        String query = "delete from " + UtenteDAO.TABLE_NAME + " where username=?";
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DriverManagerConnectionPool.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, utente.getUsername());
            ps.execute();
        } finally {
            try {
                if (ps != null) ps.close();
            } finally {
                DriverManagerConnectionPool.releaseConnection(con);
            }
        }
    }

    public UtenteBean login(String username, String password) {
        UtenteBean utente=null;
        PreparedStatement pst;
        ResultSet rs;
        Connection con=null;

        try {
            con= DriverManagerConnectionPool.getConnection();
            String query= "select * from utente where username=? and password=?";
            pst= con.prepareStatement(query);
            pst.setString(1, username);
            pst.setString(2,password);
            rs= pst.executeQuery();
            if(rs.next()) {
                utente = new UtenteBean();
                utente.setUsername(rs.getString("username"));
                utente.setPassword(rs.getString("password"));
                utente.setEmail(rs.getString("email"));
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));
                utente.setBday(new java.util.Date(rs.getDate("ddn").getTime()));
                utente.setSex(rs.getString("sex"));
                utente.setRisposta(rs.getString("risposta"));
                utente.setGestoreCatalogo(rs.getBoolean("ammin1"));
                utente.setGestorePrenotazioni(rs.getBoolean("ammin2"));
                utente.setGestoreOrdini(rs.getBoolean("ammin3"));
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }

        return utente;
    }
 ////////////////////////////////////////////////////////////////////////////////////////////   
    public String doRetrieveDomanda(String email) {
    	  Connection con = null;
          PreparedStatement ps = null;
          String query = "select domanda from " + UtenteDAO.TABLE_NAME + " where email=?";
          String domanda=null;

          try {
              con = DriverManagerConnectionPool.getConnection();

              ps = con.prepareStatement(query);
              ps.setString(1, email);
              ResultSet rs = ps.executeQuery();

              while (rs.next()) {
                  domanda=rs.getString("domanda");
                 
              }
              rs.close();
          }catch(Exception e) {
        	  e.printStackTrace();
    }finally {
              try {
                  if (ps != null) ps.close();
              }catch(Exception e) {
            	  e.printStackTrace();
              } finally {
              }
                  DriverManagerConnectionPool.releaseConnection(con);
              }

          return domanda;
    }
    
    public UtenteBean doRetrieveByMail(String codice) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String query = "select * from " + UtenteDAO.TABLE_NAME + " where email=?";
        UtenteBean b = new UtenteBean();

        try {
            con = DriverManagerConnectionPool.getConnection();

            ps = con.prepareStatement(query);
            ps.setString(1, codice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                b.setUsername(rs.getString("username"));
                b.setPassword(rs.getString("password"));
                b.setEmail(rs.getString("email"));
                b.setNome(rs.getString("nome"));
                b.setCognome(rs.getString("cognome"));
                b.setBday(rs.getDate("ddn"));
                b.setSex((rs.getString("sex")));
                b.setRisposta(rs.getString("risposta"));
                b.setGestoreCatalogo(rs.getBoolean("ammin1"));
                b.setGestorePrenotazioni(rs.getBoolean("ammin2"));
                b.setGestoreOrdini(rs.getBoolean("ammin3"));
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
    
    public String doRetrieveRisposta(String email) throws SQLException{
    	        Connection con = null;
    	        PreparedStatement ps = null;
    	        String query = "select risposta from " + UtenteDAO.TABLE_NAME + " where username=?";
    	        String risposta=null;

    	        try {
    	            con = DriverManagerConnectionPool.getConnection();

    	            ps = con.prepareStatement(query);
    	            ps.setString(1, email);
    	            ResultSet rs = ps.executeQuery();

    	            while (rs.next()) {
    	                risposta=rs.getString("risposta");
    	            }
    	            rs.close();
    	        } finally {
    	            try {
    	                if (ps != null) ps.close();
    	            } finally {
    	                DriverManagerConnectionPool.releaseConnection(con);
    	            }

    	        }
    	        return risposta;
  }
    
    public void ModifyPassword(String id, String nome) throws SQLException{
		String query="update utente set password=? where username=?"; 
		Connection con=null; 
		PreparedStatement ps=null; 
		
		try {
			con= DriverManagerConnectionPool.getConnection(); 
			
			ps=con.prepareStatement(query); 
			ps.setString(2, id);
			ps.setString(1, nome);
			ps.executeUpdate();

		}finally {
			try {
				if(ps!=null) ps.close(); 
			}finally {
				DriverManagerConnectionPool.releaseConnection(con);
			}
		}
		}
		
		public void ModifyNome(String id, String nome) throws SQLException{
			String query="update utente set nome=? where username=?"; 
			Connection con=null; 
			PreparedStatement ps=null; 
			
			try {
				con= DriverManagerConnectionPool.getConnection(); 
				
				ps=con.prepareStatement(query); 
				ps.setString(2, id);
				ps.setString(1, nome);
				ps.executeUpdate();

			}finally {
				try {
					if(ps!=null) ps.close(); 
				}finally {
					DriverManagerConnectionPool.releaseConnection(con);
				}
			}
			
		
	}
		
		public void ModifyCognome(String id, String nome) throws SQLException{
			String query="update utente set cognome=? where username=?"; 
			Connection con=null; 
			PreparedStatement ps=null; 
			
			try {
				con= DriverManagerConnectionPool.getConnection(); 
				
				ps=con.prepareStatement(query); 
				ps.setString(2, id);
				ps.setString(1, nome);
				ps.executeUpdate();

			}finally {
				try {
					if(ps!=null) ps.close(); 
				}finally {
					DriverManagerConnectionPool.releaseConnection(con);
				}
			}
	}
		
		public void ModifyMail(String id, String nome) throws SQLException{
			String query="update utente set email=? where username=?"; 
			Connection con=null; 
			PreparedStatement ps=null; 
			
			try {
				con= DriverManagerConnectionPool.getConnection(); 
				
				ps=con.prepareStatement(query); 
				ps.setString(2, id);
				ps.setString(1, nome);
				ps.executeUpdate();

			}finally {
				try {
					if(ps!=null) ps.close(); 
				}finally {
					DriverManagerConnectionPool.releaseConnection(con);
				}
			}
	}
		public void ModifyDDn(String id, java.util.Date nome) throws SQLException{
			String query="update utente set ddn=? where username=?"; 
			Connection con=null; 
			PreparedStatement ps=null; 
			
			try {
				con= DriverManagerConnectionPool.getConnection(); 
				
				ps=con.prepareStatement(query); 
				ps.setString(2, id);
				ps.setDate(1,(java.sql.Date) nome);
				ps.executeUpdate();

			}finally {
				try {
					if(ps!=null) ps.close(); 
				}finally {
					DriverManagerConnectionPool.releaseConnection(con);
				}
			}
	}
		
		public void ModifyGender(String id, String nome) throws SQLException{
			String query="update utente set sex=? where username=?"; 
			Connection con=null; 
			PreparedStatement ps=null; 
			
			try {
				con= DriverManagerConnectionPool.getConnection(); 
				
				ps=con.prepareStatement(query); 
				ps.setString(2, id);
				ps.setString(1, nome);
				ps.executeUpdate();

			}finally {
				try {
					if(ps!=null) ps.close(); 
				}finally {
					DriverManagerConnectionPool.releaseConnection(con);
				}
			}
	}
		
		public void ModifyDomanda(String id, String nome) throws SQLException{
			String query="update utente set domanda=? where username=?"; 
			Connection con=null; 
			PreparedStatement ps=null; 
			
			try {
				con= DriverManagerConnectionPool.getConnection(); 
				
				ps=con.prepareStatement(query); 
				ps.setString(2, id);
				ps.setString(1, nome);
				ps.executeUpdate();

			}finally {
				try {
					if(ps!=null) ps.close(); 
				}finally {
					DriverManagerConnectionPool.releaseConnection(con);
				}
			}
	}
		
		public void ModifyRisposta(String id, String nome) throws SQLException{
			String query="update utente set risposta=? where username=?"; 
			Connection con=null; 
			PreparedStatement ps=null; 
			
			try {
				con= DriverManagerConnectionPool.getConnection(); 
				
				ps=con.prepareStatement(query); 
				ps.setString(2, id);
				ps.setString(1, nome);
				ps.executeUpdate();

			}finally {
				try {
					if(ps!=null) ps.close(); 
				}finally {
					DriverManagerConnectionPool.releaseConnection(con);
				}
			}
	}
		
		public String doRetrievePassword(String email) {
		  	  Connection con = null;
		        PreparedStatement ps = null;
		        String query = "select password from " + UtenteDAO.TABLE_NAME + " where username=?";
		        String risposta=null;

		        try {
		            con = DriverManagerConnectionPool.getConnection();

		            ps = con.prepareStatement(query);
		            ps.setString(1, email);
		            ResultSet rs = ps.executeQuery();

		            while (rs.next()) {
		                risposta=rs.getString("password");
		               
		            }
		            rs.close();
		        }catch(Exception e) {
		      	  e.printStackTrace();
		  }finally {
		            try {
		                if (ps != null) ps.close();
		            }catch(Exception e) {
		          	  e.printStackTrace();
		            } finally {
		            }
		                DriverManagerConnectionPool.releaseConnection(con);
		            }

		        return risposta;
		  }

		 public void saveDomanda(String risposta) throws SQLException {
		        String query = "insert into utente values(?);";

		        Connection con = null;
		        PreparedStatement ps = null;


		        try {
		            con = DriverManagerConnectionPool.getConnection();

		            ps = con.prepareStatement(query);
		            ps.setString(1, risposta);

		            ps.executeUpdate();


		        } finally {
		            try {
		                if (ps != null) ps.close();
		            } finally {
		                DriverManagerConnectionPool.releaseConnection(con);
		            }
		        }
		    }
}
