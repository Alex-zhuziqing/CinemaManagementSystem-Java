package FancyCinemas.Model;

public enum MovieClassification {
    GENERAL(0, "G"),
    PARENTAL_GUIDANCE(1, "PG"),
    MATURE(2, "M"),
    MATURE_ACCOMPANIES(3, "MA15+"),
    RESTRICTED(4, "R18+");

    public final int classVal;
    public final String shortName;

    private MovieClassification(int classVal, String shortName) {
        this.classVal = classVal;
        this.shortName = shortName;
    }

    public static Integer getClassVal(String shortName) {
        for (MovieClassification m : MovieClassification.values()) {
            if (m.shortName.equals(shortName)) {
                return m.classVal;
            }
        }
        return -1;
    }
}
