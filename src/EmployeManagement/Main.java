package EmployeManagement;

public class Main {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("hello");

		//EmployeManagement employeManagement = new EmployeManagement();

		// <<------- adding developer and manager in database ----->>

		/*
		 * employeManagement.addDevelopersInDatabase(new Developer(121, "premz",
		 * 999999.0)); employeManagement.addDevelopersInDatabase(new Developer(122,
		 * "sakshiz", 500000.0));
		 * 
		 * 
		 * employeManagement.addManagersInDatabase(new Manager(111, "Boss",100000.0));
		 * 
		 * employeManagement.addManagersInDatabase(new Manager(112, "Shet",100000.0));
		 */

		// <<------- removing developer and manager in database ----->>

		/*
		 * employeManagement.removeDeveloperInDatabase(122);
		 * employeManagement.removeManagerInDatabase(112);
		 */

		// <<------- show data developer and manager ----->>

		/*
		 * employeManagement.showDataDeveloperInDatabase();
		 * employeManagement.showDataManagerInDatabase();
		 */

		// <<------- update name & salary ,developer and manager ----->>

		/*
		 * employeManagement.updateNameDeveloper(121, "Prem Lond");
		 * employeManagement.updateSalaryDeveloper(121, 999.0);
		 * 
		 * employeManagement.updateNameManager(111, "Happy Boss");
		 * employeManagement.updateSalaryManager(111, 1999.0);
		 */
	}

}
