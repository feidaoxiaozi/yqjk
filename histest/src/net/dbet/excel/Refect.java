package net.dbet.excel;

import java.util.List;


public interface Refect {
	/**
	 * 获取�?个类�?有属性的注释�?
	 * @param class1
	 * @return
	 */
	public String[] getFieldAnnotation(Class<?> c);
	
	/**
	 * 获取�?个对象的取�?�，装入list
	 * @param obj
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List getFieldValue(Object obj);

}
