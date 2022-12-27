import java.util.ArrayList;
import java.util.Scanner;


/*********Admin class to perform all tasks*************/

class Admin{
    static String Sname,Susername,Spassword;
    static int Sid, Fid;
    static String Fname,Fusername,Fpassword,Fsubject;
    static float nepali,math,physics,chemistry,biology,english;
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
    public void viewStudent(){
        System.out.println("id:"+Sid+" name:"+Sname+" username:"+Susername+" password:"+Spassword);
    }
    public void viewFacilitator(){
        System.out.println("id:"+Fid+" name:"+Fname+" username:"+Fusername+" password:"+Fpassword+" subject:"+Fsubject);
    }
    public void addMarks(float marks){
        if(Fsubject.equals("nepali")){
            this.nepali = marks;
        } else if (Fsubject.equals("math")) {
            this.math = marks;
        } else if (Fsubject.equals("physics")) {
            this.physics = marks;
        } else if (Fsubject.equals("chemistry")) {
            this.chemistry= marks;
        } else if (Fsubject.equals("biology")) {
            this.biology = marks;
        } else if (Fsubject.equals("english")) {
            this.english = marks;
        } else {
            System.out.println("Subject does not match...");
        }


    }
    public void viewMarks(){

        System.out.println("Student Name: "+Sname+"Marks: nepali: "+nepali+" math:"+math+" physics:"+physics+" chemistry:"+chemistry+" biology:"+biology+" english:"+english+" total marks: "+(nepali+math+physics+chemistry+biology+english)+" percentage:"+(nepali+math+physics+chemistry+biology+english)/6);
    }
}


/*********Student class to perform all tasks while properties are inherited from parent class*************/


class Student extends Admin{
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

/*********Main class here to perform all the tasks*************/
public class Main {

