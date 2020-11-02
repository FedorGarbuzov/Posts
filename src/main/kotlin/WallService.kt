import java.lang.RuntimeException

class PostNotFoundException(message: String) : RuntimeException(message)
class CommentNotFoundException(message: String) : RuntimeException(message)
class ReasonNotFoundException(message: String) : RuntimeException(message)

object WallService {
    private var id = 0
    var posts = emptyArray<Post>()
    var comments = emptyArray<Comment>()
    var reports = emptyArray<CommentReport>()

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

    fun reportComment(commentReport: CommentReport) {
        val target = comments.find { it.id == commentReport.commentId && it.fromId == commentReport.ownerId }
        if (target == null) throw CommentNotFoundException("Комментарий с заданными параметрами не найден") else reports += commentReport
        val old = reports.last()
        val indexOfReport = reports.lastIndex
        val reportReason = when (commentReport.reason) {
            0 -> "cпам"
            1 -> "детская порнография"
            2 -> "экстремизм"
            3 -> "насилие"
            4 -> "пропаганда наркотиков"
            5 -> "материал для взрослых"
            6 -> "оскорбление"
            7 -> "призывы к суициду"
            else -> throw ReasonNotFoundException("Неверно указана причина жалобы")
        }
        reports[indexOfReport] = old.copy(reason = reportReason)
    }
}