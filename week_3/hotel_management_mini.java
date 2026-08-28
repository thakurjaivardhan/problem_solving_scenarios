class FeeAccount {
    protected String accountNo;
    protected double totalFee;
    protected double paidFee;

    FeeAccount(String accountNo, double totalFee, double paidFee) {
        this.accountNo = accountNo;
        this.totalFee = totalFee;
        this.paidFee = paidFee;
    }

    double getDue() {
        return totalFee - paidFee;
    }

    boolean pay(double amount) {
        if (amount <= 0) {
            return false;
        }

        paidFee += amount;
        return true;
    }
}


class HostelFeeAccount extends FeeAccount {

    HostelFeeAccount(String accountNo, double totalFee, double paidFee) {
        super(accountNo, totalFee, paidFee);
    }
}


class HostelRoom {
    String roomNo;
    int beds;
    int occupied;

    HostelRoom(String roomNo, int beds, int occupied) {
        this.roomNo = roomNo;
        this.beds = beds;
        this.occupied = occupied;
    }

    boolean allot(String name) {
        if (occupied < beds) {
            occupied++;
            return true;
        }

        return false;
    }

    static HostelRoom findAvailableRoom(HostelRoom[] rooms) {
        for (HostelRoom room : rooms) {
            if (room.occupied < room.beds) {
                return room;
            }
        }

        return null;
    }
}


class SrmStudent {

    String name;
    String regNo;
    HostelFeeAccount feeAccount;
    HostelRoom room;

    static int totalStudents = 0;

    SrmStudent(String name, String regNo, HostelFeeAccount feeAccount) {
        this.name = name;
        this.regNo = regNo;
        this.feeAccount = feeAccount;
        this.room = null;
        totalStudents++;
    }

    String fullStatus() {
        String roomText;

        if (room == null) {
            roomText = "unallotted";
        } else {
            roomText = room.roomNo;
        }

        return name + " | Due: Rs " + feeAccount.getDue()
                + " | Room: " + roomText;
    }
}


public class hotel_management_mini {

    public static void main(String[] args) {

        HostelRoom[] rooms = {
            new HostelRoom("C-214", 3, 2),
            new HostelRoom("C-507", 2, 1)
        };

        SrmStudent ravi = new SrmStudent(
            "Ravi",
            "RA231100301011",
            new HostelFeeAccount("FA101", 200000, 60000)
        );

        SrmStudent anitha = new SrmStudent(
            "Anitha",
            "RA231100301012",
            new HostelFeeAccount("FA102", 200000, 20000)
        );

        SrmStudent karthik = new SrmStudent(
            "Karthik",
            "RA231100301013",
            new HostelFeeAccount("FA103", 200000, 0)
        );

        HostelRoom room1 = HostelRoom.findAvailableRoom(rooms);

        if (room1 != null && room1.allot(ravi.name)) {
            ravi.room = room1;
        }

        HostelRoom room2 = HostelRoom.findAvailableRoom(rooms);

        if (room2 != null && room2.allot(anitha.name)) {
            anitha.room = room2;
        }

        ravi.feeAccount.pay(-5000);

        SrmStudent[] students = {
            ravi,
            anitha,
            karthik
        };

        for (SrmStudent s : students) {
            System.out.println(s.fullStatus());
        }

        System.out.println("Total students: "
                + SrmStudent.totalStudents);
    }
}