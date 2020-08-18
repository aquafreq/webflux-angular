FROM node:12.16.2 AS compile-image

WORKDIR /opt/ng
COPY .npmrc package.json yarn.lock ./

RUN npm install

COPY . ./
RUN ng build --prod

FROM nginx
COPY docker/nginx/default.conf /etc/nginx/conf.d/default.conf
COPY --from=compile-image /opt/ng/dist/app-name /usr/share/nginx/html
