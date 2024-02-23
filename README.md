# SharedPreferencesPlayground

## SharedPreferences Study Project
This project is a study on the use of SharedPreferences in Android applications, developed using Android Studio and Kotlin.

## Description
SharedPreferences is a way to store key/value pairs persistently. In this project, we explore how to use SharedPreferences to store and retrieve simple information in an Android application.

## Features
* Capture the user's name, phone number, and age through input fields.
* Store the entered data using SharedPreferences.
* Retrieve stored data for display.


## Layout
### The layout of the application consists of:
* A text field to enter the user's name.
* A text field to enter the user's phone number.
* A text field to enter the user's age.
* A button to save the entered data.

## Screenshots

<img width="261" alt="Captura de Tela 2024-02-23 às 16 11 44" src="https://github.com/Cacaendlich/SharedPreferences/assets/98967640/92351650-631f-43c1-9baa-6bb7466a998e">
<img width="258" alt="Captura de Tela 2024-02-23 às 16 12 59" src="https://github.com/Cacaendlich/SharedPreferences/assets/98967640/06e52b9d-a209-4404-ad3b-e00809fcfed8">
<img width="272" alt="Captura de Tela 2024-02-23 às 16 08 02" src="https://github.com/Cacaendlich/SharedPreferences/assets/98967640/4e559455-c8c1-48cc-9c94-6e40a3b78eb1">




## How to Use
* Clone this repository to your local development environment.
* Open the project in Android Studio.
* Run the application on an emulator or Android device.
* Enter the requested data in the text fields.
* Click the "Save" button to save the data.
* The data will be stored using SharedPreferences and can be retrieved later.

## Dependencies

### Here are the dependencies used in the project:

```groovy
dependencies {
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.8.2")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
