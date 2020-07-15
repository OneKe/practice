package common.redis;

/**
 * 序列化 redisTemplate
 * 1.默认情况下，RedisTemplate 使用 JdkSerializationRedisSerializer，也就是 JDK 序列
 * 化，容易产生 Redis 中保存了乱码的错觉。
 * 2.通常考虑到易读性，可以设置 Key 的序列化器为 StringRedisSerializer。但直接使用
 * RedisSerializer.string()，相当于使用了 UTF_8 编码的 StringRedisSerializer，需要注
 * 意字符集问题。
 * 3.如果希望 Value 也是使用 JSON 序列化的话，可以把 Value 序列化器设置为
 * Jackson2JsonRedisSerializer。默认情况下，不会把类型信息保存在 Value 中，即使我
 * 们定义 RedisTemplate 的 Value 泛型为实际类型，查询出的 Value 也只能是
 * LinkedHashMap 类型。如果希望直接获取真实的数据类型，你可以启用 Jackson
 * ObjectMapper 的 activateDefaultTyping 方法，把类型信息一起序列化保存在 Value中。
 * 4.如果希望 Value 以 JSON 保存并带上类型信息，更简单的方式是，直接使用
 * RedisSerializer.json() 快捷方法来获取序列化器。
 * <p>
 * 坑：redisTemplate<String,Long> 获取的值。在Integer范围内返回的是Integer，超过Integer.Max_VALUE,才会返回Long;
 */
public class RedisConfig {
//
//    private RedisTemplate<String, Long> redisTemplate;
//
//    @Bean
//    public <T> RedisTemplate<String, T> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
//        RedisTemplate<String, T> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory);
//        ObjectMapper om = new ObjectMapper();
//        // 指定要序列化的域，field,get和set,以及修饰符范围，ANY是都有包括private和public
//        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        // 指定序列化输入的类型，类必须是非final修饰的，final修饰的类，比如String,Integer等会跑出异常
//        om.activateDefaultTyping(om.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
//        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer(om);
//        template.setKeySerializer(RedisSerializer.string());
//        template.setValueSerializer(serializer);
//        template.setHashKeySerializer(RedisSerializer.string());
//        template.setHashValueSerializer(serializer);
//        template.afterPropertiesSet();
//        return template;
//    }
//
//    private Long getLongValue(String key) {
//        Object o = redisTemplate.opsForValue().get(key);
//        if (o instanceof Integer) {
//            return ((Integer) o).longValue();
//        }
//        if (o instanceof Long) {
//            return (Long) o;
//        }
//        return null;
//    }
}
