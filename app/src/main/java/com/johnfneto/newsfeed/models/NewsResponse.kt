import com.google.gson.annotations.SerializedName
import com.johnfneto.newsfeed.models.Articles

data class NewsResponse (

	@SerializedName("status") val status : String,
	@SerializedName("totalResults") val totalResults : Int,
	@SerializedName("articles") val articles : List<Articles>
)