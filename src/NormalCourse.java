public class NormalCourse extends Course{
    public NormalCourse() {
        super();
        this.Code = "";
    }

    public NormalCourse(String name, int level, int creditHours) {
        super(name, level, creditHours);
        this.Code=name+"_N"+level;

    }
}
