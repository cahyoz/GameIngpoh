package com.example.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListGameResponse(
	@SerializedName("count")
	val count: Int,

	@SerializedName("next")
	val next: String,

	@SerializedName("previous")
	val previous: String,

	@SerializedName("results")
	val results: List<GameResponse>
)

data class GameResponse(
	@SerializedName("id")
	val id: Int,

	@SerializedName("slug")
	val slug: String,

	@SerializedName("name")
	val name: String,

	@SerializedName("released")
	val released: String,

	@SerializedName("tba")
	val tba: Boolean,

	@SerializedName("background_image")
	val backgroundImage: String,

	@SerializedName("rating")
	val rating: Double,

	@SerializedName("rating_top")
	val ratingTop: Int,

	@SerializedName("ratings")
	val ratings: Array<Any>, // You may need to adjust this based on the actual structure

	@SerializedName("ratings_count")
	val ratingsCount: Int,

	@SerializedName("reviews_text_count")
	val reviewsTextCount: String,

	@SerializedName("added")
	val added: Int,

	@SerializedName("added_by_status")
	val addedByStatus: Map<String, Any>, // You may need to adjust this based on the actual structure

	@SerializedName("metacritic")
	val metacritic: Int,

	@SerializedName("playtime")
	val playtime: Int,

	@SerializedName("suggestions_count")
	val suggestionsCount: Int,

	@SerializedName("updated")
	val updated: String,

	@SerializedName("esrb_rating")
	val esrbRating: EsrbRating, // Adjust this based on the actual structure

	@SerializedName("platforms")
	val platforms: List<Platform> // Adjust this based on the actual structure
)

data class EsrbRating(
	@SerializedName("id")
	val id: Int,

	@SerializedName("slug")
	val slug: String,

	@SerializedName("name")
	val name: String
)

data class Platform(
	@SerializedName("platform")
	val platform: PlatformInfo,

	@SerializedName("released_at")
	val releasedAt: String,

	@SerializedName("requirements")
	val requirements: Requirements // Adjust this based on the actual structure
)

data class PlatformInfo(
	@SerializedName("id")
	val id: Int,

	@SerializedName("slug")
	val slug: String,

	@SerializedName("name")
	val name: String
)

data class Requirements(
	@SerializedName("minimum")
	val minimum: String,

	@SerializedName("recommended")
	val recommended: String
)
