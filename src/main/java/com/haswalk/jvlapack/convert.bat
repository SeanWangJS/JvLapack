gcc -c .\lib\com_haswalk_jlapack_JLapack.c -o .\lib\com_haswalk_jlapack_JLapack.o -I "%MKL_ROOT%\include" -I "%JAVA_HOME%\include" -I "%JAVA_HOME%\include\win32"
gcc -shared -o .\lib\com_haswalk_jlapack_JLapack.dll .\lib\com_haswalk_jlapack_JLapack.o -L "%MKL_ROOT%\lib\intel64_win" -lmkl_rt