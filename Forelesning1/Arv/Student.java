package Arv;

public class Student extends Person{
    private int studentId;
    private String[] emner;

    public Student(String navn, int alder, int studentId, String[] emner) {
        super(navn, alder);
        this.studentId = studentId;
        this.emner = emner;
    }

    @Override
    public String toString() {
        return "Sturdent " + studentId + ": " + navn;
    }

    public void printEmner() {
        for (int i = 0; i < emner.length; i++) {
            if (emner[i] != null) {
                System.out.println(emner[i]);
            }
        }
    }

}