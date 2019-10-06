/**
 * mybatis 缓存
 * 默认提供了两级缓存：
 * 本地缓存（sqlSession,默认开启）,本质上就是一个map:
 *          与数据库同一此会话期间查询到的数据会放到本地缓存中，每个sqlSession都会有一个与之对应的缓存
 *          一级缓存的失效情况：
 *                  1. sqlSession是不同的对象
 *                  2. 查询参数不同
 *                  3. 两次查询之间，存在增删改查的操作
 *                  4. 如果手动清空了本地缓存: sqlSession.clearCache();
 * 全局缓存(namespaces)，每个namespace都对应一个缓存，如果一个sqlSession关闭，则一级缓存中的数据会被放到
 * namespace中的二级缓存中
 * 使用：
 *       全局配置文件中，开启缓存
 *       在mapper文件中，使用<cache></cache>标签
 */
public class mybatiesCache {

    public void testCache01()
    {

    }
}
