//DATABASE TEST TO BE CARRIED OUT BY APP!


//IMPORTS!
import org.junit.Test;
import org.junit.Rule;
import static org.junit.Assert.assertArrayEquals;

public class WildlifeTest{
    @Rule
    public DataBaseRule db= DataBaseRule();

    public boolean InsertSighting(){
        db.getCon().createQuery("INSERT INTO sighting (ranger_name,location)")
    }
}
