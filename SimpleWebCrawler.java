import java.net.URL;
import java.util.*;
import java.util.regex.*;
import java.io.*;

public class SimpleWebCrawler{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter source URL: ");
        String source = br.readLine();
        
        Queue<String> urls = new LinkedList<String>();
        Set<String> crawled = new TreeSet<String>();

        urls.add(source);
        crawled.add(source);

        while(!urls.isEmpty()){
            String v = urls.poll();
            System.out.println("Crawling the URL.. "+v);
            String contents = getURLContents(v);
            
            String regexp = "https?://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regexp);
            Matcher matcher = pattern.matcher(contents);
            while(matcher.find()){
                String w = matcher.group();
                if(!crawled.contains(w)){
                    crawled.add(w);
                    urls.add(w);
                }
            }
        }

    }
    public static String getURLContents(String url){
        try{
            URL gurl = new URL(url);
            InputStream is = gurl.openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is)); 
            StringBuilder sb = new StringBuilder();
            String line;
            while((line = br.readLine()) != null)
                sb.append(line);
            is.close();
            return sb.toString();
        }catch(Exception e){
            e.printStackTrace();
            return "Exception Occurred";
        }
    }
}