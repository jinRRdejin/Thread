package com.cultraview.com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestThread {

	/*why
	 * 	减少线程创建和销毁的次数，每个工作线程都可以被重复利用，可执行多个任务
	 *  可根据系统的承受能力，调整线程之中工作线程的数目，达到最佳运行效果
	 *  拥有定期执行，定时执行，单线陈 ，并发数控制，线程中断等功能
	 * 
	 */
	
	public static void main(String[] args) {
//		ThreadPoolExecutor tp = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue)
		/*
		 * 创建单线程话的线程池，他只会用唯一的工作线程来执行任务
		 * 保证所有任务按照任务的提交顺序执行
		 * 
		 * 如果这个唯一的工作线程异常结束，那么会有一个新的线程代替他
		 */
		ExecutorService  es = Executors.newSingleThreadExecutor();
		/*
		 *创建一个定长线程池。可控制线程最大并发数，超出线程会在队列中等待
		 * 定长线程池的大小最好根据系统资源进行设置Runtime.getRuntime().availableProcessors()
		 */
		ExecutorService  es1 = Executors.newFixedThreadPool(2);
		
		/*
		 * 创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空线程。若无可回收则新建
		 * 线程池无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程
		 * 而不用每次都新建
		 */
		ExecutorService  es2 = Executors.newCachedThreadPool();
		
		
		/*
		 * 创建一个定长线程池，支持定时以及周期性执行任务
		 *
		 */
		ScheduledExecutorService   es3 = Executors.newScheduledThreadPool(2);
		es3.schedule(new Thread01(), 3, TimeUnit.SECONDS);
		//延迟3s执行
		
		es3.scheduleAtFixedRate(new Thread01(), 1, 2, TimeUnit.SECONDS);
		//延迟1s后每2秒执行一次
		
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
