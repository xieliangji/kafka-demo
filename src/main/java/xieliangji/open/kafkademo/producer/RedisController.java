package xieliangji.open.kafkademo.producer;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/redis")
public class RedisController {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisController(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @GetMapping
    public ResponseEntity<String> setAndGetKey(@RequestParam("value") String value) {
        String key = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(key, value);
        String v = (String) redisTemplate.opsForValue().get(key);
        redisTemplate.delete(key);
        return ResponseEntity.ok(v);
    }
}
