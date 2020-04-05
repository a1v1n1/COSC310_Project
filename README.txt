==========================================================
||			Group 32			||
|| Alvin Krisnanto Putra		54658380	||
|| Manassawin Rotsawatsuk (Winter)	12682936	||
|| 							||
==========================================================
This project aims to create a "medical" diagnosis chatbot. It is meant to help you find the correct type of physician based on your specific symptoms.

The classes are organized into main and stages. Main is used to run the stages, while the stages handle branches of conversations that you enter into. Each additional feature is added into the project as another stage.

The Main class handles the creation of the bot in a while loop so the user can talk to as many bots as they want. The Main class sends the user to Bot.start() once a bot has been created

The Bot class handles creating the different stages of the conversation and looping through them. The class uses enums to improve code readability. The bot name is also randomized upon creation of the bot.

The Stage class is used as a parent to all other stage classes to guarantee that they have specific features.

The IntroStage class handles the greeting of the user, and asks if they need medical attention. If they say no, the chat closes. If they say yes, it continues to ImmediateStage

The ImmediateStage class checks if the user requires immediate emergency medical attention. If yes, the chatbot asks for the user's address and dispatches 911 to that location. If no, it continues to FreeStage.

The FreeStage class handles user information gathering. If they are not free, the chat ends. If they are, it asks for their name, sex, and age before moving to Diagnosis.

The Diagnosis class handles user diagnosis by asking them what they are having issues with. After data collection, it suggests the appropriate types of physicians to handle the problem. After finishing their diagnosis, the user is sent to Review.

The Review class asks the user to leave a review and rate the experience out of 5. The chat closes after the answers are collected.

Changes since A2:
Improvements to text and number parser.

Addition of second conversation topic(Get help from 911).

5 varied responses for out of topic conversation attempts.

Addition of the GuiMain class forms the GUI of the main window, which allows the user to start a chat window with an agent.

Addition of the GuiBot class forms the GUI for the chat window, which allows user to chat with an agent within a GUI instead of a console.

Addition of the ChatbotSocket class enables the communication of the chatbot with other chatbots, where it is able to communicate through the use of sockets.
