package week_3;
class SrmStudent
{
    String name;
    int regNo;
    float attendance;
    SrmStudent(String name,int regNo,float attendance)
    {
        this.name = name;
        this.regNo = regNo;
        this.attendance = attendance;

    }
    void addAttendanceUpdate(int newAttendance)
    {
        attendance = newAttendance;
    }
    boolean isEligible()
    {
        return attendance>=75;
    }
    static double classAverage(SrmStudent[] Students)
    {
        double total = 0;
        for(int i = 0;i<Students.length;i++)
            total = total + Students[i].attendance;
        return total/Students.length;
    }


}
public class working_attendance_system {
    public static void main(String[] args) {
            SrmStudent[] students = new SrmStudent[] {
    new SrmStudent("Ravi", 1, 82),
    new SrmStudent("Anitha", 2, 68),
    new SrmStudent("Karthik", 3, 91),
    new SrmStudent("Meera", 4, 74),
    new SrmStudent("Suresh", 5, 60)
    };
    for (SrmStudent s : students) {
    System.out.println(
        s.name + " " +
        s.attendance + " " +
        (s.isEligible() ? "Eligible" : "Detained")
        );
    }
    System.out.println("ATTENDANCE AVERAGE IS "+SrmStudent.classAverage(students));
    }
    
}
