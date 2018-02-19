import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        try {

            URL url = new URL("http://example.org");


            URLConnection urlConnection = url.openConnection(); // BY default you can only read from a connection
            urlConnection.setDoOutput(true);    // Enable output
            urlConnection.connect();


            BufferedReader inputStream = new BufferedReader(
                    new InputStreamReader(
                            urlConnection.getInputStream()
//                            url.openStream()
                    )
            );

            Map<String,List<String>> headerFields = urlConnection.getHeaderFields();
            for(Map.Entry<String, List<String>> mapEntry : headerFields.entrySet()){

                String key = mapEntry.getKey();
                List<String> value = mapEntry.getValue();
                System.out.println("-------key = "  +  key);

                System.out.println("value = "+ value);


            }


//            String line = "";
//            while(line != null){
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//            inputStream.close();







//            URI uri = url.toURI();

//            URI baseUri = new URI("https://myServer.com:5000");
//
//            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
//            URI uri2 = new URI("/catalogue/tvs?manufacturer=android");
//            URI uri3 = new URI("/stores/locations?zip=123445");
//
//            URI resolved1 = baseUri.resolve(uri1);
//            URI resolved2 = baseUri.resolve(uri2);
//            URI resolved3 = baseUri.resolve(uri3);
//
//            URL url1 = resolved1.toURL();
//            System.out.println(url1);
//            URL url2 = resolved2.toURL();
//            System.out.println(url2);
//            URL url3 = resolved3.toURL();
//            System.out.println(url3);
//
//            URI relativizedURI = baseUri.relativize(resolved1);
//            System.out.println("\n"+relativizedURI);
//
//            System.out.println("Scheme = " + uri.getScheme());
//            System.out.println("Scheme-part " + uri.getSchemeSpecificPart());
//            System.out.println("Authority "+ uri.getAuthority());
//            System.out.println("User info " + uri.getUserInfo());
//            System.out.println("Host " + uri.getHost());
//            System.out.println("Path " + uri.getPath());
//            System.out.println("Query " + uri.getQuery());
//            System.out.println("Fragment " + uri.getFragment());
//        }catch(URISyntaxException e){
//            System.out.println("URI bad syntax: " + e.getMessage());
        }catch (MalformedURLException e){
            System.out.println("URL Malformed " + e.getMessage());
        }catch(IOException e){
            System.out.println("IOException " + e.getMessage());
        }
    }
}
