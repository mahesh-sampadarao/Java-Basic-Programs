import java.util.Scanner;

public class NonPrimitiveArrays {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Student[] st=new Student[n];

        for(int i=0;i<n;i++){
            int id=sc.nextInt();sc.nextLine();
            String name=sc.nextLine();
            double marks=sc.nextDouble();

            st[i]=new Student(id, name, marks);
        }

        int id=sc.nextInt();
        sc.close();

        Student ans=findById(st,id);
        if(ans==null){
            System.out.println("Not Found");
        }else{
            System.out.println(ans.getId());
            System.out.println(ans.getName());
            System.out.println(ans.getMarks());
        }

    }

    public static Student findById(Student[] st,int id){
        for(int i=0;i<st.length;i++){
          if(st[i].getId()==id){
              return st[i];
          }
        }
        return null;
    }
}

class Student{
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

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

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}

