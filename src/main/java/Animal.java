import org.sql2o.Connection;
public class Animal{
//  THIS WILL ONLY BE ACCESSED WITHIN THI CLASS!!
    private double id;
    private Sighting name;
    private Sighting category;
    private Sighting health;
    private Sighting age;
    private Sighting status;
    private DB db=new DB();
    public Animal(double id,String name,String category,String health, String age, String status){

        this.id=id;
        this.name=name;
        this.category=category;
        this.health=health;
        this.age=age;
        this.status=status;
    }
    public double getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getCategory(){
        return this.category;
    }
    public String getHealth(){
        return this.health;
    }
    public String getAge(){
        return this.age;
    }
    public String getStatus(){
        return this.status;
    }


    public boolean save(){

        db.getCon().createQuery("INSERT INTO animal (id,name,category,health,age,status) VALUES(:id,:name,:category,:health,:age,:status)")
                .addParameter("id",id)
                .addParameter("name",name)
                .addParameter("category",category)
                .addParameter("health",health)
                .addParameter("age",age)
                .addParameter("status",status)
                .executeUpdate();
        return  true;
    }


}