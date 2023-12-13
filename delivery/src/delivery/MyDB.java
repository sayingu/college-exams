package delivery;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import java.text.SimpleDateFormat;


public class MyDB {
	static  Connection con         = null;
	static  Statement stmt         = null;
	static  ResultSet rs           = null ;

	static String driver= "com.mysql.jdbc.Driver";
	static String URL = "jdbc:mysql://localhost:3306/delivery" ;;
	
	static {
		loadConnect();
	}
	
	public static void loadConnect()  { //DB와 연결하는 메소드 입니다.
		try {
			// 연결을 닫는다.
			if( stmt != null ) stmt.close();
			if( con != null ) con.close();
		} catch (SQLException ex ) {};  
		
		// 드라이버 로딩
		try {
			Class.forName(driver);

		} catch ( java.lang.ClassNotFoundException e ) {
			System.err.println("** Driver loaderror in loadConnect: " + e.getMessage() );
			e.printStackTrace();

		}

		try {
			// 연결하기
			con  = DriverManager.getConnection(URL, "root", "onlyroot");

			System.out.println("\n"+URL+"에 연결됨");


		} catch( SQLException ex ) 
		{

			System.err.println("** connection error in loadConnect(): " + ex.getMessage() );
			ex.printStackTrace();
		}	   

	}
	
	
	public static ResultSet selectQuery(String sql) { //인수는 select하는 sql문
		try {
			// Statement 생성 
			stmt = con.createStatement();


			rs = stmt.executeQuery(sql);  

		} catch( SQLException ex ) 	    {
			System.err.println("** SQL exec error in selectQuery() : " + ex.getMessage() );
		}

		return rs; //selectQuery문의 resultset 반환 합니다. 

	}

	public static int updateQuery(String sql) { //인수는 추가, 삭제, 수정하는 sql문 
		int count;

		try {
			// Statement 생성 
			stmt = con.createStatement();
			count = stmt.executeUpdate(sql);  //count로 실행이 되었는지 체크.
			return count;

		} catch( SQLException ex ) 	    {
			System.err.println("** SQL exec error in updateQuery() : " + ex.getMessage() );
			return 0; 
		}	
	}
	
	public static ResultSet selectAllCustomer() {  //전체 고객 출력하는 메소드입니다.
		String sql = "select * from customer;";
		System.out.println("   >> SQL : " + sql + "\n");

		return selectQuery(sql);
	}
	
	public static ResultSet selectAllstore() {  //전체 음식점 출력하는 메소드입니다.
		String sql = "select * from store;";
		System.out.println("   >> SQL : " + sql + "\n");

		return selectQuery(sql);
	}
	
	
	
	public static void disconnect()  {
		try {
			// 연결을 닫는다.
			if( stmt != null ) stmt.close();
			if( con != null ) con.close();
		} catch (SQLException ex ) {};    
	}

	 public static int deleteOrderbyOnum(String Onum)
	   {
	      String sql = "delete from orders where onum = '"+Onum+"';";
	      
	      return updateQuery(sql);
	   }	
	

