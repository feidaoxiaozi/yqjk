package net.dbet.excel;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
 * 元注解@Target,@Retention,@Documented,@Inherited
 * 
 *     @Target 表示该注解用于什么地方，可能�? ElemenetType 参数包括�?
 *         ElemenetType.CONSTRUCTOR 构�?�器声明
 *         ElemenetType.FIELD 域声明（包括 enum 实例�?
 *         ElemenetType.LOCAL_VARIABLE �?部变量声�?
 *         ElemenetType.METHOD 方法声明
 *         ElemenetType.PACKAGE 包声�?
 *         ElemenetType.PARAMETER 参数声明
 *         ElemenetType.TYPE 类，接口（包括注解类型）或enum声明
 *         
 *     @Retention 表示在什么级别保存该注解信息。可选的 RetentionPolicy 参数包括�?
 *         RetentionPolicy.SOURCE 注解将被编译器丢�?
 *         RetentionPolicy.CLASS 注解在class文件中可用，但会被VM丢弃
 *         RetentionPolicy.RUNTIME VM将在运行期也保留注释，因此可以�?�过反射机制读取注解的信息�??
 *         
 *     @Documented 将此注解包含�? javadoc �?
 *     
 *     @Inherited 允许子类继承父类中的注解
 *   
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited

public @interface ExcelAnnotation{
	/**
	 * 在Excel要显示的字段�?
	 * @return
	 */
	public abstract String name() default "�?";
}
