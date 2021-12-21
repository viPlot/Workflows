package spring;

public class AppException extends RuntimeException{
    protected Object [] params;

    public AppException(String code, Object... params) {
        super(code);
    }

    public AppException(String code, Throwable cause, Object... params) {
        super(code, cause);
        this.params = params;
    }
}
