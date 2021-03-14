package p1MainClasses;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import setIntersectionFinders.AbstractIntersectionFinder;
import setIntersectionFinders.IntersectionFinder_P1P2;
import setIntersectionFinders.IntersectionFinder_P2;
import setIntersectionFinders.IntersectionFinder_P3;

public class Part1Main {
	public static <E> void main(String[] args)  throws FileNotFoundException, CloneNotSupportedException {

		int company, crime;

		String parentDirectory = "inputFiles";
		Scanner parameters = new Scanner(new File(parentDirectory, "parameters.txt"));
		company = parameters.nextInt();
		crime = parameters.nextInt();

		parameters.close();

		Integer[][][] dr = new Integer[company][crime][5000];

		for (int i = 0; i < company; i++) {
			for (int j = 0; j < crime; j++) {
				Scanner inFile = new Scanner(new File("inputFiles/F_" + i + "_" + j + ".txt"));
				int l = 0;
				while (inFile.hasNext()) {
					String next = inFile.nextLine();
					int nextin = Integer.parseInt(next);
					dr[i][j][l] = nextin;
					l++;
				}
			}
		}

		if (args.length > 0) {
			System.out.println("Unexpected number of parameters. Must be <= 1.");
			return;
		}

		AbstractIntersectionFinder<E> p1 = new IntersectionFinder_P1P2<E>("p1");
		AbstractIntersectionFinder<E> p2 = new IntersectionFinder_P1P2<E>("p2");
		AbstractIntersectionFinder<E> p3 = new IntersectionFinder_P2<E>();
		AbstractIntersectionFinder<E> p4 = new IntersectionFinder_P3<E>();
		
		String x = "0";
		if (args.length > 0)
			x = args[0];
		
		if (x.equals("1") || x.equals("0"))
			System.out.println("The Final Set by P1:  " + p1.intersectSets(p1.createSets(dr)).toString());
		if (x.equals("2") || x.equals("0"))
			System.out.println("The Final Set by P2:  " + p2.intersectSets(p1.createSets(dr)).toString());
		if (x.equals("3") || x.equals("0"))
			System.out.println("The Final Set by P3:  " + p3.intersectSets(p1.createSets(dr)).toString());
		if (x.equals("4") || x.equals("0"))
			System.out.println("The Final Set by P4:  " + p4.intersectSets(p1.createSets(dr)).toString());

	}
}