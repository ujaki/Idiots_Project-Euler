import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class Problem22 {
	
	public static int cal(int num, String str) {
		
		int sum = 0;
		int result = 0;
		
		for(int i = 0; i < str.length(); i++){
			sum += str.charAt(i) - 64;
		}
		
		result = num * sum;
		
		return result;
		
	}

	public static void main(String[] args) {
		
		try{
			BufferedReader in = new BufferedReader(new FileReader("names.txt")); //Read a file
			String s;  
			
			while((s = in.readLine()) != null){ //read string
				int result = 0;
				
				String[] split = s.split(","); //split by ","
				Arrays.sort(split, String.CASE_INSENSITIVE_ORDER); //sorting
				for(int i = 0; i < split.length; i++){
					String split_final = split[i].replaceAll("\"", ""); // remove ""
					result += cal(i + 1, split_final);
					
				}
				
				System.out.println(result);

			}
			
			in.close(); //stream close
			
		}catch(IOException e) {
			System.err.println(e);
			System.exit(1);
		}
		
		
	}

}