    static Admin  ad = new Admin();
    static Facilitator f= new Facilitator();
    static Student s = new Student();
    /*********Menu to show admin*************/
    public static void AdminMenu(){
        Main m =  new Main();
        Scanner sc = new Scanner(System.in);
        System.out.println("\n1.Add Student.\n2.Add Facilitator\n3.Add Marks\n4.View Student\n5.View Facilitator\n6.View Marks\n7.Log Out");

        System.out.println("Enter your choice: ");
        int choice  = sc.nextInt();

        switch(choice){
            case 1:
                System.out.println("Enter the student id :");
                int Sid = sc.nextInt();
                System.out.println("Enter the student name : ");
                String Sname = sc.next();
                System.out.println("Enter the student username : ");
                String Susername = sc.next();
                System.out.println("Enter the student password:");
                String Spassword = sc.next();

                ad.getStudent(Sid,Sname,Susername,Spassword);
                m.AdminMenu();
                break;
            case 2:
                System.out.println("Enter the facilitator id :");
                int Fid= sc.nextInt();
                System.out.println("Enter the facilitator name :");
                String Fname = sc.next();
                System.out.println("Enter the facilitator username : ");
                String Fusername = sc.next();
                System.out.println("Enter the facilitator password : ");
                String Fpassword = sc.next();
                System.out.println("Enter the subject name : ");
                String Fsubject = sc.next();
                ad.getFacilitator(Fid,Fname,Fusername,Fpassword,Fsubject);
                m.AdminMenu();
                break;
            case 3:

                System.out.println("Enter the Nepali Marks : ");
                float nepali = sc.nextFloat();
                System.out.println("Enter the Math Marks : ");
                float math = sc.nextFloat();
                System.out.println("Enter the Physics Marks : ");
                float physics = sc.nextFloat();
                System.out.println("Enter the chemistry Marks : ");
                float chemistry= sc.nextFloat();
                System.out.println("Enter the biology Marks : ");
                float biology = sc.nextFloat();
                System.out.println("Enter the English Marks : ");
                float english = sc.nextFloat();

                ad.getMarks(nepali,math,physics,chemistry,biology,english);
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
                if(retChoice.equals("y")){
                    m.AdminMenu();
                }
                else{
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
    public static void FacilitatorMenu(){
        Main m = new Main();

        System.out.println("\n1.Add Marks\n2.View Student\n3.View Facilitator\n4.View Marks\n5.Log Out");
        System.out.println("Enter you choice : ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice){
            case 1:
                if(f.Fsubject.equals("nepali")){
                    System.out.println("Enter Your Subject Nepali Marks:");
                } else if (f.Fsubject.equals("math")) {
                    System.out.println("Enter Your Subject Math Marks:");
                } else if (f.Fsubject.equals("physics")) {
                    System.out.println("Enter Your Subject Physics Marks:");
                } else if (f.Fsubject.equals("chemistry")) {
                    System.out.println("Enter Your Subject Chemistry Marks:");
                } else if (f.Fsubject.equals("biology")) {
                    System.out.println("Enter Your Subject Biology Marks:");
                } else if (f.Fsubject.equals("english")) {
                    System.out.println("Enter Your Subject English Marks:");
                } else {
                    System.out.println("Subject does not match...");
                }

                float marks = sc.nextFloat();
                f.addMarks(marks);
                System.out.println("Do you want to return ? y or n ");
                String retChoice = sc.next();
                if(retChoice.equals("y")){
                    m.FacilitatorMenu();
                }
                else{
                    System.out.println("Remain here...");
                }
                break;
            case 2:
                f.viewStudent();
                System.out.println("Do you want to return ? y or n ");
                String retChoice0 = sc.next();
                if(retChoice0.equals("y")){
                    m.FacilitatorMenu();
                }
                else{
                    m.mainMenu();
                }
                break;
            case 3:
                f.viewFacilitator();
                System.out.println("Do you want to return ? y or n ");
                String retChoice1 = sc.next();
                if(retChoice1.equals("y")){
                    m.FacilitatorMenu();
                }
                else{
                    m.mainMenu();
                }
                break;
            case 4:
                f.viewMarks();
                System.out.println("Do you want to return ? y or n ");
                String retChoice2 = sc.next();
                if(retChoice2.equals("y")){
                    m.FacilitatorMenu();
                }
                else{
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
    public static void StudentMenu(){
        Main m = new Main();
        System.out.println("\n1.View Student\n2.View Facilitator\n3.View Marks\n4.Log Out");
        System.out.println("Enter you choice : ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                s.viewStudent();
                System.out.println("Do you want to return ? y or n ");
                String retChoice = sc.next();
                if(retChoice.equals("y")){
                    m.StudentMenu();
                }
                else{
                    m.mainMenu();
                }
                break;
            case 2:
                s.viewFacilitator();
                System.out.println("Do you want to return ? y or n ");
                String retChoice1 = sc.next();
                if(retChoice1.equals("y")){
                    m.FacilitatorMenu();
                }
                else{
                    m.mainMenu();
                }
                break;
            case 3:
                s.viewMarks();
                System.out.println("Do you want to return ? y or n ");
                String retChoice2 = sc.next();
                if(retChoice2.equals("y")){
                    m.FacilitatorMenu();
                }
                else{
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
    public void mainMenu(){
        Scanner sc = new Scanner(System.in);
        Facilitator f = new Facilitator();
        Student s = new Student();
        System.out.println("\n\nWho are You???\n1.Admin\n2.Facilitator\n3.Student");
        System.out.println("Enter your position number: ");
        int positionNum = sc.nextInt();

        switch(positionNum){
            case 1:
                System.out.println("Enter the username: ");
                String username = sc.next();
                System.out.println("Enter the password: ");
                String password = sc.next();
                if(username.equals("admin") && password.equals("admin")){
                    AdminMenu();
                }else{
                    System.out.println("Sorry! Wrong password...");
                    mainMenu();
                }

                break;
            case 2:
                System.out.println("Enter the username: ");
                String Fusername = sc.next();
                System.out.println("Enter the password: ");
                String Fpassword = sc.next();
                if(Fusername.equals(f.Fusername) && Fpassword.equals(f.Fpassword)){
                    FacilitatorMenu();
                }else{
                    System.out.println("Sorry! Wrong password...");
                    mainMenu();
                }
                break;
            case 3:
                System.out.println("Enter the username: ");
                String Susername = sc.next();
                System.out.println("Enter the password: ");
                String Spassword = sc.next();
                if(Susername.equals(s.Susername) && Spassword.equals(s.Spassword)){
                    StudentMenu();
                }else{
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
