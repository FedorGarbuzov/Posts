data class CommentThread (
    val count: Int = 0,
    val items: Array<Comment> = emptyArray(),
    val canPost: Boolean = true,
    val showReplyButton: Boolean = true,
    val groupsCanPost: Boolean = true
)