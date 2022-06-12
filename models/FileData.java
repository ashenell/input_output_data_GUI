package models;

public class FileData {
    private String name;
    private int age;

    //________________Constructor_________________//
    public FileData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //________________Getter______________________//
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
