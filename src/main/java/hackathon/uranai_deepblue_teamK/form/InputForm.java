package hackathon.uranai_deepblue_teamK.form;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by rkuser on 2016/07/23.
 */
public class InputForm {

    @NotBlank(message = "{name}")
    private String name;

    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birth;

    public InputForm() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public Date getBirth() {
        return birth;
    }
}
