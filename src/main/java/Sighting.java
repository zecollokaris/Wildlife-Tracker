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
    public String getRanger_name(){
        return this.ranger_name;
    }
    public String getLocation(){
        return this.location;
    }
    public String getDoing(){
        return this.doing;
    }
    public String getAnimal(){
        return this.animal;
    }
    public String getDate(){
        return this.date;
    }
    public String getMonth(){
        return this.month;
    }


    public boolean save(){
        try {
            db.getCon().createQuery("INSERT INTO sighting(ranger_name,location,doing,animal,date,month) VALUES(:ranger_name,:location,:doing,:animal,:date,:month)")
                    .addParameter("ranger_name",ranger_name)
                    .addParameter("location",location)
                    .addParameter("doing",doing)
                    .addParameter("animal",animal)
                    .addParameter("date",date)
                    .addParameter("month",month)
                    .executeUpdate();
            return true;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
            return false;
        }
    }

}