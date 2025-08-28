import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final Course[] COURSES = {
            new NormalCourse("Math", 1, 2),
            new NormalCourse("Programming_1", 1, 3),
            new NormalCourse("Technical_Writing", 1, 3),
            new NormalCourse("Electronics", 2, 4),
            new NormalCourse("Data_Structures", 2, 3),
            new NormalCourse("OOP", 2, 3),
            new NormalCourse("Algorithms", 3, 2),
            new NormalCourse("Operating_Systems", 3, 3),
            new NormalCourse("Databases", 3, 3),
            new NormalCourse("Machine_Learning", 4, 3),
            new NormalCourse("Compilers", 4, 4),
            new NormalCourse("Programming_Concepts", 4, 4),

            new SummerCourse("Math", 1, 2),
            new SummerCourse("Compilers", 4, 4),
            new SummerCourse("Algorithms", 3, 2),
            new SummerCourse("OOP", 2, 3)
    };
    public static Course SearchCourse (String code){

        for (Course c : COURSES) {
            if(c.Code.equals(code)){
                return c;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            int noOfRegisteredCourses, StudentType;
            List<Student> EnteredStudents = new ArrayList<>();
            ArrayList<Float> EnteredMoney = new ArrayList<>();
            System.out.print("Enter the number of Students in the System: ");
            int numOfStudents = scan.nextInt();
            scan.nextLine();
            System.out.println("For Each Student:");
            for (int i = 0; i < numOfStudents; i++) {
                System.out.printf("Student no.%d\n", i + 1);
                System.out.print("Enter Student Type (0: general, 1: special): ");
                StudentType = scan.nextInt();
                scan.nextLine();
                System.out.print("Enter the Student Name: ");
                String StudentName = scan.nextLine();
                System.out.print("Enter the Student ID: ");
                int StudentID = scan.nextInt();
                System.out.print("Enter Student Level: ");
                int StudentLevel = scan.nextInt();
                Student currentStudent = new Student() {
                    @Override
                    public float calculateExpenses() {
                        return 0;
                    }
                };
                if (StudentType == 0) {
                    currentStudent = new GeneralProgramStudent();
                } else if (StudentType == 1) {
                    currentStudent = new SpecialProgramStudent();
                }
                System.out.print("The number of Courses to be Registered: ");
                noOfRegisteredCourses = scan.nextInt();
                System.out.println("Courses to be Registered: ");
                currentStudent.name = StudentName;
                currentStudent.ID = StudentID;
                currentStudent.level = StudentLevel;
                scan.nextLine();
                for (int j = 0; j < noOfRegisteredCourses; j++) {
                    System.out.printf("Course %d: \n", j + 1);
                    System.out.print("Code: ");
                    String code = scan.nextLine();
                    Course c1;
                    c1 = Main.SearchCourse(code);
                    if (currentStudent.registerCourse(c1)) {
                        System.out.print("Grade: ");
                        int grade = scan.nextInt();
                        currentStudent.grades[currentStudent.noOfCourses - 1] = grade;
                    }
                }
                System.out.println();
                EnteredStudents.add(currentStudent);
                EnteredMoney.add(currentStudent.calculateExpenses());

            }
            for (int i = 0; i < numOfStudents; i++) {
                Student s1 = EnteredStudents.get(i);
                System.out.printf("Student no.%d: \n", i + 1);
                System.out.print("Student Name: ");
                System.out.println(EnteredStudents.get(i).name);
                System.out.print("Student ID: ");
                System.out.println(EnteredStudents.get(i).ID);
                System.out.print("Student Level: ");
                System.out.println(EnteredStudents.get(i).level);
                s1.printRegisteredCourses();
                System.out.println(EnteredMoney.get(i));
                System.out.printf("%.2f", s1.getTotalGPA());
                System.out.println();

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
