interface IComputeEmpWage
{
	public void addCompanyEmpWage(String company, int empRatePerHour, int numWorkingDays, int maxWorkingHrs);
	public void computeEmpWage();
}

class CompanyEmpWage
{
	public final String company;
        public final int empRatePerHour;
        public final int numWorkingDays;
        public final int maxWorkingHrs;
        public int totalEmpWage;

	public CompanyEmpWage(String company, int empRatePerHour, int numWorkingDays, int maxWorkingHrs)
        {
                this.company = company;
                this.empRatePerHour = empRatePerHour;
                this.numWorkingDays = numWorkingDays;
                this.maxWorkingHrs = maxWorkingHrs;
        }

	public void setTotalEmpWage(int totalEmpWage)
	{
		this.totalEmpWage = totalEmpWage;
	}

	public String toString()
        {
                return "Total Emp Wage for Company: " + company + " is " + totalEmpWage;
        }

}

public class EmpWageComputation implements IComputeEmpWage
{
	public static final int IS_FULL_TIME=1;
	public static final int IS_PART_TIME=2;

	private int numOfCompany = 0;
	private CompanyEmpWage[] companyEmpWageArray;

	public EmpWageComputation()
	{
		companyEmpWageArray = new CompanyEmpWage[5];
	}

	public void addCompanyEmpWage(String company, int empRatePerHour, int numWorkingDays, int maxWorkingHrs)
	{
		companyEmpWageArray[numOfCompany] = new CompanyEmpWage(company, empRatePerHour, numWorkingDays, maxWorkingHrs);
		numOfCompany++;
	}

	public void computeEmpWage()
	{
		for ( int i = 0; i < numOfCompany; i++ )
		{
			companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
			System.out.println(companyEmpWageArray[i]);
		}
	}

	public int computeEmpWage(CompanyEmpWage companyEmpWage)
	{
		int empHrs, totalEmpHrs=0, totalWorkingDays=0;
                while ( totalEmpHrs <= companyEmpWage.maxWorkingHrs && totalWorkingDays < companyEmpWage.numWorkingDays )
                {
                        totalWorkingDays++;
                        int empCheck=(int)Math.floor(Math.random()*10)%3;
                        switch (empCheck)
                        {
                                case IS_FULL_TIME:
                                        empHrs=8;
                                        break;
                                case IS_PART_TIME:
                                        empHrs=4;
                                        break;
                                default:
                                        empHrs=0;
                        }
                        totalEmpHrs += empHrs;
                        System.out.println("Day" + totalWorkingDays + " Emp Hr: " +empHrs);
                }
                return totalEmpHrs * companyEmpWage.empRatePerHour;
	}

	public static void main(String[] args)
	{
		EmpWageComputation empWageComputation = new EmpWageComputation();
		empWageComputation.addCompanyEmpWage("DMart",20,2,10);
		empWageComputation.addCompanyEmpWage("Reliance",10,4,20);
		empWageComputation.computeEmpWage();
	}

}
