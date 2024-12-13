package de.codecentric.vue;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
	private static final long serialVersionUID = -1711719865222191254L;

	public NotFoundException(String message) {
        super(message);
    }
}
