import java.util.Scanner;
public class StudentDBApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StudentDatabase.students = new Student[2];
        System.out.println("Enter 1 student data: ");
        StudentDatabase.addStudent(in.nextLine(), in.nextLine(), in.nextInt());
        in.nextLine();
        System.out.println("Enter 2 student data: ");
        StudentDatabase.addStudent(in.nextLine(), in.nextLine(), in.nextInt());
        in.nextLine();
        //System.out.println("Enter 3 student data: ");
        //StudentDatabase.addStudent(in.nextLine(), in.nextLine(), in.nextInt());
        //in.nextLine();
       
          
        //HW1: modify the scanning code so it accepts more then 1 word;
         
        //System.out.println(StudentDatabase.students[0]);

        StudentDatabase.printAllStudents();



    }
}

class StudentDatabase{
    public static Student [] students;
    static short lastIndex = 0;

    public static void addStudent(String fullName, String groupName, int generalGrade){
        //HW3: make sure no exceptions apear here; 
            students[lastIndex]= new Student( fullName, groupName, generalGrade);
            lastIndex++;  
        
    }

    public static void printAllStudents(){
        System.out.println("\n\n STUDENT LIST: ");
        //HW2: dont print null values
        for (Student student  : StudentDatabase.students) {
            if (student != null){
                System.out.println(student);
            }
           
        }
    }

}
class Student{
    private String fullName;
    private String groupName;
    private int generalGrade;
    
    public Student(String fullName, String groupName, int generalGrade) {
        this.fullName = fullName;
        this.groupName = groupName;
        this.generalGrade = generalGrade;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getGeneralGrade() {
        return generalGrade;
    }

    public void setGeneralGrade( int generalGrade) {
        this.generalGrade = generalGrade;
    }

    @Override
    public String toString() {
        return "Student [  fullName= " + fullName + ", groupName= " + groupName + ", generalGrade= " + generalGrade + "  ]";
    }

    

    

    
}