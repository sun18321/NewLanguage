package com.sun.newlanguage

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

class User : Parcelable {
    private var name: String? = null
    private var age: Int = 0

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    //此处读的顺序要和 writeToParcel(Parcel dest, int flags)的写入顺序保持一致，否则会导致读取的数据出错
    private constructor(`in`: Parcel) {
        name = `in`.readString()
        age = `in`.readInt()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeInt(age)

    }

    companion object {

        @SuppressLint("ParcelCreator")
        val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
            override fun createFromParcel(source: Parcel): User {
                return User(source)
            }

            override fun newArray(size: Int): Array<User?> {
                return arrayOfNulls(size)
            }
        }
    }
}
