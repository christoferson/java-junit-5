package demo.operation.internal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import demo.IBinaryOperation;
import demo.IFieldMapper;

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
	
	@Test
	@DisplayName("Test IFieldMapper")
	void test3() {
		List<IFieldMapper<MappingContext, Player>> mapperList = new ArrayList<>();
		
		mapperList.add((MappingContext ctx, Player player) -> {
			ctx.increment();
			return String.valueOf(player) + "-1";
		});
		mapperList.add((MappingContext ctx, Player player) -> {
			ctx.increment();
			return String.valueOf(player) + "-2";
		});
		mapperList.add(FieldMappers::Health);
		mapperList.add(FieldMappers::Mana);
		mapperList.add(FieldMappers::Level);
		
		MappingContext ctx = new MappingContext();
		
		for (var mapper : mapperList) {
			Player player = new Player("Foo");
			String value = mapper.apply(ctx, player);
			//System.out.println(value);
		}
		//System.out.println(ctx.count());
	}
	
	@Test
	@DisplayName("Test PlayerFieldMapperHealth")
	void testPlayerFieldMapperHealth() {
		IFieldMapper<MappingContext, Player> mapper = FieldMappers::Health;
		MappingContext ctx = new MappingContext();
		Player player = new Player("Foo");
		String value = mapper.apply(ctx, player);
		assertEquals("Player.Health Player[name=Foo]", value);
		assertEquals(0, ctx.count());
	}
}
