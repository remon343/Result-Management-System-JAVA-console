
import java.util.InputMismatchException;
import java.util.Scanner;


/*********Admin class to perform all tasks*************/

class Admin{
    String Sname,Susername,Spassword;
    int Sid, Fid;
    String Fname,Fusername,Fpassword,Fsubject;
    float nepali,math,physics,chemistry,biology,english;
    public void getStudent(int id,String name, String username, String password){
        this.Sid = id;
        this.Sname = name;
        this.Susername = username;
        this.Spassword = password;
    }
    public void getFacilitator(int id,String name, String username,String password,String subject){
        this.Fid = id;
        this.Fname = name;
        this.Fusername = username;
        this.Fpassword = password;
        this.Fsubject = subject;
    }

    public void getMarks(float nepali, float math, float physics, float chemistry,float biology, float english){
        this.nepali = nepali;
        this.math = math;
        this.physics = physics;
        this.chemistry = chemistry;
        this.biology = biology;
        this.english = english;
    }
    public void viewStudent(){
        System.out.println("id:"+Sid+" name:"+Sname+" username:"+Susername+" password:"+Spassword);
    }
    public void viewFacilitator(){
        System.out.println("id:"+Fid+" name:"+Fname+" username:"+Fusername+" password:"+Fpassword+" subject:"+Fsubject);
    }
    public void viewMarks(){
        System.out.println("Student Name: "+Sname+"Marks: nepali: "+nepali+" math:"+math+" physics:"+physics+" chemistry:"+chemistry+" biology:"+biology+" english:"+english+" total marks: "+(nepali+math+physics+chemistry+biology+english)+" percentage:"+(nepali+math+physics+chemistry+biology+english)/6);
    }

}


/*********Facilitator class to perform all tasks while properties are inherited from parent class*************/

class Facilitator extends Admin{
    Student s = new Student();
    public void viewStudent(int Sid, String Sname,String Susername,String Spassword){
        System.out.println("id:"+Sid+" name:"+Sname+" username:"+Susername+" password:"+Spassword);
    }
    public void viewFacilitator(int Fid,String Fname,String Fusername, String Fpassword,String Fsubject){
        System.out.println("id:"+Fid+" name:"+Fname+" username:"+Fusername+" password:"+Fpassword+" subject:"+Fsubject);
    }

    public void viewMarks(String Sname, float nepali, float math, float physics, float chemistry, float biology, float english){

        System.out.println("Student Name: "+Sname+"Marks: nepali: "+nepali+" math:"+math+" physics:"+physics+" chemistry:"+chemistry+" biology:"+biology+" english:"+english+" total marks: "+(nepali+math+physics+chemistry+biology+english)+" percentage:"+(nepali+math+physics+chemistry+biology+english)/6);
    }
}


/*********Student class to perform all tasks while properties are inherited from parent class*************/


class Student extends Admin{
    public void viewStudent(int Sid,String Sname,String Susername,String Spassword){
        System.out.println("id:"+Sid+" name:"+Sname+" username:"+Susername+" password:"+Spassword);
    }
    public void viewFacilitator(int Fid, String Fname, String Fusername, String Fpassword, String Fsubject){
        System.out.println("id:"+Fid+" name:"+Fname+" username:"+Fusername+" password:"+Fpassword+" subject:"+Fsubject);
    }
    public void viewMarks(String Sname, float nepali, float math, float physics, float chemistry, float biology, float english){
        System.out.println("Student Name: "+Sname+"Marks: nepali: "+nepali+" math:"+math+" physics:"+physics+" chemistry:"+chemistry+" biology:"+biology+" english:"+english+" total marks: "+(nepali+math+physics+chemistry+biology+english)+" percentage:"+(nepali+math+physics+chemistry+biology+english)/6);
    }
}


/*********Main class here to perform all the tasks*************/
public class Main {

    static Admin  ad = new Admin();
    static Facilitator f= new Facilitator();
    static Student s = new Student();

    /*********Menu to show admin*************/
    public static void AdminMenu() {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1.Add Student.\n2.Add Facilitator\n3.Add Marks\n4.View Student\n5.View Facilitator\n6.View Marks\n7.Log Out");
        int choice = 0;
        try {
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e);
            AdminMenu();
        }

