package com.rahul.kotlinmvvmapp.models

import javax.annotation.Generated
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Generated("com.robohorse.robopojogenerator")
data class LinksClass(

	@field:SerializedName("comments")
	val comments: CommentsClass? = null,

	@field:SerializedName("issue")
	val issue: IssueClass? = null,

	@field:SerializedName("self")
	val self: SelfClass? = null,

	@field:SerializedName("review_comments")
	val reviewComments: ReviewCommentsClass? = null,

	@field:SerializedName("commits")
	val commits: CommitsClass? = null,

	@field:SerializedName("statuses")
	val statuses: StatusesClass? = null,

	@field:SerializedName("html")
	val html: HtmlClass? = null,

	@field:SerializedName("review_comment")
	val reviewComment: ReviewCommentClass? = null
)