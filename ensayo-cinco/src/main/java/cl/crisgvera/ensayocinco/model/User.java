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
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    @Id
    private Long id;

    @Column(length = 50)
    private String name, email;

    @Column(length = 20, unique = true)
    private String username;

    @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, orphanRemoval = true)
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Set<Post> posts = new HashSet<>();

    public User(Long id) {
        this.id = id;
    }

    public void addPost(Post post) {
        posts.add(post);
        post.setUserId(this);
    }

    public void deletePost(Post post) {
        posts.remove(post);
        post.setUserId(null);
    }

}
