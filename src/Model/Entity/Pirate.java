package Model.Entity;

public class Pirate {
    private String name;
    private String age;
    private String role;

    public Pirate(String name, String age, String role) {
        this.name = name;
        this.age = parseAge(age);
        this.role = role;
    }

    public Pirate(){
        this.name = "";
        this.age ="";
        this.role ="";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String parseAge(String age){
        try{
            Integer.parseInt(age);
            return age;
        }catch (NumberFormatException exception){
            return "Undefined";
        }
    }

    public String getKey(){
        return name;
    }
}
