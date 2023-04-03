import java.util.Random;
import java.time.*;

public class Student {

//attributes
    int currentYear = Year.now().getValue();
    String firstName = ConstantValues.NO_NAME;
    String lastName = ConstantValues.NO_NAME;
    int id;
    double bachelorCredits;
    double masterCredits;
    String titleOfMastersThesis = ConstantValues.NO_TITLE;
    String titleOfBachelorThesis = ConstantValues.NO_TITLE;
    int startYear = currentYear;
    int graduationYear;
    String birthDate = ConstantValues.NO_BIRTHDATE;
    String missingBachelorStr;
    String missingMasterStr;
    

//constructors

    Student(){
        getRandomId();
    }

    Student(String lname, String fname){
        getRandomId();
        firstName = fname;
        lastName = lname;
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

        if(id > 0 && id < 100){
            this.id = id;
        }
    }

    double getBachelorCredits(){
        return bachelorCredits;
    }

    void setBachelorCredits(final double bachelorCredits){
        if(bachelorCredits >= 0.0 && bachelorCredits <= 300.0){
            this.bachelorCredits = bachelorCredits;
            setMissingBachelor(bachelorCredits);
        }
    }

    double getMasterCredits(){
        return masterCredits;
    }

    void setMasterCredits(final double masterCredits){
        if(masterCredits >= 0.0 && masterCredits <= 300.0){
            this.masterCredits = masterCredits;
            setMissingMasters(masterCredits);
        }
    }

    String getTitleOfMastersThesis(){
        return titleOfMastersThesis;
    }

    void setTitleOfMastersThesis(String title){
        if(title != null){
            this.titleOfMastersThesis = title;
        }
    }

    String getTitleOfBachelorThesis(){
        return titleOfBachelorThesis;
    }

