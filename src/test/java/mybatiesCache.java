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
 *       在mapper文件中，使用<cache></cache>标签，注意会话提交或者关闭之后，一级缓存中的 数据才会转移到二级缓存中
 *       POJO需要序列化
 * 缓存先关的属性：
 *      1. CacheEnabled： true|false  控制二级缓存的开启
 *      2. 每个select标签都有useCache=true|false 开启之后二级缓存生效，一级缓存不受影响
 *      3. 每个增删改标签都有flushCache=true标签，执行完之后一级缓存和二级缓存都会清空缓存
 *      4.查询标签中的属性flushCache=false，如果改为true，则缓存也会被清空
 *      5.localCacheScope: 本地缓存作用域（一级缓存），改成STATEMEN可以关闭一级缓存
 *
 * 自定义缓存：
 *      1. 实现mybaties提供的Cache接口
 *      2. 在SQL配置文件中的<Cache type=""></Cache>指定自己的缓存控件即可
 */
public class mybatiesCache {

    public void testCache01()
    {

    }
}
