package Automation.Spotify_automation;

import static io.restassured.RestAssured.given;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;
@Test
public class api {
	public String token ="Bearer BQBmM8uekKzJ1ZUf0DUkvKGhlr66hA_nPGiEXaqvEJ_Uh4d-Ymo433nUdvQtAuQq4B6jOUhS8l0feC7rv4t7sGo0wJy1lWgQ6ct00oKsx_az7pkmJighOXfIx6__PDS3ves2LWQ57s-JCt2l1OclBNFU2AlCl8b-spZqPDwpjR9ihrhYjLC-pKl_TUL50-DC7HxeEx_cqNSfYNAUZzG-4KOTpWpCbH3oLxbN_tELLIDsOVTdtmTpdS_xMz02DYuZH626Ew";
	@Test
	public void getuserprofile() {
		Response response=given()
				.header("Accept","application/json")
				.header("Content-Type"," application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/me");
		response.prettyPrint();
		String userId=response.path("id");
		System.out.println("----------------------------------------------------");
		System.out.println("userId --"+userId);
		response.then().assertThat().statusCode(200);
		Assert.assertEquals(200, response.getStatusCode());
		String url=response.path("external_urls.spotify");
		System.out.println("----------------------------------------------------");
		System.out.println("URL --"+url);
		response.then().assertThat().statusCode(200);
		Assert.assertEquals(200, response.getStatusCode());
			}
	@Test
	public void getcurrentuserprofile() {
		Response response=given()
				.header("Accept","application/json")
				.header("Content-Type"," application/json")
				.header("Authorization",token)
				.when()
				.get("https://api.spotify.com/v1/users/31zlloo3zvqziikgkopnfiht66am");
		response.prettyPrint();
	}
	
@Test
public void createplaylist() {
	Response response=given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorization",token)
			.body("{\"name\":\"Spiritual songs\",\"description\":\"\"New playlist description\",\"public\":false}")
			.when()
			.post("https://api.spotify.com/v1/users/31zlloo3zvqziikgkopnfiht66am/playlists");
	response.prettyPrint();
}
@Test
public void getcurrentuserplaylist() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.when()
			.get("https://api.spotify.com/v1/users/31zlloo3zvqziikgkopnfiht66am/playlists?offset=5&limit=10");
	response.prettyPrint();
}
@Test
public void GetPlaylistCoverImage() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.when()
			.get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/images\" -H \"Accept: application/json\" -H \"Content-Type: application/json\" -H \"Authorization: Bearer BQDuvb2a23_ysDuceth3TOaeLEDObCtuiZYuMaK2xYW-ORhOhhXHZD8hugslavkpsFYwwEQ_cxC4vCjBIkTRIe7Iz0N8hOtQuT34IS_-d3c47Vv10yv14FaKaK_RwhIl2XEvM97w41rOOs_EbGl5RS6WJqnoyxMYZhmtbRGXosWXJ068AQl-vDmYZdblNnEQN6hPw4gFLYGC9-Aq5nirSkd0r4PkwPLpGaGEzb8USOqNfsP18LJb-fqpzdhmKY_UFmrduXbR7V9r");
	response.prettyPrint();
}
@Test
public void Search_Method() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			//.pathParam("q","artist")
			//.pathParam("type", "track")
			.queryParams("q","artist")
			.queryParams("type","track")
			.when()
			.get("https://api.spotify.com/v1/search");
	//.get("https://api.spotify.com/v1/search?q={q}&type={type}"};
	response.prettyPrint();
	System.out.println("----------------------------------------------------");
	response.then().assertThat().statusCode(200);
	Assert.assertEquals(200, response.getStatusCode());
			}
