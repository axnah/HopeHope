package altn72.hopehope.Model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tool {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String domain;

    @Column(length = 500)
    private String simpleDescription;

    @Lob
    private String detailedDescription;

    @Column(nullable = false)
    private String link;

    private String accessTutorial;
}
