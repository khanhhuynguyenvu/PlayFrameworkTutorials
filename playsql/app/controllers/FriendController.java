package controllers;

import daos.central.CentralDao;
import models.Friend;
import play.mvc.Controller;
import play.mvc.Result;

//Demo CRUD Friend object in mysql database
public class FriendController extends Controller {
    private CentralDao centralDao = new CentralDao();

    public Result add() {
        Friend friend = new Friend();
        friend.setName("name");
        friend.setSurname("surname");
        centralDao.getFriendDao().save(friend);
        return ok("Create Friend Object with Id: " + friend.getId());
    }

    public Result update(String id) {
        Friend friend = centralDao.getFriendDao().findById(id, Friend.class);
        friend.setName("huy update ");
        friend.setSurname("huy surname update");
        centralDao.getFriendDao().update(friend);
        return ok("Update Friend object: " + friend.toString());
    }

    public Result delete(String id){
        Friend friend = centralDao.getFriendDao().findById(id,Friend.class);
        centralDao.getFriendDao().remove(friend);
        return ok("Delete Friend object: "+ friend.toString());
    }
}
