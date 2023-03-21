package be.vdab.muziek.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LabelNietGevondenException extends RuntimeException {
    public LabelNietGevondenException() {
        super("Label niet gevonden.");
    }
}
