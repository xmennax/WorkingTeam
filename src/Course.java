public class Course {
    String Name;
    String Code;
    int MinStudentLevel;
    int CreditHours;

    public Course() {
    }
    public Course(String name, int level, int creditHours) {
        Name = name;
        MinStudentLevel = level;
        CreditHours = creditHours;

    }

    @Override
    public String toString() {
        return "Course{" +
                "Name='" + Name + '\'' +
                ", Code='" + Code + '\'' +
                ", MinStudentLevel=" + MinStudentLevel +
                ", CreditHours=" + CreditHours +
                '}';
    }
}
