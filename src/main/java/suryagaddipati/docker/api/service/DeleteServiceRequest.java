package suryagaddipati.docker.api.service;

import akka.http.javadsl.model.HttpMethods;
import suryagaddipati.docker.api.request.ApiRequest;

public class DeleteServiceRequest extends ApiRequest {
    public DeleteServiceRequest(String serviceName) {
        super(HttpMethods.DELETE,"/services/"+serviceName);
    }

}
