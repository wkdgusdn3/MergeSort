import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MergeSort {

	// array를 2개의 array로 나누고, combineArray 메소드를 통하여 merge를 하는 메소드
	ArrayList<Integer> divideArray(ArrayList<Integer> array) {

		ArrayList<Integer> array1;
		ArrayList<Integer> array2;

		if (array.size() != 1) { // array의 원소가 2개이상이면
			// array의 좌측 수열을 재귀함수로 호출
			array1 = divideArray(new ArrayList<Integer>(array.subList(0, (array.size() - 1) / 2 + 1)));
			// array의 우측 수열을 재귀함수로 호출
			array2 = divideArray(new ArrayList<Integer>(array.subList((array.size() - 1) / 2 + 1, array.size())));

		} else { // array의 원소가 1개 이상이면
			return array; // 원소 1개를 가진 array를 반환
		}

		return combineArray(array1, array2); //
	}

	// 두개의 array를 merge 해주는 메소드
	ArrayList<Integer> combineArray(ArrayList<Integer> array1, ArrayList<Integer> array2) {

		ArrayList<Integer> newArray = new ArrayList<Integer>();

		int i = 0;
		int j = 0;

		while (i < array1.size() || j < array2.size()) {

			if (i >= array1.size()) { // array1의 모든 원소가 정렬됬을 경우
				newArray.add(array2.get(j)); // newArray에 array2의 첫번째 넣는다.
				j++;
			} else if (j >= array2.size()) { // array2의 모든 원소가 정렬됬을 경우
				newArray.add(array1.get(i)); // newArray에 array1의 첫번째 원소를 넣는다.
				i++;
			} else {
				if (array1.get(i) > array2.get(j)) { // array1의 첫번째 원소가 array2의
														// 첫번째 원소보다 클 경우
					newArray.add(array2.get(j)); // newArray에 array2의 첫번째 넣는다.
					j++;
				} else { // array1의 비교 원소가 array2의 비교 원소보다 작을 경우
					newArray.add(array1.get(i)); // newArray에 array1의 첫번째 원소를
													// 넣는다.
					i++;
				}
			}
		}

		return newArray; // 정렬된 array를 반환
	}
	
	void print(ArrayList<Integer> array) {
//		 정렬 된 순열을 출력해준다.
		System.out.print("정렬된 수 : ");
		
		for (int i = 0; i < array.size(); i++) {
			System.out.print(array.get(i) + " ");
			if ((i + 1) % 100 == 0) { // 줄바꿈을 위한 코드
				System.out.println("");
			}
		}
		System.out.println("");
	}
}
