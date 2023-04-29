import java.time.*;

public class DesignatedCourse {
    private Course course;
    private boolean responsible;
    private int year;

    DesignatedCourse(){

    }

    DesignatedCourse(Course course, boolean resp, int year){
        this.course = course;
        this.responsible = resp;
        this.year = year;
    }

    public Course getCourse(){
        return course;
    }

    public void setCourse(Course course){
        if(course != null){
            this.course = course;
        }
    }

    public boolean isResponsible(){
        return responsible;
    }

    public void setResponsible(boolean responsible){
        this.responsible = responsible;
    }

    public boolean getResponsible(){
        if(!isResponsible()){
            return false;
        }else return true;
    }

    public int getYear(){
        return year;
    }

    public void setYear(int year){
        if(year >= 2000 && year <= Year.now().getValue() + 1){
            this.year = year;
        }
    }
    public String toString(){
            return "[course="+getCourse().toString()+", year="+getYear()+"]";
    }

}


