package common.pool;

/**
 * 池化技术
 * 1.池和连接分离 jedisPool
 * 2.内部带有连接池    apache httpclient
 * 3.非连接池
 * <p>
 * 重点：1.确保复用；2.显示关闭
 * 如果不能保证复用，比单独创建性能更差。需要守护线程，管理模块，保活功能
 */
public class ConnectionPool {
    //redis 连接池
    //httpClient 连接池
    //数据库连接池
}
