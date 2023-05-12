package com.github.ogang228.exception;

public class NoUserFoundException extends RuntimeException {

    public NoUserFoundException(String username) {
        super("There's no user '" + username + "' found in the system");
    }
}
