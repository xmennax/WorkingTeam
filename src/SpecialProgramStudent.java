public class SpecialProgramStudent extends Student{
    public float calculateExpenses(){
        int sumOfCreditHours=0;
        for (int i = 0; i < noOfCourses; i++) {
            sumOfCreditHours+=courseList[i].CreditHours;
        }
        return (float)sumOfCreditHours*500;
    }
}
