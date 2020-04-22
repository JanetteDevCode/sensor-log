package dev.janette.sensorlog.error;

public class KeyNotValidException extends RuntimeException {
    public KeyNotValidException() {
        super("Invalid key provided for API access.");
    }
}
