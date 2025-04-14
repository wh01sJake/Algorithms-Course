package Week8Lab;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadCustomer {
    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<>();

        String regex = "[0-9]+";
        Pattern pattern = Pattern.compile(regex);


        try(BufferedReader br= new BufferedReader(new FileReader("cars.csv"))){

            br.readLine();

            String line;
            int lineNum = 2;

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            while((line =br.readLine()) !=null){

                String[] data = line.split(",");
                Matcher matcher = pattern.matcher(data[0]);


                String name = null;
                try {
                    if(matcher.find()){

                        throw new Exception("Invalid Customer Name "+matcher.group(0)  +" at line " + lineNum);
                    }

                    name = data[0];

                    if(name.isEmpty()){
                        name = null;
                    }

                } catch (Exception e) {
                   e.printStackTrace();
                   continue;
                }


                Date dateOfBirth = null;
                try {
                    dateOfBirth = df.parse(data[1]);
                } catch (ParseException e) {
                    e.printStackTrace();
                    continue;
                }


                String address = null;

                    address = data[2];



                customers.add(new Customer(name, dateOfBirth, address));
                lineNum++;

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }






        bubbleSort(customers);

        for(Customer c: customers){
            System.out.println(c.toString());
        }



    }


    public static void bubbleSort(List<Customer> customers) {
        int n = customers.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if(customers.get(j).compareTo(customers.get(j+1))>0){

                    Customer temp = customers.get(j);
                    customers.set(j, customers.get(j+1));
                    customers.set(j+1, temp);
                }
            }
        }

    }



}
