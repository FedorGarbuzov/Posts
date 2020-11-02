import org.junit.Assert
import org.junit.Test

class WallServiceTest {

    @Test
    fun add() {
        WallService.add(Post())
    }

    @Test
    fun updateTrue() {
        val post = Post()
        WallService.add(post)

        val result = WallService.update(post)

        Assert.assertTrue(result)
    }

    @Test
    fun updateFalse() {

        Assert.assertFalse(WallService.update(Post(id = 2)))
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrowPostNotFoundException() {
        WallService.createComment(Comment(postId = 1))
    }

    @Test
    fun shouldNotThrowPostNotFoundException() {
        val post = Post()
        WallService.add(post)
        val comment = Comment(postId = 0)
        WallService.createComment(comment)
    }

    @Test(expected = CommentNotFoundException::class)
    fun throwCommentNotFoundException() {
        WallService.reportComment(CommentReport(0, 2, 3))
    }

    @Test
    fun shouldNotThrowCommentNotFoundException() {
        val post = Post()
        WallService.add(post)
        val comment = Comment(postId = 0)
        WallService.createComment(comment)
        WallService.reportComment(CommentReport(0, 0, 3))
    }

    @Test(expected = ReasonNotFoundException::class)
    fun throwReasonNotFoundException() {
        val post = Post()
        WallService.add(post)
        val comment = Comment(postId = 0)
        WallService.createComment(comment)
        WallService.reportComment(CommentReport(0, 0, 8))
    }
}