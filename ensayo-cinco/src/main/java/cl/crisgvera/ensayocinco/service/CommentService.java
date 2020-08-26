package cl.crisgvera.ensayocinco.service;

import cl.crisgvera.ensayocinco.model.Comment;
import cl.crisgvera.ensayocinco.repository.CommentRepository;
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
public class CommentService implements CrudMethods<Comment, Long> {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostService postService;

    @Override
    public Comment findById(Long aLong) {
        return null;
    }

    @Override
    public Collection<Comment> findAll() {
        return commentRepository.findAll().stream()
                .filter(Objects::nonNull)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    public Collection<Comment> findAllByPostId_Id(Long postId) {
        return commentRepository.findAllByPostId_Id(postId);
    }

    @Override
    public Comment save(Comment comment) {
        return null;
    }

    public List<Comment> saveAll(List<Comment> comments) {
        comments.forEach(comment -> {
            comment.setPostId(postService.findById(comment.getPostId().getId()));
        });
        return commentRepository.saveAll(comments);
    }

    @Override
    public Comment update(Comment comment) {
        return null;
    }

    @Override
    public void delete(Comment comment) {

    }

    public void deleteAll() {
        commentRepository.deleteAll();
    }
}
