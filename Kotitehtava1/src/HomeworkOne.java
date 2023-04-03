
public class HomeworkOne {
    public static void main(String[] args) throws Exception {
    
        Student testi = new Student();
        Student testi2 = new Student("Mouse", "Mickey");
        Student testi3 = new Student("Mouse", "Minnie");

        testi.setFirstName("Donald");
        testi.setLastName("Duck");
        testi.setBachelorCredits(120);
        testi.setMasterCredits(180);
        testi.setTitleOfMastersThesis("Masters thesis title");
        testi.setTitleOfBachelorThesis("Bachelor thesis title");
        testi.setstartYear(2001);
        testi.setGraduationYear(2020);

        testi2.setPersonId("221199-123A");
        testi2.setTitleOfBachelorThesis("A new exciting purpose of life");
        testi2.setBachelorCredits(65);
        testi2.setMasterCredits(22);
        
        testi3.setPersonId("111111-333J");
        testi3.setBachelorCredits(215);
        testi3.setMasterCredits(120);
        testi3.setTitleOfMastersThesis("Christmas - The most wonderful time of the year");
        testi3.setTitleOfBachelorThesis("Dreaming of a white Christmas");
        testi3.setstartYear(2018);
        testi3.setGraduationYear(2022);
        

        System.out.println(testi);
        System.out.println(testi2);
        System.out.println(testi3);


        System.out.println(testi.setPersonId("This is a string"));
        System.out.println(testi.setPersonId("320187-1234"));
        System.out.println(testi.setPersonId("11111111-3334"));
        System.out.println(testi.setPersonId("121298-830A"));






    }
    
}

