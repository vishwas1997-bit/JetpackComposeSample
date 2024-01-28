package com.example.jetpackcompose.netclan.domain.model

data class IndividualExploreModel(
    var image: String,
    var name: String,
    var place: String,
    var distance: String,
    var purposes: String,
    var bio: String,
    var uid: String,
    var gender: String,
    var wishList: String,
    var invitationStatus: String,
    var profileScore: Float = 0f,
    var profession: String
)