package DataJpa.dao.service.exception;

public class EntityDoesnotExistException extends ServiceException{
    public EntityDoesnotExistException() {
    }

    public EntityDoesnotExistException(String message) {
        super(message);
    }

    public EntityDoesnotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public EntityDoesnotExistException(Throwable cause) {
        super(cause);
    }

    public EntityDoesnotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
