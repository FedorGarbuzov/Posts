import java.lang.RuntimeException
class PostNotFoundException(message: String) : RuntimeException(message)

object WallService {
    private var id = 0
    var posts = emptyArray<Post>()
    var comments = emptyArray<Comment>()

    fun add(post: Post): Post {
        posts += post.copy(id = id++)
        return posts.last()
    }

    fun update(post: Post): Boolean {
        val indexOfOld = posts.indexOfFirst { it.id == post.id }
        val old = posts.getOrElse(indexOfOld) { return false }
        posts[indexOfOld] = post.copy(ownerId = old.ownerId, date = old.date)
        return true
    }

    fun createComment(comment: Comment) {
        val indexOfPost = posts.indexOfFirst { it.id == comment.postId }
        val old = posts.getOrElse(indexOfPost) { throw PostNotFoundException("Пост с указанным id '${comment.postId}' не найден") }
        comments += comment
        posts[indexOfPost] = old.copy(comments = Comments(old.comments.count + 1))
    }
}