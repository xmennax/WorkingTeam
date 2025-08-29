public abstract class Student {


    final int max_size = 6;
    String name;
    int ID;
    int level;
    double[] grades ;
    Course[] courseList ;
    int noOfCourses;

    public Student(){
        noOfCourses = 0;
        this.courseList = new Course[max_size];
        this.grades = new double[max_size];
    }
    public boolean isEmpty(){
        return noOfCourses==0;
    }
    public void printRegisteredCourses(){
        if(isEmpty()) {
            System.out.println("There is no Registered Courses");
            return;
        }
        for (int i = 0; i < noOfCourses; i++) {
            System.out.print(courseList[i] + " ");
        }
        System.out.println();
    }
    public abstract float calculateExpenses();

    public boolean registerCourse(Course c1){
        if (noOfCourses >= 6) {
            return false;
        }
        for (int i = 0; i < noOfCourses; i++) {
            if (courseList[i].equals(c1)) {
                System.out.println("The Course has already been registered ");
                return false;
            }
        }
        courseList[noOfCourses] = c1;
        noOfCourses++;

        return true;
    }

    public double getTotalGPA(){
        int sum=0;
        double x = 0;
        for (int i = 0; i < noOfCourses; i++) {
            sum += courseList[i].CreditHours;
            x += courseList[i].CreditHours*getCourseGPA(grades[i]);
        }
        if(sum==0){
            System.out.println("No Credit Hours Registered");
            return 0.0;
        }
        x/=sum;
        return x;
    }

    public double getCourseGPA(double grade){
        double gpa = 0 ;
        if (grade >100 || grade < 0)
            System.out.println("invalid Grade");
        else if(grade >=93)
            gpa = 4.00;
        else if(grade>=90)
            gpa = 3.70;
        else if(grade>=87)
            gpa = 3.30;
        else if(grade>=83)
            gpa = 3.00;
        else if(grade>=80)
            gpa = 2.70;
        else if(grade>=77)
            gpa = 2.30;
        else if(grade>=73)
            gpa = 2.00;
        else if(grade>=70)
            gpa = 1.70;
        else if(grade>=67)
            gpa = 1.30;
        else if(grade>=63)
            gpa = 1.00;
        else if(grade>=60)
            gpa = 0.70;
        else
            gpa = 0.00;

        return gpa;
    }
}
