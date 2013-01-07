package net.dbet.service;

import java.util.List;
import net.dbet.yqjk.Yqjkxx;

public interface YqjkService {
   
    public void saveYqjk(Yqjkxx yqjkxx);
	
	public void delYqjkxx(Yqjkxx yqjkxx);
	
	public Yqjkxx findById(int roleId);
	
	public List<Yqjkxx> findAllYqjkxx();
	
	public void updateYqjkxx(Yqjkxx Yqjkxx);
}
