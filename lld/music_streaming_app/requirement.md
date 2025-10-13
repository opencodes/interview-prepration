### Music Streaming Application
System DesignHigh-Level Design (HLD)High ScalabilityHigh Availability
Medium

#### Design a music streaming application which fetches top trending songs. The application should provide a seamless and enjoyable user experience, supporting various features such as search, recommendations, playlists. It should be scalable, reliable, and responsive to accommodate a large number of concurrent users and handle peak loads efficiently.

Requirements:
- Find trending songs based on regions.
- Scalable and fault tolerance to handle millions of requests from the clients and handle peak loads efficiently.
- Music Library to maintain an extensive and diverse collection of songs, albums, and artists from various genres. Songs should have associated metadata like title, artist, album, genre, and release date.
- Search and Discovery so that user is able to search for songs, artists, and albums efficiently.
- Music Playback to provide smooth music playback with features like play, pause, skip, volume control, and progress tracking. It should support streaming audio at different bit rates based on user network conditions.

Follow ups:
- Design the data schema of the same
- Choices of DB to use.

## Recommendation Service
The recommendation system analyzes the user's listening habits, likes, and playlists. It uses a combination of collaborative filtering (based on users with similar preferences) and content-based filtering (based on song metadata).

### Collaborative Filtering
Collaborative filtering is one of the most commonly used techniques in recommendation systems. This method leverages the behavior of users with similar music tastes to generate recommendations.

##### User-Based Collaborative Filtering: 
This technique groups users based on their listening history. For example, if User A and User B both frequently listen to the same set of artists and songs, the system may recommend songs that User A has listened to but User B hasn’t.

##### Item-Based Collaborative Filtering: 
In this technique, songs are recommended based on their similarity to songs the user has previously liked. If many users who like Song X also like Song Y, the system recommends Song Y to users who have listened to Song X.

### Content-Based Filtering
**Content-based filtering** focuses on the properties of songs, such as genre, artist, album, tempo, and instrumentation, to recommend similar songs to users.

##### Song Attributes: 
Spotify collects metadata on each song, including genre, tempo, mood, and instruments. This data is used to recommend songs with similar attributes to what the user has already liked or listened to.

##### Artist Similarity: 
If a user listens to multiple songs from a particular artist, the system may recommend songs from similar artists, based on shared attributes (e.g., genre, style).

