# palindrome-app
Web application to search all the palindromes in the given string.

To run the application:
1. Clone the project to the folder using 'git clone <project_link>'.
2. Open the project in the IDE (intelliJIDEA)
3. Run command 'mvn clean package'
4. Either run the Application.java file or run the terminal command ' java -jar target/palindrome-app-0.1.0.jar'
3. Open the browser and go to a 'localhost:8080' address.

Request example:
http://localhost:8080/palindrome?input=арозаупаланалапуазораabchelloolleh

Response example:
[
  {
    "position":0,
    "text":"арозаупаланалапуазора"
  },
  {
    "position":24,
    "text":"helloolleh"
  }
]

Allowed format string: no whitespaces, no any special character. Max length = 155 symbols.
