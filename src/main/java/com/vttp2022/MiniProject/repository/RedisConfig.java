package com.vttp2022.MiniProject.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {
    private static final Logger logger = LoggerFactory.getLogger(RedisConfig.class);

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private Integer redisPort;
    //why optional 
    //prev Optional<Integer>

    @Value("${spring.redis.password}")
    private String redisPassword;

    @Value("${spring.redis.database}")
    private Integer redisDatabase;

    @Bean(name = "games")
    @Scope("singleton")
    public RedisTemplate<String, String> redisTemplate() {
        final RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
        config.setHostName(redisHost);
        config.setPort(redisPort);
        config.setDatabase(redisDatabase);
        config.setPassword(redisPassword);

        Jackson2JsonRedisSerializer jackson2JsonJsonSerializer = new Jackson2JsonRedisSerializer(Mastermind.class);
        //name the class - from midel ??? 

        final JedisClientConfiguration jedisClient = JedisClientConfiguration.builder().build();
        final JedisConnectionFactory jedisFac = new JedisConnectionFactory(config, jedisClient);
        //why final - comparing with chuks code 
        
        jedisFac.afterPropertiesSet();
        logger.info("redis host port > {redisHost} {redisPort}", redisHost, redisPort);
        RedisTemplate<String, Mastermind> template = new RedisTemplate<String, Mastermind>();
        template.setConnectionFactory(jedisFac);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(jackson2JsonJsonSerializer);
        template.setHashKeySerializer(template.getKeySerializer());
        template.setHashValueSerializer(template.getValueSerializer());
        return template;

    }

    // need to place redis config info 

    //create main file in model and update into mastermind 



    
    
}
