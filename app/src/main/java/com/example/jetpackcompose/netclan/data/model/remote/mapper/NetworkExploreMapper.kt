package com.example.jetpackcompose.netclan.data.model.remote.mapper

import android.util.Log
import com.example.jetpackcompose.netclan.data.model.remote.dto.response.IndividualData
import com.example.jetpackcompose.netclan.data.model.remote.dto.response.Places
import com.example.jetpackcompose.netclan.data.model.remote.dto.response.Startup
import com.example.jetpackcompose.netclan.domain.model.IndividualExploreModel
import java.text.DecimalFormat

fun IndividualData.mapFromEntity() = IndividualExploreModel(
    image = this.profilePicUrl.orEmpty(),
    name = this.firstName + " " + this.lastName,
    place = getPlace(this.places!!) + " | " + this.profession!!.data.orEmpty(),
    distance = "Within " + rangeConvertInSIUnit(this.distanceAway!!),
    uid = this.uid.orEmpty(),
    purposes = getPurpose(this.startup!!),
    wishList = this.startup!!.wishlist.orEmpty(),
    profession = this.profession!!.data.orEmpty(),
    gender = getGender(this.gender!!),
    invitationStatus = getConnectionStatus(this.invStatus!!),
    bio = this.bio?.data.orEmpty(),
    profileScore = getProfileScore(this.profileScore!!)
)


fun List<IndividualData>.mapFromListModel(): List<IndividualExploreModel> {
    return this.map {
        it.mapFromEntity()
    }
}

private fun getPlace(place: Places): String {
    var placeName = ""
    return try {
        val placeItems = place.data
        for (data in placeItems) {
            if (data.type == 1) {
                placeName = data.name!!
            }
        }
        if (placeName.contains(",")) {
            placeName = placeName.substring(0, placeName.indexOf(","))
        }
        placeName
    } catch (e: Exception) {
        placeName
    }
}

private fun rangeConvertInSIUnit(distanceMeters: Int): String {
    return if (isBetween(distanceMeters, 0, 100)) {
        "100 m"
    } else if (isBetween(distanceMeters, 100, 200)) {
        "100-200 m"
    } else if (isBetween(distanceMeters, 200, 300)) {
        "200-300 m"
    } else if (isBetween(distanceMeters, 300, 400)) {
        "300-400 m"
    } else if (isBetween(distanceMeters, 400, 500)) {
        "400-500 m"
    } else if (isBetween(distanceMeters, 500, 600)) {
        "500-600 m"
    } else if (isBetween(distanceMeters, 600, 700)) {
        "600-700 m"
    } else if (isBetween(distanceMeters, 700, 800)) {
        "700-800 m"
    } else if (isBetween(distanceMeters, 800, 900)) {
        "800-900 m"
    } else if (isBetween(distanceMeters, 900, 1000)) {
        "1 KM"
    } else {
        var distanceKm = distanceMeters / 1000.0
        distanceKm = Math.round(distanceKm * 10.0) / 10.0
        val df = DecimalFormat("#.0")
        df.format(distanceKm) + " KM"
    }
}

private fun isBetween(x: Int, lower: Int, upper: Int): Boolean {
    return lower <= x && x <= upper
}

private fun getPurpose(data: Startup): String {
    var allPurpose = ""
    val allpurposelist = StringBuilder()
    try {
        if (data != null) {
            val purposeList: List<String> =
                data.purpose
            if (purposeList != null) {
                for (j in purposeList.indices) {
                    allPurpose = if (j == 0) {
                        allpurposelist.append(purposeList[0]).toString()
                    } else {
                        allpurposelist.append(" | " + purposeList[j]).toString()
                    }
                }
            }
        }
        return allPurpose
    } catch (e: java.lang.Exception) {
        return allPurpose
    }
}

private fun getGender(gender: Int): String {
    return if (gender == 0) {
        "Male"
    } else {
        "Female"
    }
}

private fun getConnectionStatus(status: Int): String {
    if (status == 0) {
        return "+ Invite"
    } else if (status == 1) {
        return "Pending"
    } else {
        return "Connected"
    }
}

private fun getProfileScore(score: Int): Float {
    return 0.5.toFloat()
}

