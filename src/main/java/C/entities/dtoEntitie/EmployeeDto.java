package C.entities.dtoEntitie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeDto {
    private Integer employeedId;
    private String lastName;
    private String firstName;
    private String title;
    private LocalDateTime brithData;
    private LocalDateTime hireData;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String phone;
    private String fax;
    private String email;
}
