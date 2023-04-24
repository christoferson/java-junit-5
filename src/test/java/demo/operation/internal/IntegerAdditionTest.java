package demo.operation.internal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import demo.IBinaryOperation;

class IntegerAdditionTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Static : Sum positive numbers")
	void testStatic() {
		IBinaryOperation<Integer, Integer, Integer> op = BinaryOperations::plus;
		Integer sum = op.apply(5, 7);
		assertEquals(12, sum);
	}
	
	@Test
	@DisplayName("Validate 1st argument not null")
	void testValidate1stArgumentNotNull() {
		IBinaryOperation<Integer, Integer, Integer> op = new IntegerAddition();
		IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
			Integer sum = op.apply(null, 7);
		}, "Expected to throw IllegalArgumentException but did not");

		assertEquals("1st Argument cannot be null!", thrown.getMessage());
		
		
	}
	
	@Test
	//@Disabled
	@DisplayName("Sum positive numbers")
	void test1() {
		IBinaryOperation<Integer, Integer, Integer> op = new IntegerAddition();
		Integer sum = op.apply(5, 7);
		assertEquals(12, sum);
	}

	@Test
	@DisplayName("Sum positive and negative number")
	void test2() {
		IBinaryOperation<Integer, Integer, Integer> op = new IntegerAddition();
		Integer sum = op.apply(5, -7);
		assertEquals(-2, sum);
	}
}
