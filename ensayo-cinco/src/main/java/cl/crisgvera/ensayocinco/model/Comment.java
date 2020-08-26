package cl.crisgvera.ensayocinco.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "COMMENTS")
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    private Long id;

    @Column(length = 250)
    private String name;

    @Column(length = 100)
    private String email;

    @Column(length = 1000)
    private String body;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            optional = false)
    @JoinColumn(name = "POSTID")
    private Post postId;

    public Comment(Long id) {
        this.id = id;
    }

}
