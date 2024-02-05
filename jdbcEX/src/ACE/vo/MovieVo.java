package ACE.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class MovieVo {
    private String title;
    private String category;
    private int view_age;
    private int price;
    @Override
    public String toString() {
        return "[title=" + title + ", category=" + category + ", view_age=" + view_age + ", price=" + price
                + "]";
    }


     
}