public class Peeps{
    private String name;
    private int age;
    private String hobby;
    private Animal pet;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }

    public void setHobby(String hobby){
        this.hobby = hobby;
    }
    public String getHobby(){
        return hobby;
    }

    public void setPet(Animal pet){
        this.pet = pet;
    }
    public Animal getPet(){
        return pet;
    }

    public String Profile(){
        return "My name is " + name + "\n" +
                "I am " + age + " years old\n" +
                "My favorite hobby is " + hobby + "\n" +
                "I own a " + pet.getPetType() + " and its name is " + pet.getPetName() + 
                ".\n\n"; 
    }

    
}