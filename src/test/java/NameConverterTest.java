import model.NameConverter;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by 21cmPC on 04.04.2017.
 */
public class NameConverterTest {
    NameConverter nameConverter;

    @Before
    public void before() {
        nameConverter = new NameConverter();
    }

    @Test
    public void test1() {
        assertEquals(nameConverter.doCheck("ALEX"), "Alex");
    }

    @Test
    public void test2(){
        assertEquals(nameConverter.doCheck("Alex"), "Alex");
    }

    @Test
    public void test3(){
        assertEquals(nameConverter.doCheck("Ale%x"), NameConverter.NOT_VALID_NAME);
    }

    @Test
    public void test4(){
        assertEquals(nameConverter.doCheck(" "), NameConverter.NOT_VALID_NAME);
        assertEquals(nameConverter.doCheck(""), NameConverter.NOT_VALID_NAME);
    }

    @Test
    public void test5(){
        assertEquals(nameConverter.doCheck("Алекс"),"Aleks");
    }

    @Test
    public void test6(){
        assertEquals(nameConverter.doCheck("александр македонский"), NameConverter.NOT_VALID_NAME);
    }

    @Test
    public void test7(){
        assertEquals(nameConverter.doCheck("АЛександр"), "Aleksandr");
    }

}