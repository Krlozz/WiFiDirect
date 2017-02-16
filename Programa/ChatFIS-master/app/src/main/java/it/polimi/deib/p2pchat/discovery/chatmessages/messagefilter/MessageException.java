package it.polimi.deib.p2pchat.discovery.chatmessages.messagefilter;

import lombok.Getter;

public class MessageException extends Exception {

    public static enum Reason {NULLMESSAGE, MESSAGETOOSHORT, MESSAGEBLACKLISTED};

    @Getter private Reason reason;

    public MessageException() {
        super();
    }

    public MessageException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessageException(String message) {
        super(message);
    }

    public MessageException(Throwable cause) {
        super(cause);
    }

    public MessageException(Reason reason) {
        this.reason = reason;
    }
}
