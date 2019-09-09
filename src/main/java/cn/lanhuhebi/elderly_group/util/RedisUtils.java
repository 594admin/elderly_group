package cn.lanhuhebi.elderly_group.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisUtils {

    private Logger logger=LoggerFactory.getLogger(RedisUtils.class);

    @Resource
    private RedisTemplate<String,Object> redisTemplate;


    public boolean set(String key,String value){
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<String,Object> vo=redisTemplate.opsForValue();
        vo.set(key,value);
        return true;
    }

    public boolean set(String key,long seconds,String value){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<String,Object> vo=redisTemplate.opsForValue();
        vo.set(key,value);
        expire(key,seconds);
        return true;
    }

    public boolean update(String key,String value){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<String,Object> vo=redisTemplate.opsForValue();

        Long expireTime=redisTemplate.getExpire(key);
        if (expireTime==null){
            return false;
        }
        if (expireTime==-2||expireTime==0){
            return false;
        }
        vo.set(key,value);
        if (expireTime>0){
            expire(key,expireTime);
        }
        return true;
    }

    public Long getExpire(String key){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<String,Object> vo=redisTemplate.opsForValue();
        return redisTemplate.getExpire(key);
    }

    public boolean expire(final String key,final long expireTime){
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                boolean flag=false;
                try {
                    redisTemplate.setKeySerializer(new StringRedisSerializer());
                    redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
                    StringRedisSerializer stringRedisSerializer=new StringRedisSerializer();
                    byte keys[]=stringRedisSerializer.serialize(key);
                    flag=redisConnection.expire(keys,expireTime);
                }catch (Exception e){
                    e.printStackTrace();
                }
                return flag;
            }
        });
    }

    public boolean exist(String key){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<String,Object> vo=redisTemplate.opsForValue();
        Object value=vo.get(key);
        if (value==null||value==""){
            return false;
        }else{
            return true;
        }
    }

    public Object get(String key){
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<String,Object> vo=redisTemplate.opsForValue();
        return vo.get(key);
    }

    public void delete(String key){
        try {
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            redisTemplate.setValueSerializer(new StringRedisSerializer());
            redisTemplate.delete(key);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean setnx(final String key,final String value)throws Exception{
        return redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                boolean flag=false;
                try {
                    redisTemplate.setKeySerializer(new StringRedisSerializer());
                    redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
                    StringRedisSerializer stringRedisSerializer=new StringRedisSerializer();
                    byte keys[]=stringRedisSerializer.serialize(key);
                    byte values[]=stringRedisSerializer.serialize(value);
                    flag=redisConnection.setNX(keys,values);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    return flag;
                }
            }
        });
    }

    public boolean lock(String key){
        boolean flag=false;
        try {
            String lockKey=generateLockKey(key);
            flag=setnx(lockKey,"lock");
            return flag;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    private String generateLockKey(String key){
        return String.format("LOCK:%s",key);
    }

    public Object getValueNx(String key){
        String lockKey=generateLockKey(key);
        Object result=get(lockKey);
        return result;
    }

    //上面是各种redis命令封装后的java方法
    //这个类也可以再写一些方便本项目服务的方法，比如，写个查token

    public boolean validateLogin(String token){
        return exist(token);
    }


}
