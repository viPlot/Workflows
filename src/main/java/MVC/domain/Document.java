package MVC.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private boolean status;

    @OneToOne
    @JoinColumn(name = "id_assigment")
    private Assignment idAssigment;

    @Column(name = "director_signature")
    private boolean directorSignature;

    @Column(name = "department_head_signature")
    private boolean depHeadSignature;

    @Column(name = "specialist_department_signature")
    private boolean specDepartmentSignature;
}
