package hackathon.uranai_deepblue_teamK.form;

import java.util.Date;

/**
 * Created by rkuser on 2016/07/23.
 */
public class InputForm {

    private String name;
    private Date birth;

    public InputForm(String name, Date birth) {
        this.name = name;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public Date getBirth() {
        return birth;
    }
}
