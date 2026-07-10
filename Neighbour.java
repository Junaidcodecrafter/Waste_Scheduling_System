package waste_scheduling_system;

public class Neighbour  {
    private String name;
    private int age;
    private String cnic;
    private String phonenumber; 
    private String address;
    private String password;
    
    public Neighbour(){
        
    }
    public String getPhonenumber() {
        return phonenumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCnic() {
        return cnic;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }
    
    public Neighbour(String name,int age,String cnic,String address,String password, String phonenumber) {
        this.name = name;
        this.age = age;
        this.cnic = cnic;
        this.address = address;
        this.password = password;
        this.phonenumber = phonenumber;    
    }
}