        switch (choice) {
            case 1:
                try{
                System.out.println("Enter the student id :");
                s.Sid = sc.nextInt();
                } catch(InputMismatchException e){
                    System.out.println(e);
                    AdminMenu();
                }
                System.out.println("Enter the student name : ");
                s.Sname = sc.next();
                System.out.println("Enter the student username : ");
                s.Susername = sc.next();
                System.out.println("Enter the student password:");
                s.Spassword = sc.next();

                ad.getStudent(s.Sid, s.Sname, s.Susername, s.Spassword);
                m.AdminMenu();
                break;
            case 2:
                try {
                    System.out.println("Enter the facilitator id :");
                    f.Fid = sc.nextInt();
                }catch(InputMismatchException e){
                    System.out.println(e);
                    AdminMenu();
                }
                System.out.println("Enter the facilitator name :");
                f.Fname = sc.next();
                System.out.println("Enter the facilitator username : ");
                f.Fusername = sc.next();
                System.out.println("Enter the facilitator password : ");
                f.Fpassword = sc.next();
                System.out.println("Enter the subject name : ");
                f.Fsubject = sc.next();
                ad.getFacilitator(f.Fid, f.Fname, f.Fusername, f.Fpassword, f.Fsubject);
                m.AdminMenu();
                break;
            case 3:
                try {
                    System.out.println("Enter the Nepali Marks : ");
                    s.nepali = sc.nextFloat();
                    System.out.println("Enter the Math Marks : ");
                    s.math = sc.nextFloat();
                    System.out.println("Enter the Physics Marks : ");
                    s.physics = sc.nextFloat();
                    System.out.println("Enter the chemistry Marks : ");
                    s.chemistry = sc.nextFloat();
                    System.out.println("Enter the biology Marks : ");
                    s.biology = sc.nextFloat();
                    System.out.println("Enter the English Marks : ");
                    s.english = sc.nextFloat();
                }catch (InputMismatchException e){
                    System.out.println(e);
                    AdminMenu();
                }

                ad.getMarks(s.nepali, s.math, s.physics, s.chemistry, s.biology, s.english);
                System.out.println("Want to return menu.y or n?");
                String retMenu = sc.next();
                if (retMenu.equals("y")) {
                    m.AdminMenu();
                } else {
                    m.mainMenu();
                }
                break;

            case 4:
                ad.viewStudent();
                System.out.println("Want to return menu.y or n?");
                String retMenu1 = sc.next();
                if (retMenu1.equals("y")) {
                    m.AdminMenu();
                } else {
                    m.mainMenu();
                }
                break;
            case 5:
                ad.viewFacilitator();
                System.out.println("Want to return menu.y or n?");
                String retMenu2 = sc.next();
                if (retMenu2.equals("y")) {
                    m.AdminMenu();
                } else {
                    m.mainMenu();
                }
                break;
            case 6:
                ad.viewMarks();
                System.out.println("Do you want to return ? y or n ");
                String retChoice = sc.next();
                if (retChoice.equals("y")) {
                    m.AdminMenu();
                } else {
                    m.mainMenu();
                }
                break;
            case 7:
                m.mainMenu();
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    /*********Menu to show Facilitator*************/
    public static void FacilitatorMenu() {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1.Add Marks\n2.View Student\n3.View Facilitator\n4.View Marks\n5.Log Out");
        int choice = 0;
        try {
            System.out.println("Enter you choice : ");

            choice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e);
            FacilitatorMenu();
        }

        switch (choice) {
            case 1:
                if (f.Fsubject.equals("nepali")) {
                    System.out.println("Enter Your Subject Nepali Marks:");
                    s.nepali = sc.nextFloat();
                } else if (f.Fsubject.equals("math")) {
                    System.out.println("Enter Your Subject Math Marks:");
                    s.math = sc.nextFloat();
                } else if (f.Fsubject.equals("physics")) {
                    System.out.println("Enter Your Subject Physics Marks:");
                    s.biology = sc.nextFloat();
                } else if (f.Fsubject.equals("chemistry")) {
                    System.out.println("Enter Your Subject Chemistry Marks:");
                    s.chemistry = sc.nextFloat();
                } else if (f.Fsubject.equals("biology")) {
                    System.out.println("Enter Your Subject Biology Marks:");
                    s.biology = sc.nextFloat();
                } else if (f.Fsubject.equals("english")) {
                    System.out.println("Enter Your Subject English Marks:");
                    s.english = sc.nextFloat();
                } else {
                    System.out.println("Subject does not match...");
                }
                System.out.println("Do you want to return ? y or n ");
                String retChoice = sc.next();
                if (retChoice.equals("y")) {
                    m.FacilitatorMenu();
                } else {
                    System.out.println("Remain here...");
                }
                break;
            case 2:
                System.out.println(s.Sid);
                f.viewStudent(s.Sid, s.Sname, s.Susername, s.Spassword);
                System.out.println("Do you want to return ? y or n ");
                String retChoice0 = sc.next();
                if (retChoice0.equals("y")) {
                    m.FacilitatorMenu();
                } else {
                    m.mainMenu();
                }
                break;
            case 3:
                f.viewFacilitator(f.Fid, f.Fname, f.Fusername, f.Fpassword, f.Fsubject);
                System.out.println("Do you want to return ? y or n ");
                String retChoice1 = sc.next();
                if (retChoice1.equals("y")) {
                    m.FacilitatorMenu();
                } else {
                    m.mainMenu();
                }
                break;
            case 4:
                f.viewMarks(s.Sname, s.nepali, s.math, s.physics, s.chemistry, s.biology, s.english);
                System.out.println("Do you want to return ? y or n ");
                String retChoice2 = sc.next();
                if (retChoice2.equals("y")) {
                    m.FacilitatorMenu();
                } else {
                    m.mainMenu();
                }
                break;
            case 5:
                m.mainMenu();
                break;
            default:
                System.out.println("Invalid choice.");

        }

    }

