package module01;

public class ImmutableClass {
    private final String text;
    private final MutableClass mutableClass;

    public ImmutableClass(String text, MutableClass mutableClass) {
        this.text = text;
        this.mutableClass = new MutableClass(mutableClass.getNum(), mutableClass.getStr());
    }

    public String getText() {
        return text;
    }

    public MutableClass getMutableClass() {
        return new MutableClass(mutableClass.getNum(), mutableClass.getStr());
    }

    @Override
    public String toString() {
        return "ImmutableClass{text='" + text + "', mutable=" + mutableClass + "}";
    }
}
