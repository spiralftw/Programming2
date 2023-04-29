import java.util.List;
import java.time.*;
import java.util.ArrayList;

class Student extends Person {
    private int currentYear = Year.now().getValue();
    private int id;
    private int startYear = currentYear;
    private int graduationYear;
    private int degreeCount = 3;
    private List<Degree> degrees = new ArrayList<Degree>();

    Student(String lname, String fname){
        super(lname, fname);
        degrees.add(new Degree());
        degrees.add(new Degree());
        degrees.add(new Degree());
        this.setId(super.getRandomId(1, 100));
    }

    int getId(){
        return id;
    }
    
    void setId(final int id){
    
        if(id > 0 && id <= 100){
            this.id = id;
        }
    }
    int getstartYear(){
        if(startYear == 0){
            startYear = 2023;
        }
        return startYear;
    }
    
    void setstartYear(final int startYear){
        if(startYear <= currentYear && startYear > 2000){
            this.startYear = startYear;
        }
    }
    
    int getGraduationYear(){
        return graduationYear;
    }
    
    String setGraduationYear(final int graduationYear){
          if(canGraduate() == false){
              return "Check amount of required credits";
          }
        
        if(graduationYear < startYear || graduationYear > currentYear) {
            return "Check graduation year";
        }
        else
        this.graduationYear = graduationYear;
        return "Ok";
    }
    
    public void setDegreeTitle(final int i, String dName){
        if(i >= 0 && i < degrees.size() && dName != null){
            degrees.get(i).setDegreeTitle(dName);
        }
    }
    
    public boolean addCourse(final int i, StudentCourse course){
        if(i >= 0 && i < degreeCount && course != null){
            if(degrees.get(i).addStudentCourse(course) != false){
                return true;
            }
        }
        return false;
    }
    
    public int addCourses(final int i, List<StudentCourse> courses){
        int count = 0;
        if (i >= 0 && i < degrees.size() && courses != null) {
            Degree degree = degrees.get(i);
            for (StudentCourse course : courses) {
                if (course != null && degree.addStudentCourse(course)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    
    public void printCourses(){
        for(int i = 0; i < degreeCount; i++){
            degrees.get(i).printCourses();
        }
    }
    
    public void printDegrees(){
        for(int i = 0; i < degreeCount; i++){
            System.out.println(degrees.get(i));
        }
    }
    
    public void setTitleOfThesis(final int i, String title){
        if(i >= 0 && i < degreeCount && title != null){
            degrees.get(i).setTitleOfThesis(title);
        }
    }
    
    boolean hasGraduated(){
        if(graduationYear == 0){
            return false;
        }  
        return graduationYear <= currentYear;
    }
    
      private boolean canGraduate(){
        if(degrees.get(0).getTitleOfThesis() !=  ConstantValues.NO_TITLE && degrees.get(1).getTitleOfThesis() != ConstantValues.NO_TITLE ){
            if(degrees.get(0).getCredits() >= ConstantValues.BACHELOR_CREDITS && degrees.get(1).getCredits() >= ConstantValues.MASTER_CREDITS){
                return true;
            }
        }
            return false;
      }
    
    int getStudyYears(){
    
        if(hasGraduated() != false){
            return graduationYear - startYear;
        }
        return currentYear - startYear;
    }

    String getIdString(){
        return "Student id: " + id;
    }

    String totalGPA(){
       return String.format("%.2f",((degrees.get(0).getGPA(2).get(0) + degrees.get(1).getGPA(2).get(0)) / ((degrees.get(0).getGPA(2).get(1) + degrees.get(1).getGPA(2).get(1)))));
    }

    public String toString(){

        String print = getIdString() + 
        "\nFirst name: " + getFirstName() + ", LastName: " + getLastName() +
        "\nDate of birth: " + getBirthDate();
        if(graduationYear != 0){
            print += "\nStatus: The student has graduated in " + getGraduationYear();
        }
        else{
            print += "\nStatus: The student has not graduated, yet";
        }
        print += "\nStart year: " + getstartYear() +" (studies have lasted for " + getStudyYears() +" years)"+
            "\nTotal credits: " + (degrees.get(0).getCredits() + degrees.get(1).getCredits()) + "GPA( = " + totalGPA() + ")" +
            "\nBachelor credits: " + degrees.get(0).getCredits();
        if(degrees.get(0).getCredits() > ConstantValues.BACHELOR_CREDITS){
            print += "\nTotal bachelor credits completed(" + degrees.get(0).getCredits() + "/180.0)";
        }
        else{
            print += "\nMissing bachelor's credits " + (180 - degrees.get(0).getCredits()) + "(" + degrees.get(0).getCredits() + "/180)";
        }
        print += "\nAll mandatory bachelor credits completed (" + degrees.get(0).getCreditsByType(1) + "/" + ConstantValues.BACHELOR_MANDATORY + ")" +
        "\nGPA of Bachelor studies: " + String.format("%.2f",degrees.get(0).getGPA(2).get(2)) +
        "\nTitle of BSc Thesis: \"" + degrees.get(0).getTitleOfThesis() + "\"" +
        "\nMaster credits: " + degrees.get(1).getCredits();

        if(degrees.get(1).getCredits() > ConstantValues.MASTER_CREDITS){
            print += "\nTotal master's credits completed(" + degrees.get(1).getCredits() + "/120.0)";
        }
        else{
            print += "\nMissing master's credits " + (120 - degrees.get(1).getCredits()) + "(" + degrees.get(1).getCredits() + "/120)";
        }
        print += "\nAll mandatory master credits completed (" + degrees.get(1).getCreditsByType(1) + "/" + ConstantValues.MASTER_MANDATORY + ")" +
        "\nGPA of Master studies: " + String.format("%.2f", degrees.get(1).getGPA(2).get(2)) +
        "\nTitle of MSc Thesis \"" + degrees.get(1).getTitleOfThesis() + "\"";

        return print;
    }
    
}

