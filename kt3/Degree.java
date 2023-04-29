import java.util.ArrayList;
import java.util.List;

public class Degree {
    static final int MAX_COURSES = 50;
    String degreeTitle = ConstantValues.NO_TITLE;
    String titleOfThesis = ConstantValues.NO_TITLE; 
    private List<StudentCourse> myCourses = new ArrayList<StudentCourse>();

    public List<StudentCourse> getCourses(){
        return myCourses;
    }


    public void addStudentCourses(List<StudentCourse>courses){

        if(courses != null){
            for(StudentCourse course : courses){
                addStudentCourse(course);
            }
        }
    }

    public boolean addStudentCourse(StudentCourse course){
        if(myCourses.size() < MAX_COURSES && course != null){
            myCourses.add(course);

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
        for(StudentCourse course : myCourses){
            if(course.getCourse().getCourseBase() == base && isCourseCompleted(course)){
                sum = sum + course.getCourse().getCredits();
            }
        }
        return sum;
    }

    public double getCreditsByType(final int courseType){
        double sum = 0;
        for(StudentCourse course : myCourses){
            if(course != null && course.getCourse().getCourseType() == courseType && isCourseCompleted(course)){
                sum = sum + course.getCourse().getCredits();
            }
        }
        return sum;
    }
    public double getCredits(){
        double sum = 0;
        for(StudentCourse course : myCourses){
            if(isCourseCompleted(course)){
                sum = sum + course.getCourse().getCredits();
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
        for(StudentCourse course : myCourses){
            if(course != null){
                System.out.println(course.toString());
            }
        }
    }

    public List<Double> getGPA(int type){
 
        return calculateGPA(type);
    }

    public List<Double> calculateGPA(int type){

        double sum = 0, average = 0, count = 0;
        List<Double> result = new ArrayList<>();

        if(myCourses == null){
            result.add(sum);
            result.add(count);
            result.add(average);
            return result;
        }
        if(type == 0){
            for(int i=0; i<myCourses.size(); i++){

            if(myCourses.get(i).getCourse()!=null&&myCourses.get(i).getCourse().getCourseType()==0 && myCourses.get(i).getCourse().isNumericGrade()){
                sum=sum+myCourses.get(i).getGradeNum();
                count++;
            }
            }   
                average=sum/count;
                result.add(sum);
                result.add(count);
                result.add(average);

        return result;
        }

        if(type == 1){
        for(int i=0; i<myCourses.size(); i++){

            if(myCourses.get(i).getCourse()!=null&&myCourses.get(i).getCourse().getCourseType()==1 && myCourses.get(i).getCourse().isNumericGrade()){
                sum=sum+myCourses.get(i).getGradeNum();
                count++;
            }
        }
                average=sum/count;
                result.add(sum);
                result.add(count);
                result.add(average);

            return result;
        }
        if(type==2){

            for(int i=0; i<myCourses.size(); i++){
                if(myCourses.get(i).getCourse()!=null&&myCourses.get(i).getCourse().isNumericGrade()){
                    sum=sum+myCourses.get(i).getGradeNum();
                    count++;
                    }
                }
                average=sum/count;
                result.add(sum);
                result.add(count);
                result.add(average);


            return result;
        }
        return result;
    }


    
    public String toString(){
        String course = "";
        int s = 1;
        for(StudentCourse sc : myCourses){
            if(sc != null){
                course += "\n\t\"" + s + ". " + sc;
                s++;
            }
        }
        return "Degree [Title: \"" + getDegreeTitle() + "\" (courses: " + myCourses.size() + ")"
            + "\n\t Thesis title: \"" + getTitleOfThesis() + "\"" + course;
    }
}

