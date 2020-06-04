import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {

	//Verify if Sum of all Course prices matches with Purchase Amount
	@Test
	public void sumOfcourses(){
		int sum=0;
		JsonPath js = new JsonPath(payload.coursePrice());
		int count = js.getInt("courses.size()");
		for (int i = 0; i < count; i++) {
			int price=js.getInt("courses[" + i + "].price");
			int copies=js.getInt("courses[" + i + "].copies");
			int amount=price * copies;
			System.out.println(amount);
			sum = sum + amount;
		}
		System.out.println("Total purchase amt: "+sum);
		int purchaseAmount=js.getInt("dashboard.purchaseAmount");
		assertEquals(sum, purchaseAmount);
		
	}

}
