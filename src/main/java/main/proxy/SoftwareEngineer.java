package main.proxy;

public class SoftwareEngineer implements Person {
    private String name;

    public SoftwareEngineer() {
    }

    public SoftwareEngineer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void goWorking(String name, String dst) {
        System.out.println("name =" + name + " ， 去 " + dst + " 工作");
    }
}