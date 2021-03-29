import java.util.Scanner;

public class Worker
{
    private String Fname, Lname;
    private double dependents, hourly_rate, numberHours, LocalT, FederalT, stateT, TotalSal;
    public Worker()
    {
        Fname="";
        Lname="";
        dependents=0;
        hourly_rate=0;
        numberHours=0;
        LocalT=0;
        FederalT=0;
        stateT=0;
        TotalSal= hourly_rate*numberHours;
    }

    public void writeOutput()
    {
        System.out.println("First name: "+ this.Fname);
        System.out.println("Last name: "+ this.Lname);
        System.out.println("Dependents: "+ this.dependents);
        System.out.println("Hourly rate: "+ this.hourly_rate);
        System.out.println("Number of hours worked: "+ this.numberHours);
        //System.out.println("Local Tax to be paid: " + LocalTCal());
        //System.out.println("Federal Tax to be paid: " + FederalTCal());
        //System.out.println("State Tax to be paid: " + StateTCal());

    }

    public void readInput()
    {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter your first name: ");
        this.Fname= sc.nextLine();
        System.out.println("Enter your last name: ");
        this.Lname= sc.nextLine();
        System.out.println("Enter your dependents: ");
        this.dependents= sc.nextDouble();
        System.out.println("Enter your hourly rate: ");
        this.hourly_rate= sc.nextDouble();
        System.out.println("Enter number of hours you worked: ");
        this.numberHours= sc.nextDouble();

        if (numberHours <= 40) {
            TotalSal = numberHours * hourly_rate;
        }

        else{
            double overtime= (numberHours-40)*(1.50);
            TotalSal= (overtime+40)*hourly_rate;
        }
    }

    double LocalTCal()
    {
        if (TotalSal <= 45000){
            LocalT= 0.015*TotalSal;
        }
        else{
            LocalT= 0.015*45000;
        }
        return LocalT;
    }
/*
    double FederalTCal()
    {

    }

    double StateTCal()
    {

    }
*/



    public static void main(String[] args)
    {
        //Employer clerk = new Employer ( );
        Worker worker;
        int count;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of employees:");
        int numberOfWorkers = scan.nextInt();
        for (count = 1; count <= numberOfWorkers; count++)
        {
            worker = new Worker ();
            System.out.println("Enter data for worker number " + count);
            worker.readInput();
            //worker.calculateData();
            worker.writeOutput( );
            //clerk.colectDataForEmployerReport(worker);
        }
        //clerk.printDataForEmployerReport();
    }







}
