import java.util.Scanner;
public class StudentDBApp {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StudentDatabase.students = new Student[4];
        int option;

        //while (true) {
        //    option= ConsoleUI.printMenu();
        //    if (option ==1){
        //         StudentDatabase.printAllStudents();
        //    }else if(option ==2 ){
        //        System.out.println("Enter student's data: ");
        //        StudentDatabase.addStudent(in.nextLine(), in.nextLine(), in.nextInt());
        //        in.nextLine();
        //    }else if(option == 3){
        //        System.out.print("Chose the student you wont to delete: ");
        //        StudentDatabase.deleteStudent(in.nextInt());

        //    }else if(option ==4){
        //       System.out.println("Enter new student data: ");
        //       StudentDatabase.updateStudentdata(in.nextInt(), in.nextLine(), in.nextLine(), in.nextInt());
        //    };
        //    
        //}


        while (true){
        option= ConsoleUI.printMenu();
            switch (option ) {
                case 1:
                   StudentDatabase.printAllStudents();
                    break;
                case 2 :
                    System.out.print("Enter student's data: ");
                    StudentDatabase.addStudent(in.nextLine(), in.nextLine(), in.nextInt());
                    in.nextLine();
                    break;
                case 3:
                    System.out.print("Chose the student you wont to delete: ");
                    StudentDatabase.deleteStudent(in.nextInt());
                    break;
            
                case 4 :
                    System.out.println("Enter new student data: ");
                    StudentDatabase.updateStudentdata(in.nextInt(), in.nextLine(), in.nextLine(), in.nextInt());
                    break;
                default:
                    break;
           }
        }



        //System.out.println("Enter 1 student data: ");
       //StudentDatabase.addStudent(in.nextLine(), in.nextLine(), in.nextInt());
        //in.nextLine();
        //System.out.println("Enter 2 student data: ");
        //StudentDatabase.addStudent(in.nextLine(), in.nextLine(), in.nextInt());
        //in.nextLine();
        //System.out.println("Enter 3 student data: ");
        //StudentDatabase.addStudent(in.nextLine(), in.nextLine(), in.nextInt());
        //in.nextLine();
       
     
       
          
        //HW1: modify the scanning code so it accepts more then 1 word;
         
        //System.out.println(StudentDatabase.students[0]);

        //StudentDatabase.printAllStudents();
        //StudentDatabase.updateStudentdata(0, "Tinica Maria", "bIOLOGY", 12);
        //StudentDatabase.printAllStudents();
        //StudentDatabase.deleteStudent(0);
        //StudentDatabase.printAllStudents();



    }
}

class ConsoleUI{
    public static int printMenu(){
        System.out.println("MENU ");
        System.out.println("1 To view students list \n2. To add student's data \n3. To delete a student data \n4. To change student data .");
        System.out.print(">>");
        Scanner in  = new Scanner(System.in);
        int option  = in.nextInt();
        return option;
    };

}

class StudentDatabase{
    public static Student [] students;
    static short lastIndex = 0;

    public static void addStudent(String fullName, String groupName, int generalGrade){
        //HW3: make sure no exceptions apear here; 
        Student[] newStudents = new Student[students.length + 1];
        for (int i = 0; i < students.length; i++) {
            newStudents[i] = students[i];
        }
        newStudents[lastIndex] = new Student(fullName, groupName, generalGrade);
        lastIndex++;
        students = newStudents;

        
        
            
    }

    public static void printAllStudents(){
        System.out.println("\n\n STUDENT LIST: ");
        //HW2: dont print null values
        for (Student student  : StudentDatabase.students) {
            if (student != null){
                System.out.println(student);
            }else {
                System.out.println("This field is empty !!!");
            }
           
        }
    }

    public static void updateStudentdata(int index,String fullName, String groupName, int generalGrade ){
       students[index].setFullName(fullName);
       students[index].setGroupName(groupName);
       students[index].setGeneralGrade(generalGrade);

    }

    public static void updateStudentname(int index,String fullName){
       students[index].setFullName(fullName);
       

    }

    public static void updateStudentGrade(int index, int generalGrade ){
       students[index].setGeneralGrade(generalGrade);

    }

    public static void updateStudentCredentials(int index, String groupName, int generalGrade ){
       students[index].setGroupName(groupName);
       students[index].setGeneralGrade(generalGrade);

    }



    public static void deleteStudent(int index){
        // make this if more compact
        Student[] newStudents = new Student[students.length-1];
        for (int i = 0, j = 0; i < students.length; i++ ) {
            if (i != index){
                newStudents[j++] = students[i];
            }   
            
        }
        students = newStudents;
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
