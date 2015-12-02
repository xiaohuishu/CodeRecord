package cn.march.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author: xiaohui.shu 创建于 cn.march.guava.cache
 * @version: 日期: 15-12-1 时间: 下午7:59
 */
public class GuavaCacheTest {

    private static final CacheBuilder<String, String> builder = CacheBuilder.newBuilder().maximumSize(1000)
            .expireAfterWrite(10, TimeUnit.SECONDS).removalListener(new RemovalListener<String, String>() {
                @Override
                public void onRemoval(RemovalNotification<String, String> notification) {
                    // process
                }
            });

    // 使用CacheLoader方式
    private static final LoadingCache<String, String> cacheBuilder = builder.build(new CacheLoader<String, String>() {
                @Override
                public String load(String key) throws Exception {
                    return "hello " + key + "!";
                }
            });

    // 使用CallBack方式
    private static final Cache<String, String> cache = builder.build();

    public static void main(String[] args) throws ExecutionException {
        //CacheLoader方式
        System.out.println(cacheBuilder.get("xiaohuishu"));
        cacheBuilder.put("test", "test1");
        System.out.println(cacheBuilder.get("test"));
        //CallBack方式
        final String name = "xiaohuishu";
        cache.put("test", "test1");
        System.out.println(cache.get(name, new Callable<String>() {
            @Override public String call() throws Exception {
                return "hello " + name + "!";
            }
        }));
        System.out.println(cache.get(name, new Callable<String>() {
            @Override public String call() throws Exception {
                return "second hello " + name + "!";
            }
        }));
        System.out.println(cache.getIfPresent("test"));
        //remove
        cacheBuilder.invalidate("test");
        cache.invalidate("test");

    }
}
