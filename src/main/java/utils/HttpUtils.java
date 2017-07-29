package utils;

import model.Filter;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class HttpUtils {
    public static Filter extractFilter(HttpServletRequest req) throws IOException {
        Filter filter = new Filter();

        InputStream inputStream = req.getInputStream();
        String body = IOUtils.toString(inputStream, StandardCharsets.ISO_8859_1);

        JSONObject jsonObject = new JSONObject(body);

        if (jsonObject.has("containsNumber") && jsonObject.get("containsNumber") !=null ){
            filter.setContainsNumber((Boolean)jsonObject.get("containsNumber"));
        }
        if (jsonObject.has("containsChar") && jsonObject.get("containsChar") != null){
            filter.setContainsChar((Boolean)jsonObject.get("containsChar"));
        }
        if (jsonObject.has("containsWord") && jsonObject.get("containsWord") != null
                && !jsonObject.get("containsWord").equals("")){
            filter.setContainsWord(jsonObject.getString("containsWord"));
        }

        return filter;
    }
}

