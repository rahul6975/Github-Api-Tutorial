package com.rahul.kotlinmvvmapp.models

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Generated("com.robohorse.robopojogenerator")
data class BaseClass(

	@field:SerializedName("ref")
	val ref: String? = null,

	@field:SerializedName("repo")
	val repo: RepoClass? = null,

	@field:SerializedName("label")
	val label: String? = null,

	@field:SerializedName("sha")
	val sha: String? = null,

	@field:SerializedName("user")
	val user: UserClass? = null
)