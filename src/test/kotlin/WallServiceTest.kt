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

        Assert.assertFalse(WallService.update(Post()))
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        WallService.createComment(Comment(postId = 1))
    }

    @Test
    fun shouldNotThrow() {
        val post = Post()
        WallService.add(post)
        val comment = Comment(postId = 0)
        WallService.createComment(comment)
    }
}