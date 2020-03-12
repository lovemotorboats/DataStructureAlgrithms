package recursionanddynamicplanning.envelop;

import java.util.Comparator;

public class EnvelopComparator implements Comparator<Envelop> {
    @Override
    public int compare(Envelop o1, Envelop o2) {
        return o1.len != o2.len ? o1.len - o2.len :o2.wid - o1.wid;
    }
}
