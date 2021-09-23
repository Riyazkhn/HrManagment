package defaultpackage1;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.model.Department;
import com.model.Employee;
import com.service.DepartmentService;
import com.service.DepartmentServiceImplements;
import com.service.EmployeeService;
import com.service.EmployeeServiceImplements;

public class Client {
	static String str;

	public static boolean isValidations(String mobilenumber) {
		Pattern pattern = Pattern.compile(("(0/91)?[7-9][0-9]{9}"));
		Matcher match = pattern.matcher(mobilenumber);
		return (match.find() && match.group().equals(mobilenumber));
	}

	public static boolean isValidationsCharacter(String employeeName) {
		Pattern pattern = Pattern.compile(("[a-zA-Z0-9 ]*"));
		Matcher match = pattern.matcher(employeeName);
		return (match.find() && match.group().equals(employeeName));
	}

	public static boolean isValidationsEmail(String email) {
		Pattern pattern = Pattern.compile("^(.+)@(.+)$");
		Matcher match = pattern.matcher(email);
		return (match.find() && match.group().equals(email));

	}

	public static void main(String[] args) {

		DepartmentService departmentservice = new DepartmentServiceImplements();
		EmployeeService employeeservice = new EmployeeServiceImplements();
		Scanner sc = new Scanner(System.in);
		System.out.println("***********HR Mangement System**************");
		System.out.println("*********Admin Login************");
		System.out.println("Enter Username: ");
		String userName = sc.next();
		System.out.println("Enter Password: ");
		String password = sc.next();
		if (userName.equals("Admin") && password.equals("Admin")) {
			System.out.println("*******Authentication  Successfully done!*******");
			System.out.println("*********Welcome********");
			do {

				System.out.println(
						"1.EmployeeDetails\t" + "\n" + "2.Add Employee\t" + "\n" + "3.Update Employee Details" + "\n"
								+ "4.Delete Employee\t" + "\n" + "5.SearchEmployeebyId\t" + "\n" + "6.Add Department"
								+ "\n" + "7.DepartmentNamebyCount" + "\n" + "8.List of Employee from department");

				System.out.println("\nEnter your choice: ");
				int choice = sc.nextInt();

				List<Employee> list = employeeservice.getAllEmployee();
				Iterator<Employee> itr = list.iterator();
				switch (choice) {

				case 1:
					System.out.println("********** All Employee Details *****");
					while (itr.hasNext()) {
						Employee employee = itr.next();
						System.out.println("EmployeeId: " + employee.getEmployeeId());
						System.out.println("EmployeeName: " + employee.getEmployeeName());
						System.out.println("EmployeeSalary: " + employee.getEmployeeSalary());
						System.out.println("EmployeeAge: " + employee.getEmployeeAge());
						System.out.println("EmployeeAddress: " + employee.getEmployeeAddress());
						System.out.println("Department Id: " + employee.getDepartmentId());
						System.out.println(("RoleId: " + employee.getRoleId()));
						System.out.println(("MobileNumber" + employee.getMobileNumber()));
						System.out.println(("Email" + employee.getEmail()));
						System.out.println("***********_________________********");
					}
					break;

				case 2:

					System.out.println("");
					System.out.println("********Enter Employee Information******");
					System.out.println("Enter Employeeid: ");
					int employeeId = sc.nextInt();
					System.out.println("Enter Employeename: ");
					String employeeName = sc.next();
					if (isValidationsCharacter(employeeName)) {

					} else {
						System.out.println("It contain special character which is invalid:");
						System.out.println("Please enter again employeename:  ");
						employeeName = sc.next();
					}
					System.out.println("Enter EmployeeSalary: ");
					int employeesalary = sc.nextInt();
					System.out.println("Enter EmployeeAge: ");
					int employeeAge = sc.nextInt();
					System.out.println("Enter EmployeeAddress: ");
					String employeeAddress = sc.next();
					System.out.println("Enter Departmentid: ");
					int departmentId = sc.nextInt();
					System.out.println("Enter role id: ");
					int roleId = sc.nextInt();
					System.out.println("Enter Employee Mobilenumber ");
					String mobileNumber = sc.next();
					if (isValidations(mobileNumber)) {

					} else {
						System.out.println("Enter mobile number is invalid");
						System.out.println("Please enter again:  ");
						mobileNumber = sc.next();
					}
					System.out.println("Enter Employee Email:");
					String email = sc.next();
					if (isValidationsEmail(email)) {
						System.out.println();
					} else {
						System.out.println("Enter Email is invalid: ");
						System.out.println("Please enter again:  ");
						email = sc.next();
					}
					Employee employee = new Employee(employeeId, employeeName, employeesalary, employeeAge,
							employeeAddress, departmentId, roleId, mobileNumber, email);
					int status = employeeservice.insertEmployee(employee);
					if (status > 0) {
						System.out.println("row  added successfully: " + status);
					} else {
						System.out.println("unable to added employee");
					}
					break;

				case 3:

					System.out.println("*********Update Employee Information******");
					System.out.println("Enter EmployeeId to be updated: ");
					int employeeId1 = sc.nextInt();
					System.out.println("Enter EmployeeName to be updated: ");
					String employeeName1 = sc.next();
					if (isValidationsCharacter(employeeName1)) {

					} else {
						System.out.println("It contain special character which is invalid:");
						System.out.println("Please enter again employeename:  ");
						employeeName1 = sc.next();
					}
					System.out.println("Enter EmployeeSalary to be updated: ");
					int employeeSalary1 = sc.nextInt();
					System.out.println("Enter EmployeeAge to be updated: ");
					int employeeAge1 = sc.nextInt();
					System.out.println("Enter EmployeeAddress to be updated: ");
					String employeeAddress1 = sc.next();
					System.out.println("Enter Department id to be updated: ");
					int departmnetId1 = sc.nextInt();
					System.out.println("Enter Role id to be updated");
					int roleId1 = sc.nextInt();
					System.out.println("Enter MobileNumber to be updated: ");
					String mobileNumber1 = sc.next();
					if (isValidations(mobileNumber1)) {

					} else {
						System.out.println("*********Enter mobile number is invalid********");
						System.out.println("Please enter again:  ");

						mobileNumber1 = sc.next();

					}
					System.out.println("Enter Email to be updated");
					String email1 = sc.next();
					if (isValidationsEmail(email1)) {

					} else {
						System.out.println("Enter Email is invalid: ");
						System.out.println("Please enter again:  ");
						email1 = sc.next();
					}
					Employee employee1 = new Employee(employeeId1, employeeName1, employeeSalary1, employeeAge1,
							employeeAddress1, departmnetId1, roleId1, mobileNumber1, email1);
					boolean statusupdate = employeeservice.updateEmployee(employee1);
					if (statusupdate) {
						System.out.println("Employee update successfully");
					} else {
						System.out.println("Enable to update employee ");
					}

					break;
				case 4:
					System.out.println("********* Delete Employee Details*********** ");
					System.out.println("Enter Employee id to be Deleted");
					int employeeId2 = sc.nextInt();
					int statusdelete = employeeservice.deleteEmployee(employeeId2);
					if (statusdelete > 0) {
						System.out.println("row deleted successfully: " + statusdelete);
					} else {
						System.out.println("Unable to delete employee details");
					}
					break;
				case 5:
					System.out.println("*************Search by employee id********************");
					System.out.println("Enter employee id");
					int employeeid3 = sc.nextInt();
					Employee employeedetails = employeeservice.searchEmployeebyId(employeeid3);
					if (employeedetails != null) {
						System.out.println("Employee id:  " + employeedetails.getEmployeeId());
						System.out.println("Employee name: " + employeedetails.getEmployeeName());
						System.out.println("Employee salary: " + employeedetails.getEmployeeSalary());
						System.out.println("Employee Age: " + employeedetails.getEmployeeAge());
						System.out.println(("Employee Address: " + employeedetails.getEmployeeAddress()));
						System.out.println("Department Id:  " + employeedetails.getDepartmentId());
						System.out.println("Role Id: " + employeedetails.getRoleId());
						System.out.println("Mobile Number: " + employeedetails.getMobileNumber());
						System.out.println("Email : " + employeedetails.getEmail());
					} else {
						System.out.println("Employee record is not available");
					}
					break;
				case 6:
					System.out.println("");
					System.out.println("********Enter Department information**********");
					System.out.println("Enter Department Id");
					int departmentId2 = sc.nextInt();
					System.out.println("Enter Department Name");
					String departmentName2 = sc.next();
					System.out.println("Enter the Department Locations");
					String departmentLocation = sc.next();
					Department department = new Department(departmentId2, departmentName2, departmentLocation);
					int statusDepartment = departmentservice.insertDepartment(department);
					if (statusDepartment > 0) {
						System.out.println("Department record Added Successfully");
					} else {
						System.out.println("Unable to add department details");
					}
					break;
				case 7:

					System.out.println("**********Strength of Department********");
					System.out.println("***Count according to departmentname***");
					employeeservice.departmentWiseEmployeeCount();
					break;

				case 8:
					System.out.println("List of employee for department by Id");
					System.out.println("Enter Department id: ");
					int employeeid4 = sc.nextInt();
					List<Employee> employeelist = employeeservice.departmentHaveEmployee(employeeid4);
					for (Employee departmentRecord : employeelist) {
						if (departmentRecord != null) {
							System.out.println("Employee id:  " + departmentRecord.getEmployeeId());
							System.out.println("Employee name: " + departmentRecord.getEmployeeName());
							System.out.println("Employee salary: " + departmentRecord.getEmployeeSalary());
							System.out.println("Employee Age: " + departmentRecord.getEmployeeAge());
							System.out.println(("Employee Address: " + departmentRecord.getEmployeeAddress()));
							System.out.println("Department Id:  " + departmentRecord.getDepartmentId());
							System.out.println("Role Id: " + departmentRecord.getRoleId());
							System.out.println("Mobile Number: " + departmentRecord.getMobileNumber());
							System.out.println("Email : " + departmentRecord.getEmail());
							System.out.println("______________________________________________");
						} else {
							System.out.println("Employee record is not available");
						}
					}
				}

				System.out.println();
				System.out.println("Do you wish to continue(y/n)?");
				str = sc.next();
			} while (str.equals("y") || str.equals("Y"));
		} else {
			System.out.println("Authentication Failed Wrong Username and Password");
		}

	}
}
