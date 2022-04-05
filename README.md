<h1 align="center">Github Api Tutorial App</h1>

<p align="center">  
Android App which shows list of all closed pull request from this repo
</p>

<p align="center">
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
</p>


## App Screenshots

<table>
  <tr>
    <img src="https://github.com/rahul6975/Github-Api-Tutorial/blob/master/screenshot/github_api_tutorial.png" width="200"/>
  </tr>
  
  
## Libraries & Tech Used
- Minimum SDK level 21
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) for asynchronous handling.
- JetPack
  - LiveData - notify domain layer data to views.
  - Lifecycle - observing data when lifecycle state changes.
  - ViewModel - lifecycle aware UI related data holder.
- Architecture
  - MVVM Architecture (View - ViewModel) 
- [Retrofit](https://square.github.io/retrofit/) - for getting response from API
- [Glide](https://github.com/bumptech/glide) - loading images.
