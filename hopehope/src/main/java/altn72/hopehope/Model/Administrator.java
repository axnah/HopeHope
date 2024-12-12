package altn72.hopehope.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Administrator extends User {
    private String roleDescription;
}
