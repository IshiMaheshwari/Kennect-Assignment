FROM openjdk:16

WORKDIR /app

COPY webapp/WEB-INF/classes/ /app/WEB-INF/classes/
COPY webapp/lib/ /app/lib/
COPY webapp/web.xml /app/WEB-INF/
COPY index.html createPost.html styles.css post.jsp index.jsp /app/

EXPOSE 8080

CMD ["java", "-classpath", "/app:/app/WEB-INF/classes:/app/lib/*", "com.kennect.Main"]
