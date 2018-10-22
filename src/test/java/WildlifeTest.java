//DATABASE TEST TO BE CARRIED OUT BY APP!


//IMPORTS!
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.assertEquals;

public class WildlifeTest{

//  DATABASE RULE!!
    @Rule
    public DataBaseRule db=new DataBaseRule();


    public boolean InsertSighting() {
        db.getCon().createQuery("INSERT INTO sighting (ranger_name,location,doing,animal,date,month) VALUES (:id,:ranger_name,:location,:doing,:animal,:date,:month);")
        .addParameter("ranger_name","Collins Kariuki")
        .addParameter("location","Near The Lake")
        .addParameter("doing","Feeding on grass")
        .addParameter("animal","zebra")
        .addParameter("date","21st")
        .addParameter("month","September")
        .executeUpdate();
        return true;
    }

    public boolean InsertAnimal() {
        db.getCon().createQuery("INSERT INTO animal (id,name,category,health,age,status) VALUES (:id,:name,:category,:health,:age,:status);")
        .addParameter("ranger_name","Collins Kariuki")
        .addParameter("location","Near The Lake")
        .addParameter("doing","Feeding on grass")
        .addParameter("animal","zebra")
        .addParameter("date","21st")
        .addParameter("month","September")
        .executeUpdate();
    }


}
