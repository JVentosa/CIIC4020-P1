package setIntersectionFinders;

import java.util.ArrayList;
import interfaces.IntersectionFinder;
import interfaces.MySet;

public abstract class AbstractIntersectionFinder<E> implements IntersectionFinder<E> {
	private String name;

	public AbstractIntersectionFinder(String name) {
		this.name = name;
	}

	public AbstractIntersectionFinder() {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public MySet<E> intersectSets() {
		// TODO Auto-generated method stub
		return null;
	}

	public MySet<E> intersectSets(MySet<E>[] t) {
		// TODO Auto-generated method stub
		return null;
	}

	public MySet<E>[] createSets(Integer[][][] rawData) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Integer> intersectMySets(ArrayList<Integer>[] mySet) {
		return null;
		// TODO Auto-generated method stub

	}

	public MySet<E>[] createSets2(Integer[][][] myData) {
		// TODO Auto-generated method stub
		return null;
	}

}
