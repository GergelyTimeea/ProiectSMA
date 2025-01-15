package com.example.proiectdentisti.Domain

import android.os.Parcel
import android.os.Parcelable

data class DoctorsModel(
    val Address:String = "123 Main St",
    val Biography:String = "Expert in dental surgery",
    val Id:Int = 1,
    val Name:String ="Dr. John Doe",
    val Picture:String ="https://example.com/picture.jpg",
    val Special:String = "Dentist",
    val Expriense:Int = 10,
    val Location:String ="https://maps.google.com/?q=45.73909857525553, 21.235084185980583",
    val Mobile:String ="+123456789",
    val Patiens:String ="500",
    val Rating:Double = 4.5,
    val Site:String ="https://example.com"
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readDouble(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(Address)
        parcel.writeString(Biography)
        parcel.writeInt(Id)
        parcel.writeString(Name)
        parcel.writeString(Picture)
        parcel.writeString(Special)
        parcel.writeInt(Expriense)
        parcel.writeString(Location)
        parcel.writeString(Mobile)
        parcel.writeString(Patiens)
        parcel.writeDouble(Rating)
        parcel.writeString(Site)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DoctorsModel> {
        override fun createFromParcel(parcel: Parcel): DoctorsModel {
            return DoctorsModel(parcel)
        }

        override fun newArray(size: Int): Array<DoctorsModel?> {
            return arrayOfNulls(size)
        }
    }
}

