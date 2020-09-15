public class EmpWageComputation
{
	public static final int IS_FULL_TIME=1;
	public static final int IS_PART_TIME=2;
	public static final int EMP_RATE_PER_HOUR=20;
	public static final int NUM_WORKING_DAYS=20;
	public static final int MAX_WORKING_HRS=100;
	public static void main(String[] args)
	{
		int empHrs, totalEmpWage, totalEmpHrs=0, totalWorkingDays=0;
		System.out.println("Welcome to Employee Wage Computation Program on Master Branch");
		while ( totalEmpHrs <= MAX_WORKING_HRS && totalWorkingDays < NUM_WORKING_DAYS )
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
			if (totalEmpHrs > 96)
			{
				if (empHrs==8 || empHrs==4)
				{
					break;
				}
			}
			if (totalEmpHrs > 92 )
			{
				if (empHrs==8)
				{
					break;
				}
			}
			totalEmpHrs += empHrs;
			System.out.println("Day" + totalWorkingDays + " Emp Hr: " +empHrs);
		}
		totalEmpWage = totalEmpHrs * EMP_RATE_PER_HOUR;
		System.out.println("Total Emp Hour: " + totalEmpHrs);
		System.out.println("Total Emp Wage: " + totalEmpWage);
	}
}
