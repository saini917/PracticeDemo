import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {

	
	//using json online editor
	public static void main(String str[]) {
		JsonPath js = new JsonPath(payload.coursePrice());

		// Print No of courses returned by API
		int count = js.getInt("courses.size()");
		System.out.println("Number of courses: " + count);

		// Print Purchase Amount
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println("Total Purchase Amount: " + totalAmount);

		// Print Title of the first course
		String title = js.get("courses[0].title");
		System.out.println("First course title: " + title);

		// Print All course titles and their respective Prices
		for (int i = 0; i < count; i++) {
			System.out.println(js.get("courses[" + i + "].title").toString());
			System.out.println(js.get("courses[" + i + "].price").toString());
		}

		// Print no of copies sold by RPA Course
		System.out.println("Print no of copies sold by RPA Course");
		for (int i = 0; i < count; i++) {
			String courseTitles=js.get("courses[" + i + "].title");
			if(courseTitles.equalsIgnoreCase("RPA")){
				//copies sold
				int copies=js.get("courses[" + i + "].copies");
				System.out.println(copies);
				break;
				  
			}
		}
	}

}


