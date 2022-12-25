package az.khayalsharifli.profilescreen.model

data class Profile(
    val isAdmin: Boolean,
    val firstName: String,
    val lastName: String,
    val email: String,
    val telephone: String,
    val gender: String,
    val avatarUrl: Int,
    val customerNo: Int
)
