package cl.crisgvera.ensayocinco.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "POSTS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Post {

    @Id
    private Long id;

    @Column(length = 250)
    private String title;

    @Column(length = 1000)
    private String body;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
            optional = false)
    @JoinColumn(name = "USERID")
    private User userId;

    @OneToMany(mappedBy = "postId", cascade = CascadeType.ALL, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Set<Comment> comments = new HashSet<>();

    public Post(Long id) {
        this.id = id;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
        comment.setPostId(this);
    }

    public void deleteComment(Comment comment) {
        comments.remove(comment);
        comment.setPostId(null);
    }

}
