#include <jni.h>
#include <string>


extern "C" jstring Java_com_example_home_data_remote_service_footballMatches_FootballServiceImpl_getBaseUrlFromNative(
        JNIEnv* env,
        jobject /* this */) {
    std::string baseURL = "https://api.football-data.org/v2/";
    return env->NewStringUTF(baseURL.c_str());
}


extern "C" jstring Java_com_example_home_data_remote_service_footballMatches_FootballServiceImpl_getApiKeyName(
        JNIEnv* env,
        jobject /* this */) {
    std::string keyName = "X-Auth-Token";
    return env->NewStringUTF(keyName.c_str());
}

extern "C" jstring Java_com_example_home_data_remote_service_footballMatches_FootballServiceImpl_getApiKeyValue(
        JNIEnv* env,
        jobject /* this */) {
    std::string keyValue = "965c87cec54f484e9b2de4c841e6ca3a";
    return env->NewStringUTF(keyValue.c_str());
}
