
public class PersonID {
    
    public String birthDate = ConstantValues.NO_BIRTHDATE;


    public String getBirthDate(){
        return birthDate;
    }
    
    public String setPersonID(final String personId){
        if(checkPersonIDNumber(personId) == false){
            return ConstantValues.INVALID_BIRTHDAY;
        }
        
        if(checkValidCharacter(personId) == false){
            return ConstantValues.INCORRECT_CHECKMARK;
        }

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
        if(seven == 'A'){
            birthDate = dayString + "." + monthString + ".20" + yearString;
        }

        if(checkBirthdate(birthDate) == false){
            return ConstantValues.INVALID_BIRTHDAY;
        }

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

private boolean checkBirthdate(String birthDate){
    if(birthDate.length() != 10){
        return false;
    }
    String yearString =  birthDate.substring(6,10);
    String monthString = birthDate.substring(3,5);
    String dayString = birthDate.substring(0,2);

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
            if(day < 1 || day > 29){
                return false;
            } 
        }
        else if(day < 1 || day > 28){
            return false;
        }
        break;
    }
    return true;
}

}
