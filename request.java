
package waste_scheduling_system;

public class request {
    private String request_time;
    private String request_address;
    private String request_shift;
    private String request_id;
    private String customer_name;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public String getRequest_time() {
        return request_time;
    }

    public void setRequest_time(String request_time) {
        this.request_time = request_time;
    }

    public String getRequest_address() {
        return request_address;
    }

    public void setRequest_address(String request_address) {
        this.request_address = request_address;
    }

    public String getRequest_shift() {
        return request_shift;
    }

    public void setRequest_shift(String request_shift) {
        this.request_shift = request_shift;
    }
    

    public request(String request_time, String request_address, String request_shift,String request_id,String customer_name,String status) {
        this.request_time = request_time;
        this.request_address = request_address;
        this.request_shift = request_shift;
        this.request_id = request_id;
        this.customer_name = customer_name;
        this.status = status;
    }  
}