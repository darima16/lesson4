package task4;

public class Person {
    String name;
    String surname;
    String data;

    Person(String name, String surname, String data) {
        this.name = name;
        this.data = data;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getData() {
        return data;
    }


}
