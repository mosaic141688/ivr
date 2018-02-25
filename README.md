# ivr

The Components of the project are: 

- [ ] The GUI Component which is the subclass of Android Activity Class
- [ ] The Service that listens for USSD results and gets the text from it
This Component extends the AccessibilityService base class by inheritance

- [ ] The Component that takes the text from the USSD Service and uses the Text To Speach engine to convert i tto voice
This Component inherits from the TextToSpeech.OnInitListener class by polymophysim and implements the onInit virtual method which is
called when the TTS engine has been initialised
