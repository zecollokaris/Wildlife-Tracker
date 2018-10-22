//MAIN DATABASE CLASS USED IN THE APPLICATION

//IMPORTS!
import org.sql2o.*;
import java.util.List;

//DATABASE CLASS
public class DB{
    private Connection con;
    public DB(){
        con=new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker","karis","Kar!s123").open();
    }

    public Connection getCon(){
        return con;
    }

    public  String executeCommand(String sql){
        try{
            con.createQuery(sql).executeUpdate();
        }
        catch (Exception ex) {
            return "Error insertion";
        }
        return "Complete";
    }


}
