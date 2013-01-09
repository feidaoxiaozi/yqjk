package net.dbet.excel;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class RefectImpl implements Refect {

	
	public String[] getFieldAnnotation(Class<?> c) {
		
		Field[] fields = c.getDeclaredFields();
		String[] fieldAnnotations = new String[fields.length];
		for(int i = 0;i < fields.length;i++){
			if(!fields[i].isAnnotationPresent(ExcelAnnotation.class))
				return null;
			ExcelAnnotation excel = fields[i].getAnnotation(ExcelAnnotation.class);
			fieldAnnotations[i] = excel.name();
		}
		return fieldAnnotations;
	}

	@SuppressWarnings("unchecked")
	
	public List getFieldValue(Object obj) {
		Class c = obj.getClass();
		Field[] fields = c.getDeclaredFields();
		List<Object> lists = new ArrayList<Object>();
		Object o = null;
		
		for(int i = 0;i < fields.length;i++){
			PropertyDescriptor pd = null;
			try {
				pd = new PropertyDescriptor(fields[i].getName(),c);
				Method getMethod = pd.getReadMethod();//获得get方法
				o = getMethod.invoke(obj);
				if(o == null || o.equals(""))
					o = "";
				//System.out.println(o);
			
			} catch (IntrospectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lists.add(o);
		}
		return lists;
	}

}
