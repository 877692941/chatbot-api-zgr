package org.example;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * Unit test for simple App.
 */
public class ApiTest{
    @Test
    public void query_unanswered_questions() throws IOException {
        //封装数据信息
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //获取请求
        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/51112844244184/topics?scope=unanswered_questions&count=20");
        get.addHeader("cookie","zsxq_access_token=C60D82BA-3B0B-C166-DF6E-1970651047EE_E99B9081CC7CD049; abtest_env=product; zsxqsessionid=9508721eb53067b6d151654e620815d1; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22218282144285221%22%2C%22first_id%22%3A%2218c8f6cd2b1357-014acc60ebfbc93-26031051-1327104-18c8f6cd2b3609%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjOGY2Y2QyYjEzNTctMDE0YWNjNjBlYmZiYzkzLTI2MDMxMDUxLTEzMjcxMDQtMThjOGY2Y2QyYjM2MDkiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIyMTgyODIxNDQyODUyMjEifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22218282144285221%22%7D%2C%22%24device_id%22%3A%2218c8f6cd2b1357-014acc60ebfbc93-26031051-1327104-18c8f6cd2b3609%22%7D");
        get.addHeader("Content-type","application/json, text/plain, */*");

        //对get进行处理
        CloseableHttpResponse response = httpClient.execute(get);
        //判断请求回来的信息是否正确
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            //将结果返回成字符串的格式
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
    @Test
    public void answer() throws IOException {
        //封装数据信息
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        //https://api.zsxq.com/v2/groups/411281455151288/topics?scope=unanswered_questions&count=20

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/411281455151288/answer");
        post.addHeader("cookie","zsxq_access_token=C60D82BA-3B0B-C166-DF6E-1970651047EE_E99B9081CC7CD049; abtest_env=product; zsxqsessionid=9508721eb53067b6d151654e620815d1; sajssdk_2015_cross_new_user=1; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22218282144285221%22%2C%22first_id%22%3A%2218c8f6cd2b1357-014acc60ebfbc93-26031051-1327104-18c8f6cd2b3609%22%2C%22props%22%3A%7B%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThjOGY2Y2QyYjEzNTctMDE0YWNjNjBlYmZiYzkzLTI2MDMxMDUxLTEzMjcxMDQtMThjOGY2Y2QyYjM2MDkiLCIkaWRlbnRpdHlfbG9naW5faWQiOiIyMTgyODIxNDQyODUyMjEifQ%3D%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22218282144285221%22%7D%2C%22%24device_id%22%3A%2218c8f6cd2b1357-014acc60ebfbc93-26031051-1327104-18c8f6cd2b3609%22%7D");
        post.addHeader("Content-type","application/json, text/plain, */*");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"自己去百度！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";
        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
            //将结果返回成字符串的格式
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
