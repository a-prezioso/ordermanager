# Start with the official Node.js image as a base
FROM node:14 AS build

# Set the working directory
WORKDIR /app

# Copy package.json and package-lock.json
COPY package*.json ./

# Install the npm packages
RUN npm install

# Copy the rest of the application files
COPY . .

# Build the Angular app
RUN npm run build

# Use Nginx for serving the Angular app
FROM nginx:1.19.0-alpine

# Copy the built Angular app to the Nginx container
COPY --from=build /app/dist/app-frontend /usr/share/nginx/html

# Copy the custom Nginx configuration
COPY nginx.conf /etc/nginx/conf.d/default.conf
