import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estado {

    Map<Character, List<Estado>> trans;

    public Estado() {
            this.trans = new HashMap<>();
    }

    public void addTrans(char c, Estado next) {
        if (!trans.containsKey(c)) {
                trans.put(c, new ArrayList<>());
        }
        trans.get(c).add(next);
        }
}
