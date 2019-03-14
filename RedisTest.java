package utils;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class RedisTest {

    public static void main(String[] args) throws Exception {
        /** 定义Set集合封装主机与端口HostAndPort(集群节点) */
        Set<HostAndPort> nodes = new HashSet<>();
        /** 添加多个集群节点 */
        nodes.add(new HostAndPort("192.168.118.132", 7001));
        nodes.add(new HostAndPort("192.168.118.132", 7002));
        nodes.add(new HostAndPort("192.168.118.132", 7003));
        nodes.add(new HostAndPort("192.168.118.132", 7004));
        nodes.add(new HostAndPort("192.168.118.132", 7005));
        nodes.add(new HostAndPort("192.168.118.132", 7006));

        /** 创建JedisCluster集群对象 */
        JedisCluster jedisCluster = new JedisCluster(nodes);
        /** 设置数据 */
        jedisCluster.set("test", "jedisCluster");
        /** 获取数据 */
        System.out.println(jedisCluster.get("test"));
        /** 关闭JedisCluster */
        jedisCluster.close();
    }

}
