package Week7lab;

public class SearchLab {
    public static void main(String[] args) {
        String[] countries = new String[]{"Afghanistan", "Albania", "Costa Rica", "Cote d'Ivoire", "Croatia (Hrvatska)", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Falkland Islands (Malvinas)", "Faroe Islands", "Fiji",  "Algeria", "American Samoa", "Andorra", "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "French Guiana", "French Polynesia", "French Southern Territories", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Gibraltar", "Greece", "Greenland", "Grenada", "Guadeloupe", "Guam", "Guatemala", "Guinea",  "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegowina", "Botswana", "Bouvet Island", "Brazil", "British Indian Ocean Territory", "Brunei Darussalam", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Cayman Islands", "Central African Republic", "Chad", "Chile", "China", "Christmas Island", "Cocos (Keeling) Islands", "Colombia", "Comoros", "Congo", "Congo, the Democratic Republic of the", "Cook Islands", "Finland", "France", "France Metropolitan",  "Kiribati", "Korea, Democratic People's Republic of", "Korea, Republic of", "Kuwait", "Kyrgyzstan", "Lao, People's Democratic Republic", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libyan Arab Jamahiriya", "Liechtenstein", "Lithuania", "Luxembourg", "Macau", "Macedonia, The Former Yugoslav Republic of", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mayotte", "Mexico", "Micronesia, Federated States of", "Moldova, Republic of", "Monaco", "Mongolia", "Montserrat", "Morocco", "Mozambique", "Myanmar", "Namibia", "Nauru", "Nepal", "Netherlands", "Netherlands Antilles", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Niue", "Norfolk Island", "Northern Mariana Islands", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn", "Poland", "Portugal", "Puerto Rico", "Qatar", "Reunion", "Romania", "Russian Federation",  "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Seychelles", "Sierra Leone", "Singapore", "Slovakia (Slovak Republic)", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Georgia and the South Sandwich Islands", "Spain", "Sri Lanka", "St. Helena", "St. Pierre and Miquelon", "Sudan", "Suriname", "Svalbard and Jan Mayen Islands", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "Swaziland", "Sweden", "Switzerland", "Syrian Arab Republic", "Taiwan, Province of China", "Tajikistan", "Tanzania, United Republic of", "Thailand", "Togo", "Tokelau", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Turks and Caicos Islands", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "United States Minor Outlying Islands", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Virgin Islands (British)", "Virgin Islands (U.S.)", "Wallis and Futuna Islands", "Western Sahara", "Yemen", "Yugoslavia", "Guinea-Bissau", "Guyana", "Haiti", "Heard and Mc Donald Islands", "Holy See (Vatican City State)", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran (Islamic Republic of)", "Iraq", "Ireland", "Israel", "Italy", "Zambia", "Zimbabwe", "Palestine"};
//        linearSearch(countries,"China");


        mergeSort(countries);

        for (String country : countries) {
            System.out.println(country);
        }

        System.out.println(countries.length);

        binarySearch(countries,"Zambia");
    }




    public static int linearSearch(int[] nums, int searchKey) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] == searchKey) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] nums, int searchKey) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == searchKey) {
                return mid;
            }
            else if (nums[mid] > searchKey) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static void linearSearch(String[] countries, String searchKey){
        int n = countries.length;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (countries[i].equals(searchKey)) {
                found = true;
                System.out.println(countries[i]);
            }
        }

        if (!found) {
            System.out.println(-1);
        }
    }

    public static void mergeSort(String[] countries){
        int n = countries.length;
        if (n < 2) {
            return;
        }

        int mid = n / 2;
        String[] leftHalf = new String[mid];
        String[] rightHalf = new String[n-mid];

        for (int i = 0; i < mid; i++) {
            leftHalf[i] = countries[i];
        }
        for (int i = mid; i < n; i++) {
            rightHalf[i-mid] = countries[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(countries,leftHalf,rightHalf);
    }

    private static void merge(String[] countries, String[] leftHalf, String[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i =0, j=0, k=0;

        while (i < leftSize && j < rightSize) {
            if (leftHalf[i].compareTo(rightHalf[j]) < 0) {
                countries[k] = leftHalf[i];
                i++;
            }
            else {
                countries[k] = rightHalf[j];
                j++;
            }
            k++;
        }
        while (i < leftSize) {
            countries[k] = leftHalf[i];
            i++;
            k++;
        }
        while (j < rightSize) {
            countries[k] = rightHalf[j];
            j++;
            k++;
        }

    }

    public static void binarySearch(String[] countries, String searchKey){
        int left = 0, right = countries.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (countries[mid].equals(searchKey)) {
                System.out.println("found " + countries[mid] + " at index " + mid);
                return;
            }
            else if (countries[mid].compareTo(searchKey) > 0) {
                right = mid + 1;
            }
            else {
                left = mid + 1;
            }
        }

//        System.out.println("country " + searchKey+ " not found");

    }



}
