package pl.deren.demo;

import java.util.Map;

public class PhoneReq {
    private String message;
    private int number;

    public PhoneReq(String message, int number) {
        this.message=message;
        this.number=number;

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return message + "odp  "+ number;
    }
}
