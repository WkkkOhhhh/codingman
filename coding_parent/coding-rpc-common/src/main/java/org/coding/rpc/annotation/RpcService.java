package org.coding.rpc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * @author 王坤 自定义一个rpcservice注解
 * @date 2017年3月13日上午9:55:28
 *
 */
@Target({ ElementType.TYPE }) // 修饰类、接口等
@Retention(RetentionPolicy.RUNTIME) // 表示注解会在jvm运行期间被反射调用
@Component // 这个就没悬念了，交给spring扫描而已
public @interface RpcService {
	// ？和T的区别：？表示未知的父类，T表示未知的,T的话在编译期会被替换成指定的具体类
	Class<?> value();

}
