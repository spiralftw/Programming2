import java.util.ArrayList;
import java.util.List;

public class AssistantTeacher extends Employee implements Teacher{

    private List<DesignatedCourse> courses = new ArrayList<DesignatedCourse>();

    AssistantTeacher(String lname, String fname ){
        super(lname, fname);
    }

    public String getEmployeeIdString(){
        return "OY_ASSISTANT_";
    }

    public String getCourses(){
        String courseString = "";

        for (DesignatedCourse designatedCourse : courses) {
            courseString += "\t" + designatedCourse.toString() + "\n"; 
        }
        return courseString;  
    }

      public void setCourses(List<DesignatedCourse>courses){
        if(courses != null){
            this.courses = courses;
        }
    }

    public String toString(){
       
        return
        "Teacher id: " + getIdString() +
        "\nFirst name: " + getFirstName() +", Last name: " + getLastName() +
        "\nBirthdate: " + getBirthDate() +
        "\nSalary: " + String.format("%.2f", calculatePayment()) + 
        "\nAssistant for courses:" +
        "\n" + getCourses();
    }

}

