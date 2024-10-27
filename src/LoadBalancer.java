public interface LoadBalancer  {
    void addResource(String url);
    String nextResource() throws Exception;

}
