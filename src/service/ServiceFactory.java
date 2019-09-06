package service;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {
    private static final Map<String, Service> FACTORY_MAP = new HashMap<>();

    static {
        FACTORY_MAP.put("/login", new LoginService());
    }

    public static synchronized Service getService(String serviceRequest){
        return FACTORY_MAP.get(serviceRequest);
    }
}
