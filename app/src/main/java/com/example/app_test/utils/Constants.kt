package com.example.app_test.retrofit.utils

object  Constants {
    const val TAG : String = "로그"
}

enum class SEARCH_TYPE {
    PHOTO,
    USER
}

enum class  RESPONSE_STATE {
    OKAY,
    FAIL
}
object API {
    const val BASE_URL : String = "https://api.unsplash.com/"

    const val CLIENT_ID : String = "qhMJZnDcaW8r4Dd7MX0V_9lp6iBJmdxYz9HxKGmZa-c"

    const val SEARCH_PHOTOS : String = "search/photos"
    const val SEARCH_USERS : String = "search/users"

}
