public class EmpWageComputation
{
	public static final int IS_FULL_TIME=1;
	public static final int IS_PART_TIME=2;

	private final String company;
	private final int empRatePerHour;
	private final int numWorkingDays;
	private final int maxWorkingHrs;
	private int totalEmpWage;

	public EmpWageComputation(String company, int empRatePerHour, int numWorkingDays, int maxWorkingHrs)
	{
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numWorkingDays = numWorkingDays;
		this.maxWorkingHrs = maxWorkingHrs;
	}

	public void computeEmpWage()
	{
		int empHrs, totalEmpHrs=0, totalWorkingDays=0;
                while ( totalEmpHrs <= maxWorkingHrs && totalWorkingDays < numWorkingDays )
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
                totalEmpWage = totalEmpHrs * empRatePerHour;
	}

	public String toString()
	{
		return "Total Emp Wage for Company: " + company + " is " + totalEmpWage;
	}

	public static void main(String[] args)
	{
		EmpWageComputation dMart = new EmpWageComputation("DMart",20,2,10);
		EmpWageComputation reliance = new EmpWageComputation("Reliance",10,4,20);
		dMart.computeEmpWage();
		System.out.println(dMart);
		reliance.computeEmpWage();
		System.out.println(reliance);
	}

}
