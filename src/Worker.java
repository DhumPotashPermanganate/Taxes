import java.util.Scanner;

public class Worker
{
    private String Fname, Lname;
    private double dependents, hourly_rate, numberHours, LocalT, FederalT, StateT, TotalSal, LocalTWTD, FederalTWTD, StateTWTD;
    public Worker()
    {
        Fname="";
        Lname="";
        dependents=0;
        hourly_rate=0;
        numberHours=0;
        LocalT=0;
        FederalT=0;
        StateT=0;
        LocalTWTD=0;
        StateTWTD=0;
        FederalTWTD=0;

        TotalSal= hourly_rate*numberHours;
    }

    public void writeOutput()
    {
        System.out.println("Worker: "+ this.Fname+ " "+ this.Lname);
        System.out.println("One Week: "+ this.numberHours);
        System.out.println("Amount per Hour: "+ this.hourly_rate);
        System.out.println("Total for one week:\t\t\t" + TotalSal);
        System.out.println("\t\tCurrent\t\tYr.To Date");
        double buffer1=FederalTCal()+this.FederalTWTD;
        System.out.println("Federal\t\t"+FederalTCal()+"\t\t"+buffer1);
        double buffer2= StateTCal()+this.StateTWTD;
        System.out.println("State\t\t"+StateTCal()+"\t\t"+buffer2);
        double buffer3=LocalTCal()+this.LocalTWTD ;
        if (buffer3>517.50)
            buffer3=517.50;
        System.out.println("Local\t\t"+LocalTCal()+"\t\t"+buffer3);



        /*
        System.out.println("First name: "+ this.Fname);
        System.out.println("Last name: "+ this.Lname);
        System.out.println("Dependents: "+ this.dependents);


        //

        //System.out.println("State Tax to be paid: " + StateTCal());
        */
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
        System.out.println("Local tax withheld to date: ");
        this.LocalTWTD=sc.nextDouble();
        System.out.println("Federal tax withheld to date");
        this.FederalTWTD=sc.nextDouble();
        System.out.println("State tax withheld to date");
        this.StateTWTD=sc.nextDouble();

        if (numberHours <= 40) {
            TotalSal = this.numberHours * this.hourly_rate;
        }

        else{
            double overtime= (numberHours-40)*(1.50);
            TotalSal= (overtime+40)*hourly_rate;
        }
    }

    double LocalTCal()
    {
        if (TotalSal <= 45000){
            LocalT= 0.0115*TotalSal;
        }
        else{
            LocalT= 0.0115*45000;
        }
        return LocalT;
    }

    double FederalTCal()
    {
        double yearly= TotalSal*52;

        if (yearly >= 0 && yearly <=20000)
            this.FederalT= (TotalSal- (this.dependents*15))*0.1;
        else if(yearly>20000 && yearly<=30000)
            this.FederalT= (TotalSal- (this.dependents*15))*0.2;
        else
            this.FederalT= (TotalSal- (this.dependents*15))*0.3;

        return FederalT;
    }

    double StateTCal()
    {
        double yearly= TotalSal*52;
        if (yearly >= 0 && yearly <=30000)
            StateT= TotalSal*0.05;
        else
            StateT= TotalSal*0.1;
        return StateT;
    }

    void calculateData()
    {
        StateTCal();
        FederalTCal();
        LocalTCal();

    }


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
            worker.calculateData();
            worker.writeOutput( );
            //clerk.colectDataForEmployerReport(worker);
        }
        //clerk.printDataForEmployerReport();
    }







}
