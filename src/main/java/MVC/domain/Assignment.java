package MVC.domain;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private boolean status;

    @Column(name = "id_creator")
    private Long idCreator;

    @JoinColumn(name = "id_document")
    @OneToOne
    private Document idDocument;

    @Column(name = "is_document")
    private boolean isDocument;
}
