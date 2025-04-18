import java.util.Date;

public class Customer {
    private String name;
    private Date regDate;
    private String addr;
    private String city;
    private String pin;
    private String phone;
    private String email;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Date getRegDate() { return regDate; }
    public void setRegDate(Date regDate) { this.regDate = regDate; }
    public String getAddr() { return addr; }
    public void setAddr(String addr) { this.addr = addr; }
    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }
    public String getPin() { return pin; }
    public void setPin(String pin) { this.pin = pin; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}