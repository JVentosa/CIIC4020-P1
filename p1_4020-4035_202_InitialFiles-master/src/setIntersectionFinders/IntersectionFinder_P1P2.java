package setIntersectionFinders;

import java.util.Iterator;
import interfaces.MySet;
import mySetImplementations.Set1;
import mySetImplementations.Set2;
/*
 * @author Jose C. Ventosa Rodriguez - 802198619 - CIIC4020 - 050L
 */

public class IntersectionFinder_P1P2<E> extends AbstractIntersectionFinder<E> {
	private int company;
	private int crimes;
	public IntersectionFinder_P1P2(String name) {
		super(name);
	}

	public void IntersectionFinder_P2() {
		new Set1<E>();
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public MySet<E>[] createSets(Integer[][][] rawData) {
		company = rawData.length;
		crimes = rawData[0].length;
		Integer three, matrix;

		MySet[] thecrimes = new MySet[crimes];
		for (int i = 0; i < crimes; ++i) {
			if (this.getName() == "p1")
				thecrimes[i] = new Set1<E>();
			else
				thecrimes[i] = new Set2<E>();

			for (int j = 0; j < company; ++j) {
				three = rawData[j][i].length;
				for (int k = 0; k < three; k++) {
					matrix = rawData[j][i][k];
					if (matrix == null)
						break;
					if (!thecrimes[i].contains(matrix)) {
						thecrimes[i].add(matrix);
					}
				}

			}
		}
		return thecrimes;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MySet<E> intersectSets(MySet<E>[] intersect) {

		MySet<E> finalCrimes;
		if (this.getName() == "p1") {
			finalCrimes = new Set1<E>();
		} else {
			finalCrimes = new Set2<E>();
		}

		for (E e : intersect[0]) {
			finalCrimes.add(e);

		}

		for (int i = 1; i < intersect.length; i++) {
			Iterator finalCrimesiterator = finalCrimes.iterator();
			E e;
			while (finalCrimesiterator.hasNext()) {
				e = (E) finalCrimesiterator.next();
				if (!intersect[i].contains(e)) {

					finalCrimesiterator.remove();
				}
			}

		}

		return finalCrimes;
	}

}
