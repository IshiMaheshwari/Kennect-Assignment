
Case Study: Post-Feed Application

This is a simple Java web application that allows users to create text posts and add comments to those posts.

## Problem Statement

The goal of this project is to create a web application that lets users create text posts and add comments to these posts. The application should have the following features:

1. Ask the user to enter their name before showing the page.
2. Users can create new posts, including a message and their username.
3. Users can add comments to any post, including a message and their username.
4. If posts are available, display the posts.
5. If there are no posts to show, display a message encouraging the user to create a post.

## Technologies Used

- Java: The application's backend logic is implemented in Java.
- Servlets: Java Servlets are used to handle HTTP requests and responses.
- MySQL: The application stores posts and comments data in a MySQL database.
- HTML/CSS/JavaScript: These technologies are used for the frontend user interface.
- Docker: Docker is used for containerizing the application for easy deployment.

## Project Structure

The project structure is as follows:

- **webapp** This directory contains the web application's content.
  - **WEB-INF**: Contains the Servlets and configuration files.
    - **classes**: Contains Java classes (Servlets and other classes).
    - **lib**: Contains any external JAR libraries.
    - **views**: Contains JSP (JavaServer Pages) files for rendering HTML.
  - **web.xml**: Configuration file for Servlets.
- **index.html**: The homepage of the application where users enter their name.
- **createPost.html**: Page for creating new posts.
- **style.css**: CSS file for styling the web pages.


## How to Run the Application

To run the application, follow these steps:

1. **Clone the Repository**: Clone this GitHub repository to your local machine.

2. **Set Up MySQL**: Make sure you have MySQL installed and create a database named `tmdb`. You can use the provided database creation script in the MySQL database code section above.

3. **Build the Docker Image**: In the project directory, open a terminal and run the following command to build the Docker image:
  docker-compose build

4. **Run the Docker Container**: Once the image is built, start the Docker container with the following command:
  docker-compose up
 

5. **Access the Application**: Open a web browser and navigate to `http://localhost:8080`. You should see the application's homepage.

6. **Use the Application** : Enter your name, create posts, and add comments as per the application's features.

## Output Demo Images
![19](https://github.com/IshiMaheshwari/Kennect-Assignment/assets/86151143/171636fd-8747-4277-b486-4254db60fc17)

![20](https://github.com/IshiMaheshwari/Kennect-Assignment/assets/86151143/6aa19897-ea62-4ab9-91c1-fd418602f1a1)

## Contributing

Feel free to contribute to this project by opening issues or submitting pull requests on GitHub.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
