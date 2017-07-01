package filters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.util.*;

public class HeaderSetterWrapper extends HttpServletRequestWrapper {
    private Map<String, String> customHeaders = new HashMap<>();

    public HeaderSetterWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        List<String> headers = Collections.list(super.getHeaderNames());
        if (customHeaders.size() > 0){
            headers.addAll(customHeaders.keySet());
        }

        return Collections.enumeration(headers);
    }

    @Override
    public String getHeader(String name) {
        String header = super.getHeader(name);
        if ( customHeaders.containsKey(name)){
            header = customHeaders.get(name);
        }

        return header;
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        List<String> headers = Collections.list(super.getHeaders(name));
        if (customHeaders.containsKey(name)){
            headers.add(customHeaders.get(name));
        }

        return Collections.enumeration(headers);
    }

    public void addHeader(String name, String value){
        customHeaders.put(name, value);
    }
}
