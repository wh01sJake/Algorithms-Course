package Week4lab;

public class User implements Comparable<User> {
    private String name;
    private int age;
    private String gender;
    private String address;
    private int input;

    public User(String name, int age, String gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public int getInput() {
        return input;
    }
    public void setInput(int input) {
        this.input = input;
    }



    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public int compareTo(User o) {
        int nameCompare = this.name.compareTo(o.name);
        int ageCompare = this.age - o.age;
        if (nameCompare != 0) {
            return nameCompare;
        }
        return ageCompare;
    }
}
