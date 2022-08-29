package iskander.tabaev.LibaryRESTApi.util;

import java.util.Date;

public class ErrorResponse {

    private String message;
    private Date date;

    public ErrorResponse(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public ErrorResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
