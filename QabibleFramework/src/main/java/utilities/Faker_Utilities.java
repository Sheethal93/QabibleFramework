package utilities;

import com.github.javafaker.Faker;

public class Faker_Utilities {
	public String getFakeFirstName() {

		Faker faker = new Faker();  

		String firstName = faker.name().firstName();
		return firstName;

		}
		public String getFakeSecondName() {

		Faker faker = new Faker();
		 
		String lastName = faker.name().lastName();
		return lastName;

		}

		public String getFakeEmailID() {    

		Faker faker = new Faker();
		 
		String email = faker.internet().emailAddress();
		
	
		return email;

		}


}
