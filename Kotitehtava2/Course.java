
public class Course {
   private String name = ConstantValues.NO_NAME;
   private String courseCode;
   private Character courseBase;
   private int courseType;
   private int period;
   private double credits;
   private boolean numericGrade; 


    Course(){ 
    }

    Course(String name, final int code, Character courseBase, final int type, final int period, final double credits, boolean numericGrade){
    setName(name);
    setCourseCode(code, courseBase);
    setCourseType(type);
    setPeriod(period);
    setCredits(credits);
    setNumericGrade(numericGrade);
    }

    Course(Course course){
        name = course.getName();
        courseCode = course.getCourseCode();
        courseBase = course.getCourseBase();
        courseType = course.getCourseType();
        period = course.getPeriod();
        credits = course.getCredits();
        numericGrade = course.isNumericGrade();
    }


    public String getName(){
        return name;
    }

    public void setName(String name){
        if(name != null && name != ""){
            this.name = name;
        }
    }

    public String getCourseTypeString(){
        if(courseType == 0){
            return "Optional";
        }
        else{
            return "Mandatory";
        }
    }

    public int getCourseType(){
        return courseType;
    }

    public void setCourseType(final int type){
        if(type == 1 || type == 0){
            courseType = type;
        }
    }

    public String getCourseCode(){
        return courseCode;
    }

    public void setCourseCode(final int courseCode, Character courseBase){
        if(0 < courseCode && courseCode < 1000000){
            if(courseBase == 'A' || courseBase == 'P' || courseBase == 'S'){
                
                String cCode = "" + courseCode;
                cCode = cCode + courseBase;
                this.courseCode = cCode;
                this.courseBase = courseBase;
            }
        }
    }

    public Character getCourseBase(){
        return courseBase;
    }

    public int getPeriod(){
        return period;
    }

    public void setPeriod(final int period){
        if(period >= ConstantValues.MIN_PERIOD && period <= ConstantValues.MAX_PERIOD){
            this.period = period;
        }
    }

    public double getCredits(){
       return credits;
    }

    private void setCredits(final double credits){
        if(credits >= ConstantValues.MIN_CREDITS && credits <= ConstantValues.MAX_COURSE_CREDITS){
           this.credits = credits;
        }
    }

    public boolean isNumericGrade(){
        return numericGrade;
    }

    public void setNumericGrade(boolean numericGrade){
        this.numericGrade = numericGrade;
    }
    
    public String toString(){
        return "["+  getCourseCode() +" ("+ String.format("%.2f", credits) +" cr), \""+ getName() +"\". "+ getCourseTypeString() +", period: "+ getPeriod()+".]";
    }

}

