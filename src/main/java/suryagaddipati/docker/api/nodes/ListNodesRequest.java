
package suryagaddipati.docker.api.nodes;

import akka.http.javadsl.model.HttpMethods;
import suryagaddipati.docker.api.request.ApiRequest;
import suryagaddipati.docker.marshalling.ResponseType;

public class ListNodesRequest extends ApiRequest {

    public ListNodesRequest() {
        super(HttpMethods.GET, "/nodes", Node.class, ResponseType.LIST);
    }
}
