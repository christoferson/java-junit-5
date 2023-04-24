package demo.operation.internal;

import demo.IMappingContext;

public class MappingContext implements IMappingContext {

	private int count;
	
	public void increment() {
		count++;
	}
	
	public int count() {
		return count;
	}
}
