package TABA;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Anomaly
 * Description:
 * <p>
 * Datetime: 18/05/2025 13:56
 * Author: @Likun.Fang
 * Version: 1.0
 */
public class Anomaly {
    public static void main(String[] args) {

        String fileName = "log.txt";
        List<String> data = readFile(fileName);

//        System.out.println("data size: " +data.size());

//        checkDateFormat(data);

//        checkCountryCode(data);

//        checkId(data);

//        checkCurrencyIndicator(data);

        System.out.println("detecting anomalies...");
        detectAnomalies(data);
        System.out.println();

    }


    //Question 4.b.i
    // this method should return a list collection of the input file
    // the list will be used by other methods to check anomalies.
    public static List<String> readFile(String fileName){

        List<String> data = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){

            String line = null;
            while ((line = br.readLine()) != null){

                System.out.println(line);

                data.add(line);

            }

            return data;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //question 4.b.ii
    // I'll simply use substring for this case since we only need to check the first 4 digits and "/" after them.
    public static void checkDateFormat(List<String> data){

            for (String line : data){

                try {
                    //skip the first line
                    if(line.startsWith("id")){
                        continue;
                    }
                    String[] fields = line.split(",");
                    //id,fname,lname,phone,fee,date(yyyy/mm/dd)

                    String date = fields[5].trim();
                    System.out.println(date);

                    // first check
                    // min length : 2002/1/1
                    // max length : 2002/12/12
                    if (date.length() < 8 || date.length() > 10){
                        throw new InvalidYearException("Incorrect year part in the date format " +date + " invalid length for date");
                    }

                    String yearPart = date.substring(0,5);
                    //correct yearPart = "2002/"
                    if (!(yearPart.substring(0,4).matches("\\d{4}")) || yearPart.charAt(4) != '/'  ){
                        throw new InvalidYearException("Incorrect year part in the date format " +date + " The year part of the date should start with four digits followed by “/”");
                    }
                } catch (InvalidYearException e) {
                    e.printStackTrace();
                }

            }
        }

        public static void checkCountryCode(List<String> data){

            for (String line : data){

                try {
                    if (line.startsWith("id")){
                        continue;
                    }

                    String[] fields = line.split(",");

                    String phone = fields[3];

                    if (!(phone.startsWith("+353"))){
                        throw new InvalidCountryCodeException("Incorrect country code in a phone number " + phone + " Allowed country code is only +353");
                    }
                } catch (InvalidCountryCodeException e) {
                    e.printStackTrace();
                }

            }

        }

        public static void checkId(List<String> data){

            for (String line : data){

                try {
                    if (line.startsWith("id")){
                        continue;
                    }

                    String[] fields = line.split(",");

                    String id = fields[0];

                    if (id == null || id.isEmpty()){
                        throw new MissingIdException("Missing an id number at all. ");
                    }
                    // this seems unnecessary here because there is no id < 0 in original file
                    // keep it for code robustness
                    else {
                        try {
                            int idValue = Integer.parseInt(id);
                            if (idValue <= 0) {
                                throw new MissingIdException("Id number should be integer > 0: " + id);
                            }
                        } catch (NumberFormatException e) {
                            throw new MissingIdException("Invalid id format (non-integer): " + id);
                        }
                    }


                } catch (MissingIdException e) {
                    e.printStackTrace();
                }
            }
        }

        public static void checkCurrencyIndicator(List<String> data){

            for (String line : data){

                try {
                    if (line.startsWith("id")){
                        continue;
                    }

                    String[] fields = line.split(",");

                    String fee = fields[4];

                    if ( !(fee.contains("$") || fee.contains("€") || fee.contains("£")) ){
                        throw new InvalidCurrencyIndicatorException("Missing currency indicator in a salary column");
                    }


                    if (!(fee.startsWith("€")|| fee.startsWith("£") || fee.startsWith("$"))){

                        throw new InvalidCurrencyIndicatorException("Currency should start with €, £ or $ " + fee);
                    }
                } catch (InvalidCurrencyIndicatorException e) {
                    e.printStackTrace();
                }

            }

        }

        public static void detectAnomalies (List<String> data){

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("error.txt"))) {

            List<String> errorLines = new ArrayList<>();

            for (String line : data){

                try {
                    if (line.startsWith("id")){
                        continue;
                    }

                    String[] fields = line.split(",");

                    String date = fields[5].trim();

                    String phone = fields[3];

                    String id = fields[0];


                    String fee = fields[4];

                    if (date.length() < 8 || date.length() > 10){
                        throw new InvalidYearException("Incorrect year part in the date format " +date + " invalid length for date");
                    }

                    String yearPart = date.substring(0,5);
                    //correct yearPart = "2002/"
                    if (!(yearPart.substring(0,4).matches("\\d{4}")) || yearPart.charAt(4) != '/'  ){
                        throw new InvalidYearException("Incorrect year part in the date format " +date + " The year part of the date should start with four digits followed by “/”");
                    }

                    if (!(phone.startsWith("+353"))){
                        throw new InvalidCountryCodeException("Incorrect country code in a phone number " + phone + " Allowed country code is only +353");
                    }

                    if (id == null || id.isEmpty()){
                        throw new MissingIdException("Missing an id number at all. ");
                    }
                    // this seems unnecessary here because there is no id < 0 in original file
                    // keep it for code robustness
                    else {
                        try {
                            int idValue = Integer.parseInt(id);
                            if (idValue <= 0) {
                                throw new MissingIdException("Id number should be integer > 0: " + id);
                            }
                        } catch (NumberFormatException e) {
                            throw new MissingIdException("Invalid id format (non-integer): " + id);
                        }
                    }

//                    if ( !(fee.contains("$") || fee.contains("€") || fee.contains("£")) ){
//                        throw new InvalidCurrencyIndicatorException("Missing currency indicator in a salary column");
//                    }


                    if (!(fee.startsWith("€")|| fee.startsWith("£") || fee.startsWith("$"))){

                        throw new InvalidCurrencyIndicatorException("Currency should start with €, £ or $ " + fee);
                    }
                } catch (InvalidYearException | InvalidCountryCodeException | MissingIdException |
                         InvalidCurrencyIndicatorException e) {
                    errorLines.add(line);
                }
            }

            bw.write("id,fname,lname,phone,fee,date\n");

            for (String error: errorLines){
                bw.write(error + "\n");
            }




        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        }
    }