@Test
public void GetArtistAlbums() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/albums?offset=5&limit=10&include_groups=single,appears_on&market=ES&locale=en-US,en;q=0.9");
	response.prettyPrint();
}
@Test
public void GetPlaylistAlbums() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/tracks?market=ES&fields=items(added_by.id%2Ctrack(name%2Chref%2Calbum(name%2Chref)))&limit=10&offset=5");
	response.prettyPrint();
}
@Test
public void GetPlaylist() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n?market=ES&fields=items(added_by.id%2Ctrack(name%2Chref%2Calbum(name%2Chref)))");
	response.prettyPrint();
}
@Test
public void GetUsersPlaylist() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/users/smedjan/playlists?limit=10&offset=5");
	response.prettyPrint();
}
@Test
public void GetSeveralShows() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/shows?market=ES&ids=5CfCWKI5pZ28U0uOzXkDHe%2C5as3aKmN2k11yfDDDSrvaZ");
	response.prettyPrint();
}
@Test
public void GetShowEpisodes() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ/episodes?market=ES&limit=10&offset=5" );
	response.prettyPrint();
}
@Test
public void GetShow() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/shows/38bS44xjbVVZ3No3ByF1dJ?market=ES" );
	response.prettyPrint();
}
@Test
public void GetTracksAudioAnalysis() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get( "https://api.spotify.com/v1/audio-analysis/11dFghVXANMlKmJXsNCbNl");
	response.prettyPrint();
}
@Test
public void GetTracksAudioFeatures() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/audio-features?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
	response.prettyPrint();
}
@Test
public void GetTracksAudioFeatures2() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/audio-features/11dFghVXANMlKmJXsNCbNl");
	response.prettyPrint();
}
@Test
public void GetSeveralTracks() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/tracks?market=ES&ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B");
	response.prettyPrint();
}
@Test
public void GetTrack() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/tracks/11dFghVXANMlKmJXsNCbNl?market=ES" );
	response.prettyPrint();
}
@Test
public void GetAlbumTrack() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks?market=ES&limit=10&offset=5");
	response.prettyPrint();
}
@Test
public void GetAlbum() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/albums/4aawyAB9vmqN3uQ7FjRGTy?market=ES");
	response.prettyPrint();
}
@Test
public void GetSeveralAlbum() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/albums?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc&market=ES");
	response.prettyPrint();
}
@Test
public void GetArtistsAlbums() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/albums?include_groups=single%2Cappears_on&market=ES&limit=10&offset=5\" -H \"Accept: application/json");
	response.prettyPrint();
}
@Test
public void GetArtistsRelatedArtists() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/related-artists");
	response.prettyPrint();
}
@Test
public void  GetArtistsTopTracks() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg/top-tracks?market=ES");
	response.prettyPrint();
}
@Test
public void  GetArtist() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/artists/0TnOYISbd1XYRBk9myaseg");
	response.prettyPrint();
}
@Test
public void  GetSeveralArtist() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/artists?ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
	response.prettyPrint();
}
@Test
public void  GetAudiobookChapters() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/audiobooks/38bS44xjbVVZ3No3ByF1dJ/chapters?market=ES&limit=10&offset=5");
	response.prettyPrint();
}
@Test
public void  GetanAudiobook() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/audiobooks/38bS44xjbVVZ3No3ByF1dJ?market=ES");
	response.prettyPrint();
}
@Test
public void  GetSeveralAudiobooks() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/audiobooks?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B&market=ES");
	response.prettyPrint();
}
@Test
public void GetAvailableGenreSeeds () {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/recommendations/available-genre-seeds");
	response.prettyPrint();
}
@Test
public void GetSeveralBrowseCategories() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/browse/categories?country=SE&locale=sv_SE&limit=10&offset=5");
	response.prettyPrint();
}
@Test
public void GetSingleBrowseCategory() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/browse/categories/dinner?country=SE&locale=sv_SE");
	response.prettyPrint();
}
@Test
public void GetCategorysPlaylists() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/browse/categories/dinner/playlists?country=SE&limit=10&offset=5");
	response.prettyPrint();
}
@Test
public void GetFeaturedPlaylists() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/browse/featured-playlists?country=SE&locale=sv_SE&timestamp=2014-10-23T09%3A00%3A00.000Z&limit=10&offset=5");
	response.prettyPrint();
}
@Test
public void GetNewReleases() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/browse/new-releases?country=SE&limit=10&offset=5");
	response.prettyPrint();
}
@Test
public void GetRecommendations() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/recommendations?limit=10&market=ES&seed_artists=4NHQUGzhtTLFvgF5SZesLK&seed_genres=classical%2Ccountry&seed_tracks=0c6xIDDpzE81m2q797ordA");
	response.prettyPrint();
}
@Test
public void  GetaChapter() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/chapters/38bS44xjbVVZ3No3ByF1dJ?market=ES");
	response.prettyPrint();
}
@Test
public void  GetSeveralChapters() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/chapters?ids=7ouMYWpwJ422jRcDASZB7P%2C4VqPOruhp5EdPBeR92t6lQ%2C2takcwOaAZWiXQijPHIx7B&market=ES");
	response.prettyPrint();
}
@Test
public void  GetEpisode() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/episodes/512ojhOuo1ktJprKbVcKyQ?market=ES");
	response.prettyPrint();
}
@Test
public void GetSeveralEpisodes() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/episodes?ids=77o6BIVlYM3msb4MMIL1jH%2C0Q86acNRm6V9GYx55SXKwf&market=ES\" -H \"Accept: application/json");
	response.prettyPrint();
}
@Test
public void UnfollowArtistsorUsers() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/me/following?type=artist&ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6\" --data \"{ids:[\\\"74ASZWbe4lXaubB36ztrGX\\\", \\\"08td7MxkoHQkXnWAYD8d6Q\\\"]}");
	response.prettyPrint();
}
@Test
public void UnfollowPlaylist() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers");
	response.prettyPrint();
}
@Test
public void  CheckIfUserFollowsArtistsorUsers() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/me/following/contains?type=artist&ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
	response.prettyPrint();
}
@Test
public void GetFollowedArtists() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/me/following?type=artist&after=0I2XqVXqHScXjHhk6AYYRe&limit=10\" -H \"Accept: application/json");
	response.prettyPrint();
}
@Test
public void CheckifUsersFollowPlaylist() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers/contains?ids=jmperezperez%2Cthelinmichael%2Cwizzler");
	response.prettyPrint();
}
@Test
public void FollowArtistsorUsers() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/me/following?type=artist&ids=2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6");
	response.prettyPrint();
}
@Test
public void FollowPlaylist() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/playlists/3cEYpjA9oz9GiPac4AsH4n/followers");
	response.prettyPrint();
}
@Test
public void RemoveUsersSavedAlbums() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/me/albums?ids=382ObEPsp2rxGrnsizN5TX%2C1A2GTWGtFfWp7KSQTwWOyo%2C2noRn2Aes5aoNVsU6iWThc");
	response.prettyPrint();
}
@Test
public void GetAvailableMarkets() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/markets\" -H ");
	response.prettyPrint();
}
@Test
public void GetUsersTopItems() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/me/top/artists?time_range=medium_term&limit=10&offset=5");
	response.prettyPrint();
}
@Test
public void GettheUsersQueue() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/me/player/queue\" -H \"Accept: application/json");
	response.prettyPrint();
}
@Test
public void GetRecentlyPlayedTracks() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/me/player/recently-played?limit=10&after=1484811043508");
	response.prettyPrint();
}
@Test
public void GetPlaybackState() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/me/player?market=ES");
	response.prettyPrint();
}
@Test
public void GetAvailableDevices() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/me/player/devices");
	response.prettyPrint();
}
@Test
public void GetCurrentlyPlayingTrack() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/me/player/currently-playing?market=ES");
	response.prettyPrint();
}
@Test
public void SkipToNext() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/me/player/next?device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8\" -H \"Accept: application/json");
	response.prettyPrint();
}
@Test
public void SkipToPrevious() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/me/player/previous?device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
	response.prettyPrint();
}
@Test
public void AddItemtoPlaybackQueue() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/me/player/queue?uri=spotify%3Atrack%3A4iV5W9uYEdYUVa79Axb7Rh&device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
	response.prettyPrint();
}
@Test
public void PausePlayback() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/me/player/pause?device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
	response.prettyPrint();
}
@Test
public void StartResumePlayback() {
	Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/me/player/play?device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
	response.prettyPrint();
}

