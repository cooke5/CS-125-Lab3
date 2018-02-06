import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    public static void main(String[] unused) {
        int specialCount = 0;
        String specialWord = "Hamlet";
        String URL = urlToString("http://erdani.com/tdpl/hamlet.txt");
        URL = URL.toLowerCase();
        String[] words = URL.split("\\s+");
        for (int n = 0; n < words.length; n++) {
            if (words[n].equals(specialWord.toLowerCase())) {
                specialCount++;
            }
        }
        System.out.println(specialCount);
        System.out.println(words.length);
        //System.out.println(urlToString("http://erdani.com/tdpl/hamlet.txt"));
    }
}
