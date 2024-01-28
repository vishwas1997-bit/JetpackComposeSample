package com.example.jetpackcompose.netclan.data.model.remote.dto.response

import com.google.gson.annotations.SerializedName

data class IndividualExploreResponseDto(
    @SerializedName("refresh_rate") var refreshRate: Int? = null,
    @SerializedName("data") var data: ArrayList<IndividualData> = arrayListOf(),
    @SerializedName("totalPage") var totalPage: Int? = null,
    @SerializedName("page") var page: Int? = null
)


data class IndividualData(
    @SerializedName("visibility") var visibility: Visibility? = Visibility(),
    @SerializedName("startup") var startup: Startup? = Startup(),
    @SerializedName("isVerified") var isVerified: Int? = null,
    @SerializedName("profileScore") var profileScore: Int? = null,
    @SerializedName("phone") var phone: Long? = null,
    @SerializedName("countryCode") var countryCode: String? = null,
    @SerializedName("location") var location: Location? = Location(),
    @SerializedName("age") var age: Int? = null,
    @SerializedName("firstName") var firstName: String? = null,
    @SerializedName("gender") var gender: Int? = null,
    @SerializedName("lastName") var lastName: String? = null,
    @SerializedName("netClanId") var netClanId: String? = null,
    @SerializedName("phoneStatus") var phoneStatus: Int? = null,
    @SerializedName("places") var places: Places? = Places(),
    @SerializedName("profession") var profession: Profession? = Profession(),
    @SerializedName("profilePicUrl") var profilePicUrl: String? = null,
    @SerializedName("isFromCloseContact") var isFromCloseContact: Boolean? = null,
    @SerializedName("invStatus") var invStatus: Int? = null,
    @SerializedName("uid") var uid: String? = null,
    @SerializedName("distanceAway") var distanceAway: Int? = null,
    @SerializedName("bio") var bio: Bio? = null
)

data class Visibility(
    @SerializedName("firstName") var firstName: Int? = null,
    @SerializedName("dob") var dob: Int? = null,
    @SerializedName("profilePic") var profilePic: Int? = null
)

data class Startup(
    @SerializedName("wishlist") var wishlist: String? = null,
    @SerializedName("purpose") var purpose: ArrayList<String> = arrayListOf()
)

data class Location(
    @SerializedName("coordinates") var coordinates: ArrayList<Double> = arrayListOf()
)

data class PlaceItem(
    @SerializedName("_id") var Id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("state") var state: String? = null,
    @SerializedName("country") var country: String? = null,
    @SerializedName("status") var status: Int? = null,
    @SerializedName("type") var type: Int? = null
)

data class Places(
    @SerializedName("data") var data: ArrayList<PlaceItem> = arrayListOf(),
    @SerializedName("status") var status: Int? = null
)

data class Profession(
    @SerializedName("status") var status: Int? = null,
    @SerializedName("data") var data: String? = null
)

data class Bio(
    @SerializedName("data") val data: String? = null,
    @SerializedName("status") val status: Int? = null
)