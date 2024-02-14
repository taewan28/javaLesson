package ACE.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode

public class MovieViewVo {
private String viewerId;
    private String name;
    private int age;
    private String password;
    
    @Override
    public String toString() {
        return String.format("%6d %15s %40s\t %8d %15d %40s" ,viewerId,name,age);
    }


}