    void setTitleOfBachelorThesis(String title){
        if(title != null){
            this.titleOfBachelorThesis = title;
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
        if (canGraduate() == false){
            return "Check the required studies";
        }
        
        if (graduationYear < startYear || graduationYear > currentYear) {
            return "Check graduation year";
        }
        else
        this.graduationYear = graduationYear;
        return "Ok";
    }


    boolean hasGraduated(){
        if(graduationYear == 0){
            return false;
        }  
        return graduationYear <= currentYear;
    }

    private boolean canGraduate(){
        if(getTitleOfBachelorThesis() != ConstantValues.NO_TITLE && getTitleOfMastersThesis() != ConstantValues.NO_TITLE){
            return (bachelorCredits >= 180 && masterCredits >= 120);
        }
        else return false;
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

    String status(){
        if(hasGraduated() != false){
            return "Status: The student has graduated in " + graduationYear;
        }
        return "The student has not graduated, yet.";
    }


    String setPersonId(final String personId){
        if(checkPersonIDNumber(personId) == false){
            return ConstantValues.INVALID_BIRTHDAY;
        }

        if(checkBirthdate(personId) == false){
            return ConstantValues.INVALID_BIRTHDAY;
        }

        if(checkValidCharacter(personId) == false){
            return ConstantValues.INCORRECT_CHECKMARK;
        }
      
        setBirthDay(personId);
        return  "Ok";

    }
    private boolean checkPersonIDNumber(final String personId){
        char seven = personId.charAt(6);
        if(personId.length() != 11 ){
            return false;
        }
        if(seven != 'A' && seven != '-' && seven != '+'){
            return false;
        }
        return true;
    }
    

    private boolean checkLeapYear(int year){
        if (year % 4 == 0) {
        if (year % 100 == 0){
        if (year % 400 == 0){
            return true;
    }
        else{
            return false;
            }
            }

            else{
            return true;
            }
        }   else{
            return false;
        }

        
    }

    private boolean checkValidCharacter(final String personID){
        int x = 0;
        String cleanPersonId = personID.substring(0, 6) + personID.substring(7, personID.length() - 1);
        double dPersonId = Double.parseDouble(cleanPersonId);
        char lastChar = personID.charAt(personID.length() - 1);
        double modulo = dPersonId % 31;
        int i =(int)Math.round(modulo);

        
        switch(i){
            case 0:
                if(lastChar == '0'){
                    x= 1;
                }
        break;
            case 1:
            if(lastChar == '1'){
                x= 1;
            }
        break;
            case 2:
            if(lastChar == '2'){
                x= 1;
            }
        break;
            case 3:
            if(lastChar == '3'){
                x= 1;
            }
        break;
            case 4:
            if(lastChar == '4'){
                x= 1;
            }
        break;
            case 5:
            if(lastChar == '5'){
                x= 1;
            }
        break;
            case 6:
            if(lastChar == '6'){
                x= 1;
            }
        break;
            case 7:
            if(lastChar == '7'){
                x= 1;
            }
        break;
            case 8:
            if(lastChar == '8'){
                x= 1;
            }
        break;
            case 9:
            if(lastChar == '9'){
                x= 1;
            }
        break;
            case 10:
            if(lastChar == 'A'){
                x= 1;
            }
        break;
            case 11:
            if(lastChar == 'B'){
                x= 1;
            }
        break;
            case 12:
            if(lastChar == 'C'){
                x= 1;
            }
        break;
            case 13:
            if(lastChar == 'D'){
                x= 1;
            }
        break;
            case 14:
            if(lastChar == 'E'){
                x= 1;
            }
        break;
            case 15:
            if(lastChar == 'F'){
                x= 1;
            }
        break;
            case 16:
            if(lastChar == 'H'){
                x= 1;
            }
        break;
            case 17:
            if(lastChar == 'J'){
                x= 1;
            }
        break;
            case 18:
            if(lastChar == 'K'){
                x= 1;
            }
        break;
            case 19:
            if(lastChar == 'L'){
                x= 1;
            }
        break;
            case 20:
            if(lastChar == 'M'){
                x= 1;
            }
        break;
            case 21:
            if(lastChar == 'N'){
                x= 1;
            }
        break;
            case 22:
            if(lastChar == 'P'){
                x= 1;
            }
        break;
            case 23:
            if(lastChar == 'R'){
                x= 1;
            }
        break;
            case 24:
            if(lastChar == 'S'){
                x= 1;
            }
        break;
            case 25:
            if(lastChar == 'T'){
                x= 1;
            }
        break;
            case 26:
            if(lastChar == 'U'){
                x= 1;
            }
        break;
            case 27:
            if(lastChar == 'V'){
                x= 1;
            }
        break;
            case 28:
            if(lastChar == 'W'){
                x= 1;
            }
        break;
            case 29:
            if(lastChar == 'X'){
                x= 1;
            }
        break;
            case 30:
            if(lastChar == 'Y'){
                x= 1;
            }
        break;
        }

       if(x == 1){
        return true;
       }else return false;
    }

    private boolean checkBirthdate(final String personId){
        String yearString =  personId.substring(4,6);
        String monthString = personId.substring(2,4);
        String dayString = personId.substring(0,2);

        int year = Integer.parseInt(yearString);
        int month = Integer.parseInt(monthString);
        int day = Integer.parseInt(dayString);
        if(year < 0){
            return false;
        }
        if(month < 1 || month > 12){
            return false;
        }
        switch (month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                if(day < 1 || day > 31){
                    return false;
                }
            break;

            case 4:
            case 6:
            case 9:
            case 11:
                if(day < 1 || day > 30){
                    return false;
                }
            break;

            case 2:
            if(checkLeapYear(year) == true){
                if(day < 1 && day > 28){
                    return false;
                } 
            }
            else if(day < 1 || day > 29){
                return false;
            }
            break;
        }
            return true;
    }
public void setBirthDay(String personId){

    String yearString =  personId.substring(4,6);
    String monthString = personId.substring(2,4);
    String dayString = personId.substring(0,2);
    char seven = personId.charAt(6);
    if(seven == '+'){
        birthDate = dayString + "." + monthString + ".18" + yearString;
    }
    if(seven == '-'){
        birthDate = dayString + "." + monthString + ".19" + yearString;
    }
    if(seven == '-'){
        birthDate = dayString + "." + monthString + ".20" + yearString;
    }
}

public String getBirthDay(){
    return birthDate;
}

void setMissingBachelor(double bachelorCredits){
    double missingBachelor = 180 - bachelorCredits;
    if(bachelorCredits < 180){
         missingBachelorStr = " ==> Missing bachelor credits " + missingBachelor + " (" + bachelorCredits + "/180.0)";
    }
    else missingBachelorStr = " ==> All required bachelor credits completed" + " (" + bachelorCredits + "/120.0)";

}
void setMissingMasters(double masterCredits){
    double missingMasters = 120 - masterCredits;
    if(masterCredits < 120){
        missingMasterStr = " ==> Missing bachelor credits " + missingMasters + " (" + masterCredits + "/180.0)";
    }
    missingMasterStr = " ==> All required bachelor credits completed" + " (" + masterCredits + "/120.0)";

}
public String getMissingBachelor(){
    if(bachelorCredits != 0){
    return missingBachelorStr;
    }else return ConstantValues.NO_CREDITS;
}
public String getMissingMasters(){
    if(masterCredits != 0){
    return missingMasterStr;
    }else return ConstantValues.NO_CREDITS;
}


public String toString(){
    return "Student id: "+ getId() +
        "\nFirstName: " + getFirstName() + ", LastName: " + getLastName() +
        "\nDate of birth: " + getBirthDay() + 
        "\nStatus: " + status() +
        "\nStartYear: " + getstartYear() +" (studies have lasted for " + getStudyYears() +" years)"+
        "\nBachelorCredits: " + getBachelorCredits() + getMissingBachelor() +
        "\nTitleOfBachelorThesis: " + getTitleOfBachelorThesis() +
        "\nMasterCredits: " + getMasterCredits() + getMissingMasters() +
        "\nTitleOfMastersThesis: " + getTitleOfMastersThesis() + "\n\n";
}
}

