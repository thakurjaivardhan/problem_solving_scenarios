package week_3;
class FeeAccount{
    private int regNo;
    private double totalFee,amountPaid;

    FeeAccount(int regNo,double totalFee,double amountPaid)
    {
        this.regNo = regNo;
        this.totalFee = totalFee;
        this.amountPaid = amountPaid;
    }
    void pay(double amount)
    {
        if(amount<=0)
            {
                System.out.println( "invalid amount");
                return;
            }
        else{
            amountPaid = amountPaid-amount;
        }
    }
    double getDue(){
        return totalFee - amountPaid;
    }
}
class HostelFeeAccoount extends FeeAccount{
    HostelFeeAccoount(int regNo, double totalFee, double amountPaid) {
        super(regNo, totalFee, amountPaid);
    }
    void payinTwoinstallments(double amount){
        double half = amount/2;
        pay(half);
        pay(amount-half);
    }
}
class ScholarshipFeeAccount extends FeeAccount{
    private double scholarshipPercent;
    ScholarshipFeeAccount(int regNo, double totalFee,double amountPaid,double scholarshipPercent){
        super(regNo, totalFee, amountPaid);
        this.scholarshipPercent = scholarshipPercent;
    }
    double effectiveDue(){
        return getDue()*(1-scholarshipPercent/100);
    }
}
public class fee_account_system{
    public static void main(String[] args){
        FeeAccount plain = new FeeAccount(1, 150000, 150000);
        HostelFeeAccoount hostel = new HostelFeeAccoount(2, 200000, 0);
        hostel.payinTwoinstallments(600000);
        ScholarshipFeeAccount scholar = new ScholarshipFeeAccount(3, 180000, 0, 20);

        FeeAccount[] accounts = {plain,hostel,scholar};

        for(FeeAccount acc:accounts){
            if (acc instanceof ScholarshipFeeAccount) {
            ScholarshipFeeAccount s = (ScholarshipFeeAccount) acc;
            System.out.println("Scholarship account effective due: " + s.effectiveDue());

        } else if (acc instanceof HostelFeeAccoount) {
            System.out.println("Hostel account due: " + acc.getDue());

        } else {
            System.out.println("Plain account due: " + acc.getDue());}
        
        }

    }

}
