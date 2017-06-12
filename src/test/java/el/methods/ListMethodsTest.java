package el.methods;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by 21cmPC on 12.06.2017.
 */
public class ListMethodsTest {
    @Test
    public void listFiles() throws Exception {
        List<String> files = new LinkedList<>();
        files.add("file1");
        files.add("file2");

        String res = ListMethods.listFiles(files);

        assertEquals(res, "<input name=\"file\" type=\"radio\" value=\" file1\" > file1<br><input name=\"file\" type=\"radio\" value=\" file2\" > file2<br>");
    }

}