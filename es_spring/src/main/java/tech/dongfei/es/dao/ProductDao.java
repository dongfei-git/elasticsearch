package tech.dongfei.es.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import tech.dongfei.es.entity.Product;

@Repository
public interface ProductDao extends ElasticsearchRepository<Product, Long> {
}
