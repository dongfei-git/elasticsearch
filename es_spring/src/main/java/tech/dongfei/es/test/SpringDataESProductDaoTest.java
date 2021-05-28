package tech.dongfei.es.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import tech.dongfei.es.dao.ProductDao;
import tech.dongfei.es.entity.Product;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataESProductDaoTest {

    @Autowired
    private ProductDao productDao;

    /**
     * 新增数据
     */
    @Test
    public void save() {
        Product product = new Product();
        product.setId(1L);
        product.setTitle("huawei");
        product.setCategory("pnone");
        product.setPrice(2999.00);
        product.setImages("http://www.huawei.com/hw.jpg");
        productDao.save(product);
    }

    @Test
    public void findById() {
        Product product = productDao.findById(2L).get();
        System.out.println(product);
    }

    @Test
    public void findAll() {
        Iterable<Product> products = productDao.findAll();
        for (Product product : products) {
            System.out.println(product);
        }
    }

    @Test
    public void delete() {
        Product product = new Product();
        product.setId(2L);
        productDao.delete(product);
    }

    @Test
    public void saveAll() {
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setId(Long.valueOf(i));
            product.setTitle("["+i+"]xiaomi");
            product.setCategory("phone");
            product.setPrice(1999.00 + i);
            product.setImages("http://www.xiaomi.com/xiaomi.jpg");
            productList.add(product);
        }
        productDao.saveAll(productList);
    }

    /**
     * 分页查询
     */
    @Test
    public void findByPageable() {
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        int from = 0;
        int size = 3;
        PageRequest pageRequest = PageRequest.of(from, size, sort);
        Page<Product> productPage = productDao.findAll(pageRequest);
        for (Product product : productPage) {
            System.out.println(product);
        }
    }
}
