package PrevCA;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * ClassName: ReadFilmData
 * Description:
 * <p>
 * Datetime: 2025/4/10 15:08
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class ReadFilmData {
    public static void main(String[] args) {

        List<Film> filmList = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("Film.csv"));
        ){
            String line = null;
            br.readLine();
            while((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int film_id = 0;
                try {
                    film_id = Integer.parseInt(data[0]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                String genre = data[1];

                String director_name = data[2];

                String title = data[3];

                double length = Double.parseDouble(data[4]);

                double rating = Double.parseDouble(data[5]);

                filmList.add(new Film(film_id, genre, director_name, title, length, rating));

            }

            System.out.println(sumEvenLength(filmList, 0));

            System.out.println(findMinLength(filmList));

            sortByOption(filmList);

            filmList.forEach(System.out::println);


            //create 6 threads

            for (int i = 0; i < 6; i++){
                Thread thread = new Thread(new SortingThread(), "T" + (i + 1));
                thread.start();

            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static double sumEvenLength(List<Film> filmList, int index) {
        if (index == filmList.size() ) {
            return 0;
        }
        else if (index % 2 != 0){
            return sumEvenLength(filmList, index + 1);
        }

        return filmList.get(index).getLength() + sumEvenLength(filmList, index + 2);
    }

    private static double findMinLength(List<Film> filmList) {
        double min = Double.MAX_VALUE;

        int n = filmList.size();
        for (int i = 0; i < n; i++) {
            if( i % 2 != 0){
                if (filmList.get(i).getLength() < min) {
                    min = filmList.get(i).getLength();
                }
            }
        }
        return min;




    }

    private static void sortByOption(List<Film> filmList) {
        Scanner sc  = new Scanner(System.in);
        System.out.println("Enter 1,2,3,4,5 to sort by ID/genre/name/title/length/rating");
        int choice = sc.nextInt();


        switch (choice) {

            case 1 -> filmList.sort(Comparator.comparing(Film::getFilm_id));

            case 2 -> filmList.sort(Comparator.comparing(Film::getGenre));

            case 3 -> filmList.sort(Comparator.comparing(Film::getDirector_name));

            case 4 -> filmList.sort(Comparator.comparing(Film::getTitle));

            case 5 -> filmList.sort(Comparator.comparing(Film::getLength));

            case 6 -> filmList.sort(Comparator.comparing(Film::getRating));

            default -> System.out.println("Invalid choice");

        }

        Integer i = Integer.valueOf(5);


    }
}


class SortingThread implements Runnable {


    @Override
    public void run() {

        List<Film> filmList = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("Film.csv"));
        ){
            String line = null;
            br.readLine();
            while((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int film_id = 0;
                try {
                    film_id = Integer.parseInt(data[0]);
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

                String genre = data[1];

                String director_name = data[2];

                String title = data[3];

                double length = Double.parseDouble(data[4]);

                double rating = Double.parseDouble(data[5]);

                filmList.add(new Film(film_id, genre, director_name, title, length, rating));



            }

            switch (Thread.currentThread().getName()){
                case "T1" -> filmList.sort(Comparator.comparingInt(Film::getFilm_id));
                case "T2" -> filmList.sort(Comparator.comparing(Film::getGenre));
                case "T3" -> filmList.sort(Comparator.comparing(Film::getDirector_name));
                case "T4" -> filmList.sort(Comparator.comparing(Film::getTitle));
                case "T5" -> filmList.sort(Comparator.comparingDouble(Film::getLength));
                case "T6" -> filmList.sort(Comparator.comparingDouble(Film::getRating));
            }

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Film0");
            stringBuilder.append(Thread.currentThread().getName().substring(1));
            stringBuilder.append(".txt");

            String fileName = stringBuilder.toString();

            try(BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));){

            for (Film film : filmList){
                bw.write(film.toString() + "\n");
            }

            }
            System.out.println(Thread.currentThread().getName() + " generated file: " + fileName);




        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

