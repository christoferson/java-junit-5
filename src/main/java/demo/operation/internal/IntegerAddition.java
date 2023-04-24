package demo.operation.internal;

import demo.IBinaryOperation;

public class IntegerAddition implements IBinaryOperation<Integer, Integer, Integer> {

	@Override
	public Integer apply(Integer t, Integer u) {
		if (t == null) throw new IllegalArgumentException("1st Argument cannot be null!");
		return null;
	}


}
