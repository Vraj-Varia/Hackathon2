import java.util.Date;

public class Delivery {
    private int empId;
    private int orderId;
    private Date delDate;
    private String status;
    private String remarks;

    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }
    public Date getDelDate() { return delDate; }
    public void setDelDate(Date delDate) { this.delDate = delDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}