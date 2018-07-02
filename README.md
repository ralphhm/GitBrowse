# GitBrowse
### Summary
This is a sample app written in Kotlin that shows trending Android repositories on Github.
The main screen which is the entry point of the app is a list repositories. It acts as master view where the user can click on a repository item and gets navigated to a detail view.
The MVI pattern is used to encapsulate App specific domain logic into ViewModels that emit mutual exclusive ui states.
The use of [Android architecture ViewModel](The use https://developer.android.com/topic/libraries/architecture/viewmodel) allows ui state preserving on orientation change.
The internals of the ViewModel are based on explicit ui states that are inspired by the talk [Managing State with RxJava by Jake Wharton](https://www.youtube.com/watch?v=0IKHxjkgop4).

### Dependencies
* [Kotlin](https://developer.android.com/kotlin)
* [Retrofit 2](http://square.github.io/retrofit) HTTP client to query the API and map requests in a declarative way
* [Moshi](https://github.com/square/moshi) JSON library to parse custom Date attributes
* [RxJava 2](https://github.com/ReactiveX/RxJava) reactive extensions for the JVM to handle asynchronous events in a reactive/stream based way  
* [Koin](https://insert-koin.io/) lightweight Kotlin dependency injection framework that allows simple ViewHolder injection and without code generation
* [Groupie](https://github.com/lisawray/groupie) RecyclerView layout library that implements delegation pattern to easily add new item types   
* [Fresco](http://frescolib.org) Image loading library for loading movie images
* [Android arch LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
* [Android arch ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)

### Build
The App can be build by executing the task assembleRelease with the supplied Gradle wrapper "gradlew" 

### Possible improvements
* Cache repository entities in database using Room
* Add paging support
* Provide a search box that triggers a repository search by query
* Add pull to refresh for refreshing the content