# Tech Challenge
FORVIA Tech Challenge

### Description
This Android application fetches and displays a list of applications from Aptoide using their provided API in JSON format. Additionally, it includes an "App Details" screen accessible by tapping an app in the list, featuring additional information and a "Download" button which displays a text indicating that download functionality is not available in demo mode.

### Features

- Fetches and displays a list of applications from Aptoide API.
- Displays detailed information about each app and a "Download" button.
- Sends notifications every 30 minutes.
- Provides offline support by caching apps data for use without an internet connection.

## Usage

1. Upon launching the app, it fetches the list of applications from the Aptoide API.
2. The main screen displays the list of applications.
3. Tap on any app to view its details.
4. In the "App Details" screen, additional information about the app is displayed along with a "Download" button (functionality disabled in demo mode).
5. The app sends notifications every 30 minutes when new apps are available.
6. The app works offline by using cached data when there is no internet connection.

## Improvements

1. Caching the background/images
2. Send the notification only when the list of apps is different than previous list.
3. Improve testing.

## Results
APK and Demo available in results folder

## Demo
[![FORVIA Tech Challenge](https://raw.githubusercontent.com/joqinha/TechChallenge/master/results/thumbnail.png)](https://raw.githubusercontent.com/joqinha/TechChallenge/master/results/Demo_Tech_Challenge.webm)