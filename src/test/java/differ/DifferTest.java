package differ;

import org.junit.Test;

import java.io.IOException;

/**
 * Created by def on 28.10.15.
 */
public class DifferTest {

    @Test
    public void test() throws IOException {
        Differ differ = new Differ();
        differ.process("/home/def/differ/Kody_ABC-8kh.csv",
                "/home/def/differ/Kody_ABC-8kh_2.csv", "new_file");
    }
}
