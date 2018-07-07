import java.util.Comparator;

public class BinIntCmp implements Comparator<BinInt> {
    public int compare(BinInt o1, BinInt o2) {
        if (o1.get1Cnt() == o2.get1Cnt())
        return (o1.getInt() - o2.getInt());
    return (o1.get1Cnt() - o2.get1Cnt() < 0) ? -1 : 1;
    }
}