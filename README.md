# ExploreCity App 🌍

ExploreCity is a modern Android application designed to help users discover and explore city landmarks and attractions with ease. The app features a professional Material Design interface, robust authentication, and integrated tools like a compass and maps for seamless navigation.

## 🚀 Features

-   **Professional Authentication**- Secure Sign-In, Sign-Up, and Password Recovery flows built with Material Design 3 components.
-   **City Exploration**- Discover local attractions with rich descriptions and media.
-   **Integrated Tools**
    *   🧭 **Real-time Compass**- Navigate the city with a built-in sensor-based compass.
    *   📍 **Google Maps Integration**- View locations and find your way easily.
    *   🎬 **Media Support**- High-quality video previews of destinations.
-   **Performance Optimized**: Specifically engineered to handle high-resolution assets efficiently, preventing OOM (Out of Memory) crashes on devices.

## 🛠 Tech Stack

-   **Language**- Java
-   **UI Framework**- Android XML with Material Components (MDC)
-   **Architecture**- Android Jetpack (AppCompat, ConstraintLayout, ViewModel)
-   **Database**- SQLite (via `DatabaseHelper`)
-   **Build System**- Gradle 8.10 / AGP 8.7.3
-   **APIs**- Google Play Services Maps

## ⚙️ Optimizations

This project underwent a significant performance and UI overhaul:
-   **Memory Management**- High-resolution background assets (e.g., `pi.jpg`) were optimized from 5MB+ to under 500KB to reduce RAM spikes and prevent heap-related crashes.
-   **UI Refactoring**- Legacy `EditText` and standard `Button` components were replaced with `TextInputLayout`, `TextInputEditText`, and `MaterialButton` for a professional, consistent look and feel.
-   **NPE Safety**- Implemented strict null-checks for `ActionBar` interactions to ensure stability across different Android versions.

## 📸 Screenshots

| Sign In | Sign Up | Forgot Password |
| :---: | :---: | :---: |
| [Sign In] | [Sign Up] | [Forgot Password] |


## 📥 Installation

1.  **Clone the repository**
    ```bash
    git clone https://github.com/vichara1998/explore-city.git
    ```
2.  **Open in Android Studio**
    *   File > Open > Select `ExploreCityapp` folder.
3.  **Build Project**
    *   Wait for Gradle Sync to complete.
    *   Ensure you have the latest Android SDK and Build Tools installed.
4.  **Run**
    *   Select your emulator or physical device and click **Run**.



---
Built with ❤️ for city explorers.
