/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_haswalk_jvlapack_JvLapack */

#ifndef _Included_com_haswalk_jvlapack_JvLapack
#define _Included_com_haswalk_jvlapack_JvLapack
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_haswalk_jvlapack_JvLapack
 * Method:    dsyev
 * Signature: (ICCI[DI[D)V
 */
JNIEXPORT void JNICALL Java_com_haswalk_jvlapack_JvLapack_dsyev
  (JNIEnv *, jclass, jint, jchar, jchar, jint, jdoubleArray, jint, jdoubleArray);

/*
 * Class:     com_haswalk_jvlapack_JvLapack
 * Method:    dsysv
 * Signature: (ICII[DI[I[DI)V
 */
JNIEXPORT void JNICALL Java_com_haswalk_jvlapack_JvLapack_dsysv
  (JNIEnv *, jclass, jint, jchar, jint, jint, jdoubleArray, jint, jintArray, jdoubleArray, jint);

/*
 * Class:     com_haswalk_jvlapack_JvLapack
 * Method:    dposv
 * Signature: (ICII[DI[DI)V
 */
JNIEXPORT void JNICALL Java_com_haswalk_jvlapack_JvLapack_dposv
  (JNIEnv *, jclass, jint, jchar, jint, jint, jdoubleArray, jint, jdoubleArray, jint);

#ifdef __cplusplus
}
#endif
#endif
