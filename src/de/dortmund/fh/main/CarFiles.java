package de.dortmund.fh.main;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.time.Year;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import de.dortmund.fh.model.Car;

public class CarFiles {

	public static void main(String[] args) {

		// Create car objects and store it in array

		Car[] carArray = new Car[7];
		Car car1 = new Car("1", "BMW", "i5", 2010, "Black", 30000, "GMV5");
		Car car2 = new Car("2", "MERCEDES", "C", 2010, "Black", 40000, "GMV5");
		Car car3 = new Car("3", "BMW", "i5", 2010, "Black", 50000, "GMV5");
		Car car4 = new Car("4", "MERCEDES", "C", 2012, "Black", 60000, "GMV5");
		Car car5 = new Car("5", "BMW", "i5", 2010, "Black", 70000, "GMV5");
		Car car6 = new Car("6", "MERCEDES", "C", 2023, "Black", 80000, "GMV5");
		Car car7 = new Car("7", "BMW", "i5", 2023, "Black", 90000, "GMV5");
		carArray[0] = car1;
		carArray[1] = car2;
		carArray[2] = car3;
		carArray[3] = car4;
		carArray[4] = car5;
		carArray[5] = car6;
		carArray[6] = car7;

		// Defining Inputs
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the brand of the car to filter");
		String brandName = scan.nextLine();
		System.out.println("Please enter the model of the car to filter");
		String model = scan.nextLine();
		System.out.println("Please enter the years of usage of the car to filter");
		int numOfUse = scan.nextInt();
		System.out.println("Please enter the year of manufacture of the car to filter");
		int manufacture = scan.nextInt();
		System.out.println("Please enter the price of the car to filter");
		int price = scan.nextInt();
		scan.close();

		// Filtering the list

		List<Car> brandList = Arrays.asList(carArray).stream().filter(c -> c.getMake().equalsIgnoreCase(brandName))
				.collect(Collectors.toList());
		List<Car> modelList = Arrays.asList(carArray).stream().filter(c -> c.getModel().equalsIgnoreCase(model)
				&& (numOfUse < Year.now().getValue() - c.getYearOfManufacture())).collect(Collectors.toList());
		List<Car> manufactureList = Arrays.asList(carArray).stream()
				.filter(c -> c.getYearOfManufacture() == manufacture && (price < c.getPrice()))
				.collect(Collectors.toList());

		// Save the Lists to files
		System.out.println("Saving the results to files");
		try {
			ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("brandNameFilter.txt"));
			oos1.writeObject(brandList);
			oos1.flush();
			oos1.close();
			ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream("modelNameFilter.txt"));
			oos2.writeObject(modelList);
			oos2.flush();
			oos2.close();
			ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream("manufactureFilter.txt"));
			oos3.writeObject(manufactureList);
			oos3.flush();
			oos3.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
