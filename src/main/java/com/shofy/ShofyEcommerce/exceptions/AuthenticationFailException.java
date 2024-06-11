package com.shofy.ShofyEcommerce.exceptions;

public class AuthenticationFailException extends RuntimeException {
    public AuthenticationFailException(String msg){
        super(msg);
    }

}
