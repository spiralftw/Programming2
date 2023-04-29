import java.util.ArrayList;
import java.util.List;

public class ResponsibleTeacher extends Employee implements Teacher{

    private List<DesignatedCourse> courses = new ArrayList<DesignatedCourse>();

    ResponsibleTeacher(String lname, String fname ){
        super(lname, fname);
    }

    public String getEmployeeIdString(){
        return "OY_TEACHER_";
    }

    public String getCourses(){
        String courseString = "";
            for (DesignatedCourse designatedCourse : courses){
                if(!designatedCourse.isResponsible()){
                    courseString += "\t Teacher: " + designatedCourse.toString() + "\n"; 
                }else courseString += "\t Responsible teacher: " + designatedCourse.toString() + "\n"; 
                
            }
        return courseString;  
    }

    public void setCourses(List<DesignatedCourse>courses){
        if(courses != null){
            this.courses = courses;
        }
    }
    
    public String toString(){
        return "Teacher id: " + getIdString() +
        "\nFirst name: " + getFirstName() +", Last name: " + getLastName() +
        "\nBirthdate: " + getBirthDate() +
        "\nSalary: " + String.format("%.2f", calculatePayment()) + 
        "\nTeacher for courses:" +
        "\n" + getCourses();
    }

}
