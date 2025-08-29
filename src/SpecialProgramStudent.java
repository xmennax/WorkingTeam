public class SpecialProgramStudent extends Student{
    @Override
    public boolean registerCourse(Course c1){
        if(this.level<c1.MinStudentLevel){
            System.out.println("Can't Register");
            return false;
        }
        return super.registerCourse(c1);
    }
    public float calculateExpenses(){
        int sumOfCreditHours=0;
        for (int i = 0; i < noOfCourses; i++) {
            sumOfCreditHours+=courseList[i].CreditHours;
        }
        return (float)sumOfCreditHours*500;
    }
}
