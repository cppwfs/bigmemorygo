package org.terracotta;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;


public class WriteTask implements Runnable {
	Cache cache;
	int pause; 
	public static String MALE = "MALE";
	public static String FEMALE = "FEMALE";
	public WriteTask(Cache cache, int pause){
		this.cache = cache;
		this.pause = pause;
	}
	
	public void run() {
		// TODO Auto-generated method stub
		for (int x=0;x<100000;x++){
			String gender = (x%2==1)?MALE:FEMALE;
			Person p = new Person("Glenn"+x,x%100,gender);
			cache.put(new Element("Hi"+x,p));
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
