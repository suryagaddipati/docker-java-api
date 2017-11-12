package suryagaddipati.docker.api.service;

import akka.http.javadsl.model.HttpMethods;
import suryagaddipati.docker.api.request.ApiRequest;

public class ServiceLogRequest extends ApiRequest {

    public ServiceLogRequest(String id) {
        super(HttpMethods.GET, "/services/" + id + "/logs?follow=true&stdout=true&stderr=true");
    }
}
