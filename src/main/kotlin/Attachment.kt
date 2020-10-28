interface Attachment {
    val type: String
}

data class Photo(
        override val type: String = "Photo",
        val id: Int = 0,
        val ownerId: Int = 0,
        val date: Int = 0,
        val albumId: Int = 0,
        val userId: Int = 0,
        val text: String = "",
        val sizes: Array<Any> = emptyArray(),
        val width: Int = 0,
        val height: Int = 0
) : Attachment

data class Audio(
        override val type: String = "Audio",
        val id: Int = 0,
        val ownerId: Int = 0,
        val date: Int = 0,
        val artist: String = "",
        val title: String = "",
        val duration: Int = 0,
        val url: String = "",
        val lyricsId: Int? = null,
        val albumId: Int? = null,
        val genreId: Int = 0,
        val noSearch: Boolean = false,
        val isHq: Boolean = false
) : Attachment

data class Note(
        override val type: String = "Note",
        val id: Int = 0,
        val ownerId: Int = 0,
        val date: Int = 0,
        val title: String = "",
        val text: String = "",
        val comments: Int = 0,
        val readComments: Int = 0,
        val viewUrl: String = ""
) : Attachment

data class Video(
        override val type: String = "Video",
        val id: Int = 0,
        val ownerId: Int = 0,
        val date: Int = 0,
        val title: String = "",
        val description: String = "",
        val duration: Int = 0,
        val image: Array<Any> = emptyArray(),
        val firstFrame: Array<Any> = emptyArray(),
        val addingDate: Int = 0,
        val views: Int = 0,
        val localViews: String = "",
        val comments: Int = 0,
        val player: String = "",
        val platform: String = "",
        val canEdit: Boolean = true,
        val canAdd: Boolean = true,
        val isPrivate: Boolean = false,
        val accessKey: String = "",
        val processing: Boolean = true,
        val isFavorite: Boolean = false,
        val canComment: Boolean = true,
        val canLike: Boolean = true,
        val canRepost: Boolean = true,
        val canSubscribe: Boolean = true,
        val canAddToFaves: Boolean = true,
        val canAttachLink: Boolean = false,
        val width: Int = 0,
        val height: Int = 0,
        val userId: Int = 0,
        val converting: Boolean = false,
        val added: Boolean = false,
        val isSubscribed: Boolean = false,
        val repeat: Boolean = true,
        val VideoType: String = "",
        val balance: Int = 0,
        val liveStatus: String = "",
        val live: Boolean = true,
        val upcoming: Boolean = false,
        val spectators: Int = 0,
        val likes: Likes = Likes(),
        val reposts: Reposts = Reposts(),
) : Attachment

data class Page(
        override val type: String = "",
        val id: Int = 0,
        val ownerId: Int = 0,
        val date: Int = 0,
        val groupId: Int = 0,
        val creatorId: Int = 0,
        val title: String = "",
        val currentUserCanEdit: Boolean = false,
        val whoCanView: Int = 2,
        val whoCanEdit: Int = 0,
        val edited: Int = 0,
        val created: Int = 0,
        val editorId: Int = 0,
        val views: Int = 0,
        val parent: String? = null,
        val parent2: String? = null,
        val source: String = "",
        val html: String? = null,
        val viewUrl: String = ""
) : Attachment