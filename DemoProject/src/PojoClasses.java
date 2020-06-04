import static io.restassured.RestAssured.*;

public class PojoClasses {
	private String message;
	private String greet;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getGreet() {
		return greet;
	}

	public void setGreet(String greet) {
		this.greet = greet;
	}
	/*
	 * { "message" : "", "greet" : "" }
	 */

	public static void main(String str[]) {
		PojoClasses pojo = new PojoClasses();
		
		//serializatio concept --- when pojo class(java object) object value is converted into json/xml 
		pojo.setMessage("hello"); 
		pojo.setGreet("hi");
		
		//deserialization -- when json value response is converted into in pogo classes(java object)

	}

	/*
	 * { "message" : "hello", "greet" : "hi" }
	 */
	
	//rest assured
	/*given().
	         body(pojo).
	when().
	       post(/pojo)*/

}
