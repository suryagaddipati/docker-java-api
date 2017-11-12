package suryagaddipati.docker.api.response;

import akka.http.javadsl.model.StatusCode;
import suryagaddipati.docker.api.request.ApiRequest;

public class ApiError {
    public ApiError(Class<? extends ApiRequest> requestClass, StatusCode statusCode, String message) {
        this.requestClass = requestClass;
        this.statusCode = statusCode;
        this.message = message;
    }

    public Class<?> getRequestClass() {
        return requestClass;
    }

    public StatusCode getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    private Class<?> requestClass;
    private StatusCode statusCode;
    private String message;
}
