package net.dbet.service;

import java.util.List;
import net.dbet.yqjk.User;

public interface UserService {
   
	public abstract boolean verifyUser(String username,String password);

    public abstract void insertUserxx(User user);

    public abstract void delUser(User user);
		
    public abstract List<User> findAllUserxx();

    public abstract User findUserxxById(int userId);

    public abstract void updateUserxx(User user);
}
