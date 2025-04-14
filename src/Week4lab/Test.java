package Week4lab;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        User [] users = {
                    new User("Alice", 30, "F", "London"),
                    new User("Bob", 25, "M", "Paris"),
                    new User("Alice", 20, "F", "Tokyo"), // Same name, different age
                    new User("Jake",25,"M","ChengDu"),
                    new User("Jake",29,"M","Dublin")
        };


        GenericArray <User> userArray = new GenericArray<>(users);
        for (User user: users){
            System.out.println(user);
        }



        userArray.bubbleSort();
        System.out.println("**************");
        for (User user: users){
            System.out.println(user);
        }
    }
}
