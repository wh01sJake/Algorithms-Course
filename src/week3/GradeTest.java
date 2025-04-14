package week3;

import java.util.Scanner;

public class GradeTest  {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many grades you want to sort?");
        int n = sc.nextInt();
        sc.nextLine();

        Grade[] grades = new Grade[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter subject " + (i + 1) + ": ");
            String subject = sc.nextLine();

            System.out.println("Enter grade " + (i + 1) + ": ");
            int grade = sc.nextInt();
            sc.nextLine();

            grades[i] = new Grade(grade, subject);
        }
        System.out.println("Please enter 0 for numerical sort and 1 for alphabetical");
        int choice = sc.nextInt();

        if (choice == 0) {
            sortByValue(grades);
        }
        else if (choice == 1) {
            sortByAlphabet(grades);
        }

        for (Grade g : grades) {
            System.out.println(g);
        }


    }

    public static void sortByValue(Grade[] grades) {
  /*          for (int i = 1; i < grades.length; i++) {
                for (int j = i; j >=1; j--) {
                    if (grades[j].getGrade() < grades[j-1].getGrade()) {
                        Grade temp = grades[j-1];
                        grades[j-1] = grades[j];
                        grades[j] = temp;
                    }
                }
            }*/
       for (int i = 1; i < grades.length; i++) {
            Grade current = grades[i];
            int j;
            for (j = i-1; j >= 0; j--) {
                if (current.getGrade() < grades[j].getGrade()) {
                    grades[j+1] = grades[j];
                }else {
                    break;
                }

            }
            grades[j+1] = current;
        }


    }

    public static void sortByAlphabet(Grade[] grades) {
        for (int i = 0; i < grades.length-1; i++) {
            for (int j = 0; j < grades.length-i-1; j++) {
                if (grades[j].getSubject().toLowerCase().compareTo(grades[j+1].getSubject().toLowerCase()) > 0 ) {
                    Grade temp = grades[j];
                    grades[j] = grades[j+1];
                    grades[j+1] = temp;
                }
            }
        }
    }
}
