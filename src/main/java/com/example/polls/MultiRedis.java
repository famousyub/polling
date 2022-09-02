package com.example.polls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EnableCaching
//@Component
public class MultiRedis implements CommandLineRunner {
	
	
	 private final static Logger logger = LoggerFactory.getLogger(MultiRedis.class);

	    private final StringRedisTemplate userStringRedisTemplate;
	    private final StringRedisTemplate roleStringRedisTemplate;
	  

	    @Autowired
	    public MultiRedis(@Qualifier("userStringRedisTemplate") StringRedisTemplate userStringRedisTemplate,
	                                 @Qualifier("roleStringRedisTemplate") StringRedisTemplate roleStringRedisTemplate
	                                ) {
	        this.userStringRedisTemplate = userStringRedisTemplate;
	        this.roleStringRedisTemplate = roleStringRedisTemplate;
	       
	    }

	   

	    @Override
	    public void run(String... strings) throws Exception {

	        userStringRedisTemplate.opsForValue().set("hello", "world_1");
	        roleStringRedisTemplate.opsForValue().set("hello", "world_2");

	        String primaryKeyValue = userStringRedisTemplate.opsForValue().get("hello");
	        String secondaryKeyValue = roleStringRedisTemplate.opsForValue().get("hello");

	        logger.info("==================================================================");
	        logger.info(String.format("read the primary redis, key is `hello`, value is %s", primaryKeyValue));
	        logger.info(String.format("read the secondary redis, key is `hello`, value is %s", secondaryKeyValue));
	        logger.info("==================================================================");

	        // you can also check the value with redis-cli
	    }

	
}
