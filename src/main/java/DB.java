//MAIN DATABASE CLASS USED IN THE APPLICATION

//IMPORTS!
import org.sql2o.*;
import java.util.List;

//DATABASE CLASS
public class DB{
    private Connection con;
    public DB(){
        con=new Sql2o("jdbc:postgresql://ec2-23-23-80-20.compute-1.amazonaws.com:5432/d6b9dvft2na4n7","lajpujfanekstm","39d38863421fde8cf14a09cf810b5561f009293c78c41deb66d0438a4e9363b8").open();
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


//  ANIMAL!!
    public List<Animal> allData(){
        return con.createQuery("SELECT id,name,category,health,age,status FROM animal").executeAndFetch(Animal.class);
    }

    public Animal getAnimal(double id){
        return (Animal) con.createQuery("SELECT id,name,category,health,age,status FROM animal WHERE id=:id;")
                .addParameter("id",id)
                .executeAndFetchFirst(Animal.class);
    }




//  SIGHTING!!
    public List<Sighting> getSightings(double id) {
        return  con.createQuery("SELECT id, ranger_name, location,doing,animal,date,month FROM sighting WHERE animal=:id;")
                .addParameter("id", id)
                .executeAndFetch(Sighting.class);
    }

    public List<Sighting> getSighting(double id) {
        return con.createQuery("SELECT id,ranger_name,location,doing,animal,date,month FROM sighting WHERE animal=:id;")
                //Cast From Double To String
                .addParameter("id", Double.toString(id))
                .executeAndFetch(Sighting.class);
    }

}
