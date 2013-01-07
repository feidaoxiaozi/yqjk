package net.dbet.yqjkdao.impl;

import java.util.List;

import net.dbet.yqjk.User;
import net.dbet.yqjkdao.UserDao;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	public void delUser(User user) {
		this.getHibernateTemplate().delete(user);
		
	}
	@SuppressWarnings("unchecked")
	public List<User> findAllUserxx() {
		String hql = "from User";
		return this.getHibernateTemplate().find(hql);
	}

	public User findUserxxById(int userId) {		
		User user = (User)this.getHibernateTemplate().get(User.class, userId);
		return user;
	}

	public void insertUserxx(User user) {
		this.getHibernateTemplate().save(user);
		
	}

	public void updateUserxx(User user) {
		this.getHibernateTemplate().update(user);
		
	}

	public int verifyUser(String username,String password) {
		Query query = getSession().createQuery("select count(u.userId) from User u where u.username = ? and u.password = ?");
		query.setParameter(0, username);
		query.setParameter(1, password);
		return Integer.parseInt(query.uniqueResult().toString());
	}

}
