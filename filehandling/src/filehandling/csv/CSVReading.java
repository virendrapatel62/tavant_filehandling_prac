package filehandling.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReading {

	public static void main(String[] args) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader("data.csv"));
		
		String line = null ;
		Scanner scanner = null;
		List<Employee> employees = new ArrayList<Employee>();
		
		while((line = bufferedReader.readLine())!=null) {
			String[] record = line.split(",");
			Employee employee = new Employee();
			
			
			scanner = new Scanner(line);
			scanner.useDelimiter(",");
			int index = 0 ;
			while(scanner.hasNext()) {
				String data = scanner.next();
				switch (index) {
				case 0:
					employee.setSno(Integer.parseInt(data));
					break;
				case 1:
					employee.setName(data);
					break;
				case 2:
					employee.setSalary(Float.parseFloat(data));
					break;
				
				}
				index++;
			}
			index = 0;
			
			employees.add(employee);
			
		}
		
		System.out.println(employees);
		
	}
}
