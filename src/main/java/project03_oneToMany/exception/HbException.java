package project03_oneToMany.exception;

public class HbException extends Exception{

    private static final long serialVersionUID = 1L;

    private String mess;

    public HbException() {
    }

    public HbException(String mess) {
        this.mess = mess;
    }

    public String getMessage() {return this.mess;}
}
