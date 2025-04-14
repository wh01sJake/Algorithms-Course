package CA1;

import java.io.File;
import java.util.*;

public class ReadStaffData {

    public static void main(String[] args) throws Exception{
        //parsing and reading the CSV file data into the film (object) array
        // provide the path here...
        File directory = new File("./");
        String name = directory.getAbsolutePath() + "//Staff.csv";
        Scanner sc = new Scanner(new File(name));
        Staff[] staffs = new Staff[10000];

        // this will just print the header in CSV file
        sc.nextLine();

        int i = 0; String st = "";
        while (sc.hasNextLine())  //returns a boolean value
        {
            st = sc.nextLine();
            String[] data = st.split(",");
            staffs[i++] = new Staff(Integer.parseInt(data[0]), data[1], data[2], data[3], Float.parseFloat(data[4]), Float.parseFloat(data[5]));
        }
        sc.close();  //closes the scanner

 /*       // We can print film details due to overridden toString method in film class
        System.out.println(staffs[0]);
        System.out.println(staffs[1]);

        // we can compare films based on their ID due to overridden CompareTo method in film class
        System.out.println(staffs[0]==staffs[0]);
        System.out.println(staffs[0]==staffs[1]);*/



/*
        long currentTime = System.nanoTime();
//        bubbleSort(staffs);//    802003100 for 10k records
//        selectionSort(staffs);// 316034000 for 10k records
//        insertionSort(staffs);// 162202900 for 10k records
        mergeSort(staffs);//      10233900 for 10k records

        long endTime = System.nanoTime();
        System.out.println("Sort time:" + (endTime - currentTime));*/

/*        for (int j = 0; j<staffs.length; j++){
            System.out.println(staffs[j]);
        }*/



        int runs = 1000;
        long totalTime = 0;
        Staff[] testStaff = new Staff[10000];
        mergeSort(staffs);
        for (int k = 0; k < runs; k++) {
            // Copy from the original every loop
//            System.arraycopy(staff10, 0, testStaff, 0, 10);
            System.arraycopy(staffs, 0, testStaff, 0, 10000);

            long start = System.nanoTime();
//            bubbleSort(testStaff);// 3559 ns ,59884 ns, 8942642 ns,188932127ns, 745606970ns
//                optimizedBubbleSort(testStaff); //3129  ns ,58911 ns ,8961506ns,208880000ns ,789154525ns
//                insertionSort(testStaff); // 2618 ns , 40249 ns ,1440283ns,38258249ns,152557082ns
//            selectionSort(testStaff); // 3176 ns , 47739 ns ,  3643503ns,  97379006ns,351095059ns
//            binaryInsertionSort(testStaff); //2537 ns , 24147 ns, 379697ns,2613523ns, 6576721ns
//            mergeSort(testStaff); // 2899 ns , 20211 ns,214136ns,1501525ns,3207051ns ,
            quickSort(testStaff); //3417 ns, 19807 ns, 182580 ns, 961902 ns, 1957427 ns
//            linearSearch(staffs,0,"Jake"); //97261
//            optimizedLinearSearch(staffs,0,"Jake"); //78046
//                binarySearch(staffs,"Jake"); //66846

            totalTime += System.nanoTime() - start;
        }
        System.out.println("Average  time: " + (totalTime / runs) + " ns");


    }

