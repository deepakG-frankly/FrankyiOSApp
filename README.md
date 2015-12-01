#Steps to run iOS app on Simulator with 

1. prerequisite for run the appium in mac machine
 a. Install java 
 b. Configure Maven in your Mac machine for building the project
 c. Install ruby and homebrew from www.brew.sh
	install node commend brew with terminal
		brew install node
 d. Install Appium server using node
	npm install -g appium
	appium &
 e. Run sudo authorise ios

2. For running the test script on mobile simulator we can use ipa file or .app which comes after building the project
	Steps for building the project to get .app file
		a. select a same simulator in Xcode while building the app that you have selected in appium
3. For running the test script on real device you will be needing .ipa file
	Steps for extracting the .ipa file from Xcode
	Always do clear sing in for extracting the .ipa file form xacode
