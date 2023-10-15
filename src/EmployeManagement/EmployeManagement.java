package EmployeManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeManagement {

	List<Developer> developers;
	List<Manager> managers;

	public EmployeManagement() {
		developers = new ArrayList<Developer>();
		managers = new ArrayList<Manager>();
	}

	/* add developers in arraylist */
	public void addDevelopersInArrayList(Developer developer) {
		developers.add(developer);
	}

	/* add managers in arraylist */
	public void addManagersInArrayList(Manager manager) {
		managers.add(manager);
	}

	/* remove developers in arraylist */
	public void removeDevelopersInArrayList(int id) {
		developers.removeIf(developer -> developer.getId() == id);
	}

	/* remove managers in arraylist */
	public void removeManagersInArrayList(int id) {
		managers.removeIf(manager -> manager.getId() == id);
	}

	/* return developer list */
	public List<Developer> getDevelopers() {
		return developers;
	}

	/* return manager list */
	public List<Manager> getManagers() {
		return managers;
	}

	/* add developers in database */
	public void addDevelopersInDatabase(Developer developer) throws Exception {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "premz@514.");

		PreparedStatement ps = con.prepareStatement("insert into dev values (?,?,?)");

		ps.setInt(1, developer.getId());
		ps.setString(2, developer.getName());
		ps.setDouble(3, developer.getSalary());

		int i = ps.executeUpdate();

		if (i > 0) {
			System.out.println("Successfully add Data in Developer Database" + developer.getId() + " "
					+ developer.getName() + " " + developer.getSalary());
		} else {
			System.out.println("fail to add data in Developer Database!!!");
		}

	}

	/* add managers in database */
	public void addManagersInDatabase(Manager manager) throws Exception {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "premz@514.");

		PreparedStatement ps = con.prepareStatement("insert into man values (?,?,?)");

		ps.setInt(1, manager.getId());
		ps.setString(2, manager.getName());
		ps.setDouble(3, manager.getSalary());

		int i = ps.executeUpdate();

		if (i > 0) {
			System.out.println("Successfully add Data in Manager Database" + manager.getId() + " " + manager.getName()
					+ " " + manager.getSalary());
		} else {
			System.out.println("Fail to add Data in Manager Database!!!");
		}
	}

	public void removeDeveloperInDatabase(int id) throws Exception {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "premz@514.");

		PreparedStatement ps = con.prepareStatement("delete from dev where id=(?)");

		ps.setInt(1, id);

		int i = ps.executeUpdate();

		if (i > 0) {
			System.out.println("Succesffuly remove data Developer which is id :" + id);
		} else {
			System.out.println("fail to remove data from database!!!");
		}

	}

	public void removeManagerInDatabase(int id) throws Exception {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "premz@514.");

		PreparedStatement ps = con.prepareStatement("delete from man where id=(?)");

		ps.setInt(1, id);

		int i = ps.executeUpdate();

		if (i > 0) {
			System.out.println("Succesffuly remove data Manager which is id :" + id);
		} else {
			System.out.println("fail to remove data from database!!!");
		}

	}

	public void showDataDeveloperInDatabase() throws Exception {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "premz@514.");

		PreparedStatement ps = con.prepareStatement("select * from dev");

		ResultSet rs = ps.executeQuery();

		System.out.println("Developer List ->");
		while (rs.next()) {
			System.out.println("Id     : " + rs.getInt("id"));
			System.out.println("Name   : " + rs.getString("name"));
			System.out.println("Salary : " + rs.getDouble("salary"));
			System.out.println("--------------------------------");

		}

	}

	public void showDataManagerInDatabase() throws Exception {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "premz@514.");

		PreparedStatement ps = con.prepareStatement("select * from man");

		ResultSet rs = ps.executeQuery();
		System.out.println("Manager List ->");
		while (rs.next()) {
			System.out.println("Id     : " + rs.getInt("id"));
			System.out.println("Name   : " + rs.getString("name"));
			System.out.println("Salary : " + rs.getDouble("salary"));
			System.out.println("--------------------------------");

		}

	}

	public void updateNameDeveloper(int id, String name) throws Exception {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "premz@514.");

		PreparedStatement ps = con.prepareStatement("update dev set name=(?) where id=(?)");
		
		ps.setString(1, name);
		ps.setInt(2, id);
		int i = ps.executeUpdate();

		if (i > 0) {
			System.out.println("Successfully updated " + name);
		} else {
			System.out.println("fail to update ");
		}
	}

	public void updateSalaryDeveloper(int id, double salary) throws Exception {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "premz@514.");

		PreparedStatement ps = con.prepareStatement("update dev set salary=(?) where id=(?)");

		ps.setDouble(1, salary);
		ps.setInt(2, id);
		int i = ps.executeUpdate();

		if (i > 0) {
			System.out.println("Successfully updated " + salary);
		} else {
			System.out.println("fail to update ");
		}
	}

	public void updateNameManager(int id, String name) throws Exception {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "premz@514.");

		PreparedStatement ps = con.prepareStatement("update man set name=(?) where id=(?)");
		
		ps.setString(1, name);
		ps.setInt(2, id);

		int i = ps.executeUpdate();

		if (i > 0) {
			System.out.println("Successfully updated " + name);
		} else {
			System.out.println("fail to update ");
		}
	}

	public void updateSalaryManager(int id, double salary) throws Exception {

		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp", "root", "premz@514.");

		PreparedStatement ps = con.prepareStatement("update man set salary=(?) where id=(?)");
		
		ps.setDouble(1, salary);
		ps.setInt(2, id);

		int i = ps.executeUpdate();

		if (i > 0) {
			System.out.println("Successfully updated " + salary);
		} else {
			System.out.println("fail to update ");
		}
	}
}
