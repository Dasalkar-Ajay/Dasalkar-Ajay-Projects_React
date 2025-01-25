import java.util.HashMap;

public class  LinkShortener {
    private HashMap<String, String> urlMap;
    private HashMap<String, String> shortToLongMap;

    public LinkShortener(){
        urlMap = new HashMap<>();
        shortToLongMap = new HashMap<>();
    }

    public String shortenUrl(String longUrl) {
        String shortUrl = generateShortUrl(longUrl);
  
        while (shortToLongMap.containsKey(shortUrl)) {
            shortUrl = generateShortUrl(longUrl + System.currentTimeMillis()); 
        }

        urlMap.put(longUrl, shortUrl);
        shortToLongMap.put(shortUrl, longUrl);

        return shortUrl;
    }


    public String expandUrl(String shortUrl) {
        if (shortToLongMap.containsKey(shortUrl)) {
            return shortToLongMap.get(shortUrl);
        } else {
            return "Error: Invalid short URL.";
        }
    }

    private String generateShortUrl(String longUrl) {
        return Integer.toHexString(longUrl.hashCode());
    }
}
