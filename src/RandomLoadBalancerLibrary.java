import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLoadBalancerLibrary implements LoadBalancer {

    List<String> UrlInstances = new ArrayList<>();
    int counter = 0;
    int totalSize =0;

    @Override
    public void addResource(String url) {
        UrlInstances.add(url);
        totalSize++;

    }

    @Override
    public String nextResource() throws Exception {
        Random random =new Random();
        int randomValue =  random.nextInt(totalSize);

        if(totalSize == 0) {
            throw new Exception( "No resources available");
        }
        var resource = UrlInstances.get(randomValue);
        System.out.println("Resource url " + resource);
        return resource;

    }
}
