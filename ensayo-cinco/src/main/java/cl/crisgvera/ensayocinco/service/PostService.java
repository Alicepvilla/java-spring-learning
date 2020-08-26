package cl.crisgvera.ensayocinco.service;

import cl.crisgvera.ensayocinco.model.Post;
import cl.crisgvera.ensayocinco.repository.PostRepository;
import cl.crisgvera.ensayocinco.service.util.CrudMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PostService implements CrudMethods<Post, Long> {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserService userService;

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id)
                .orElse(null);
    }

    @Override
    public Collection<Post> findAll() {
        return postRepository.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    @Override
    public Post save(Post post) {
        return null;
    }

    public List<Post> saveAll(List<Post> posts) {
        posts.forEach(post -> {
            post.setUserId(userService.findById(post.getUserId().getId()));
        });
        return postRepository.saveAll(posts);
    }

    @Override
    public Post update(Post post) {
        return null;
    }

    @Override
    public void delete(Post post) {

    }

    public void deleteAll() {
        postRepository.deleteAll();
    }
}
