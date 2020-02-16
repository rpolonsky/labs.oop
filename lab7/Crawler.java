import java.net.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Crawler {
    private static final String DEFAULT_URL = "https://yandex.ru/";
    private static final int DEFAULT_DEPTH = 1;

    private static URL url;
    private static int maxDepth;
    private static LinkedList<UrlWithDepth> links;

    public static void main(String[] args) throws MalformedURLException, UnknownHostException, IOException {
        url = new URL(args.length > 0 && args[0] != null ? args[0] : DEFAULT_URL);
        maxDepth = (int) (args.length > 1 && args[1] != null ? args[1] : DEFAULT_DEPTH);
        links = new LinkedList<UrlWithDepth>();

        parseUrls(url, 0);

        for (int i = 0; i < links.size(); i++) {
            UrlWithDepth link = links.get(i);
            System.out.println(link.depth + ": " + link.url);
        }
    }

    public static void parseUrls(URL url, int depth) throws MalformedURLException, UnknownHostException, IOException {
        /* connect to provided url through HttpURLConnection */
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.connect();

        try {
            InputStreamReader in = new InputStreamReader((InputStream) conn.getContent());
            BufferedReader reader = new BufferedReader(in);

            String line;
            while ((line = reader.readLine()) != null) {
                Matcher LinkFinder = UrlWithDepth.LINK_PATTERN.matcher(line);

                while (LinkFinder.find()) {
                    String matchedUrl = LinkFinder.group(1);

                    if (UrlWithDepth.isAbsolute(matchedUrl)) {
                        links.add(new UrlWithDepth(matchedUrl, depth));
                    } else {
                        links.add(new UrlWithDepth(new URL(url, matchedUrl), depth));
                    }
                }
            }

            if (depth < maxDepth) {
                for (int i = 0; i < links.size(); i++) {
                    UrlWithDepth link = links.get(i);
                    parseUrls(link.url, link.depth + 1);
                }
            }
        } catch (ClassCastException e) {
        } catch (UnknownServiceException e) {
        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
        }
    }
}
