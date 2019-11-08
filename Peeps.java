public class Peeps{
    private String name;
    private String job;

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public void setJob(String job){
        this.job = job;
    }

    public String getJob(){
        return job;
    }

    public String toString(){
        return "My name is " + name + " and I hope to be a " + job + " one day.";
    }

}