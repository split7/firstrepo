package services;

import main.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import proxies.CommentNotificationProxy;
import repositories.CommentRepositories;

/*
На практике в типичных приложениях объекты, выполняющие условия задачи,
обычно называют сервисами
 */

@Service
//@Lazy - Spring будет создавать бин, только при его первом использовании
public class CommentService {

    private final CommentRepositories commentRepositories;

    private final CommentNotificationProxy commentNotificationProxy;

    //Если бы у этого класса было бы несколько конструкторов, то нужно было бы писать @Autowired
    public CommentService(CommentRepositories commentRepositories
            ,@Qualifier("PUSH") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepositories = commentRepositories;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        commentRepositories.storeComment(comment);
        commentNotificationProxy.sendComment(comment);
    }


}