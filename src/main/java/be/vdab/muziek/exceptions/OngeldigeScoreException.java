package be.vdab.muziek.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class OngeldigeScoreException extends RuntimeException {
    public OngeldigeScoreException() {
        super("Score moet tussen 0 en 10 liggen.");
    }
}
