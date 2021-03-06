package com.ping.demo2;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class TestPost {
    public static void main(String[] args) {
        //1.打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.输入网址
        HttpPost httpPost = new HttpPost("http://www.itcast.cn");
        CloseableHttpResponse response = null;
        try {
            //3.发送请求
            response = httpClient.execute(httpPost);
            //4.解析相应获取数据
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity httpEntity = response.getEntity();
                String content = EntityUtils.toString(httpEntity, "utf8");
                System.out.println(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
