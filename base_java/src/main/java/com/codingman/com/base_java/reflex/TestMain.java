package com.codingman.com.base_java.reflex;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * @author 王坤
 *
 * @date 2017年3月13日上午10:14:42
 *
 */
//这里如果是int，boolean，string等基本类型的，动态改变值是没有效果滴，只有Integer等包装类才有效果
//因为java在编译的时候就把基本类型的常量替换拉
public class TestMain {
	public static void main(String[] args) {
		try {
			Class cs = Class.forName("com.codingman.com.base_java.reflex.TestA");
			Object o=cs.getAnnotatedInterfaces();
			Field[] fields = cs.getFields();
			for (Field field : fields) {
				String descriptor = Modifier.toString(field.getModifiers());// 获得其属性的修饰
				descriptor = descriptor.equals("") == true ? "" : descriptor + " ";
				if("NAME".equals(field.getName())){
					//修改权限 -private
					field.setAccessible(true);
					/*去除final修饰符的影响，将字段设为可修改的*/ 
					Field modifiersField = Field.class.getDeclaredField("modifiers");  
					modifiersField.setAccessible(true);
					//转换为二进制
					modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
					field.set(null, 678);  
					System.out.println(descriptor+field.getName()+"="+field.get(o));
				}
			}
			System.out.println(TestB.WK_NAME);
			System.out.println(TestA.NAME+">>>>______");
		} catch (Exception e)

		{
			e.printStackTrace();
		}
	}
}
