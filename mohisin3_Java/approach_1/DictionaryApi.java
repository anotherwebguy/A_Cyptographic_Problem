
import java.net.HttpURLConnection;
import java.net.URL;

public class DictionaryApi {
    private static final String USER_AGENT_ID = "Java/"+System.getProperty("java.version");
    
    
    static boolean getMeaning(String word) {
        try {
            String queryPath = "https://api.dictionaryapi.dev/api/v2/entries/en/"+word;
            URL queryURL = new URL(queryPath);
            HttpURLConnection connection 
                    = (HttpURLConnection) queryURL.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", USER_AGENT_ID);
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) { 
                // 200 is HTTP status OK
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
}