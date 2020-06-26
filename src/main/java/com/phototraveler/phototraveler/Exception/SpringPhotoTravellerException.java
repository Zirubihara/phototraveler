package com.phototraveler.phototraveler.Exception;

public class SpringPhotoTravellerException extends RuntimeException {

    public SpringPhotoTravellerException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public SpringPhotoTravellerException(String exMessage) {
        super(exMessage);
    }
}
