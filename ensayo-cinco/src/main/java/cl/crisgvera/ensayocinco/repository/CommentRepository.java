package cl.crisgvera.ensayocinco.repository;

import cl.crisgvera.ensayocinco.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Collection<Comment> findAllByPostId_Id(Long postId);

}
