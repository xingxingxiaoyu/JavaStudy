package art.proxy; 
 
 
public class Person implements IPrint, IPrint2 { 
    private String name; 
    private int age; 
 
    public String getName() { 
        return name; 
    } 
 
    public void setName(String name) { 
        this.name = name; 
    } 
 
    public int getAge() { 
        return age; 
    } 
 
    public void setAge(int age) { 
        this.age = age; 
    } 
 
    @Override 
    public String toString() { 
        return "Person{" + 
                "name='" + name + '\'' + 
                ", age=" + age + 
                '}'; 
    } 
 
    public Person(String name, int age) { 
        this.name = name; 
        this.age = age; 
    } 
 
    @Override 
    public void print() { 
        System.out.println(toString()); 
    } 
} 
