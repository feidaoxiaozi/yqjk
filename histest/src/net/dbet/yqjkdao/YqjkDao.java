package net.dbet.yqjkdao;

import java.util.List;

import net.dbet.yqjk.Yqjkxx;

public interface YqjkDao {
       
	public abstract void saveYqjk(Yqjkxx yqjkxx);
	
	public abstract void delYqjkxx(Yqjkxx yqjkxx);
	
	public abstract Yqjkxx findById(int roleId);
	
	public abstract List<Yqjkxx> findAllYqjkxx();
	
	public abstract void updateYqjkxx(Yqjkxx Yqjkxx);
}
