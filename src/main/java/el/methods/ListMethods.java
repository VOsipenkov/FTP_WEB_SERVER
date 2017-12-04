package el.methods;

import java.util.List;

public class ListMethods {

    public static String listFiles(List files){
        StringBuilder res = new StringBuilder();

        if (files == null) return res.toString();

        for (Object file : files){
            res.append("<input name=\"file\" type=\"radio\" value=\" ");
            res.append(file.toString()+"\" > ");
            res.append(file.toString()+"<br>");
        }

        return  res.toString();
    }
}
