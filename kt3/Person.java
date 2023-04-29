
public abstract class Person {
    private String firstName = ConstantValues.NO_NAME;
    private String lastName = ConstantValues.NO_NAME;
    private String birthDate = ConstantValues.NOT_AVAILABLE;

    Person(String lname, String fname){
        if(fname != null){
            setFirstName(fname);
        }
        if(lname != null){
            setLastName(lname);
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName != null){
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName != null){
            this.lastName = lastName;
        }
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String setBirthDate(String personId) {
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

    protected int getRandomId(final int min, final int max){
    int range = max - min + 1;
    
    int randomId = (int) (Math.random() * range) + min;
    
    return randomId;
    
    }

    abstract String getIdString();

}


