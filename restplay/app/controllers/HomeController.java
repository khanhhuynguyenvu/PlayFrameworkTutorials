package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.Babe;
import play.libs.Json;
import play.mvc.*;

import java.nio.file.Path;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(views.html.index.render());
    }
    public Result get(){
        return ok("hahah");
    }
    public Result getBabe(Http.Request request){
        JsonNode jsonNode = request.body().asJson();
        if(jsonNode == null){
            return badRequest("Expecting Json Data");
        }else {
            Babe babe = Json.fromJson(jsonNode, Babe.class);
            return ok(Json.toJson(babe));
        }
    }
    public Result getBabeName(Http.Request request){
        JsonNode jsonNode =   request.body().asJson();
        if(jsonNode == null){
            return badRequest("Expecting Json Data");
        }else{
            String babeName = jsonNode.findPath("name").textValue();
            return ok(Json.toJson(babeName));
        }
    }
}
