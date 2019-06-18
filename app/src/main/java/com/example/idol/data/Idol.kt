package com.example.idol.data

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "idols")
data class Idol (
    @ColumnInfo(name="nombre") var nombre:String,
    @ColumnInfo(name="compañia") var compañia:String,
    @ColumnInfo(name="estatura") var estatura:String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        nombre = parcel.readString(),
        compañia = parcel.readString(),
        estatura = parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(compañia)
        parcel.writeString(estatura)
    }

    override fun describeContents() = 0

    companion object CREATOR : Parcelable.Creator<Idol> {
            override fun createFromParcel(parcel: Parcel): Idol = Idol(parcel)
            override fun newArray(size: Int): Array<Idol?> = arrayOfNulls(size)
        }

    @PrimaryKey (autoGenerate = true)
    @ColumnInfo(name = "id") var id:Int=0
}