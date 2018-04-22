package com.cultraview.com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestThread {

	/*why
	 * 	�����̴߳��������ٵĴ�����ÿ�������̶߳����Ա��ظ����ã���ִ�ж������
	 *  �ɸ���ϵͳ�ĳ��������������߳�֮�й����̵߳���Ŀ���ﵽ�������Ч��
	 *  ӵ�ж���ִ�У���ʱִ�У����߳� �����������ƣ��߳��жϵȹ���
	 * 
	 */
	
	public static void main(String[] args) {
//		ThreadPoolExecutor tp = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue)
		/*
		 * �������̻߳����̳߳أ���ֻ����Ψһ�Ĺ����߳���ִ������
		 * ��֤����������������ύ˳��ִ��
		 * 
		 * ������Ψһ�Ĺ����߳��쳣��������ô����һ���µ��̴߳�����
		 */
		ExecutorService  es = Executors.newSingleThreadExecutor();
		/*
		 *����һ�������̳߳ء��ɿ����߳���󲢷����������̻߳��ڶ����еȴ�
		 * �����̳߳صĴ�С��ø���ϵͳ��Դ��������Runtime.getRuntime().availableProcessors()
		 */
		ExecutorService  es1 = Executors.newFixedThreadPool(2);
		
		/*
		 * ����һ���ɻ����̳߳أ�����̳߳س��ȳ���������Ҫ���������տ��̡߳����޿ɻ������½�
		 * �̳߳����޴󣬵�ִ�еڶ�������ʱ��һ�������Ѿ���ɣ��Ḵ��ִ�е�һ��������߳�
		 * ������ÿ�ζ��½�
		 */
		ExecutorService  es2 = Executors.newCachedThreadPool();
		
		
		/*
		 * ����һ�������̳߳أ�֧�ֶ�ʱ�Լ�������ִ������
		 *
		 */
		ScheduledExecutorService   es3 = Executors.newScheduledThreadPool(2);
		es3.schedule(new Thread01(), 3, TimeUnit.SECONDS);
		//�ӳ�3sִ��
		
		es3.scheduleAtFixedRate(new Thread01(), 1, 2, TimeUnit.SECONDS);
		//�ӳ�1s��ÿ2��ִ��һ��
		
		Thread01 th1 = new Thread01();
		Thread01 th2 = new Thread01();
		Thread01 th3 = new Thread01();
		es.execute(th1);
		es.execute(th2);
		es.execute(th3);
//		es.shutdown();
		es.shutdownNow();
	}

}
