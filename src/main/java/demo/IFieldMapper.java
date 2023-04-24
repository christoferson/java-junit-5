package demo;

import java.util.function.BiFunction;

public interface IFieldMapper<T extends IMappingContext, U> extends BiFunction<T, U, String> {

}
