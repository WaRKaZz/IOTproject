package entity;


import java.util.ArrayList;
import java.util.List;

public class Home {
    private List<Device> home_installed_devices = new ArrayList<>();
    private Long home_id;
    private String home_name;
    private String home_address;

    public List<Device> getHome_installed_devices() {
        return home_installed_devices;
    }

    public void setHome_installed_devices(List<Device> home_installed_devices) {
        this.home_installed_devices = home_installed_devices;
    }

    public Long getHome_id() {
        return home_id;
    }

    public void setHome_id(Long home_id) {
        this.home_id = home_id;
    }

    public String getHome_name() {
        return home_name;
    }

    public void setHome_name(String home_name) {
        this.home_name = home_name;
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }
}
