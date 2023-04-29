import java.time.*;

public class StudentCourse {
    private int currentYear = Year.now().getValue();
    private Course course;
    private int gradeNum;
    private int yearCompleted;

    StudentCourse(){}
    StudentCourse(Course course, final int gradeNum, final int yearCompleted){
        setCourse(course);
        setGrade(gradeNum);
        setYear(yearCompleted);

    }

    public Course getCourse(){
        return course;
    }

    public void setCourse(Course course){
        this.course = course;
    }

    public int getGradeNum(){
        return gradeNum;
    }

    protected void setGrade(int gradeNum){
        if(checkGradeValidity(gradeNum) == true){
            this.gradeNum = gradeNum;
        }
  
        if(yearCompleted == 0){
            yearCompleted = currentYear;
        }
    }
    private boolean checkGradeValidity(final int gradeNum){

        
            if(course.isNumericGrade() == true){
                switch(gradeNum){
                    case 0:
                    case 1:
                    case 2:  
                    case 3:
                    case 4:
                    case 5:
                        return true;
                }
            }

            if(course.isNumericGrade() == false){
                char correspondingChar = (char) gradeNum;
                
                if(correspondingChar == 'A' || correspondingChar == 'F'){
                    return true;
                }
                
            }
        
        return false;
    }

    public boolean isPassed(){
        char correspondingChar = (char) gradeNum;
        if(course.isNumericGrade() == true){
            if(gradeNum != 0){
                return true;
            }
        }
        if(course.isNumericGrade() == false){
            if(correspondingChar != 'F'){
                return true;
            }
        }
        return false;
    }

     

    public int getYear(){
        return yearCompleted;
    }

    public void setYear(final int year){
        if(year > 2000 && year <= currentYear){
            yearCompleted = year;
        }
    }

    public String toString(){
        
        if(gradeNum == 70){
            return "["+ course.getCourseCode() + " ("+ String.format("%.2f", course.getCredits()) +" cr), \""+ course.getName() + "\". " + course.getCourseTypeString() + ", period: "+ course.getPeriod() + ".] Year: " + getYear() + ", Grade: F.]";
        }
        if(gradeNum == 65){
            return "["+ course.getCourseCode() + " ("+ String.format("%.2f", course.getCredits()) +" cr), \""+ course.getName() + "\". " + course.getCourseTypeString() + ", period: "+ course.getPeriod() + ".] Year: " + getYear() + ", Grade: A.]";
        }
        if(gradeNum == 0){
            return "["+ course.getCourseCode() + " ("+ String.format("%.2f", course.getCredits()) +" cr), \""+ course.getName() + "\". " + course.getCourseTypeString() + ", period: "+ course.getPeriod() + ".] Year: " + getYear() + ", Grade: Not graded.]";
    }else return "["+ course.getCourseCode() + " ("+ String.format("%.2f", course.getCredits()) +" cr), \""+ course.getName() + "\". " + course.getCourseTypeString() + ", period: "+ course.getPeriod() + ".] Year: " + getYear() + ", Grade: " + getGradeNum() + ".]";
}



}

