package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.time.Instant;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.LogEntry;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the path file here: ");
		String path = sc.nextLine();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			Set<LogEntry> set = new HashSet<>(); //Foi utilizado o Hash por ser mais rápido e pelo fato do exercicio não pedir ordem de busca
			
			String line = br.readLine();
			
			while(line != null) {
				String[] fields = line.split(" ");
				String username = fields[0];
				Date date = Date.from(Instant.parse(fields[1])); // Lê-se "Data do instante.parse, passando o segundo campo como argumento".
				
				set.add(new LogEntry(username, date));
				
				line = br.readLine();
			}
			System.out.println("Total users: " + set.size());
		}
		catch(IOException e){
			System.out.println("Error: " + e.getMessage());
		}
		
		sc.close();
		
	}

}