    /*********Menu to show Student*************/
    public static void StudentMenu() {
        Main m = new Main();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1.View Student\n2.View Facilitator\n3.View Marks\n4.Log Out");
        int choice = 0;
        try {
            System.out.println("Enter you choice : ");

            choice = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e);
            StudentMenu();
        }
        switch (choice) {
            case 1:
                s.viewStudent(s.Sid,s.Sname,s.Susername,s.Spassword);
                System.out.println("Do you want to return ? y or n ");
                String retChoice = sc.next();
                if (retChoice.equals("y")) {
                    m.StudentMenu();
                } else {
                    m.mainMenu();
                }
                break;
            case 2:
                s.viewFacilitator(f.Fid,f.Fname,f.Fusername,f.Fpassword,f.Fpassword);
                System.out.println("Do you want to return ? y or n ");
                String retChoice1 = sc.next();
                if (retChoice1.equals("y")) {
                    m.StudentMenu();
                } else {
                    m.mainMenu();
                }
                break;
            case 3:
                s.viewMarks(s.Sname, s.nepali, s.math, s.physics, s.chemistry, s.biology, s.english);
                System.out.println("Do you want to return ? y or n ");
                String retChoice2 = sc.next();
                if (retChoice2.equals("y")) {
                    m.StudentMenu();
                } else {
                    m.mainMenu();
                }
                break;
            case 4:
                m.mainMenu();
            default:
                System.out.println("Invalid choice.");

        }

    }


    /*********Beginning of the program*************/
    public void mainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nWho are You???\n1.Admin\n2.Facilitator\n3.Student");
        int positionNum = 0;
        try {
            System.out.println("Enter your position number: ");
            positionNum = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(e);
            mainMenu();
        }

        switch (positionNum) {
            case 1:
                System.out.println("Enter the username: ");
                String username = sc.next();
                System.out.println("Enter the password: ");
                String password = sc.next();
                if (username.equals("admin") && password.equals("admin")) {
                    AdminMenu();
                } else {
                    System.out.println("Sorry! Wrong password...");
                    mainMenu();
                }

                break;
            case 2:
                System.out.println("Enter the username: ");
                String Fusername = sc.next();
                System.out.println("Enter the password: ");
                String Fpassword = sc.next();
                if (Fusername.equals(f.Fusername) && Fpassword.equals(f.Fpassword)) {
                    FacilitatorMenu();
                } else {
                    System.out.println("Sorry! Wrong password...");
                    mainMenu();
                }
                break;
            case 3:
                System.out.println("Enter the username: ");
                String Susername = sc.next();
                System.out.println("Enter the password: ");
                String Spassword = sc.next();
                if (Susername.equals(s.Susername) && Spassword.equals(s.Spassword)) {
                    StudentMenu();
                } else {
                    System.out.println("Sorry! Wrong password...");
                    mainMenu();
                }

                break;
            default:
                System.out.println("Exiting....");
                break;
        }
    }

    /*********Main body of file to run the program*************/
    public static void main(String[] s){
        System.out.println("*******Result Management System*******");
        Main m = new Main();
        m.mainMenu();

    }
}
