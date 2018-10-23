//IMPORTS!
import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;


//APP MAIN CLASS METHOD
public class App{
    static DB db=new DB();
    static Map<String,Object> model=new HashMap<String,Object>();
    public static void main(String[] args) {
//      STATIC FILES LOCATION!!
        staticFileLocation("/public");
//      MAIN VTL FILE!!
        String layout = "templates/layout.vtl";


//\\!!_  THE APPLICATION ROUTES ARE LOCATED HERE!!  _!!//\\


//      Route for viewing Sightings!
    get("/sightings",(request, response) -> {

        model.put("sighting",db.getCon().createQuery("SELECT * FROM sighting;").executeAndFetch(Sighting.class));
        model.put("template","templates/sightings.vtl");
        return new ModelAndView(model, "templates/layout.vtl");
    }, new VelocityTemplateEngine());

//      Route for home That fetches & displays Animal List!
    get("/", (request, response) -> {
        model.put("animal",null);
        if(db.allData().size()>0){
            model.put("animal",db.allData());
        } else {
            model.put("message","There Are No Animals Currently! Please Add...");
        }

        model.put("template", "templates/index.vtl" );
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    








    }

}