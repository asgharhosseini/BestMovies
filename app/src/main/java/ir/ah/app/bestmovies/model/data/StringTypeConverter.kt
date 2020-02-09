package ir.ah.app.bestmovies.model.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Collections.emptyList


class StringTypeConverter {
    var gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<String?>? {
        if (data == null) {
            return emptyList()
        }
        val listType =
            object : TypeToken<List<String?>?>() {}.type
        return gson.fromJson<List<String?>>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<String?>?): String? {
        return gson.toJson(someObjects)
    }
}