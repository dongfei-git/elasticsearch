package tech.dongfei.es.test;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

public class ESTestDocInsertBatch {

    public static void main(String[] args) throws IOException {

        // 创建es客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost", 9200, "http"))
        );

        // 删除文档
        BulkRequest request = new BulkRequest();

        request.add(new IndexRequest().index("user").id("1001").source(XContentType.JSON, "name", "zhangsan", "gender", "M", "age", "30"));
        request.add(new IndexRequest().index("user").id("1002").source(XContentType.JSON, "name", "lisi", "gender", "M", "age", "30"));
        request.add(new IndexRequest().index("user").id("1003").source(XContentType.JSON, "name", "wangwu", "gender", "M", "age", "24"));
        request.add(new IndexRequest().index("user").id("1004").source(XContentType.JSON, "name", "wangwu1", "gender", "F", "age", "30"));
        request.add(new IndexRequest().index("user").id("1005").source(XContentType.JSON, "name", "wangwu2", "gender", "M", "age", "25"));
        request.add(new IndexRequest().index("user").id("1006").source(XContentType.JSON, "name", "wangwu3", "gender", "F", "age", "49"));

        BulkResponse responses = esClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println(responses.getTook());
        System.out.println(responses.getItems());

        // 关闭es客户端
        esClient.close();

    }

}
