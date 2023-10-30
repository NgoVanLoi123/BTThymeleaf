package com.example.BTThymeleaf.model.request;
import com.example.BTThymeleaf.statics.PersonCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.List;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class PersonCreationRequest {

    private int id;
    private String name;
    private String address;
//    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")


    private LocalDate birth ;
    private List<PersonCategory> categories;
    private String gender;

}
