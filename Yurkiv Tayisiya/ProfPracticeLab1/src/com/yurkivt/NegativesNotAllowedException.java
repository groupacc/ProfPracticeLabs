package com.yurkivt;

/**
 * Created by Bagira on 22-Dec-15.
 */
public class NegativesNotAllowedException extends IllegalArgumentException {
    public NegativesNotAllowedException(String message) {
        super(message);
    }
}
