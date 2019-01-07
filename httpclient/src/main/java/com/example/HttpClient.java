package com.example;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

class HttpClient {

    Charset charset;
    String baseUrl;

    public HttpClient() {
        this.charset = StandardCharsets.UTF_8;
        this.baseUrl = "https://httpbin.org/";
    }

    public void getSample() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet request = new HttpGet(baseUrl + "get");

        System.out.println("Execute request [" + request.getRequestLine() + "]");

        CloseableHttpResponse response = null;

        try {
            response = httpclient.execute(request);

            int status = response.getStatusLine().getStatusCode();
            System.out.println("HTTP status: " + status);

            if (status == HttpStatus.SC_OK) {
                String responseData = EntityUtils.toString(response.getEntity(), charset);
                System.out.println(responseData);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpclient != null) {
                    httpclient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void postSample() {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost request = new HttpPost(baseUrl + "post");

        List<NameValuePair> requestParams = new ArrayList<>();
        requestParams.add(new BasicNameValuePair("user", "taro"));
        requestParams.add(new BasicNameValuePair("password", "123"));

        System.out.println("Execute request [" + request.getRequestLine() + "]");

        CloseableHttpResponse response = null;

        try {
            request.setEntity(new UrlEncodedFormEntity(requestParams));
            response = httpclient.execute(request);

            int status = response.getStatusLine().getStatusCode();
            System.out.println("HTTP status: " + status);

            if (status == HttpStatus.SC_OK) {
                String responseData = EntityUtils.toString(response.getEntity(), charset);
                System.out.println(responseData);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpclient != null) {
                    httpclient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
