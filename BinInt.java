import java.util.TreeSet;

public class BinInt {
    public static void BinaryHR() {
        int [] elements = {1, 3, 5, 8, 5};
        TreeSet<BinInt> b = new TreeSet<>(new BinIntCmp());
        for (int i=0; i<elements.length; i++)
            b.add(new BinInt(elements[i]));

        for(BinInt bi: b)
                System.out.println(bi.getInt() + " ==> " + bi.getBin());
    }

    private int val;
    private String bin;
    private long len1Cnt;
    public BinInt(int v) {
        this.val = v;
        this.bin = Integer.toBinaryString(v);
        this.len1Cnt = this.bin.replaceAll("0", "").length();
    }
    public int getInt() { return this.val; }
    public String getBin() { return this.bin; }
    public long get1Cnt() { return this.len1Cnt; }
}