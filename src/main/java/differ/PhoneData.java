package differ;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by def on 27.10.15.
 */
public class PhoneData {
    private final Set<String> dataSet;

    public PhoneData() {
        dataSet = new HashSet<>();
    }

    public void addData(String data){
        dataSet.add(data);
    }

    public boolean contains(String data) {
        return dataSet.contains(data);
    }
}
