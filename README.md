
# CarMeter

Carmeter project is about interfacing a GPS with a GUI [gauges or indicators for showing speed, longitude, latitude, etc..], so we show the data sent from GPS are to be parsed by Java application and showing them in the dedicated field on a user-friendly GUI Java application.


## Authors

- [@FadyKhalil](https://github.com/FadyKhalil)
- [@yasmin-samy](https://github.com/yasmin-samy)
- [@MostafaAdel26](https://github.com/MostafaAdel26)
- [@ayamustafa1011](https://github.com/ayamustafa1011)
- [@AndrewMorkos97](https://github.com/AndrewMorkos97)

## Features

- Labels to display the location using longitude and latitude in addition to displaying the speed [start, stop, latitude, longitude, sound off, switch, light mode and dark mode buttons]. 
- An audio is played as an alarm when the speed exceeds a certain limit and stops automatically when the speed is decreased and so on.
- The application can run if it’s not connected to internet by taking the choice of the user.
- Fullscreen mode
- You can switch between viewing the speedometer and the map simultaneously



## Installation

#### Using Gps Application
```bash
  Download and install “Bluetooth GPS Output” application from google play
  Pair the android phone with the laptop
  Open the application and make sure it read the location (LAt & LONG).
```
#### Using GPS Module
```bash
  Connect the Gps Module direct with a port to the laptop
  "Don't connect the Gps Module to arduino and then conncect the arduino to the 
  the laptop because the parsing data from the java application will not be completed as
  the arduino will not send the NMEA"
```
```bash
  JDK 1.8.201 (To make sure RXTX and GMapsFX work)
  Medusa-8.0.jar (This library to display the speedometer)
  GMapsFX-8.0.0.jar (To display Google map)
  RXTXcomm.jar (Used for the serial communication)
  Marineapi-0.10.0.jar (To support NMEA sentence)
  SerialRXTX.dll (make sure to put this file in your jdk extension exactly in <C:\Program Files\Java\jdk1.8.0_201\jre\bin>)
```
## API Google maps

#### This project Required api_key

```http
  https://developers.google.com/maps
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | Example: "AIz_9-iMxl-6Fnk" |

add note
## Demo


https://user-images.githubusercontent.com/96336295/150681423-1599e908-ef83-4971-be00-bf9f1208f274.mp4
