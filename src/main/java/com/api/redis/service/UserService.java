package com.api.redis.service;

import com.api.redis.model.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String USER_KEY_PREFIX = "USER_";

    // Store a user in Redis
    public void saveUser(User user) {
        redisTemplate.opsForValue().set(USER_KEY_PREFIX + user.getId(), user);
    }

    // Retrieve a user from Redis
    public User getUserById(String userId) {
        return (User) redisTemplate.opsForValue().get(USER_KEY_PREFIX + userId);
    }

    // Delete a user from Redis
    public void deleteUser(String userId) {
        redisTemplate.delete(USER_KEY_PREFIX + userId);
    }
}

