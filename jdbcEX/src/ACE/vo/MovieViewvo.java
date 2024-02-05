package ACE.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class MovieViewVo {
    private int res_idx ;
	private String title;		
	private int price;
	private Date res_date;



    @Override
    public String toString() {
        return "ViewerReserveVo [res_idx=" + res_idx + ", title=" + title + ", price=" + price + ", res_date="
                + res_date + "]";
    }
    
}