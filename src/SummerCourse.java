public class SummerCourse extends Course{
    public SummerCourse() {
        super();
        this.Code="";
    }

    public SummerCourse(String name, int level, int creditHours) {
        super(name,level , creditHours);
        this.Code=name+"_S"+level;
    }

}
