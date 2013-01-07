package net.dbet.yqjkdao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import net.dbet.yqjk.Yqjkxx;
import net.dbet.yqjkdao.YqjkDao;

public class YqjkDaoImpl extends HibernateDaoSupport implements YqjkDao {

	public void delYqjkxx(Yqjkxx yqjkxx) {
		this.getHibernateTemplate().delete(yqjkxx);

	}

	@SuppressWarnings("unchecked")
	public List<Yqjkxx> findAllYqjkxx() {
		String hql = " from Yqjkxx";
		return (List<Yqjkxx>) this.getHibernateTemplate().find(hql);
	}

	public Yqjkxx findById(int roleId) {
		Yqjkxx yqjkxx = (Yqjkxx) this.getHibernateTemplate().get(Yqjkxx.class, roleId);
		return yqjkxx;
	}

	public void saveYqjk(Yqjkxx yqjkxx) {
		this.getHibernateTemplate().save(yqjkxx);

	}

	public void updateYqjkxx(Yqjkxx yqjkxx) {
		this.getHibernateTemplate().update(yqjkxx);

	}

}
