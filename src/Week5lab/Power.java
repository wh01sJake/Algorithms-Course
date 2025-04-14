package Week5lab;

import org.w3c.dom.Node;

import java.lang.module.FindException;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Power {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Alice");
        list.add("Bob");
        list.add("Carl");
        list.add("Dan");
        printList(list);
        System.out.println(power(5, 3));
        System.out.println(power2(5, 3));
        System.out.println(reverse("abcde"));


        System.out.println(palindrome("abbbba")); //true
        System.out.println(isValidString("(())")); //true
        System.out.println(validString("((()))")); //true

    }


    //return x的y次方
    private static int power(int x , int y){
        if (y == 0){
            return 1;
        }

        return x * power(x, y-1);
    }

    private static int power2(int x , int y){
        int result = 1;
        for (int i = y; i >0 ; i--) {
            result = result * x;
        }

        return result;
    }

    private static boolean palindrome(String str){
        if (str.length() == 0 || str.length() == 1){
            return true;
        }
        char first = str.charAt(0);
        char last = str.charAt(str.length()-1);
        if (first != last){
            return false;
        }
        return palindrome(str.substring(1, str.length()-1));
    }


    private static String reverse(String str){

        if (str.isEmpty()){
            return "";
        }

       return reverse(str.substring(1)) + str.charAt(0);

    }

    private static void printList(LinkedList<?> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty");
            return;
        }

        System.out.println(list.getFirst());

        if (list.size() > 1) {
            printList(new LinkedList<>(list.subList(1, list.size())));
        }


    }

        private static boolean isValidString(String str){
            Stack<String> stack = new Stack<>();
            int index = 0;

            while (index < str.length()){
                char c = str.charAt(index);
                if (c == '('){
                    stack.push("(");
                    index++;
                }
                else if (c == ')'){
                    stack.pop();
                    index++;
                }
            }
            return stack.isEmpty();
        }





   private static boolean validString(String str){
        int index = 0,balance = 0;

      while (index < str.length()) {
          char c = str.charAt(index);
          if (c == '(') {
              balance++;
              index++;
          } else if (c == ')') {
              balance--;
              index++;
          }
      }
      return balance == 0; // validString(str.subString(index,index)

    }

    private static int TriBonacci(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        return TriBonacci(n-1) + TriBonacci(n-2) + TriBonacci(n-3);


    }


}
