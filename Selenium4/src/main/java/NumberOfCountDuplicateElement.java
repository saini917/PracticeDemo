import java.util.ArrayList;

public class NumberOfCountDuplicateElement {

	static int duplicateArray[] = { 4, 5, 5, 5, 4, 6, 6, 6, 9, 4, 10 };
	static ArrayList<Integer> a1 = new ArrayList<Integer>();
	static int index_length;
	static int index_size;

	public static void main(String[] args) {

		for (index_length = 0; index_length < duplicateArray.length; index_length++) {

			int countOfDulicateElement = 0;

			if (!a1.contains(duplicateArray[index_length])) {
				a1.add(duplicateArray[index_length]);
				countOfDulicateElement++;

				for (index_size = index_length + 1; index_size < duplicateArray.length; index_size++) {
					if (duplicateArray[index_length] == duplicateArray[index_size]) {
						countOfDulicateElement++;
					}
				}

				System.out.println(duplicateArray[index_length]);
				System.out.println(countOfDulicateElement);

			}

			if (countOfDulicateElement == 1) {
				System.out.println(duplicateArray[index_length] + " is unique elemet");
			}

		}

	}

}
