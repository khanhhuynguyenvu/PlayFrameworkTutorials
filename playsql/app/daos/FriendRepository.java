//package daos;
//
//import models.Friend;
//import play.db.jpa.JPAApi;
//
//import javax.inject.Inject;
//import javax.inject.Singleton;
//import javax.persistence.EntityManager;
//import java.util.concurrent.CompletionStage;
//import java.util.function.Function;
//import static java.util.concurrent.CompletableFuture.supplyAsync;
//
//@Singleton
//public class FriendRepository implements FriendRepositoryItf {
//    private final JPAApi jpaApi;
//    private final DatabaseExecutionContext executionContext;
//
//    @Inject
//    public FriendRepository(JPAApi jpaApi, DatabaseExecutionContext executionContext) {
//        this.jpaApi = jpaApi;
//        this.executionContext = executionContext;
//    }
//
//
//    @Override
//    public CompletionStage<Friend> add(Friend friend) {
//        return supplyAsync(() -> wrap(em -> insert(em, friend)), executionContext);
//    }
//
//    private <T> T wrap(Function<EntityManager, T> function) {
//        return jpaApi.withTransaction(function);
//    }
//    private Friend insert(EntityManager em, Friend friend) {
//        em.persist(friend);
//        return friend;
//    }
//}
