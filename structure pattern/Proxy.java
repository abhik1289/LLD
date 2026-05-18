import java.util.ArrayList;
import java.util.List;

interface Internet {
    void connectTo(String server);
}

class RealInternet implements Internet {

    @Override
    public void connectTo(String serverHost) {
        System.out.println(
                "Connecting to " + serverHost);
    }
}

class ProxyInternet implements Internet {
    private Internet realInternet;
    private List<String> bannedSites;

    public ProxyInternet() {
        this.realInternet = new RealInternet();
        this.bannedSites = new ArrayList<>();
        bannedSites.add("abc.com");
        bannedSites.add("xyz.com");
    }

    @Override
    public void connectTo(String serverHost) {
        if (bannedSites.contains(serverHost)) {
            System.out.println("Access Denied to " + serverHost);
        } else {
            realInternet.connectTo(serverHost);
        }
    }
}

public class Proxy {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();

        internet.connectTo("google.com");
        internet.connectTo("abc.com");
        internet.connectTo("xyz.com");
    }
}
