package tech.dongfei.es.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import tech.dongfei.es.entity.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataESIndexTest {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Test
    public void createIndex() {
        System.out.println("创建索引");
    }

    @Test
    public void deleteIndex() {
        boolean b = elasticsearchRestTemplate.deleteIndex(Product.class);
        System.out.println("删除索引："+b);
    }
}