	 public static float getSale(String mname)
	   {
	      float sale = 0;
	      
	      rs = selectsalebyMname(mname);
	      
	      try {
	         if(rs.next()) {
	         sale = rs.getFloat("sale");}
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      
	      return sale;
	      
	   }
	 
	 
	  public static ResultSet selectsalebyMname(String mname)
	   {
	      String sql = "select sale from menu where mname = '"+mname+"' ;";
	      
	      return selectQuery(sql);
	   }
	  
	  
	 
	public static ResultSet selectMenuPrice(String ONUM)
	   {
	      String sql = "select menu.price from menu,orders where onum = '"+ONUM+"' and menu.sname = orders.sname;";
	      
	      return selectQuery(sql);
	   }	

	 public static ResultSet selectMenuPrice(String sname, String mname)
	   {
	      String sql="select price from menu "
	            + " where sname = '"+sname+"' and mname = '"+mname+"';";
	      
	      return selectQuery(sql);
	            
	   }	
	public static int updateOrderEdit(String ONUM, String MNAME,int OCNT, int TP, String REQUEST)
	   {
	      int cnt =0;
	      
	      try {
	         String sql = "update orders set MNAME = ?, OCNT = ?, REQUEST = ?, TP = ?, ODATE=now(),OTIME=now() where ONUM = ?";
	         PreparedStatement pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, MNAME);
	         pstmt.setInt(2, OCNT);
	         pstmt.setString(3,REQUEST);
	         pstmt.setInt(4, TP);
	         pstmt.setString(5,ONUM);
	         
	          System.out.println("   >> SQL : " + sql + "\n");
	         
	         cnt = pstmt.executeUpdate();
	         
	          System.out.println("   >> SQL : cnt=" + cnt + "\n");
	      }
	      catch(SQLException e) {
	          System.err.println("** SQL exec error in selectDistinctMenu() : " + e.getMessage() );
	      }
	      return cnt;
	   } 	
	
	
	public static ResultSet selectOrderbyONUM(String ONUM) //주문번호로 주문내역 선택하기
	   {
	      
	      try {
	         String sql ="select sname, mname, ocnt, request, tp from orders where ONUM=?";
	         PreparedStatement pstmt = con.prepareStatement(sql);
	         pstmt.setString(1, ONUM);
	         rs = pstmt.executeQuery();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      return rs;      
	   }	
	
	public static ResultSet selectMyStoreOrders(String SNAME) //가게 주문한 것
	   {
	      String sql = "select CID, MNAME, OTIME, TP, REQUEST, ODATE, OCNT, DAMOUT " + 
	            " from orders where SNAME  = '" + SNAME + "';";
	      
	      return selectQuery(sql);
	   }
	
	//가게이름으로 가게정보출력
	public static ResultSet selectStorebyStorename(String storename) {
		
		String sql = "select * from store where sname like '%"+storename+"%'";
		return selectQuery(sql);
	}
	
	//분류로 가게정보출력
		public static ResultSet selectStorebyClassification(String classification) {
			
			String sql = "select * from store where CLASSIFICATION ='"+classification+"'";
			return selectQuery(sql);
		}
		
	//가게운영자 아이디로 가게정보출력
	public static ResultSet selectStorebySID(String sid) {
		
		String sql = "select * from store where sname =(select sname from STORE_ADMIN where sid='"+sid+"')";
		return selectQuery(sql);
	}
	
	 public static ResultSet selectMyOrders(String CID) //내가 주문한 것
	   {
	      String sql = "select ONUM, SNAME, MNAME, OTIME, TP, REQUEST, ODATE, OCNT,DAMOUT " + 
	            " from orders  where CID = '"+ CID +"'; ";
	      System.out.println("   >> SQL : " + sql + "\n");
	      
	      return selectQuery(sql);
	   }
	
	//가게이름으로 메뉴정보출력
		public static ResultSet selectMenubyStorename(String storename) {
			
			String sql = "select * from Menu where sname like '%"+storename+"%'";
			return selectQuery(sql);
		}
		//가게운영자 아이디로 메뉴정보출력
		public static ResultSet selectMenubySID(String sid) {
					
			String sql = "select * from menu where sname =(select sname from STORE_ADMIN where sid='"+sid+"')";
			return selectQuery(sql);
				}
				
		public static ResultSet selectMenubyMNAME(String mname)
		{
				   String sql ="select * from menu where mname ='"+mname+"';";
				       
				   return selectQuery(sql);
			 }

		
		  public static Vector selectDistinctMenu(String sname) { //주문수정에서 메뉴 선택해서 보여주기
		      
		       String sql = "select distinct mname from menu where sname = '"+sname+"' ;";
		       System.out.println("   >> SQL : " + sql + "\n");

		       ResultSet rs = selectQuery(sql);
		       Vector  mnames = new Vector();
		       String mname;

		       try {
		          while(rs.next()) {
		             mnames.add(mname = rs.getString("mname"));
		             System.out.println("   >> SQL : mname=" + mname + "\n");
		          }
		       } catch( SQLException ex ) {
		          System.err.println("** SQL exec error in selectDistinctMenu() : " + ex.getMessage() );      
		       }   

		       return mnames;
		    }		
		
		
		//메뉴 추가
		public static int insertMenu(Menu menu) {
			int updateCnt = 0;

			try {                      
				// SQL 질의문을 수행한다.
				String sql = "insert into menu values (?, ?, ?, ?, ?,0, ?);" ;
				
				
				PreparedStatement prStmt = con.prepareStatement(sql);

				prStmt.setString(1, menu.SNAME);
				prStmt.setString(2, menu.MNAME);
				prStmt.setInt(3, menu.PRICE);
				prStmt.setString(4, menu.INTRO);
				prStmt.setInt(5, menu.OCNT);
				prStmt.setFloat(6, menu.SALE);
				

				updateCnt = prStmt.executeUpdate();  		
			} catch( SQLException ex ) {

				System.err.println("\n  ??? SQL exec error in insertMenu(): " + ex.getMessage() );
			}

			return updateCnt;
		}

		
		 public static int updateMenuOcntMinus(String sname, String mname)
		   {
		      String sql = "update menu set ocnt= ocnt-1 where sname = '"+sname+"' and mname = '"+mname+"';";
		      
		      return updateQuery(sql);
		   }		

		 public static int updateCustomerOcntMinus(String CID)
		   {
		      String sql ="update customer set ocnt=ocnt-1 where cid= '"+CID+"';";
		      
		      return updateQuery(sql);
		   }
		 
		 
		public static int updateMenuOcntPlus(String sname, String mname)
		   {
		      String sql = "update menu set ocnt= ocnt+1 where sname = '"+sname+"' and mname = '"+mname+"';";
		      
		      return updateQuery(sql);
		   }		
		
		 public static int updateCustomerOcntPlus(String CID)
		   {
		      String sql ="update customer set ocnt=ocnt+1 where cid= '"+CID+"';";
		      
		      return updateQuery(sql);
		   }

		 public static int updateCancelOrders(String onum, String chreason)
		   {
		      String sql ="update cancel set cdate =now(), ctime= now(), chreason='"+chreason+"' where onum='"+onum+"';";
		   
		      return updateQuery(sql);
		   }		 
		 
		//메뉴 수정
		public static void updatePrice(Menu menu) {
			String sql;

			try {
				// Statement 생성 
				Statement stmt = con.createStatement();

				sql = "update menu set price = "+menu.PRICE+" where mname = "+menu.MNAME;

				stmt.executeUpdate(sql);

			} catch( SQLException ex ) 	    {
				System.err.println("\n  ??? SQL exec error in updatePricece() : " + ex.getMessage() );
			}
		}
		
		public static Menu getMenu(String sname, String mname)  {	
			String sql;

			try {
				ResultSet rs = getMenuRS(sname, mname);  
				
				if (rs.next()) 
					return getMenuFromRS(rs);

			} catch( SQLException ex ) 	    {
				System.err.println("\n  ??? SQL exec error in getMenu() : " + ex.getMessage() );
			}

			return null;		
		}

	//  ResultSet객체에 메뉴 투플이 저장되어 있을 때 이를 Menu 객체로 변환하는 메소드
		public static Menu getMenuFromRS(ResultSet rs) {  
			Menu menu = new Menu();

			try {
				menu.SNAME=rs.getString("sname");
				menu.MNAME=rs.getString("mname");
				menu.PRICE=rs.getInt("price");
				menu.INTRO=rs.getString("intro");
				menu.OCNT=rs.getInt("ocnt");
				menu.SALE=rs.getFloat("sale");

			} catch( SQLException ex ) 	    {
				System.err.println("\n  ??? SQL exec error in getAccountFromRS() : " + ex.getMessage() );
			}

			return menu;
		}

	public static ResultSet getMenuRS(String sname, String mname)  {	
			String sql;

			try {
				// Statement 생성 
				Statement stmt = con.createStatement();

				sql = "select * from menu where sname='"+sname+"' and mname='"+ mname+"';";
				
				ResultSet rs = stmt.executeQuery(sql);  
				
				return rs;

			} catch( SQLException ex ) 	    {
				System.err.println("\n  ??? SQL exec error in getAccount() : " + ex.getMessage() );
			}

			return null;		
		}
	public static ResultSet ShowStoreMenu(String sname) {
		String sql = "select * from menu where SNAME ='"+sname+"'";
		return selectQuery(sql);
	}

public static boolean isValidLogin(String usertype, String id, String pw) {
		
		loadConnect();
		String sql = "";
		
		if (usertype.equals("customer") ) {
			sql = "select * from customer where cid=? and pw=?";			
		}
		else if (usertype.equals("owner") ) {
			sql = "select * from store_admin  where sid=? and pw=?";			
		}		
		try {
			PreparedStatement prStmt = con.prepareStatement(sql);

			prStmt.setString(1, id);
			prStmt.setString(2, pw);

			ResultSet rs = prStmt.executeQuery();  
			if (rs.next())  { 
				return true;
			}			
		} catch( SQLException ex ) {             
			System.err.println("\n  ??? SQL exec error : " + ex.getMessage() );
		}

	    return false;

	}
	
public static boolean isDuplicatedCId(String CID) {
	String sql="";
	
	sql ="select * from customer where CID=? ";
	

	try {
		
		PreparedStatement prStmt = con.prepareStatement(sql);

		prStmt.setString(1, CID);

		ResultSet rs = prStmt.executeQuery();  
		if (rs.next())  { 
			return true;
		}			
	} catch( SQLException ex ) {             
		System.err.println("\n  ??? SQL exec error in isDuplicatedId(): " + ex.getMessage() );

	}

    return false;
}

public static boolean isDuplicatedSId(String SID) {
	String sql="";
	
	sql ="select * from store_admin where SID=? ";
	

	try {
		
		PreparedStatement prStmt = con.prepareStatement(sql);

		prStmt.setString(1, SID);

		ResultSet rs = prStmt.executeQuery();  
		if (rs.next())  { 
			return true;
		}			
	} catch( SQLException ex ) {             
		System.err.println("\n  ??? SQL exec error in isDuplicatedId(): " + ex.getMessage() );

	}

    return false;
}


    
public static boolean insertCustomer(String CID, String PW, String CNAME,String ADD,String CP) {
	
	
	
	String sql = "insert into customer values('" +CID+ "', '" +PW+ "', '" +CNAME+"', '" +ADD+ "', '"+CP+"', now(), 0, 0);";
	
	
	System.out.println("\n sql = " + sql +"\n\n");
	
	try {
		Statement stmt = con.createStatement();

	    return stmt.executeUpdate(sql) == 1;
	
   } catch( SQLException ex ) {             
	   System.err.println("\n  ??? SQL exec error in isDuplicatedId(): " + ex.getMessage() );
   }
	
	return false;
}

public static int updateReview(String ONUM,String MREVIEW, int MGPA ) // 리뷰 갱신하기
{
	String sql = "update orders set "
			+ " MREVIEW = '" + MREVIEW +"', MGPA = " +MGPA + ", WDATE = now(), WTIME = now() where ONUM = '" +ONUM+"';";
	
	return updateQuery(sql);
}

public static int updateMReviewCountPlus(String mname) //메뉴리뷰건수 +1
{
	String sql = "update menu set RCNT = RCNT +1 where sname='"+mname+"';";
	
	return updateQuery(sql);
}

public static int updateCustomerRcnt(String CID){
	
	String sql = "update customer set RCNT = RCNT +1 where CID='"+CID+"';";
	
	return updateQuery(sql);
			
}

public static int insertCancelOrders(String onum)
{
   String sql = "insert into cancel(onum, cid, sname, mname, otime, tp, request, odate, ocnt, damout) "
             + " select onum, cid, sname, mname, otime, tp, request, odate, ocnt, damout "
             + "from orders where ONUM = '"+onum+"' ;";
   
   return updateQuery(sql);       
}

public static String getOnum() //원래 주문테이블에 있는 주문번호의 맨 마지막을 찾아 +1 해줌
{
   int intonum = getMaxOnum();
   
   intonum++;
   
   String onum = "";
   
   if( intonum < 10)
   {
      onum = "000" + intonum;
   }
   else if( intonum < 100)
   {
      onum = "00" + intonum;
   }
   else if( intonum < 100)
   {
      onum = "0" + intonum;
   }
   else
   {
      onum = "" + intonum;
   }
   
   return onum;
}


public static int getMaxOnum()
{
   int maxOnum = 0;
   rs = selectMaxOnum();
   
   try {
      if(rs.next())
      {maxOnum = rs.getInt("maxOnum");}
      
   } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
   }
   
   return maxOnum;
}


public static ResultSet selectMaxOnum()
{
   String sql = "select max(onum + 0) as maxOnum from orders";
   
   return selectQuery(sql);
}

public static int insertOrder(String CID, String SNAME,  String MNAME, int TP,String REQUEST, int OCNT,int DAMOUT)
{
  
  String ONUM = getOnum();
   
   int cnt =0;
   
   try {                      
      // SQL 질의문을 수행한다.
      
      String sql="insert into orders value(?,?,?,?,now(),?,?,now(),?,?,null,0,null,null,null);";
      
      
      PreparedStatement prStmt = con.prepareStatement(sql);

      prStmt.setString(1, ONUM);
      prStmt.setString(2, CID);
      prStmt.setString(3, SNAME);
      prStmt.setString(4, MNAME);
      prStmt.setInt(5, TP);
      prStmt.setString(6, REQUEST);
      prStmt.setInt(7, OCNT);
      prStmt.setInt(8, DAMOUT);

      cnt = prStmt.executeUpdate();        
   } catch( SQLException ex ) {

      System.err.println("\n  ??? SQL exec error in insertOrder(): " + ex.getMessage() );
   }
   
   return cnt;
}


public static boolean insertAdmin(String SID, String SNAME, String SADNAME, String PW, String CP, String ADD) {
	
	
	
	String sql = "insert into store_admin values('" +SID+ "', '" +SNAME+ "', '" +SADNAME+"', '" +PW+ "', '"+CP+"', '"+ADD+"', now());";
	
	
	System.out.println("\n sql = " + sql +"\n\n");
	
	try {
		Statement stmt = con.createStatement();

	    return stmt.executeUpdate(sql) == 1;
	
   } catch( SQLException ex ) {             
	   System.err.println("\n  ??? SQL exec error in isDuplicatedId(): " + ex.getMessage() );
   }
	
	return false;
	}	


public static boolean insertStore(String SNAME, String CLASSTIFICATION, String OPENTIME, String CLOSETIME) {
	
	
	
	String sql = "insert into store values('" +SNAME+ "', '" +CLASSTIFICATION+ "', '" +OPENTIME+"', '" +CLOSETIME+ "');";
	
	
	System.out.println("\n sql = " + sql +"\n\n");
	
	try {
		Statement stmt = con.createStatement();

	    return stmt.executeUpdate(sql) == 1;
	
   } catch( SQLException ex ) {             
	   System.err.println("\n  ??? SQL exec error in isDuplicatedId(): " + ex.getMessage() );
   }
	
	return false;
}	

public static ResultSet insertMenuRS(String sname, String mname, String price, String intro) {
    
	   // SQL 질의문을 수행한다.
	   String sql = "insert into menu values ('" + sname + "', '" + mname + "', " 
	             + price + ", '" + intro + "',0,0,0); ";
	   int count = updateQuery(sql);
	      
	      if (count==1)
	         return selectQuery("select * from menu where sname='"+sname+"';");
	      else
	         return null;
	}


public static ResultSet UpdateMenuRS(String sname,String mname, String price, String intro, String sale){
	   String sql;

	   sql = "update menu set price="+price+", intro='"+intro+"', sale= "+sale+" where mname = '"+mname+"' and sname='"+sname+"';";

	   int count = updateQuery(sql);
	   
	   if (count==1)
	         return selectQuery("select * from menu where sname='"+sname+"';");
	      else
	         return null;
	}


//가게이름으로 리뷰정보출력
public static ResultSet selectReviewbyStorename(String storename) {
   
   String sql = "select sname, mreview, mgpa, wdate, wtime from orders where sname like '"+storename+"'";
   return selectQuery(sql);
}
public static String selectSnameOfId(String Id) {
	String sql="select * from store_admin where sid='" + Id+ "';";
	
	ResultSet rs = selectQuery(sql);
	
	try {
		
	if (rs.next())		
		return (String) rs.getString("sname");
	
	
	
	}
	catch(Exception e) {}
	
	return null;
}

}




