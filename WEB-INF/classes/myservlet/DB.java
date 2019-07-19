package myservlet;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    public static Connection dbCon(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/OLAS_DB?characterEncoding=gb2312", "root","***"); //½â¾öºº×ÖÂÒÂëÐèÒª
        }
        catch(Exception e){
            System.out.printf("err");
        };
        return con;
    }
}