    // Start with  bubbleSort
    public static void bubbleSort(Staff[] staffs){
        int n = staffs.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (staffs[j].compareTo(staffs[j + 1]) > 0) {
                    Staff temp = staffs[j];
                    staffs[j] = staffs[j + 1];
                    staffs[j + 1] = temp;
                }
            }
        }
    }

    //  optimizedBubbleSort
    private static void optimizedBubbleSort(Staff[] staffs) {
        int n = staffs.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false; // Reset the swap flag each round
            for (int j = 0; j < n - i - 1; j++) {
                if (staffs[j].compareTo(staffs[j + 1]) > 0) {
                    Staff temp = staffs[j];
                    staffs[j] = staffs[j + 1];
                    staffs[j + 1] = temp;
                    swapped = true;
                }
            }
            // If there is no swap in this round, it means the array is already ordered.
            if (!swapped) break; // break the loop in advance
        }
    }

    //insertionSort
    private static void insertionSort(Staff[] staffs) {
        int size = staffs.length;
        for (int i = 1; i < size; i++) { // Start from 1 up to size-1
            Staff temp = staffs[i];
            int j = i - 1;
            while (j >= 0 && staffs[j].compareTo(temp) > 0) { // Check if data[j] > temp
                staffs[j + 1] = staffs[j];
                j--; // Move left
            }
            staffs[j + 1] = temp;
        }
    }


    //Optimized InsertionSort

    private static void binaryInsertionSort(Staff[] staffs) {
        int n = staffs.length;

        // Outer loop: Iterate through all elements starting from the second one
        for (int i = 1; i < n; i++) {
            Staff key = staffs[i];// Current element to be inserted

            int left = 0; int right = i - 1; //[0,i-1]

            // Binary search to find insertion position
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (staffs[mid].compareTo(key) < 0){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }

            // At this point, 'left' is the correct insertion position
            // Shift elements from 'left' to 'i-1' one position to the right
            System.arraycopy(staffs, left, staffs, left + 1, i - left);
            // Insert the key at the correct position
            staffs[left] = key;
        }
    }




    private static void selectionSort(Staff[] staffs) {
        int n = staffs.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (staffs[j].compareTo(staffs[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Staff temp = staffs[i];
                staffs[i] = staffs[minIndex];
                staffs[minIndex] = temp;
            }
        }
    }



    //mergeSort
    private static void mergeSort(Staff[] staffs){
        int n = staffs.length;
        if (n < 2) {
            return; // return when there is 0 or 1 element left
        }
        int mid = n / 2;
        Staff[] leftHalf =new Staff[mid];
        Staff[] rightHalf =new Staff[n - mid];

/*        // assign value to the left array
        for (int i = 0; i < mid; i++) {
            leftHalf[i] = staffs[i];
        }
        // assign value to the right array
        for (int i = mid; i < n; i++) {
            rightHalf[i - mid] = staffs[i];
        }*/

        // Optimized splitting with arraycopy
        System.arraycopy(staffs, 0, leftHalf, 0, mid);
        System.arraycopy(staffs, mid, rightHalf, 0, n - mid);

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        //Merge here
        merge(staffs, leftHalf, rightHalf);
    }



    private static void merge(Staff[] staffs,Staff[] leftHalf,Staff[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0 , k = 0;

        while (i < leftSize && j < rightSize) {
                //add to left array if negative result of compare
            if (leftHalf[i].compareTo(rightHalf[j]) < 0) {
                staffs[k] = leftHalf[i];
                i++;
            }
            else {
                staffs[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        //add the rest elements
/*        while (i < leftSize) {
            staffs[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            staffs[k] = rightHalf[j];
            j++;
            k++;
        }*/

        // Optimized remaining element handling
        if (i < leftSize) {
            System.arraycopy(leftHalf, i, staffs, k, leftSize - i);
        }
        if (j < rightSize) {
            System.arraycopy(rightHalf, j, staffs, k, rightSize - j);
        }
    }

    //quickSort
    private static void quickSort(Staff[] staffs){
        quickSort(staffs, 0, staffs.length - 1);
    }


    private static void quickSort(Staff[] staffs, int start, int end) {

        // if only one element left
        if (start >= end) return;



        // set pivot as the last staff of the array
        // This may be optimized in the future because end is not always the ideal index for pivot.
        // optimization setup:
        // randomly choose an index between start and end, then swap the element to the end in order to keep the same logic.
        int pivotIndex = new Random().nextInt(end - start + 1) + start;
        swap(staffs, pivotIndex, end);


        // no need to passing in the pivot since it's always the end element.
//        int leftPointer = getPointer(staffs, start, end, pivot);
        int leftPointer = partition(staffs, start, end);


        quickSort(staffs, start, leftPointer - 1);
            quickSort(staffs, leftPointer + 1, end);
        
    }

    //extract method to increase code readability
    private static int partition(Staff[] staffs, int start, int end) {
        Staff pivot = staffs[end];
        int leftPointer = start;
        int rightPointer = end-1;

        while (leftPointer < rightPointer) {
            while (staffs[leftPointer].compareTo(pivot) < 0 && leftPointer < rightPointer) {
                leftPointer++;
            }
            while (staffs[rightPointer].compareTo(pivot) > 0 && rightPointer > leftPointer) {
                rightPointer--;
            }

            swap(staffs, leftPointer, rightPointer);
        }

        //swap pivot  with the leftPointer
        // add a check If all elements ≤ pivot, the pivot is the largest in the subarray and should stay at end.
        if (staffs[leftPointer].compareTo(staffs[end]) > 0) {

            swap(staffs, leftPointer, end);
        }
        else {
            leftPointer = end; // Pivot already in place
        }

        return leftPointer;
    }


    private static void swap(Staff[] staffs, int i, int j) {
        Staff temp = staffs[i];
        staffs[i] = staffs[j];
        staffs[j] = temp;
    }





    private static void linearSearch(Staff[] staffs, int index,String fName){
        boolean found = false;
        for (int i = index; i < staffs.length; i++) {
            if(staffs[i].getFName().equals(fName)){
                System.out.println(staffs[i]);
                found = true;
            }
        }
        if(!found){
            System.out.println("Not an existing " + fName);
        }
    }

    // An optimized linearSearch

    private static void optimizedLinearSearch(Staff[] staffs, int index,String fName){

        boolean found = false;

        for (int i = index; i < staffs.length; i++) {
            int result = staffs[i].getFName().compareTo(fName);
            if(result == 0){
                System.out.println(staffs[i]);
                found = true;
            }
            else if (result > 0) { //break the loop in advance
                break;
            }
        }
        if(!found){
            System.out.println("Not an existing " + fName);
        }
    }


    private static void binarySearch(Staff[] staffs, String fName) {
    //I realized that the original binarySearch would stop when find the target name,need to traverse
    // to left and right side until not equal.
        int left = 0;
        int right = staffs.length-1 ;
        int found = -1; // Initialize the index as -1
        while (left <= right) {
            int middle = (right - left) / 2 + left;
            int result = staffs[middle].getFName().compareTo(fName);
            if (result == 0) {
                // get any target index and break
                found = middle;
                break;
            }
            else if (staffs[middle].getFName().compareTo(fName) > 0) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }
        }

        if (found == -1) {
            System.out.println("Not an existing " + fName);
            return;
        }

        // now we got the target index, traverse to the both side
        int i = found;
        List<Staff> matches = new ArrayList<>();

        // to left
        while (i >=0 && staffs[i].getFName().equals(fName)) {
            matches.add(staffs[i]);
            i--;
        }

        //to right
        int j = found+1;
        while (j < staffs.length && staffs[j].getFName().equals(fName)) {
            matches.add(staffs[j]);
            j++;
        }

        System.out.println("Found " + matches.size() + " matches for " + fName);
        for (Staff match : matches) {
            System.out.println(match);
        }
     }
}


class Staff implements Comparable<Object> {

    private int empNo;
    private String fName;
    private String sName;
    private String department;
    private float wage;
    private float projectCompletionRate;


    // constructor
    public Staff(int empNo, String fName, String sName, String department, float wage, float projectCompletionRate) {
        super();
        this.empNo = empNo;
        this.fName= fName;
        this.sName= sName;
        this.department= department;
        this.wage = wage;
        this.projectCompletionRate = projectCompletionRate;
    }

    // setters and getters
    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        this.fName = fName;
    }

    public String getSName() {
        return sName;
    }

    public void setSName(String sName) {
        this.sName = sName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public float getProjectCompletionRate() {
        return projectCompletionRate;
    }

    public void setProjectCompletionRate(float projectCompletionRate) {
        this.projectCompletionRate = projectCompletionRate;
    }

    public float getWage(){
        return wage;
    }

    public void setWage(float wage){
        this.wage = wage;
    }

    // so the film objects can be compared when sorting/searching
    // NOTE: this will only allow comparisons based on the title of the film
    @Override
    public int compareTo(Object obj) {

		/*
		Edit this section so it compares the appropriate
		column you wish to sort by
		*/
        Staff sff = (Staff)obj;
        if(sff.getFName().compareTo(this.getFName()) != 0){
            return this.getFName().compareTo(sff.getFName());
        }

        return empNo - (sff.getEmpNo());
    }

    @Override
    public String toString() {
        return "Staff [EmpNo=" + empNo + ", first name=" + fName+ ", last Name=" + sName+ ", department="
                + department+  ", wage=" + wage+ ", project completion rate="
                + projectCompletionRate+ "]";
    }





}