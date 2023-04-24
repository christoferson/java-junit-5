package demo.operation.internal;

public abstract class FieldMappers {

	public static String Health(MappingContext ctx, Player player) {
		return String.format("Player.Health %s", player);
	}
	
	public static String Mana(MappingContext ctx, Player player) {
		ctx.increment();
		return String.format("Player.Mana %s", player);
	}

	public static String Level(MappingContext ctx, Player player) {
		ctx.increment();
		return String.format("Player.Level %s", player);
	}
}
