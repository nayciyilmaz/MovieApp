![Logo](https://github.com/nayciyilmaz/MovieApp/blob/main/proje.png?raw=true)

## Features

Modern UI Design: Implements a sleek and user-friendly interface using Jetpack Compose and Material Design 3 components.
Navigation Architecture: Seamless navigation between screens using the Navigation component.
Dynamic Movie List: Displays a list of movies fetched dynamically and allows users to interact with each item.
Expandable Movie Details: Provides detailed information about a selected movie, including an image gallery.
Lazy Loading: Efficiently handles long lists using LazyColumn and LazyRow for optimized performance.
Responsive TopAppBar: Interactive top bar with a back navigation option and a clean title display.

## Project Structure

HomeScreen: The main screen displaying a list of movies using LazyColumn. Each movie card is clickable and navigates to the details screen.
DetailScreen: Provides detailed information about a selected movie, including a horizontal scrollable image gallery using LazyRow.
MovieNavigation: Manages the app’s navigation flow with a NavHost, defining routes for the home and detail screens.
MovieScreen: Enum class that holds navigation route constants.
MovieRow: Reusable composable displaying a movie’s information in a consistent layout.

## Technologies Used

Kotlin: The primary language for developing the app.
Jetpack Compose: Used to build declarative UI components.
Material Design 3: Ensures a modern, accessible, and consistent design across all screens.
Navigation Component: Simplifies screen navigation with route management.
Coil: An image loading library for handling movie image URLs in a performant way.
