package com.clientui.clientui.exception;

import feign.Response;
import feign.codec.ErrorDecoder;
public class CustomErrorDecoder implements ErrorDecoder {
    private final ErrorDecoder defaultErrorDecoder = new Default();
    @Override
    public Exception decode(String invoqueur, Response reponse) {
        if(reponse.status() == 400 ) {
            return new ProductBadRequestException(
                    "Requête incorrecte "
            );
        }else if(reponse.status() > 400 && reponse.status() <=499 ) {
            return new Product4XXException(
                    "Erreur de au format 4XX "
            );
        }
        return defaultErrorDecoder.decode(invoqueur, reponse);
    }
}