@Test
public void SetRepeatMode() {
Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/me/player/repeat?state=context&device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
	response.prettyPrint();
}
@Test
public void SeekToPosition() {
Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/me/player/seek?position_ms=25000&device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
	response.prettyPrint();
}
@Test
public void TogglePlaybackShuffle() {
Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/me/player/shuffle?state=true&device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
	response.prettyPrint();
}
@Test
public void TransferPlayback() {
Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/me/player\" --data \"{\\\"device_ids\\");
	response.prettyPrint();
}
@Test
public void SetPlaybackVolume() {
Response response=given()
			.header("Accept","application/json")
			.header("Content-Type"," application/json")
			.header("Authorization",token)
			.get("https://api.spotify.com/v1/me/player/volume?volume_percent=50&device_id=0d1841b0976bae2a3a310dd74c0f3df354899bc8");
	response.prettyPrint();
}
@Test
public void get1() {
	Response response=given()
			.header("Accept", "application/json")
			.header("Content-Type", "application/json")
			.header("Authorisation",token)
			.pathParam("q", "remaster%20track:Doxy%20artist:Miles%20Davis")
			.pathParam("type", "track")
			.when()
			.get("");
	response.prettyPrint();
	System.out.println("----------------------------");
	response.then().assertThat().statusCode(200);
	Assert.assertEquals(200, response.getStatusCode());
}



}
