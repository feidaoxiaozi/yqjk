package net.dbet.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import net.dbet.service.YqjkService;
import net.dbet.util.DBConn;
import net.dbet.yqjk.Yqjkxx;
import net.dbet.yqjkdao.YqjkDao;

public class YqjkServiceImpl implements YqjkService {

	DBConn db = new DBConn();
	Statement st = null;
	ResultSet rs = null;
	Connection con = null;
	private YqjkDao yqjkDao;

	public YqjkDao getYqjkDao() {
		return yqjkDao;
	}

	public void setYqjkDao(YqjkDao yqjkDao) {
		this.yqjkDao = yqjkDao;
	}

	public void delYqjkxx(Yqjkxx yqjkxx) {
		this.yqjkDao.delYqjkxx(yqjkxx);
	}

	public List<Yqjkxx> findAllYqjkxx() {
        
		return this.yqjkDao.findAllYqjkxx();
	}

	public Yqjkxx findById(int roleId) {

		return this.yqjkDao.findById(roleId);
	}

	public void saveYqjk(Yqjkxx yqjkxx) {
		this.yqjkDao.saveYqjk(yqjkxx);

	}

	public void updateYqjkxx(Yqjkxx yqjkxx) {
		this.yqjkDao.updateYqjkxx(yqjkxx);

	}
	
}
