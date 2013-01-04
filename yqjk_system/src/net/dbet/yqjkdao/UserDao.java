package net.dbet.yqjkdao;

import java.util.List;
import net.dbet.yqjk.User;

public interface UserDao {
       
	public abstract int verifyUser(String username,String password);

    public abstract void insertUserxx(User user);

    public abstract void delUser(User user);
		
    public abstract List<User> findAllUserxx();

    public abstract User findUserxxById(int userId);

    public abstract void updateUserxx(User user);
}
