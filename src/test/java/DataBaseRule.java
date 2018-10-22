//  THIS DATABASE CONTAINS THE DATABASE RULES!!
// IT SETS IN BEFORE AND AFTER INSTEAD OF ALWAYS WRITING!!

import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DataBaseRule extends ExternalResource{
//  SETTING UP A CONNECTION!!
    private Connection con;
    private Sql2o sql2o=new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker_test","karis","Kar!s123");

//  @OVERRIDE
    @Override
    public void before(){
        con=sql2o.open();
    }



}
