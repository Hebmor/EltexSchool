package ru.eltex.app.java.model.shop;

public class SimpleException extends Exception {
    private int errorCode;

    public SimpleException(String message, int errorCode) {

        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
