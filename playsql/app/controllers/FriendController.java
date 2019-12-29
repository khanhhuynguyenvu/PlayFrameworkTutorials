//package controllers;
//
//import daos.FriendRepositoryItf;
//import models.Friend;
//import play.data.FormFactory;
//import play.libs.concurrent.HttpExecutionContext;
//import play.mvc.Controller;
//import play.mvc.Result;
//
//import javax.inject.Inject;
//
//public class FriendController extends Controller {
//    private final FormFactory formFactory;
//    private final FriendRepositoryItf friendRepository;
//    private final HttpExecutionContext ec;
//
//    @Inject
//    public FriendController(FormFactory formFactory, FriendRepositoryItf friendRepository, HttpExecutionContext ec) {
//        this.formFactory = formFactory;
//        this.friendRepository = friendRepository;
//        this.ec = ec;
//    }
//
//    public Result add() {
//        Friend friend = new Friend(12);
//        friendRepository.add(friend);
//        return ok(views.html.index.render());
//    }
//}
