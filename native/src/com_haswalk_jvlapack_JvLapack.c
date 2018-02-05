#include <stdio.h>
#include <jni.h>
#include <assert.h>
#include "mkl_lapacke.h"
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
  (JNIEnv * env, jclass clazz, jint layout, jchar jobz, jchar uplo, jint n, jdoubleArray A, jint LDA, jdoubleArray w) {
    jdouble *aElems = (*env) -> GetDoubleArrayElements(env, A, NULL);
    jdouble *wElems = (*env) -> GetDoubleArrayElements(env, w, NULL);
    assert(aElems && wElems);
    int info = LAPACKE_dsyev((int)layout, (char)jobz, (char) uplo, (int) n, aElems, (int) LDA, wElems);

    if(info != 0) {
        jclass excCls = (*env)->FindClass(env, "java/lang/IllegalArgumentException");
        if(!excCls) {
             return;
        }
        char* msg;
        if(info > 0) {
            sprintf(msg, "The algorithm failed to converge; %d off-diagonal elements of an intermediate tridiagonal form did not converge to zero.", info);
        }else if(info < 0) {
            sprintf(msg, "the %d-th argument had an illegal value", -info);
        }
        (*env)->ThrowNew(env, excCls, msg);
    }

    (*env) -> ReleaseDoubleArrayElements(env, A, aElems, 0);
    (*env) -> ReleaseDoubleArrayElements(env, w, wElems, 0);
  }

/*
 * Class:     com_haswalk_jvlapack_JvLapack
 * Method:    dposv
 * Signature: (ICII[DI[DI)V
 */
JNIEXPORT void JNICALL Java_com_haswalk_jvlapack_JvLapack_dposv
  (JNIEnv * env, jclass clazz, jint layout, jchar uplo, jint n, jint nrhs, jdoubleArray A, jint LDA, jdoubleArray B, jint LDB) {
    jdouble *aElems = (*env) -> GetDoubleArrayElements(env, A, NULL);
    jdouble *bElems = (*env) -> GetDoubleArrayElements(env, B, NULL);
    assert(aElems && bElems);

    int info = LAPACKE_dposv((int) layout, (char)uplo, (int)n, (int)nrhs, aElems, (int)LDA, bElems, (int)LDB);

    (*env) -> ReleaseDoubleArrayElements(env, B, bElems, 0);
    (*env) -> ReleaseDoubleArrayElements(env, A, aElems, JNI_ABORT);

}

#ifdef __cplusplus
}
#endif
#endif