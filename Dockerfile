# Use official MySQL 8.0 image
FROM mysql:8.0

# Set environment variables (change values as needed)
ENV MYSQL_ROOT_PASSWORD=password
ENV MYSQL_DATABASE=orderdb
ENV MYSQL_USER=admin
ENV MYSQL_PASSWORD=password

# Expose MySQL port
EXPOSE 3306
