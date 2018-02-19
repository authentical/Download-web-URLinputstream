import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ApacheClient {
    public static void main(String[] args) {

        // Magic
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // URL
        HttpGet httpGet = new HttpGet("http://example.org");



        // Get the webpage

        CloseableHttpResponse response1 = null;
        try {

            response1 = httpclient.execute(httpGet);
            // An HTTP entity is the majority of an HTTP request or response,
            // consisting of some of the headers and the body, if present.
            // - https://stackoverflow.com/questions/9197745/what-exactly-is-an-http-entity
            HttpEntity entity1 = response1.getEntity();


            // Read Http stuff
            System.out.println("-----CloseableHttpResponse.getStatusLine-----");
            System.out.println(response1.getStatusLine());
            System.out.println("-----CloseableHttpResponse.getStatusLine().getStatusCode()-----");
            System.out.println("response " + response1.getStatusLine().getStatusCode());


            // Read webpage
            System.out.println("-----entity.getContent-----");
            BufferedReader inputReader = new BufferedReader(
                    new InputStreamReader(
                            /*javanetHttpURLConnection.getInputStream()*/
                            entity1.getContent()));

            String line;
            while((line = inputReader.readLine()) !=null){
                System.out.println(line);
            }

            inputReader.close();


        }catch(IOException e){e.printStackTrace();}
        finally{ try{
                response1.close();
            }catch(IOException e){}
        }





//
//        try {
//            System.out.println(response1.getStatusLine());
//            HttpEntity entity1 = response1.getEntity();
//            // do something useful with the response body
//            // and ensure it is fully consumed
//            EntityUtils.consume(entity1);
//        } finally {
//            response1.close();
//        }
//
//        HttpPost httpPost = new HttpPost("http://targethost/login");
//        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
//        nvps.add(new BasicNameValuePair("username", "vip"));
//        nvps.add(new BasicNameValuePair("password", "secret"));
//        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
//        CloseableHttpResponse response2 = httpclient.execute(httpPost);
//
//        try {
//            System.out.println(response2.getStatusLine());
//            HttpEntity entity2 = response2.getEntity();
//            // do something useful with the response body
//            // and ensure it is fully consumed
//            EntityUtils.consume(entity2);
//        } finally {
//            response2.close();
//        }
    }
}
