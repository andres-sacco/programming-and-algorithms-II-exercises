package org.uade.exception;

public class ElementNotFoundADTException extends GenericADTException {
    public ElementNotFoundADTException() {
        super("The element was not found.");
    }

    public ElementNotFoundADTException(String message) {
        super(message);
    }
}
