package setIntersectionFinders;

import interfaces.MySet;
import mySetImplementations.Set2;
import java.util.ArrayList;

/**
 * @author Jose C. Ventosa Rodriguez - 802198619 CIIC4020 - 050L
 */

public class IntersectionFinder_P2<E> extends AbstractIntersectionFinder<E> {

	public IntersectionFinder_P2(String name) {
		super(name);
	}

	public IntersectionFinder_P2() {
		new Set2<E>();
	}

	@SuppressWarnings("unchecked")
	public MySet<E> intersectSets(MySet<E>[] intersect) {
		MySet<E> finalT = new Set2<E>();

		int crime = intersect.length;

		ArrayList<Integer> allElements = new ArrayList<Integer>();
		for (int i = 0; i < crime; i++) {

			for (E e : intersect[i]) {
				allElements.add((Integer) e);
			}
		}
		allElements.sort(null);
		Integer e = allElements.get(0);
		int company = 1;
		
		for (int i = 1; i < allElements.size(); i++) {
			if (i < allElements.size() && allElements.get(i).equals(e)) {
				company++;
			}
			else {
				if (company == company) {
					finalT.add((E) e);
				}
				e = allElements.get(i);
				company = 1;
			}
			if (company == crime) {
				finalT.add((E) e);
			}
		}

		return finalT;
	}

}
