package Week8Lab;

import java.util.Date;

public class Customer implements Comparable<Customer>{
    private String name;
    private Date dateOfBirth;
    private String address;

    public Customer(String name, Date dateOfBirth, String address) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }




    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\''
                ;
    }

    @Override
    public int compareTo(Customer o) {
        String thisName = this.getName();
        String oName = o.getName();
        if (thisName == null && oName == null) return 0;
        if (thisName == null) return -1; // Nulls first (adjust as needed)
        if (oName == null) return 1;      // Non-null after null
        return thisName.compareTo(oName);

    }
}
