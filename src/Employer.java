public class Employer 
{
    Worker worker= new Worker();
    public double Fed=0, Loc=0, Stat=0, wag=0, ded=0, netp=0;
    <worker> void colectDataForEmployerReport(worker w)
    {
        Fed= Fed+ worker.FederalT;
        Loc= Loc+ worker.LocalT;
        Stat= Stat+ worker.StateT;
        wag= wag+worker.TotalSal;
        ded= ded+worker.netdeduct;
        netp= wag-ded;
    }

    void printDataForEmployerReport()
    {
        System.out.println("\t\tCurrent");
        System.out.println("Federal\t\t"+Fed);
        System.out.println("State\t\t"+Stat);
        System.out.println("Local\t\t"+Loc);
        System.out.println("Gross wages:\t\t\t\t"+wag);
        System.out.println("Total Deductions:\t\t\t\t"+ded);
        System.out.println("Net Pay: \t\t\t\t"+netp);
    }
}
