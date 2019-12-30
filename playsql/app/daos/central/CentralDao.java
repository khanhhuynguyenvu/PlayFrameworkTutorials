package daos.central;

import daos.friend.FriendDao;
import daos.friend.FriendDaoImpl;

public  class CentralDao {
    private FriendDao friendDao = new FriendDaoImpl();

    public CentralDao() {
    }

    public FriendDao getFriendDao(){
        return this.friendDao;
    }
}
