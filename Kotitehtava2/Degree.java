

public class Degree {
    static final int MAX_COURSES = 50;
    int count = 0;
    String degreeTitle = ConstantValues.NO_TITLE;
    String titleOfThesis = ConstantValues.NO_TITLE; 
    StudentCourse[] myCourses = new StudentCourse[MAX_COURSES];

    public StudentCourse[] getCourses(){
        return myCourses;
    }

    public void addStudentCourses(StudentCourse[] courses){

        for(int n = 0; n < courses.length; n++){
            if(courses[n] != null){
                addStudentCourse(courses[n]);
            }
        }
    }

    public boolean addStudentCourse(StudentCourse course){
        if(count < MAX_COURSES && course != null){
            myCourses[count] = course;
            count++;
            
            return true;
        }else return false;
    }

    public String getDegreeTitle(){
        return degreeTitle;
    }

    public void setDegreeTitle(String degreeTitle){
        if(degreeTitle != null){
            this.degreeTitle = degreeTitle;
        }
    }

    public String getTitleOfThesis(){
        return titleOfThesis;
    }

    public void setTitleOfThesis(String titleOfThesis){
        if(titleOfThesis != null){
            this.titleOfThesis = titleOfThesis;
        }
    }

    public double getCreditsByBase(Character base){
        double sum = 0;
        for(int n = 0; n < MAX_COURSES; n++){
            if(myCourses[n].getCourse().getCourseBase() == base && isCourseCompleted(myCourses[n]) == true){
                sum = sum + myCourses[n].getCourse().getCredits();
            }
        }
        return sum;
    }

    public double getCreditsByType(final int courseType){
        double sum = 0;
        for(int n = 0; n < MAX_COURSES; n++){
            if(myCourses[n] != null){
                if(myCourses[n].getCourse().getCourseType() == courseType && isCourseCompleted(myCourses[n]) == true){
                    sum = sum + myCourses[n].getCourse().getCredits();
                }
            }
        }
        return sum;
    }

    public double getCredits(){
        double sum = 0;
        for(int n = 0; n < MAX_COURSES; n++){
            if(isCourseCompleted(myCourses[n]) != false){
            sum = sum + myCourses[n].getCourse().getCredits();
            }
        }
        String formattedValue = String.format("%.2f", sum);
        return Double.parseDouble(formattedValue);
    }

     private boolean isCourseCompleted(StudentCourse c){
         if(c != null && c.isPassed() == true){
             return true;
         }else return false;
    }

    public void printCourses(){
        for(int n = 0; n < MAX_COURSES; n++){
            if(myCourses[n] != null){
            System.out.println(myCourses[n]);
            }
        }
    }
    
    public String toString(){
        String course = "";
        int s = 1;
        for(int n = 0; n < MAX_COURSES; n++){
            if(myCourses[n] != null){
                course += "\n\t\""+ s + ". " + myCourses[n];
                s++;
            }
        }
        return "Degree [Title: \"" + getDegreeTitle()+ "\" (courses: " + count + ")"
        + "\n\t Thesis title: \""+ getTitleOfThesis()+ "\"" + course;
        
    }
}
