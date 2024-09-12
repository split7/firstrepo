package repositories;

import main.Comment;
import org.springframework.stereotype.Repository;
/*
Объект, который непосредственно взаимодействует с базой данных, обычно называют репозиторием.
 Встречается также термин «объект доступа к данным»
(data access object, DAO)
 */

@Repository
public class DBCommentRepository implements CommentRepositories{
    @Override
    public void storeComment(Comment comment) {
        System.out.println("Storing comment: " + comment.getText());
    }
}
