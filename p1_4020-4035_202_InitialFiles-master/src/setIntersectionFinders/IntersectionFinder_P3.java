package setIntersectionFinders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import interfaces.MySet;
import mySetImplementations.Set2;

/*
 * @author Jose C. Ventosa Rodriguez 802198619 - CIC4020 - 050L
 */

public class IntersectionFinder_P3<E> extends AbstractIntersectionFinder<E> {

	public IntersectionFinder_P3(String name) {
		super(name);

	}

	public IntersectionFinder_P3() {
	}

	@Override
	public MySet<E> intersectSets(MySet<E>[] intersect) {
		MySet<E> finalcrimeimes = new Set2<E>();
		int crime = intersect.length;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> allElements = new ArrayList<Integer>();
		
		for (int i = 0; i < crime; i++) {

			for (E e : intersect[i]) {
				allElements.add((Integer) e);

			}
		}
		for (Integer e : allElements) {
			Integer c = map.getOrDefault(e, 0);
			map.put(e, c + 1);

		}
		for (Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == crime) {
				finalcrimeimes.add((E) entry.getKey());
			}

		}
		return finalcrimeimes;
	}
}
