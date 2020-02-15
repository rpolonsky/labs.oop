import java.net.*;
import java.util.regex.*;

public class UrlWithDepth {
    public URL url;
    public int depth;

    public static final String LINK_REGEX = "href\\s*=\\s*\"([^$^\"]*)\"";
    public static final Pattern LINK_PATTERN = Pattern.compile(LINK_REGEX, Pattern.CASE_INSENSITIVE);

    public UrlWithDepth(String url, int depth) throws MalformedURLException {
        this.url = new URL(url);
        this.depth = depth;
    }

    public UrlWithDepth(URL url, int depth) {
        this.url = url;
        this.depth = depth;
    }

    public static boolean isValid(String url) {
        try {
            URL obj = new URL(url);
            obj.toURI();
            return true;
        } catch (MalformedURLException e) {
            return false;
        } catch (URISyntaxException e) {
            return false;
        }
    }

    public static boolean isAbsolute(String url) {
        return LINK_PATTERN.matcher(url).find() ? true : false;
    }
}
