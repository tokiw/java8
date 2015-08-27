package ex03_01;

import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;


public class LoggerEx extends Logger {
	protected LoggerEx(String name, String resourceBundleName) {
		super(name, resourceBundleName);
	}

	/**
	 * 
	 * @param level
	 * @param condition
	 * @param message
	 * @throws NullPointerException if arguments is null
	 */
	public void logIf(Level level, BooleanSupplier condition, Supplier<String> message) throws NullPointerException {
		Objects.requireNonNull(level);
		Objects.requireNonNull(condition);
		Objects.requireNonNull(message);
		if (this.isLoggable(level) && condition.getAsBoolean()) {
			log(level, message.get());
		}
	}
}
