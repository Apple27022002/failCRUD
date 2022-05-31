package model;

public class Student {
    private int id;
    private String name ;
    private Lop clazz;
    private int age;

    public Student() {
    }

    public Student(int id, String name, Lop clazz, int age) {
        this.id = id;
        this.name = name;
        this.clazz = clazz;
        this.age = age;
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

    public Lop getClazz() {
        return clazz;
    }

    public void setClazz(Lop clazz) {
        this.clazz = clazz;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
