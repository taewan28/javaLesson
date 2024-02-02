package ACE.vo;

import java.sql.Date;

public class MovieViewvo {

    private int res_IDX;
    private String custom_id;
    private String title;
    private Date res_data;
    
    public MovieViewvo(int res_IDX, String custom_id, String title, Date res_data) {
        this.res_IDX = res_IDX;
        this.custom_id = custom_id;
        this.title = title;
        this.res_data = res_data;
    }



    public int getRes_IDX() {
        return res_IDX;
    }



    public String getCustom_id() {
        return custom_id;
    }



    public String getTitle() {
        return title;
    }



    public Date getRes_data() {
        return res_data;
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + res_IDX;
        result = prime * result + ((custom_id == null) ? 0 : custom_id.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((res_data == null) ? 0 : res_data.hashCode());
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
        MovieViewvo other = (MovieViewvo) obj;
        if (res_IDX != other.res_IDX)
            return false;
        if (custom_id == null) {
            if (other.custom_id != null)
                return false;
        } else if (!custom_id.equals(other.custom_id))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (res_data == null) {
            if (other.res_data != null)
                return false;
        } else if (!res_data.equals(other.res_data))
            return false;
        return true;
    }
    
}

