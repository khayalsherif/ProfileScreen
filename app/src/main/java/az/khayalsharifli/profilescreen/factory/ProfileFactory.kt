package az.khayalsharifli.profilescreen.factory

import az.khayalsharifli.profilescreen.R
import az.khayalsharifli.profilescreen.model.Profile

object ProfileFactory {
    fun getProfileData() = Profile(
        isAdmin = true,
        firstName = "Khayal",
        lastName = "Sharifli",
        email = "customer@gmail.com",
        telephone = "+380630000000",
        gender = " Male ",
        avatarUrl = R.drawable.photo,
        customerNo = 27314974
    )
}