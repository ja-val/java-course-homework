package module01;

public class MutableClass {
    private int num;
    private String str;

    public MutableClass(int num, String str) {
        this.num = num;
        this.str = str;
    }

    public int getNum() { return num; }
    public String getStr() { return str; }

    public void setNum(int num) { this.num = num; }
    public void setStr(String str) { this.str = str; }

    @Override
    public String toString() {
        return "MutableClass{num=" + num + ", str='" + str + "'}";
    }
}
