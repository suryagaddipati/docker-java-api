
package suryagaddipati.docker.api.containers;

import java.util.ArrayList;
import java.util.List;

public class ContainerSpec {

    public final String Image;
    public final String[] Command;
    public final String[] Env;
    public List<Mount> Mounts = new ArrayList<>();

    public ContainerSpec(){
        this(null,null,null);
    }

    public ContainerSpec(String image, String[] cmd, String[] env) {
        this.Image = image;
        this.Command = cmd;
        this.Env  = env;
    }


    public static  class Mount {
        String Target;
        String Source;
        String Type;
        public Mount.VolumeOptions VolumeOptions;
        public Mount(){
           // for deserilization
        }
        public Mount(String Source, String Target) {
            this.Source = Source;
            this.Target =Target;
        }
        public static Mount bindMount(String Source, String Target){
            Mount mount = new Mount(Source, Target);
            mount.Type ="bind";
            return mount;
        }
        public static Mount cacheMount(String Source, String Target, String cacheDriverName){
            Mount mount = new Mount(Source, Target);
            mount.Type ="volume";
            mount.VolumeOptions = new Mount.VolumeOptions();
            mount.VolumeOptions.DriverConfig = new Mount.VolumeOptions.DriverConfig(cacheDriverName);
            return mount;
        }


        public static class VolumeOptions{
            public Mount.VolumeOptions.DriverConfig DriverConfig ;
            private static class DriverConfig{
                public DriverConfig(String name) {
                    Name = name;
                }
                String Name ;
            }
        }

    }

    public static class BindVolume extends Mount {
        String Type = "bind";
        public BindVolume(String Source, String Target) {
            super(Source, Target);
        }
    }

    public static class CacheDriverVolume extends Mount {
        CacheDriverVolume.VolumeOptions VolumeOptions = new VolumeOptions();

        String Type = "volume";
        public CacheDriverVolume(String Source, String Target) {
            super(Source, Target);
        }
    }
}
