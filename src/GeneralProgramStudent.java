public class GeneralProgramStudent extends Student{

    @Override
    public boolean registerCourse(Course c1){
        if(this.level<c1.MinStudentLevel){
            System.out.println("Can't Register");
            return false;
        }
        return super.registerCourse(c1);
    }

    public float calculateExpenses(){
        return (float) level*1000;
    }


}
