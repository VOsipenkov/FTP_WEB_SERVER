import model.NameConverter;
import org.junit.Before;
import org.junit.Ignore;
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
    @Ignore
    public void test1() {
        assertEquals(nameConverter.doCheck("ALEX"), "Alex");
    }

    @Test
    @Ignore
    public void test2(){
        assertEquals(nameConverter.doCheck("Alex"), "Alex");
    }

    @Test
    @Ignore
    public void test3(){
        assertEquals(nameConverter.doCheck("Ale%x"), NameConverter.NOT_VALID_NAME);
    }

    @Test
    @Ignore
    public void test4(){
        assertEquals(nameConverter.doCheck(" "), NameConverter.NOT_VALID_NAME);
        assertEquals(nameConverter.doCheck(""), NameConverter.NOT_VALID_NAME);
    }

    @Test
    @Ignore
    public void test5(){
        assertEquals(nameConverter.doCheck("Алекс"),"Aleks");
    }

    @Test
    @Ignore
    public void test6(){
        assertEquals(nameConverter.doCheck("александр македонский"), NameConverter.NOT_VALID_NAME);
    }

    @Test
    @Ignore
    public void test7(){
        assertEquals(nameConverter.doCheck("АЛександр"), "Aleksandr");
    }

}