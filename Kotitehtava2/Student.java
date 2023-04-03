

import java.util.Random;
import java.time.*;

public class Student {
    private int currentYear = Year.now().getValue();
    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;
    private int id;
    private int startYear = currentYear;
    private int graduationYear;
    private int degreeCount = 3;
    private Degree[] degrees;
    private String birthDate = ConstantValues.NO_BIRTHDATE;



//constructors

Student(){
    getRandomId();
    degrees = new Degree[3];
    degrees[0] = new Degree();
    degrees[1] = new Degree();
    degrees[2] = new Degree();
}

Student(String lname, String fname){
    if(lname != null || fname != null){
        degrees = new Degree[3];
        degrees[0] = new Degree();
        degrees[1] = new Degree();
        degrees[2] = new Degree();
        getRandomId();
        setFirstName(fname);
        setLastName(lname);
    }
}

//methods

String getFirstName(){
    return this.firstName;
    
}

void setFirstName(String firstName){
    if(firstName != null){
        this.firstName = firstName;
    }
}

String getLastName(){
    return this.lastName;
}

void setLastName(String lastName){
    if(lastName != null){
    this.lastName = lastName;
    }
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
    if(i >= 0 && i < degreeCount && dName != null){
        degrees[i].setDegreeTitle(dName);
    }
}

public boolean addCourse(final int i, StudentCourse course){
    if(i >= 0 && i < degreeCount && course != null){
        if(degrees[i].addStudentCourse(course) != false){
            return true;
        }
    }
    return false;
}

public int addCourses(final int i, StudentCourse[] courses){
    int addedCourses = degrees[i].count;
    if(i >= 0 && i < degreeCount && courses != null){
        degrees[i].addStudentCourses(courses);
    }
    return degrees[i].count - addedCourses;
}

public void printCourses(){
    for(int i = 0; i < degreeCount; i++){
        degrees[i].printCourses();
    }
}

public void printDegrees(){
    for(int i = 0; i < degreeCount; i++){
        System.out.println(degrees[i]);
    }
}

public void setTitleOfThesis(final int i, String title){
    if(i >= 0 && i < degreeCount && title != null){
        degrees[i].setTitleOfThesis(title);
    }
}

public String getBirthDate(){
    return birthDate;
}

public String setBirthDate(String personId){
if(personId == null){
    return "No change";
}
    PersonID testi = new PersonID();

    if(testi.setPersonID(personId) == "Ok"){

        String yearString =  personId.substring(4,6);
        String monthString = personId.substring(2,4);
        String dayString = personId.substring(0,2);
        char seven = personId.charAt(6);

        if(seven == '+'){
            birthDate = dayString + "." + monthString + ".18" + yearString;
            return birthDate;
        }
        if(seven == '-'){
            birthDate = dayString + "." + monthString + ".19" + yearString;
            return birthDate;
        }
        if(seven == 'A'){
            birthDate = dayString + "." + monthString + ".20" + yearString;
            return birthDate;
        }
    }
    return "No change";

}

boolean hasGraduated(){
    if(graduationYear == 0){
        return false;
    }  
    return graduationYear <= currentYear;
}

  private boolean canGraduate(){
    if(degrees[0].getTitleOfThesis() !=  ConstantValues.NO_TITLE && degrees[1].getTitleOfThesis() != ConstantValues.NO_TITLE ){
        if(degrees[0].getCredits() >= ConstantValues.BACHELOR_CREDITS && degrees[1].getCredits() >= ConstantValues.MASTER_CREDITS){
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

private int getRandomId(){
    Random random = new Random();
    this.id = random.nextInt(100) + 1;
    return this.id;
}

public String toString(){
    double total = degrees[0].getCredits() + degrees[1].getCredits();
    double missingBach = 180 - degrees[0].getCredits();
    double missingMast = 120 - degrees[1].getCredits();


    if(hasGraduated()){
        return
        "Student id: "+ getId() +
        "\nFirst name: " + getFirstName() + ", LastName: " + getLastName() +
        "\nDate of birth: " + getBirthDate() + 
        "\nStatus: The student has graduated in " + getGraduationYear() +
        "\nStart year: " + getstartYear() +" (studies have lasted for " + getStudyYears() +" years)"+
        "\nTotal credits: " + total +
        "\nBachelor credits: " + degrees[0].getCredits() +
        "\nTotal bachelor credits completed(" + degrees[0].getCredits() + "/180.0)" +
        "\nTitle of BSc thesis: " + degrees[0].getTitleOfThesis() +
        "\nMaster credits: " + degrees[1].getCredits() +
        "\nTotal master's credits completed (" + degrees[1].getCredits() + "/120.0)" +
        "\nTitle of MSc thesis: " + degrees[1].getTitleOfThesis() + "\n\n";
    }

    if(missingBach > 0 && missingMast > 0){
        return
        "Student id: "+ getId() +
        "\nFirstName: " + getFirstName() + ", LastName: " + getLastName() +
        "\nDate of birth: " + getBirthDate() + 
        "\nStatus: The student has not graduated, yet" + 
        "\nStartYear: " + getstartYear() +" (studies have lasted for " + getStudyYears() +" years)"+
        "\nTotal credits: " + total +
        "\nBachelor credits: " + degrees[0].getCredits() +
        "\nMissing bachelor's credits " + missingBach +" "+ degrees[0].getCredits()+"/180" +
        "\nTitle Of Bachelor Thesis: " + degrees[0].getTitleOfThesis() +
        "\nMaster Credits: " + degrees[1].getCredits() +
        "\nMissing master's credits " + missingMast +" "+ degrees[1].getCredits()+ "/120" +
        "\nTitleOfMastersThesis: " + degrees[1].getTitleOfThesis() + "\n\n";
    }
    if(missingBach > 0 && missingMast <= 0){
        return
        "Student id: "+ getId() +
        "\nFirstName: " + getFirstName() + ", LastName: " + getLastName() +
        "\nDate of birth: " + getBirthDate() + 
        "\nStatus: The student has not graduated, yet" + 
        "\nStartYear: " + getstartYear() +" (studies have lasted for " + getStudyYears() +" years)"+
        "\nTotal credits: " + total +
        "\nBachelor credits: " + degrees[0].getCredits() +
        "\nMissing bachelor's credits " + missingBach +" "+ degrees[0].getCredits() + "/180" +
        "\nTitle Of BachelorThesis: " + degrees[0].getTitleOfThesis() +
        "\nMasterCredits: " + degrees[1].getCredits() +
        "\nTotal master's credits completed (" + degrees[1].getCredits() + "/120.0)" +
        "\nTitleOfMastersThesis: " + degrees[1].getTitleOfThesis() + "\n\n";
    }else return
        "Student id: "+ getId() +
        "\nFirstName: " + getFirstName() + ", LastName: " + getLastName() +
        "\nDate of birth: " + getBirthDate() + 
        "\nStatus: The student has not graduated, yet" + 
        "\nStartYear: " + getstartYear() +" (studies have lasted for " + getStudyYears() +" years)"+
        "\nTotal credits: " + total +
        "\nBachelor Credits: " + degrees[0].getCredits() + "/180" +
        "\nTitle Of BachelorThesis: " + degrees[0].getTitleOfThesis() +
        "\nMasterCredits: " + degrees[1].getCredits() +
        "\nMissing master's credits " + missingMast + degrees[1].getCredits() + "/120" +
        "\nTitleOfMastersThesis: " + degrees[1].getTitleOfThesis() + "\n\n";
    
}
}



