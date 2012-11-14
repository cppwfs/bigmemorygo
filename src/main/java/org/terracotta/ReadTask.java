package org.terracotta;

import net.sf.ehcache.Cache;

public class ReadTask implements Runnable {
	
	Cache cache;
	int pause = 0;
	public ReadTask(Cache cache, int pause){
		this.cache = cache;
		this.pause = pause;
	}

	public void run() {
		// TODO Auto-generated method stub
		while(true){
			int r = (int) (Math.random()*100000);
			System.out.println(cache.getName()+"  "+r+"   "+cache.get("Hi"+r));
			try{
				Thread.sleep(pause);
			}catch(Exception e){
				// ignore
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
