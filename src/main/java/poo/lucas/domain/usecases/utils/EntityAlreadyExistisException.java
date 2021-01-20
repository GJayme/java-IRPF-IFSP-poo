package poo.lucas.domain.usecases.utils;

public class EntityAlreadyExistisException extends RuntimeException {
    public EntityAlreadyExistisException(String message) {
        super(message);
    }
}
