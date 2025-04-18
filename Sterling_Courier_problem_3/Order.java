import java.util.Date;

public class Order {
    private int custId;
    private Date orderDate;
    private String recName;
    private String recAddr;
    private String recCity;
    private double weight;
    private String desc;

    public int getCustId() { return custId; }
    public void setCustId(int custId) { this.custId = custId; }
    public Date getOrderDate() { return orderDate; }
    public void setOrderDate(Date orderDate) { this.orderDate = orderDate; }
    public String getRecName() { return recName; }
    public void setRecName(String recName) { this.recName = recName; }
    public String getRecAddr() { return recAddr; }
    public void setRecAddr(String recAddr) { this.recAddr = recAddr; }
    public String getRecCity() { return recCity; }
    public void setRecCity(String recCity) { this.recCity = recCity; }
    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
    public String getDesc() { return desc; }
    public void setDesc(String desc) { this.desc = desc; }
}