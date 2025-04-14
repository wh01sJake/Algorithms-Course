package week3;

public class Grade {
    private int grade;
    private String subject;

    public Grade(int grade, String subject) {
        this.grade = grade;
        this.subject = subject;
    }

    public Grade() {
    }


    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return this.subject + ": " + this.grade;
    }
}
