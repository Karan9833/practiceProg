import java.util.ArrayList;
import java.util.List;

public class LoadBalancerLibrary implements LoadBalancer {

    List<String> UrlInstances = new ArrayList<>();
    int counter = 0;
    int totalSize =0;

    @Override
    public void addResource(String url) {
        UrlInstances.add(url);
        totalSize++;

    }

    @Override
    public synchronized String nextResource() throws Exception {

        if(totalSize == 0) {
            throw new Exception( "No resources available");
        }
        if(counter == totalSize) {
            counter =0;
        }
        var resource = UrlInstances.get(counter);
        System.out.println("Resource url " + resource);
        ++counter;
        return resource;

    }
}
