package p1MainClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import dataGenerator.DataReader;
import setIntersectionFinders.AbstractIntersectionFinder;
import setIntersectionFinders.IntersectionFinder_P1P2;
import setIntersectionFinders.IntersectionFinder_P2;
import setIntersectionFinders.IntersectionFinder_P3;
public class Part1Main {
	public static <E> void main(String[] args) throws FileNotFoundException, CloneNotSupportedException {

		int param, company, crime;

		String parentDirectory = "inputFiles";
		Scanner parameters = new Scanner(new File(parentDirectory, "parameters.txt"));
		crime = parameters.nextInt();
		company = parameters.nextInt();

		parameters.close();

		Integer[][][] dr = new Integer[company][crime][5000];

		for (int i = 0; i < company; i++) {
			for (int j = 0; i < crime; j++) {
				Scanner file = new Scanner(new File("inputFiles/F_" + i + "_" + j + ".txt"));
				int l = 0;
				while (file.hasNext()) {
					String next = file.nextLine();
					int nextin = Integer.parseInt(next);
					dr[i][j][l] = nextin;
					l++;
				}
			}
		}
		
		if (args.length > 1) {
			System.out.println("Unexpected number of parameters. Must be <= 1.");
			return;
		}
		if (args.length == 1)
			param = Integer.parseInt(args[0]);
		String x = "0";
		
		AbstractIntersectionFinder<E> p1 = new IntersectionFinder_P1P2<E>("p1");
		AbstractIntersectionFinder<E> p2 = new IntersectionFinder_P1P2<E>("p2");
		AbstractIntersectionFinder<E> p3 = new IntersectionFinder_P2<E>();
		AbstractIntersectionFinder<E> p4 = new IntersectionFinder_P3<E>();
		
		if ((x == "1") || (x == "0"))
			System.out.println("The Final Set by P1: " + p1.intersectSets(p1.createSets2(dr)).toString());
		if ((x == "2") || (x == "0"))
			System.out.println("The Final Set by P1: " + p2.intersectSets(p1.createSets2(dr)).toString());
		if ((x == "3") || (x == "0"))
			System.out.println("The Final Set by P1: " + p3.intersectSets(p1.createSets2(dr)).toString());
		if ((x == "4") || (x == "0"))
			System.out.println("The Final Set by P1: " + p4.intersectSets(p1.createSets2(dr)).toString());

	}
}