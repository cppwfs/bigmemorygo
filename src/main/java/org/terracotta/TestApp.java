package org.terracotta;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Results;

public class TestApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
//		testMyCache();
		loadCustomerCache();
//		readCustomerCache();
		Thread.sleep(3000);
		searchCustomerCache();
	}

	public static void testMyCache() {
		CacheManager mgr = CacheManager.getInstance();
		Cache myCache = mgr.getCache("myCache");
		startWriteJob(myCache, 10, "T1");
		startReadJob(myCache, 1000, "T2");
	}

	public static void loadCustomerCache() {
		CacheManager mgr = CacheManager.getInstance();
		Cache customerCache = mgr.getCache("customer");
		startWriteJob(customerCache, 0, "T3");
	}

	public static void readCustomerCache() {
		CacheManager mgr = CacheManager.getInstance();
		Cache customerCache = mgr.getCache("customer");
		startReadJob(customerCache, 10000, "T4");
	}

	public static void searchCustomerCache() {
		CacheManager mgr = CacheManager.getInstance();
		Cache customerCache = mgr.getCache("customer");
		searchForAge(customerCache);
	}

	public static void startWriteJob(Cache cache, int pause, String threadName) {
		Thread t = new Thread(new WriteTask(cache, pause), threadName);
		t.start();
	}

	public static void startReadJob(Cache cache, int pause, String threadName) {
		Thread t = new Thread(new ReadTask(cache, pause), threadName);
		t.start();
	}

	public static void searchForAge(Cache cache) {
		Attribute<Integer> age = cache.getSearchAttribute("age");
		Query query = cache.createQuery().includeKeys().addCriteria(age.le(40))
				.end();
		Results results = query.execute();
		System.out.println("********************" + results.size());
	}
}
