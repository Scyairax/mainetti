package business;
import dao.ExecQuery;
import viste.*;


public class ControllLogin {
	
 public static void openvista(String nick ,String pass)
 {
	 String query = "SELECT * FROM user WHERE (nick='"+nick+"')AND(pass='"+pass+"');";
	 ExecQuery istanza = new ExecQuery();
	 int id_user = istanza.excuteSQLQuery(query);
	 int flag = istanza.excuteSQLQueryLogin(id_user);
	 switch(flag){
	 case 1 : {
		 new UserVista(nick);
		 break;
	 			}
	 case 2 : {
		 new IstruttoreViste(nick);
	 	 break;
	 			}
	 case 3 : {
		 new AdminVista(nick);
		 break;
	 			}
	 }
 }

}
