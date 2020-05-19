package Com.adressbook;
import java.util.*;
public class Person extends Address
{
	Scanner in=new Scanner(System.in);
	private String firstName;
	private String lastName;
	private long phoneNumber;
	public Scanner getIn() {
		return in;
	}
	public void setIn(Scanner in) {
		this.in = in;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
