import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Problem23 {
	
	public static boolean isAbundant(int num) {
		int sum = 0;
		for(int i = 1; i < num; i++){
			if(num % i == 0) 
				sum += i;
		}
		if(sum > num) return true;
		else return false;
	}
	
	

	public static void main(String[] args) {
	
		ArrayList<Integer> listofAbundant = new ArrayList<Integer>();
		
		for(int i=12; i<28123; i++){  //초과수 구해서 저장 
			if(isAbundant(i)){
				listofAbundant.add(i);
			}
		}
		
		// 초과수 두개의 합을 구해서 저장
		HashSet<Integer> sum_data = new HashSet<Integer>();
		for(int i=0; i<listofAbundant.size(); i++){
			for(int j=0; j<listofAbundant.size(); j++){
				sum_data.add(listofAbundant.get(i) + listofAbundant.get(j));
			}
		}
		
		// 초과수 두개의 합 목록을 정렬
		ArrayList<Integer> sum_data_sorted = new ArrayList<Integer>();
		sum_data_sorted.addAll(sum_data);
		Collections.sort(sum_data_sorted);	  

		// 두개의 합으로 나타낼수 없는 수를 구하고 다 더하기
		int result = 0;
		int last_limit = 0;
		for(Integer limit : sum_data_sorted){
			if(limit > 28123) break;
			for(int n=last_limit+1; n<limit; n++){
				result += n;
			}			
			last_limit = limit;
		}
		System.out.println(result);

	}

}









