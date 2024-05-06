public class Answer {
    private final String mod;
    private final String value;

    private final String text;

    public Answer (String m, String v, String t) {
        mod = m;
        value = v;
        text = t;
    }

    public String getMod() {
        return mod;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
