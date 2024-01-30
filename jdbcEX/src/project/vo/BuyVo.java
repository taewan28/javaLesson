package project.vo;

import java.sql.Date;

public class BuyVo {
    private int buy_IDX;
    private String customid;
    private String pcode;
    private int quantity;
    private Date buy_data;
    
    public BuyVo(int buy_IDX, String customid, String pcode, int quantity, Date buy_data) {
        this.buy_IDX = buy_IDX;
        this.customid = customid;
        this.pcode = pcode;
        this.quantity = quantity;
        this.buy_data = buy_data;
    }

    public int getBuy_IDX() {
        return buy_IDX;
    }

    public String getCustomid() {
        return customid;
    }

    public String getPcode() {
        return pcode;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getBuy_data() {
        return buy_data;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + buy_IDX;
        result = prime * result + ((customid == null) ? 0 : customid.hashCode());
        result = prime * result + ((pcode == null) ? 0 : pcode.hashCode());
        result = prime * result + quantity;
        result = prime * result + ((buy_data == null) ? 0 : buy_data.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BuyVo other = (BuyVo) obj;
        if (buy_IDX != other.buy_IDX)
            return false;
        if (customid == null) {
            if (other.customid != null)
                return false;
        } else if (!customid.equals(other.customid))
            return false;
        if (pcode == null) {
            if (other.pcode != null)
                return false;
        } else if (!pcode.equals(other.pcode))
            return false;
        if (quantity != other.quantity)
            return false;
        if (buy_data == null) {
            if (other.buy_data != null)
                return false;
        } else if (!buy_data.equals(other.buy_data))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "BuyVo [buy_IDX=" + buy_IDX + ", customid=" + customid + ", pcode=" + pcode + ", quantity=" + quantity
                + ", buy_data=" + buy_data + "]";
    }

    
    
}
