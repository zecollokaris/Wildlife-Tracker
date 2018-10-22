import org.sql2o.Connection;
public class Sighting {
//  THIS WILL ONLY BE ACCESSED WITHIN THI CLASS!!
    private double id;
    private String ranger_name;
    private String location;
    private String doing;
    private String animal;
    private String date;
    private String month;


    private DB db=new DB();
    public Sighting (double id,String ranger_name,String location,String doing,String animal,String date,String month) {
        this.ranger_name=ranger_name;
        this.location=location;
        this.doing=doing;
        this.animal=animal;
        this.date=date;
        this.month=month;
    }

    public double getId(){
        return this.id;
    }


}