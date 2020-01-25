package io.github.sooakim.auth.util.ext

import java.security.MessageDigest

fun String.encodeSHA256(): String{
    val messageDigest = MessageDigest.getInstance("SHA-256")
    val digest = messageDigest.digest(this.toByteArray())
    return digest.fold(""){ acc, item -> acc + "%02x".format(item) }
}