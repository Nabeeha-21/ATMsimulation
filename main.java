class person{
    String name;
    person( String name)
    {
        this.name=name;
        System.out.println(name);
    }
}
class employee extends person{
    int employeeID;
    employee()
    {
        super("john");
    }
}
public class main {
    public static void main(String[] args) {
        employee e1= new employee();
    }
    
}
