package ar.edu.itba.exceptions;

public class SameUserConversationException extends Exception {
    public SameUserConversationException() {
    }

    public SameUserConversationException(String message) {
        super(message);
    }
}
