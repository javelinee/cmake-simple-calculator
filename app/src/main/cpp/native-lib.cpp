#include <jni.h>
#include <string>
#include<stdio.h>

extern "C" JNIEXPORT jstring JNICALL Java_com_jesselyn_c_MainActivity_stringFromJNI(JNIEnv* env, jobject /* this */) {
    std::string hello = "A Simple Calculator App with NDK";
    return env->NewStringUTF(hello.c_str());
}

extern "C" JNIEXPORT jint JNICALL Java_com_jesselyn_c_MainActivity_addition(JNIEnv* env, jobject obj, jint x, jint y) {
    return x + y;
}

extern "C" JNIEXPORT jint JNICALL Java_com_jesselyn_c_MainActivity_subtract(JNIEnv* env, jobject obj, jint x, jint y) {
    return x - y;
}

extern "C" JNIEXPORT jint JNICALL Java_com_jesselyn_c_MainActivity_div(JNIEnv* env, jobject obj, jint x, jint y) {
    return x / y;
}

extern "C" JNIEXPORT jint JNICALL Java_com_jesselyn_c_MainActivity_multiplication(JNIEnv* env, jobject obj, jint x, jint y) {
    return x * y;
}


