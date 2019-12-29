package controllers;

import models.Friend;
import play.mvc.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Random;

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

    public Result add(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        Friend friend = new Friend(new Random().nextInt(333));
        em.getTransaction().begin();
        em.persist(friend);
        em.getTransaction().commit();
        emf.close();
        return ok("Done");
    }

}
