package service;

public class Paycheck {

    private int checkCost;
    private Boolean checkPaid;
    private String product;

    public int getCheckCost() {
        return checkCost;
    }

    public void setCheckCost(int checkCost) {
        this.checkCost = checkCost;
    }

    public Boolean getCheckPaid() {
        return checkPaid;
    }

    public void setCheckPaid(Boolean checkPaid) {
        this.checkPaid = checkPaid;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
