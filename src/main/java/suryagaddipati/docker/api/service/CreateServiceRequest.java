
package suryagaddipati.docker.api.service;

import akka.http.javadsl.model.HttpMethods;
import suryagaddipati.docker.api.containers.ContainerSpec;
import suryagaddipati.docker.api.network.Network;
import suryagaddipati.docker.api.request.ApiRequest;
import suryagaddipati.docker.api.task.TaskTemplate;
import suryagaddipati.docker.marshalling.ResponseType;

import java.util.ArrayList;
import java.util.List;

public class CreateServiceRequest extends ApiRequest {
    public TaskTemplate TaskTemplate ;
    public String Name;
    public List<Network> Networks = new ArrayList<>();
    public CreateServiceRequest(String name, String Image, String[] Cmd, String[] Env) {
        super(HttpMethods.POST, "/services/create",CreateServiceResponse.class, ResponseType.CLASS);
        this.Name = name;
        this.TaskTemplate = new TaskTemplate(Image,Cmd,Env);
    }

    public void  addBindVolume(String source,String target){
        ContainerSpec.Mount mount = ContainerSpec.Mount.bindMount(source, target);
        this.TaskTemplate.ContainerSpec.Mounts.add(mount);
    }
    public void addCacheVolume(String cacheVolumeName, String target, String cacheDriverName) {
        ContainerSpec.Mount mount = ContainerSpec.Mount.cacheMount(cacheVolumeName, target,cacheDriverName);
        this.TaskTemplate.ContainerSpec.Mounts.add(mount);
    }

    public void setTaskLimits(Long nanoCPUs, Long memoryBytes) {
        this.TaskTemplate.Resources.Limits.NanoCPUs = nanoCPUs;
        this.TaskTemplate.Resources.Limits.MemoryBytes = memoryBytes;
    }

    public void setTaskReservations(Long nanoCPUs, Long memoryBytes) {
        this.TaskTemplate.Resources.Reservations.NanoCPUs = nanoCPUs;
        this.TaskTemplate.Resources.Reservations.MemoryBytes = memoryBytes;
    }

    public void setNetwork(String network) {
        if(network !=null && "" !=network){
            Networks.add(new Network(network));
        }
    }


}
