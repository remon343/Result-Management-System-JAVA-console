import java.util.Scanner;

class Employee{
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

}
public class ObjectInJava {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        Employee[] e = new Employee[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Entwer id");
            int id=scan.nextInt();
            System.out.println("Entwer name");
            String name=scan.next();
            Employee temp=new Employee(id,name);
            e[i]=temp;
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(e[i].getName());
        }

    }

}
