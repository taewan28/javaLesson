package project.vo;

import java.sql.Date;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode

public class CustomerBuyVo {
    private int BUY_IDX;
    private String pcode;
    private String pname;
    private int price;
    private int quantity;
    private Timestamp BUY_DATE;
    
    @Override
    public String toString() {
        return String.format("%6d %15s %40s\t %8d %15d %40s" ,BUY_IDX,pcode,pname,price,quantity,BUY_DATE);
    }

    
}
