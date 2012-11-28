package com.demo.jmxweb.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import com.demo.jmxweb.entity.BeanMonitor;

public class MyInterceptor implements MethodInterceptor {
	private BeanMonitor monitor = new BeanMonitor();

	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("Beginning method(1):" + arg0.getMethod().getDeclaringClass() + "." +arg0.getMethod().getName() + "()");
		monitor.startTime = System.nanoTime();
		try{
			Object result = arg0.proceed();
			return result;
		}finally{
			//System.out.println("Ending method(1):" + arg0.getMethod().getDeclaringClass() + "." +arg0.getMethod().getName() + "()");
			monitor.endTime = System.nanoTime();
			monitor.durationTime = monitor.endTime - monitor.startTime;
			System.out.println("Method invocation time(1):" + monitor.durationTime + "ns.");
		}
	}

}
