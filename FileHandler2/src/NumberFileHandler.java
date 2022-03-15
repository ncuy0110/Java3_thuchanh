import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberFileHandler {
	private List<Integer> numbers;
	private String filePath;
	private String filename;
	public NumberFileHandler(String filename) {
		this.filename = filename;
		numbers = new ArrayList<Integer>();
		filePath = System.getProperty("user.dir") + "/src/";
	}
	public void readFileNumberByNumber() throws IOException {
		Path path = Paths.get(filePath + filename);
		Scanner scanner = new Scanner(path);
		
		while(scanner.hasNext()) {
			if(scanner.hasNextInt()) {
				int k = scanner.nextInt();
				numbers.add(k);
			}else {
				scanner.nextLine();
			}
		}
	}
	
	public void readFileLineByLine() throws IOException {
		FileReader fr = new FileReader(filePath + filename);
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		
		String[] result = line.split(" ");

		for(int i=0; i<result.length; i++) {
			numbers.add(Integer.parseInt(result[i]));
		}

	}
	
	public void swap(int x, int y) {
		int temp = numbers.get(x);
		numbers.set(x, numbers.get(y));
		numbers.set(y, temp);
	}
	
	public void sortDecs() {
		int size_ = numbers.size();
		for(int i=0; i<size_ - 1; i++) {
			for(int j=i+1; j<size_; j++) {
				if(numbers.get(i) < numbers.get(j)) {
					swap(i, j);
				}
			}
		}
	}
	
	
	
	public void writeToFile() throws IOException {
		FileWriter fw = new FileWriter(filePath + "output.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		numbers.forEach(number -> {
			try {
				bw.write(number + " ");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		bw.flush();
		bw.close();
	}
	
	public static void main(String[] args) throws IOException {
		NumberFileHandler nfh = new NumberFileHandler("numbers.txt");
		nfh.readFileLineByLine();
		nfh.sortDecs();
		nfh.writeToFile();
	}
}
