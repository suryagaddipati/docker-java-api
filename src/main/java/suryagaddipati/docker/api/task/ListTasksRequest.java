
package suryagaddipati.docker.api.task;

import akka.http.javadsl.model.HttpMethods;
import suryagaddipati.docker.api.request.ApiRequest;
import suryagaddipati.docker.marshalling.ResponseType;

public class ListTasksRequest extends ApiRequest {

    public ListTasksRequest() {
        super(HttpMethods.GET, "/tasks", Task.class, ResponseType.LIST);
    }
}
