package com.example.mvvmarchitecture.util

import java.io.IOException

class ApiException(message : String ) : IOException(message)

class NoInternetExceptiom(message : String ) : IOException(message)