public class User {
    public static void main(String[] args) {

//        LoadBalancer loadbalancer = new LoadBalancerLibrary();
//        loadbalancer.addResource("test1");
//        loadbalancer.addResource("test2");
//        loadbalancer.addResource("test3");
//
//        try {
//        loadbalancer.nextResource();// return test1
//        loadbalancer.nextResource();
//        loadbalancer.nextResource();
//
//            String url = loadbalancer.nextResource();// return test1
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//

        LoadBalancer loadbalancer = new RandomLoadBalancerLibrary();
        loadbalancer.addResource("test1");
        loadbalancer.addResource("test2");
        loadbalancer.addResource("test3");

        try {
            loadbalancer.nextResource();// return test1
            loadbalancer.nextResource();
            loadbalancer.nextResource();

            String url = loadbalancer.nextResource();// return test1
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
