package com.example.chainsearch.initialAction.auth.callbacks

interface CredentialCallback {
    fun onRes(worked: Boolean, result: String?) {
    }
}