package suryagaddipati.docker.api.response;


import akka.http.javadsl.model.ResponseEntity;
import suryagaddipati.docker.api.request.ApiRequest;

public class ApiSuccess {

    private Class<? extends ApiRequest> requestClass;


    private ResponseEntity responseEntity;

    public ApiSuccess(Class<? extends ApiRequest> requestClass, ResponseEntity responseEntity) {
        this.requestClass = requestClass;
        this.responseEntity = responseEntity;
    }

    public Class<? extends ApiRequest> getRequestClass() {
        return requestClass;
    }

    public ResponseEntity getResponseEntity() {
        return responseEntity;
    }
}
