object WallService {
    private var id = 0
    private var posts = emptyArray<Post>()

    fun add(post: Post) {
        posts += post.copy(id = id++)
    }
}