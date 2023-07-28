package ke.co.safaricom;

import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class Main {
    public static void main(String[] args) {
        get("/",(request, response) ->{
            return "Wildlife tracker";
        });

        staticFileLocation("/public");
        String layout = "templates/layout.html";
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.html");
        }, new HandlebarsTemplateEngine());

        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("animals", Animal.all());
            model.put("endangeredAnimals", EndangeredAnimal.all());
            model.put("sightings", Sighting.all());
            model.put("template", "templates/index.html");
            return new ModelAndView(model, layout);
        }, new HandlebarsTemplateEngine());

        post("/endangered_sighting", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String rangerName = request.queryParams("rangerName");
            int animalIdSelected = Integer.parseInt(request.queryParams("endangeredAnimalSelected"));
            String latLong = request.params("latLong");
            Sighting sighting = new Sighting(animalIdSelected, latLong, rangerName);
            sighting.save();
            model.put("sighting", "sighting");
            model.put("animals", EndangeredAnimal.all());
            assert EndangeredAnimal.find(animalIdSelected) != null;
            String animal = EndangeredAnimal.find(animalIdSelected).getName();
            model.put("animal", animal);
            model.put("template", "templates/success.html");
            return new ModelAndView(model, "index.html");
        }, new HandlebarsTemplateEngine());
    }

}






