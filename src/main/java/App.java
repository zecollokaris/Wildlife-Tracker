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



//\\!!_  HEROKU DEPLOYMENT-PROCESS BUILDER!!  _!!//\\
    ProcessBuilder process = new ProcessBuilder();
    Integer port;
    if (process.environment().get("PORT") != null) {
        port = Integer.parseInt(process.environment().get("PORT"));
    } else {
        port = 4567;
    }

    setPort(port);



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


    get("/animalform", (request, response) -> {

        model.put("template", "templates/animalform.vtl");
        return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


//      Route to Post Animals!
    post("/newanimal",(request,response)->{
        String id=request.queryParams("id");
        System.out.println(id);
        Animal animal=new Animal(
                Double.parseDouble(id),
                request.queryParams("name"),
                request.queryParams("category"),
                request.queryParams("health"),
                request.queryParams("age"),
                request.queryParams("status")
        );
        animal.save();
        response.redirect("/");
        return new ModelAndView(model,"templates/layout.vtl");
    },new VelocityTemplateEngine());



//      Route to Get Details
    get("/getDetails/:id",(request,response)-> {
//      TRY CATCH STATEMENT!!
        try{
            model.put("animal", db.getAnimal(Double.parseDouble(request.params(":id"))));
            model.put("sightings", db.getSighting(Double.parseDouble(request.params(":id"))));
            model.put("template", "templates/animaldetails.vtl");
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return new ModelAndView(model,"templates/layout.vtl");
    },new VelocityTemplateEngine());



//      Route to Post Sighting!!
        post("/addsighting", (request, response) ->{
            try{
                Sighting sighting = new Sighting(
                        1,
                        request.queryParams("ranger_name"),
                        request.queryParams("location"),
                        request.queryParams("doing"),
                        request.queryParams("animal"),
                        request.queryParams("date"),
                        request.queryParams("month")
                );
                sighting.save();
            }
            catch(Exception ex){
                System.out.println(ex.getMessage());
            }
            response.redirect("/getDetails/"+request.queryParams("animal"));
            return new ModelAndView(model,"templates/layout.vtl");
        }, new VelocityTemplateEngine());




//      DELETING ROUTES!!
        get("/deleteSighting/:sighting/:animal",(request,response)->{
            String SQL="DELETE FROM  sighting WHERE id="+request.params(":sighting");
            db.executeCommand(SQL);
            response.redirect("/getDetails/"+request.params(":animal"));
            return new ModelAndView(model,"templates/layout.vtl");
        },new VelocityTemplateEngine());


        get("/deleteSighting/:sighting",(req,res)->{
            String SQL="DELETE FROM  sighting WHERE id="+req.params(":sighting");
            db.executeCommand(SQL);
            res.redirect("/getSighting");
            return new ModelAndView(model,"templates/layout.vtl");
        },new VelocityTemplateEngine());

        get("/deleteAnimal/:animal",(req,res)->{
            String SQL="DELETE FROM  animal WHERE id="+req.params(":animal");
            db.executeCommand(SQL);
            res.redirect("/");
            return new ModelAndView(model,"templates/layout.vtl");
        },new VelocityTemplateEngine());



    }

}