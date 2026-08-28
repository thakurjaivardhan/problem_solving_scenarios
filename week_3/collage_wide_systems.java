package week_3;

class SrmStudent_Broken {

    static String name;
    static String regNo;
    static int attendance;

    SrmStudent_Broken(String name, String regNo, int attendance) {
        SrmStudent_Broken.name = name;
        SrmStudent_Broken.regNo = regNo;
        SrmStudent_Broken.attendance = attendance;
    }
}

class SrmStudent {

    String name;
    String regNo;
    int attendance;

    static String university = "SRM";
    static int admissionCount = 0;

    SrmStudent(String name, int attendance) {
        this.name = name;
        admissionCount++;
        this.regNo = "RA" + admissionCount;
        this.attendance = attendance;
    }

    void printIdCard() {
        System.out.println("Name: " + name);
        System.out.println("Reg No: " + regNo);
        System.out.println("University: " + university);
        System.out.println("Attendance: " + attendance);
        System.out.println();
    }

    static void printTotalAdmissions() {
        System.out.println("Total admissions: " + admissionCount);
    }
}

public class collage_wide_systems {

    public static void main(String[] args) {

        System.out.println("----- BROKEN VERSION -----");

        SrmStudent_Broken s1 =
                new SrmStudent_Broken("Ravi", "RA101", 82);

        SrmStudent_Broken s2 =
                new SrmStudent_Broken("Meera", "RA102", 74);

        System.out.println("s1 name: " + s1.name);
        System.out.println("s2 name: " + s2.name);

        System.out.println();

        System.out.println("----- FIXED VERSION -----");

        SrmStudent student1 =
                new SrmStudent("Ravi", 82);

        SrmStudent student2 =
                new SrmStudent("Meera", 74);

        student1.printIdCard();
        student2.printIdCard();

        SrmStudent.printTotalAdmissions();
    }
}