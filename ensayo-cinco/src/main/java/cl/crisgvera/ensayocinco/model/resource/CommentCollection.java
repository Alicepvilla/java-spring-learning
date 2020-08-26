package cl.crisgvera.ensayocinco.model.resource;

import cl.crisgvera.ensayocinco.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentCollection {

    private List<Comment> comments;

}
