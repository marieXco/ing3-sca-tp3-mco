FROM node:10-alpine as builder

COPY package.json package-lock.json ./

RUN npm install && mkdir /app-ui && mv ./node_modules ./app-ui

WORKDIR /app-ui

COPY . .

RUN npm run ng build --prod


FROM nginx:alpine

COPY --from=builder /app-ui/dist/episen-sca-mco-front/ /usr/share/nginx/html

EXPOSE 80

LABEL version="3"
LABEL release-date="2020-11-18"
