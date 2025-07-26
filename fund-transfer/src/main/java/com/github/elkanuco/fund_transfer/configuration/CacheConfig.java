package com.github.elkanuco.fund_transfer.configuration;

import java.net.URISyntaxException;

import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {
	
	@Bean
	public JCacheCacheManager cacheManager() throws URISyntaxException {
	    return new JCacheCacheManager(javax.cache.Caching.getCachingProvider()
	        .getCacheManager(
	            getClass().getResource("/ehcache.xml").toURI(),
	            getClass().getClassLoader()
	        ));
	}

}
